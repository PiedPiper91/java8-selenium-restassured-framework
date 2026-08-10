package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtil {

    // A single, shared logger instance for the entire utilities package
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    private LoggerUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    public static void info(String message, Object... args) {
        logger.info(message, args);
    }

    public static void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    public static void error(String message, Object... args) {
        logger.error(message, args);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
