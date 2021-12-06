

import java.io.*;
import java.nio.file.Path;
//import java.text.SimpleDateFormat;
import java.util.*;
public class ErrorOutput implements FileOutput {
    private ArrayList<String> text;
    public void writeToFile(ArrayList<String> errorMessage ){
        text = errorMessage;
    }    

    public void save(Path path) throws IOException{
        FileWriter errorFile = new FileWriter(path.getParent().toString()+"/output/errorLog.txt");
        for( String line: text){
            errorFile.write(line+"\n");
        }
        errorFile.close();
    }
}
