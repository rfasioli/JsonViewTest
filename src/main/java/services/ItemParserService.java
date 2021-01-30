package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.ItemDTO;
import dtos.jsonviews.ItemDTOView;

public class ItemParserService {

    private final ObjectMapper objectMapper;
    private final VERSION version;

    public enum VERSION {
        V1(ItemDTOView.V1.class),
        V2(ItemDTOView.V2.class),
        V3(ItemDTOView.V3.class);

        private Class jsonView;

        VERSION(Class jsonView) { this.jsonView = jsonView; }
        Class getJsonView() { return jsonView; }
    }

    public ItemParserService(ObjectMapper objectMapper, VERSION version) {
        this.objectMapper = objectMapper;
        this.version = version;
    }

    public String serialize(ItemDTO item) throws JsonProcessingException {
        return objectMapper
                .writerWithView(version.getJsonView())
                .writeValueAsString(item);
    }

    public ItemDTO deserialize(String json) throws JsonProcessingException {
        return objectMapper
                .readerWithView(version.getJsonView())
                .forType(ItemDTO.class)
                .readValue(json);
    }
}
