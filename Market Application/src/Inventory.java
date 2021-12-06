

import java.util.ArrayList;
public class Inventory {
    private AppDatabase appdb = AppDatabase.getInstance();
    private FileHelper file;
    public Inventory(String filePath){
        file = new FileHelper(filePath);
    }
    public void addItems(){
        try{
            file.readFile(true);
        } catch (Exception e){
            System.out.println("Database file not found");
            System.exit(0);
        }
        getItems(file.getFileContents());
    }

    public void addCards(){
        try{
            file.readFile(true);
        } catch (Exception e){
            System.out.println("Card file not found");
            System.exit(0);
        }
        getCards(file.getFileContents());
    }

    private void getItems(ArrayList<String> fileContent){
        for(String line: fileContent){
            String[] item = line.split(",");
            appdb.getItem().put(item[1], new ItemDetails(item[1], item[0], Float.parseFloat(item[3]), Integer.parseInt(item[2])));
        }
    }

    private void getCards(ArrayList<String> fileContent){
        for(String line: fileContent){
            appdb.getCard().add(line);
        }
    }
}
