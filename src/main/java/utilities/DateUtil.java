package utilities;

import constants.FrameworkConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FrameworkConstants.DATE_TIME_FORMAT);

    private DateUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
