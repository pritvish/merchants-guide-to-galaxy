package main;

import java.util.HashMap;
import java.util.Map;

public class ConversionDetailsStore {

    private static Map<String,String> conversionDetailsStore ;

    public static Map<String,String> getConversionMapInstance() {
        if (conversionDetailsStore == null) {
            conversionDetailsStore = new HashMap<>();
        }
        return conversionDetailsStore;
    }

    public static Map<String, String> getConversionDetailsStore() {
        return conversionDetailsStore;
    }
}
