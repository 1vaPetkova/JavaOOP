package T06Solid;


import T06Solid.core.EngineImpl;
import T06Solid.logger.Logger;
import T06Solid.logger.MessageLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

        Logger logger = new MessageLogger();
        var reader = new BufferedReader(new InputStreamReader(System.in));
        new EngineImpl(reader, logger).run();
        System.out.println(logger);

    }
}
