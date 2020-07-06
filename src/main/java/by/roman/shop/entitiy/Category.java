package by.roman.shop.entitiy;

import lombok.Data;

@Data
public class Category extends Entity {
    private int id;
    private String name;
    private int parent_id;
}
