

import java.io.*;
import java.nio.file.*;
import java.util.*;
public class FileHelper {
    Path path;
    FileOutput output;
    private ArrayList<String> fileContents = new ArrayList<>();
    public FileHelper(String filePath){
        this.path = Paths.get(filePath);
    }
    public void readFile( boolean ignoreFirstLine) throws IOException{
        if(Files.notExists(path)){
            new IOException();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()));
        String line = "";
        while((line = bufferedReader.readLine())!=null){
            if(ignoreFirstLine == true){
                ignoreFirstLine = false;
                continue;
            }
            fileContents.add(line);
        }    
    }
    public ArrayList<String> getFileContents(){
        return fileContents;
    }
    public void writeToFile(ArrayList<String> text, boolean isError) throws IOException{
        if(isError == true){
            output = new ErrorOutput();
        }
        else{
            output = new CheckoutOutput();
        }
        output.writeToFile(text);
        output.save(path);
    }
}
