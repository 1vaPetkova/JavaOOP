package T06Solid.interfaces;

import T06Solid.enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);

    ReportLevel getReportLevel();
}
