package T06Solid.controllers;

import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel, message);
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
