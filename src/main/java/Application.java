import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.ItemDTO;
import dtos.StockDTO;
import services.ItemParserService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        ItemParserService parserV1 = new ItemParserService(mapper, ItemParserService.VERSION.V1);
        ItemParserService parserV2 = new ItemParserService(mapper, ItemParserService.VERSION.V2);
        ItemParserService parserV3 = new ItemParserService(mapper, ItemParserService.VERSION.V3);

        List<StockDTO> stockDTOS = new ArrayList<>();
        stockDTOS.add(new StockDTO(1, 5, "São Paulo, SP"));
        stockDTOS.add(new StockDTO(2, 4, "Rio de Janeiro, RJ"));
        stockDTOS.add(new StockDTO(3, 1, "Brasília, DF"));
        ItemDTO item = new ItemDTO(1, "Descrição do item", 10.2, 3.57, 10, stockDTOS);

        try {
            String serializedV1 = parserV1.serialize(item);
            String serializedV2 = parserV2.serialize(item);
            String serializedV3 = parserV3.serialize(item);

            System.out.println("Item Serializado V1 => " + serializedV1);
            System.out.println("Item Serializado V2 => " + serializedV2);
            System.out.println("Item Serializado V3 => " + serializedV3);

            ItemDTO deserializedV1 = parserV1.deserialize(serializedV1);
            ItemDTO deserializedV2 = parserV2.deserialize(serializedV2);
            ItemDTO deserializedV3 = parserV3.deserialize(serializedV3);

            System.out.println("Item Deserializado V1 => " + deserializedV1);
            System.out.println("Item Deserializado V2 => " + deserializedV2);
            System.out.println("Item Deserializado V3 => " + deserializedV3);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
