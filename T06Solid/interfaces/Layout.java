package T06Solid.interfaces;

import T06Solid.enums.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);

    String getType();
}
