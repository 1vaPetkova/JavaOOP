package T06Solid;

import T06Solid.controllers.AppenderWorkshop;
import T06Solid.controllers.ConsoleAppender;
import T06Solid.controllers.LayoutWorkshop;
import T06Solid.controllers.SimpleLayout;
import T06Solid.core.EngineImpl;
import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Appender;
import T06Solid.interfaces.AppenderFactory;
import T06Solid.interfaces.Layout;
import T06Solid.interfaces.LayoutFactory;
import T06Solid.logger.Logger;
import T06Solid.logger.MessageLogger;
import groovy.swing.impl.DefaultAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
