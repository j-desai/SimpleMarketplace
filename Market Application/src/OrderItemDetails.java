

public class OrderItemDetails {
    private String itemName;
    private int itemQuantity;
    private float itemPrice;
    private String creditCard;
    public OrderItemDetails(String itemName, int itemQuantity, String creditCard){
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.creditCard = creditCard;
    }
    public String getItemName(){
        return itemName;
    }
    public int getItemQuantity(){
        return itemQuantity;
    }
    public float getItemPrice(){
        return itemPrice;
    }
    public String getCreditCard(){
        return creditCard;
    }
}
