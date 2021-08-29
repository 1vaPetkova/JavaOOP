package T06Solid.interfaces;

import T06Solid.enums.ReportLevel;

public interface AppenderFactory {
    Appender produce(String type, ReportLevel reportLevel,Layout layout);
}
