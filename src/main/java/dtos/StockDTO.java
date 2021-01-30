package dtos;

import com.fasterxml.jackson.annotation.JsonView;
import dtos.jsonviews.ItemDTOView;

import java.util.StringJoiner;

public class StockDTO {
    private Integer location;
    private Integer quantity;

    @JsonView(ItemDTOView.V3.class)
    private String address;

    public StockDTO() {
    }

    public StockDTO(Integer location, Integer quantity, String address) {
        this.location = location;
        this.quantity = quantity;
        this.address = address;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StockDTO.class.getSimpleName() + "[", "]")
                .add("location=" + location)
                .add("quantity=" + quantity)
                .add("address='" + address + "'")
                .toString();
    }
}
