

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
public interface FileOutput {
    void writeToFile(ArrayList<String> content);

    void save( Path path) throws IOException;
}
