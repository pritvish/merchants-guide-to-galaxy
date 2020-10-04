package main;

import java.util.HashMap;
import java.util.Map;

public class MetalCreditDetailsStore {

    private static Map<String,Integer> metalCreditDetailsStore ;

    public static Map<String,Integer> getMetalCreditDetailMapInstance() {
        if (metalCreditDetailsStore == null) {
            metalCreditDetailsStore = new HashMap<>();
        }
        return metalCreditDetailsStore;
    }

    public static Map<String, Integer> getMetalCreditDetailsStore() {
        return metalCreditDetailsStore;
    }
}
