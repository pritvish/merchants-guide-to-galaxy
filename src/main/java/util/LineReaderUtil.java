package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineReaderUtil {

    public static List<String> splitLine(String line) {
        String[] str = line.split(" ");
        List<String> strings = new ArrayList<>();
        strings = Arrays.asList(str);
        return strings;
    }
}
