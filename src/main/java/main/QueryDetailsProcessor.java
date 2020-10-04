package main;

import util.LineReaderUtil;
import util.RomanConversionUtil;
import util.StaticInfoUtil;

import java.util.List;
import java.util.Map;

public class QueryDetailsProcessor implements Processor {

    private static QueryDetailsProcessor queryDetailsProcessor;

    // singleton logic
    private QueryDetailsProcessor() {
    }

    public static QueryDetailsProcessor getInstance() {
        if (queryDetailsProcessor == null) {
            queryDetailsProcessor = new QueryDetailsProcessor();
        }
        return queryDetailsProcessor;
    }

    /**
     * Reads the queries and sends the translated intergalactic unit values for credit calculation
     * @param line
     */
    @Override
    public void process(String line) {
        List<String> words = LineReaderUtil.splitLine(line);
        StringBuilder intergalacticUnit = new StringBuilder();
        StringBuilder intergalacticUnitOrderBuilder = new StringBuilder();
        String metal = null;
        for (String word : words) {
            if (ConversionDetailsStore.getConversionDetailsStore().keySet().contains(word)) {
                intergalacticUnit.append(ConversionDetailsStore.getConversionDetailsStore().get(word));
                intergalacticUnitOrderBuilder.append(word + " ");
            } else if (StaticInfoUtil.getmetalList().contains(word)) {
                metal = word;
            }
        }
        queryDetailCalculator(intergalacticUnitOrderBuilder, intergalacticUnit, metal);
    }

    /**
     * Calculates the credits and shows output
     * @param intergalacticUnitOrderBuilder
     * @param intergalacticUnit
     * @param metal
     */
    public void queryDetailCalculator(StringBuilder intergalacticUnitOrderBuilder, StringBuilder intergalacticUnit, String metal) {
        Map<String, Integer> metalCreditUnitValues = MetalCreditDetailsStore.getMetalCreditDetailsStore();
        int metalCreditUnitValue = 0;
        int convertedValue = 0;
        int convertedIntergalacticUnit = RomanConversionUtil.romanToDecimal(intergalacticUnit.toString());
        if (metal != null) {
            metalCreditUnitValue = metalCreditUnitValues.get(metal);
            convertedValue = metalCreditUnitValue * convertedIntergalacticUnit;
            System.out.println(intergalacticUnitOrderBuilder.toString() + metal + " is " + convertedValue + " Credits");
        } else if (metal == null && !intergalacticUnitOrderBuilder.toString().isEmpty()) {
            convertedValue = convertedIntergalacticUnit;
            System.out.println(intergalacticUnitOrderBuilder.toString() + "is " + convertedValue);
        } else if (convertedValue == 0) {
            System.out.println("I have no idea what you are talking about");
        }
    }

}
