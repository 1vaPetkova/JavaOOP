package T06Solid.controllers;

import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Appender;
import T06Solid.interfaces.Layout;

public abstract class AbstractAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int appendsCount;

    public AbstractAppender(ReportLevel reportLevel, Layout layout) {
        this.reportLevel = reportLevel;
        this.layout = layout;
    }

    public AbstractAppender(Layout layout) {
        this(ReportLevel.INFO, layout);
    }


    protected Layout getLayout() {
        return layout;
    }


    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected abstract String getType();



    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder("Appender type: ");
        sb.append(this.getType())
                .append(", Layout type: ")
                .append(this.layout.getType())
                .append(", Report Level: ")
                .append(this.getReportLevel().toString())
                .append(", Messages appended: ")
                .append(this.appendsCount);

        return sb.toString();
    }

    protected void incrementAppendsCount(){
        this.appendsCount++;
    }

}
