package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import dtos.jsonviews.ItemDTOView;

import java.util.List;
import java.util.StringJoiner;

public class ItemDTO {
    private Integer id;
    private String description;
    private Double price;

    @JsonView(ItemDTOView.V3.class)
    private Double taxes;

    @JsonView({ItemDTOView.V1.class, ItemDTOView.V3.class})
    private Integer quantity;

    @JsonView(ItemDTOView.V2.class)
    private List<StockDTO> stockDTOS;

    public ItemDTO() {
    }

    public ItemDTO(Integer id, String description, Double price, Double taxes, Integer quantity, List<StockDTO> stockDTOS) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.taxes = taxes;
        this.quantity = quantity;
        this.stockDTOS = stockDTOS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public List<StockDTO> getStockDTOS() {
        return stockDTOS;
    }

    public void setStockDTOS(List<StockDTO> stockDTOS) {
        this.stockDTOS = stockDTOS;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("description='" + description + "'")
                .add("price=" + price)
                .add("taxes=" + taxes)
                .add("quantity=" + quantity)
                .add("stockDTOS=" + stockDTOS)
                .toString();
    }
}
