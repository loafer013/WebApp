package by.roman.shop.entitiy;


import lombok.Data;

@Data
public class Cart extends Entity {
    private int user_id;
    private int product_id;
    private int count;

    public Cart(int user_id, int product_id, int count) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.count = count;
    }
}
