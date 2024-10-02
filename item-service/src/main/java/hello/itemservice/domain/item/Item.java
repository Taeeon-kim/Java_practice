package hello.itemservice.domain.item;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // Integer 쓰는이유는 Price가 없을때도 있다는걸 열어두기위해 null 과같이
    private Integer quantity;

    public Item(){

    }

    public Item(String itemName, Integer price, Integer quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
