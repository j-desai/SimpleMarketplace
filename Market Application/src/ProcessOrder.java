
import java.util.*;
import java.io.IOException;

public class ProcessOrder {
    private AppDatabase appdb = AppDatabase.getInstance();
    private OrderDetails newOrder = new OrderDetails();
    private FileHelper file;
    private ArrayList<String> message = new ArrayList<>();
    private ArrayList<OrderItemDetails> items = new ArrayList<>();
    private HashMap<String, Integer> categoryQuantity = new HashMap<>();
    private HashSet<String> creditCards = new HashSet<String>();
    private float orderTotal = 0;
    public ProcessOrder(String path){
        file = new FileHelper(path);
    }
    public boolean orderStart() throws IOException{
        file.readFile(true);
        getOrderItems(file.getFileContents());
        return true;
    }

    public void getOrderItems(ArrayList<String> content){
        for(String line : content){
            String[] item = line.split(",");
            if(appdb.getItem().containsKey(item[0])){
                ItemDetails orderitem = appdb.getItem().get(item[0]);
                int itemquantity = Integer.parseInt(item[1]);
                items.add(new OrderItemDetails(item[0], itemquantity, item[2].replaceAll("\\s+", "")));
                addCategoryQuantity(orderitem.getItemCategory(), itemquantity);
            }
            else{
                message.add(item[0]+" is not in the database.");
            }
        }
            if(message.isEmpty()==false){
            items.clear();
        }
        
    }

    public void addCategoryQuantity(String itemCategory, int itemQuantity){
        if(categoryQuantity.containsKey(itemCategory)){
            itemQuantity += categoryQuantity.get(itemCategory);
            categoryQuantity.put(itemCategory, itemQuantity);
        }
    }

    public boolean orderCheck(){
        checkCap();
        checkInventory();
        return message.isEmpty();
    }

    public void checkCap(){
        StringBuilder capMessage = new StringBuilder();
        appdb.getCaps().forEach((itemCategory, itemCap)->{
            if(categoryQuantity.containsKey(itemCategory)){
                if(categoryQuantity.get(itemCategory)>itemCap){
                    if(capMessage.length()>0){
                        capMessage.append(", ");
                    }
                    capMessage.append("Maximum quantity for "+itemCategory+" is "+itemCap);
                }
            }
        });
        if(capMessage.length()>0){
            message.add(capMessage.toString());
        }
    }

    public void checkInventory(){
        StringBuilder inventoryMessage = new StringBuilder();
        for(OrderItemDetails item : items ){
            ItemDetails itemDetails = appdb.getItem().get(item.getItemName());
            if(itemDetails.getItemQuantity()< item.getItemQuantity()){
                if(inventoryMessage.length()>0){
                    inventoryMessage.append(", ");
                }
                inventoryMessage.append(item.getItemName()+" is unavailable as much as required. Available quantity is "+itemDetails.getItemQuantity());   
            }
        }
        if(inventoryMessage.length()>0){
            message.add("Requested Quantities not available. Please change them.");
            message.add(inventoryMessage.toString());
            
        }
    }

    public void calculateOrderTotal(){
        items.forEach((item)->{
            orderTotal += item.getItemQuantity() * appdb.getItem().get(item.getItemName()).getItemPrice();
        });
        newOrder.setOrderTotal(orderTotal);
    }
    public float getOrderTotal(){
        return newOrder.getOrderTotal();
    }
    public void finishOrder() throws IOException{
        appdb.getOrder().add(newOrder);
        for(OrderItemDetails currentItem : items ){
            ItemDetails item = appdb.getItem().get(currentItem.getItemName());
            item.setItemQuantity(item.getItemQuantity()-currentItem.getItemQuantity());
        }
        for( String card : creditCards){
            if(appdb.getCard().contains(card)==false){
                System.out.println("Card not in database. Adding it now.");
                appdb.getCard().add(card);
            }
        }
        generateOutput();
    }
    public void showMessage(){
        for(String line : message){
            System.out.println(line);
        }
    }

    public void generateOutput() throws IOException{
        if(message.isEmpty()){
            message.add("Total Amount Paid for the order: "+Float.toString(newOrder.getOrderTotal()));
            file.writeToFile(message, false);
        }
        else{
            file.writeToFile(message, true);
        }
    }
}
