package cn.godbol.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Created by li on 2017-12-15 下午2:41.
 * 仅作为了解，Spring内置了大量的Formatter
 */
public class DateFormatter implements Formatter<LocalDate> {

    @Value("${dataPattern:yyyy-mm-dd}")
    private String datePattern;


    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return null;
    }
}
