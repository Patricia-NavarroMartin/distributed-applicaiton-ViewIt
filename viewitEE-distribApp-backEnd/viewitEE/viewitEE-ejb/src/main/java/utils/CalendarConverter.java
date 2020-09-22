package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class CalendarConverter implements CalendarConverterLocal {

    @Override
    public Calendar stringToCalendar(String sdate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date ddate = sdf.parse(sdate);
        return dateToCalendar(ddate);
    }
    
    @Override
    public Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    
    @Override
    public String calendarToString(Calendar cdate, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(cdate.getTime());
    }
}
