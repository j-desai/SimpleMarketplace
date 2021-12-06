
public class ItemDetails {
    private String itemName;
    private String itemCategory;
    private float itemPrice;
    private int itemQuantity;

    public ItemDetails(){}

    public ItemDetails(String itemName, String itemCategory, float itemPrice, int itemQuantity){
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    public String getItemName(){
        return itemName;
    }
    public String getItemCategory(){
        return itemCategory;
    }
    public float getItemPrice(){
        return itemPrice;
    }
    public int getItemQuantity(){
        return itemQuantity;
    }
    public void setItemQuantity(int quantity){
        this.itemQuantity = quantity;
    }
}