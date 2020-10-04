package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticInfoUtil {

    /**
     * contains static values of roman number and its values
     * @return
     */
    public static Map<String,Integer> getromanNumberValues() {
        Map<String,Integer> romanNumberValues = new HashMap<String, Integer>();
        romanNumberValues.put("I",1);
        romanNumberValues.put("V",5);
        romanNumberValues.put("X",10);
        romanNumberValues.put("L",50);
        romanNumberValues.put("C",100);
        romanNumberValues.put("D",500);
        romanNumberValues.put("M",1000);
        return romanNumberValues;
    }

    public static List<String> getmetalList() {
        List<String> metalList = new ArrayList<>();
        metalList.add("Silver");
        metalList.add("Gold");
        metalList.add("Iron");
        return metalList;
    }

}
