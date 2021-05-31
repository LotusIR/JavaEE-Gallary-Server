package shu.jee.grandgallery.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateformat {

    public String localdatetimetostring(LocalDateTime ldt){
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date2Str = formatter2.format(ldt);
        return date2Str;
    }

    public LocalDateTime stringtolocaldatetime(String s){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(s, dtf);
        return ldt;
    }
}
