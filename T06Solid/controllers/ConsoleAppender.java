package T06Solid.controllers;

import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Appender;
import T06Solid.interfaces.Layout;

public class ConsoleAppender extends AbstractAppender {


    public ConsoleAppender(ReportLevel reportLevel, Layout layout) {
        super(reportLevel,layout);
    }

    @Override
    protected String getType() {
        return "ConsoleAppender";
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.getLayout().format(date, reportLevel,message));
        super.incrementAppendsCount();
    }
}
