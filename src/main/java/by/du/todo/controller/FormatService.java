package by.du.todo.controller;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Component
public class FormatService {
    public static String localeDate(final LocalDateTime localDateTime) {
        return getFormat(localDateTime, Locale.getDefault()) + " / " + getFormat(localDateTime, Locale.US);
    }

//    private static String getFormat(final LocalDateTime localDateTime, final Locale locale) {
//        return DateFormat.getDateInstance(DateFormat.FULL, locale)
//                .format(Date.from(localDateTime.toInstant(ZoneOffset.MIN)));
//    }

    private static String getFormat(final LocalDateTime localDateTime, final Locale locale) {
//        final ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
//        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(locale).format(zonedDateTime);
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale).format(localDateTime);
    }
}
