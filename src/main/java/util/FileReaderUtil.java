package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderUtil {

//    String path = "src/main/resources/testfile.txt";

    public static List<String> readFile(String filePath) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get(filePath));
        return allLines;
    }
}
