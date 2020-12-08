package com.olympus.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.olympus.dateutil.DateUtil;
import com.olympus.olyutil.*;

public class TestDate {
	
	
/*********************************************************************************************************************************************/
	
	
	public static void main(String[] args) throws ParseException {
		
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		String commDate = "2020-03-03";
		System.out.println("LocalDate : " + today); 
		//String date30 = dateShift(today.toString(), "yyyy-MM-dd","yyyy-MM-dd", +30);
		//System.out.println("30 days after today will be " + date30);
		
		String newDate = DateUtil.getNewEffectiveDate(commDate);
		
		System.out.println("*** NewEffectiveDate=" + newDate );
		//System.out.println("*** Added 2 months:" + addMonths( commDate, 2));
 
		
/*
		
		String date2 = dateShift("2020-10-20", "yyyy-MM-dd","MM-dd-yyyy", -2);
		System.out.println("\n *****Date2=" + date2);
		// convert String to LocalDate
		LocalDate effDate = LocalDate.parse(date, formatter);

		System.out.println("\nCurrent Date: " + today);
		System.out.println("10 days before today will be " + today.plusDays(-10));
		System.out.println("10 days after today will be " + today.plusDays(10) + "\n");

		System.out.println("\nEffective Date: " + effDate);
		System.out.println("10 days before Effective Date will be " + effDate.plusDays(-10));

		System.out.println("1 days before Effective Date will be " + effDate.plusDays(-1));
		System.out.println("15 days before Effective Date will be " + effDate.plusDays(-15));

		LocalDate effDate15 = effDate.plusDays(-15);

		System.out.println("\n**LD=" + formatter2.format(effDate15));
		String d1 = formatter2.format(effDate15);

		System.out.println("\n**LD=" + d1);
*/
		
	}
}