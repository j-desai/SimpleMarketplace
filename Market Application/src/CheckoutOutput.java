import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CheckoutOutput implements FileOutput {
    private ArrayList<String> text;
    public void writeToFile(ArrayList<String> orderLog ){
        text = orderLog;
    }    

    public void save(Path path) throws IOException{
        FileWriter checkoutFile = new FileWriter(path.getParent().toString()+"/output/checkout.txt");
        for( String line: text){
            checkoutFile.write(line+"\n");
        }
        checkoutFile.close();
    }
}
