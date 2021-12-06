// import java.util.Scanner;
import java.io.*;
public class App {
    public static void main(String[] args) throws IOException{
        App app = new App();
        app.runApp();
    }
    private void runApp() throws IOException{
        System.out.println("Enter inventory file path");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String databasefile = reader.readLine();
        Inventory inventory = new Inventory(databasefile.toString());
        inventory.addItems();
        System.out.println("Inventory Loaded!");
        Inventory cards = new Inventory("/Users/jigardesai/Desktop/SJSU/Fall 2021/CMPE 202/Individual/Market Application/Input/Cards - Sheet1.csv");
        cards.addCards();
        System.out.println("Cards Added!");
        while(true){
            String filePath = mainMenu();
            if(filePath.equals("")){
                break;
            }
            startOrder(filePath);
        }
        System.out.println("Thanks");
    }
    public String mainMenu() throws IOException{
        System.out.println("Enter order's file path or press Enter to exit.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath = reader.readLine();
        return filepath;
    }
    private void startOrder(String filePath) throws IOException{
        ProcessOrder processOrder = new ProcessOrder(filePath);
        if(processOrder.orderStart()==true){
            if(processOrder.orderCheck()==true){
                processOrder.calculateOrderTotal();
                processOrder.finishOrder();
                System.out.println("Order total is "+ processOrder.getOrderTotal());
            }
            else{
                System.out.println("!!ERROR!!\nPlease check error log file.");
                processOrder.generateOutput();
            }
        }
        else{
            System.out.println("Please check file path.");
        }
    }
}
