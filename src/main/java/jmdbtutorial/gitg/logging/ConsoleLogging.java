package jmdbtutorial.gitg.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;


public class ConsoleLogging {


    public static final Level DEFAULT_LOG_LEVEL = Level.INFO;

    public static final String DEFAULT_LOG_PATTERN = "[%-30.-30t] %-5p %40.40logger{15} : %m %n";


    public static void initialise() {
        initialise(Level.INFO, DEFAULT_LOG_PATTERN);
    }

    public static void initialise(Level level) {
        initialise(level, DEFAULT_LOG_PATTERN);
    }


    //
//    private static Map<String, String> createJodaPatternRules() {
//        Map<String, String> rules = new HashMap<String, String>();
//
//        rules.put("d" , JodaTimeDateConverter.class.getName());
//        rules.put("date" , JodaTimeDateConverter.class.getName());
//
//        return rules;
//    }


    public static void initialise(Level level, String pattern) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);

        rootLogger.setLevel(level);
        rootLogger.setAdditive(true);

        PatternLayoutEncoder layoutEncoder = new PatternLayoutEncoder();
        layoutEncoder.setPattern(pattern);
        layoutEncoder.setContext(loggerContext);
        layoutEncoder.start();

        ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<ILoggingEvent>();
        consoleAppender.setName("_default");
        consoleAppender.setEncoder(layoutEncoder);
        consoleAppender.setContext(loggerContext);


        rootLogger.detachAndStopAllAppenders();

        consoleAppender.start();
        rootLogger.addAppender(consoleAppender);

        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);

    }
}
