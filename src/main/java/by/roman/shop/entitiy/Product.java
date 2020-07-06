package by.roman.shop.entitiy;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Product extends Entity{
    private int id;
    private String name;
    private String image_path;
    private BigDecimal price;

    public Product(int id, String name, String image_path, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.image_path = image_path;
        this.price = price;
    }
}
