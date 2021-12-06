import java.util.*;

public class AppDatabase {
    private static AppDatabase instance;
    private HashMap<String, ItemDetails> items = new HashMap<>();
    private HashSet<String> cards = new HashSet<>();
    private ArrayList<OrderDetails> orders = new ArrayList<>();
    private HashMap<String, Integer> caps = new HashMap<>();
    private AppDatabase(){
        caps.put("Misc", 6);
        caps.put("Essential", 5);
        caps.put("Luxury", 3);

    }
    public static AppDatabase getInstance(){
        if (instance == null){
            instance = new AppDatabase();
        }
        return instance;
    }
    public HashMap<String, ItemDetails> getItem(){
        return items;
    }
    public ArrayList<OrderDetails> getOrder(){
        return orders;
    }
    public HashSet<String> getCard(){
        return cards;
    }
    public HashMap<String, Integer> getCaps(){
        return caps;
    }
}
