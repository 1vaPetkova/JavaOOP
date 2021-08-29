package T06Solid.interfaces;

import T06Solid.enums.ReportLevel;

public interface File {
    void write(String text);
    int getSize();
}
