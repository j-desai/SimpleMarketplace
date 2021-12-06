
import java.util.*;
public class OrderDetails {
    private HashSet<ItemDetails> items = new HashSet<>();
    private float orderTotal;
    public OrderDetails(){}

    public HashSet<ItemDetails> getOrderItems(){
        return items;
    }
    public float getOrderTotal(){
        return orderTotal;
    }
    public void setOrderItems(HashSet<ItemDetails> items){
        this.items = items;
    }
    public void setOrderTotal(float orderTotal){
        this.orderTotal = orderTotal;
    }
}
