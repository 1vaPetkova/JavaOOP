package T06Solid.logger;

import T06Solid.interfaces.Appender;

public interface Logger {
   void logInfo(String date, String message);

   void logWarning(String date, String message);

   void logError(String date, String message);

   void logCritical(String date, String message);

   void logFatal(String date, String message);
   void addAppender(Appender appender);
}