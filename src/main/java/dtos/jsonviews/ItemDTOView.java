package dtos.jsonviews;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ItemDTOView {
    public class V1 {}
    public class V2 {}
    public class V3 extends V2 {}
}
