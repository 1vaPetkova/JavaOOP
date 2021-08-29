package T06Solid.core;

import T06Solid.controllers.FactoryRepository;
import T06Solid.enums.ReportLevel;
import T06Solid.interfaces.Appender;
import T06Solid.interfaces.Engine;
import T06Solid.interfaces.InputParser;
import T06Solid.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class EngineImpl implements Engine {
    private boolean isRunning;
    private BufferedReader reader;
    private Logger logger;

    public EngineImpl(BufferedReader reader, Logger logger) {
        this.reader = reader;
        this.logger = logger;
    }


    @Override
    public void run() throws IOException {
        this.isRunning = true;
        String line = reader.readLine();

        addAppenders(Integer.parseInt(line));
        while (isRunning) {
            //read input
            line = reader.readLine();
            //parse input
            String[] parse = InputParser.parse(line);
            //execute input
            if (!parse[0].equals("END")){
            logMessage(parse);
            }
            this.isRunning = !parse[0].equals("END");
        }
    }

    private void logMessage(String[] args) {
        ReportLevel reportLevel = ReportLevel.valueOf(args[0]);
        String date = args[1];
        String message = args[2];

        switch (reportLevel) {
            case INFO -> logger.logInfo(date, message);
            case WARNING -> logger.logWarning(date, message);
            case ERROR -> logger.logError(date, message);
            case CRITICAL -> logger.logCritical(date, message);
            case FATAL -> logger.logFatal(date, message);
            default -> throw new IllegalStateException("Unknown enum value for " + reportLevel);
        }
    }

    public void addAppenders(int n) throws IOException {
        while (n-- > 0) {
            String[] info = reader.readLine().split("\\s+");
            String appenderType = info[0];
            String layoutType = info[1];
            ReportLevel reportLevel = info.length == 3 ? ReportLevel.valueOf(info[2].toUpperCase()) : ReportLevel.INFO;

            Appender appender = FactoryRepository.getAppenderFactory().produce(appenderType, reportLevel,
                    FactoryRepository.getLayoutFactory().produce(layoutType));
            logger.addAppender(appender);
        }
    }
}
