package T06Solid.controllers;

import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Appender;
import T06Solid.interfaces.AppenderFactory;
import T06Solid.interfaces.Layout;

public class AppenderWorkshop implements AppenderFactory {
    @Override
    public Appender produce(String type, ReportLevel reportLevel, Layout layout) {
        return switch (type) {
            case "ConsoleAppender" -> new ConsoleAppender(reportLevel, layout);
            case "FileAppender" -> new FileAppender(reportLevel,layout);
            default -> throw new IllegalStateException("Not valid type of appender for " + type + " parameter");
        };
    }
}
