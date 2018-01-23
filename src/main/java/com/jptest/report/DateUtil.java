package com.jptest.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Calendar stringToCalendar(String strDate, String format) {
		Calendar cal = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(strDate);
			cal.setTime(date);
		} catch (ParseException ex) {
			System.out.println("Error: ParseException on date: " + strDate);
		}
		return cal;
	}
	
	public static String calendarToString(Calendar calendarDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(calendarDate.getTime());
	}
}
