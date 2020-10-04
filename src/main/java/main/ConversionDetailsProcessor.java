package main;

import util.LineReaderUtil;
import util.StaticInfoUtil;

import java.util.List;
import java.util.Map;

public class ConversionDetailsProcessor implements Processor {

    private static ConversionDetailsProcessor conversionDetailsProcessor;

    // singleton logic
    private ConversionDetailsProcessor() {
    }

    public static ConversionDetailsProcessor getInstance() {
        if (conversionDetailsProcessor == null) {
            conversionDetailsProcessor = new ConversionDetailsProcessor();
        }
        return conversionDetailsProcessor;
    }

    /**
     * Reads the conversion details of intergalacticUnit to romanNumberValue from the line supplied and stores the data in a map
     * @param line
     */
    @Override
    public void process(String line) {
        List<String> words = LineReaderUtil.splitLine(line);
        Map<String, String> conversionDetailsStore = ConversionDetailsStore.getConversionMapInstance();
        String intergalacticUnit = null;
        String romanNumberValue = null;
        for (String word : words) {
            if (!(word.equals("is")) && !(StaticInfoUtil.getromanNumberValues().keySet().contains(word))) {
                intergalacticUnit = word;
            } else if (StaticInfoUtil.getromanNumberValues().keySet().contains(word)) {
                romanNumberValue = word;
            }
        }
        conversionDetailsStore.put(intergalacticUnit, romanNumberValue);
    }
}
