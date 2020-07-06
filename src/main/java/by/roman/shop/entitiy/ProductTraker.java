package by.roman.shop.entitiy;

import lombok.Data;

@Data
public class ProductTraker extends Entity {
    private int user_id;
    private int product_id;
    private String last_modification_time;
    private Status status;


   public enum Status {
        SELECTED, REQUESTED, IN_PROCESSING, DELIVERED
    }
}
