package utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface CalendarConverterLocal {
    public Calendar stringToCalendar(String sdate, String format) throws ParseException;
    public Calendar dateToCalendar(Date date);
    public String calendarToString(Calendar cdate, String format);
}
