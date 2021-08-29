package T06Solid.controllers;

import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Appender;
import T06Solid.interfaces.File;
import T06Solid.interfaces.Layout;

public class FileAppender extends AbstractAppender {

    private File file;

    public FileAppender(ReportLevel reportLevel, Layout layout) {
        super(reportLevel, layout);
        this.file = new LogFile();
    }

    @Override
    protected String getType() {
        return "FileAppender";
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        this.file.write(this.getLayout().format(date, reportLevel, message));
        super.incrementAppendsCount();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
