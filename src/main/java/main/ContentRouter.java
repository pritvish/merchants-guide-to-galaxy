package main;

import java.util.List;

public class ContentRouter {

    private Processor processor;

    /**
     * Consumes the contents of the file and routes the data to appropriate class
     *
     * @param fileInfo
     */
    public void route(List<String> fileInfo) {
        for (String line : fileInfo) {
            if (!line.contains("?") && !line.contains("Credits")) {
                processor = ConversionDetailsProcessor.getInstance();
                processor.process(line);
            } else if (!line.contains("?") && line.contains("Credits")) {
                processor = MetalCreditDetailsProcessor.getInstance();
                processor.process(line);
            } else if (line.contains("?")) {
                processor = QueryDetailsProcessor.getInstance();
                processor.process(line);
            }
        }
    }


}
