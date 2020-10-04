package main;

import util.LineReaderUtil;
import util.RomanConversionUtil;
import util.StaticInfoUtil;

import java.util.List;
import java.util.Map;

public class MetalCreditDetailsProcessor implements Processor {

    private static MetalCreditDetailsProcessor metalCreditDetailsProcessor;

    // singleton logic
    private MetalCreditDetailsProcessor() {
    }

    public static MetalCreditDetailsProcessor getInstance() {
        if (metalCreditDetailsProcessor == null) {
            metalCreditDetailsProcessor = new MetalCreditDetailsProcessor();
        }
        return metalCreditDetailsProcessor;
    }

    /**
     * Reads the conversion details of metal values in credits from the supplied line and sends the data to store as unitary value
     * @param line
     */
    @Override
    public void process(String line) {

        List<String> words = LineReaderUtil.splitLine(line);
        StringBuilder intergalacticUnitOrderBuilder = new StringBuilder();
        String metal = null;
        int metalValue = 0;

        for (String word : words) {
            if (ConversionDetailsStore.getConversionDetailsStore().keySet().contains(word)) {
                intergalacticUnitOrderBuilder.append(ConversionDetailsStore.getConversionDetailsStore().get(word));
            } else if (StaticInfoUtil.getmetalList().contains(word)) {
                metal = word;
            } else if (!(word.equalsIgnoreCase("is")) && !(word.equalsIgnoreCase("Credits")) && Integer.decode(word) instanceof Integer) {
                metalValue = Integer.decode(word);
            }
        }
        metalPriceConversionStore(intergalacticUnitOrderBuilder.toString(), metal, metalValue);
    }

    /**
     * Stores the unitary values of metals
     * @param intergalacticUnitOrder
     * @param metal
     * @param metalValue
     */
    public void metalPriceConversionStore(String intergalacticUnitOrder, String metal, int metalValue) {
        Map<String, Integer> metalCreditDetailsStore = MetalCreditDetailsStore.getMetalCreditDetailMapInstance();
        int decimalValue = RomanConversionUtil.romanToDecimal(intergalacticUnitOrder);
        Integer unitaryValueOfMetal = (metalValue / decimalValue);
        metalCreditDetailsStore.put(metal, unitaryValueOfMetal);
    }

}
