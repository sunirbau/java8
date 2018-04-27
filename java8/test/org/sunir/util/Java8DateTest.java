package org.sunir.util;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class Java8DateTest {
	
	@Test
	public void testLocalDate() throws Exception {
		String localDateString = "04/24/2018";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.parse(localDateString, formatter);
		assertEquals(localDateString, localDate.format(formatter));	
	}
	
	@Test
	public void testLocalTime() throws Exception {
		String localTimeString = "23:12:23";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.parse(localTimeString, formatter);
		assertEquals(localTimeString, localTime.format(formatter));	
	}
	
	@Test
	public void testLocalDateTime() throws Exception {
		String localDateTimeString = "Tuesday, Apr 24, 2018 11:10:56";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeString, formatter);
		assertEquals(localDateTimeString, localDateTime.format(formatter));	
	}
	
	@Test
	public void testDuration() throws Exception {
		LocalDateTime localDateTime1 = LocalDateTime.of(2018, Month.APRIL, 24, 23, 55, 00);
		LocalDateTime localDateTime2 = LocalDateTime.of(2018, Month.APRIL, 25, 00, 00, 00);
		Duration duration = Duration.between(localDateTime1, localDateTime2);
		assertEquals(300,duration.getSeconds());
		assertEquals(0,duration.getNano());
	}
	
	@Test
	public void testPeriod() throws Exception {
		LocalDate localDate1 = LocalDate.of(2018, Month.APRIL, 24);
		LocalDate localDate2 = LocalDate.of(2019, Month.MAY, 25);
		Period period = Period.between(localDate1, localDate2);
		assertEquals(1,period.getDays());
		assertEquals(1,period.getMonths());
		assertEquals(1,period.getYears());
	}
	
	@Test
	public void testChronoUnit() throws Exception {
		LocalDateTime localDateTime1 = LocalDateTime.of(2018, Month.APRIL, 24, 00, 00, 00);
		LocalDateTime localDateTime2 = LocalDateTime.of(2018, Month.MAY, 24, 00, 00, 00);
		assertEquals(0, ChronoUnit.YEARS.between(localDateTime1, localDateTime2));
		assertEquals(1, ChronoUnit.MONTHS.between(localDateTime1, localDateTime2));
		assertEquals(4, ChronoUnit.WEEKS.between(localDateTime1, localDateTime2));
		assertEquals(30, ChronoUnit.DAYS.between(localDateTime1, localDateTime2));
		assertEquals(720,ChronoUnit.HOURS.between(localDateTime1, localDateTime2));
		assertEquals(43200, ChronoUnit.MINUTES.between(localDateTime1, localDateTime2));
		assertEquals(2592000, ChronoUnit.SECONDS.between(localDateTime1, localDateTime2));
		assertEquals(2592000000L, ChronoUnit.MILLIS.between(localDateTime1, localDateTime2));
		assertEquals(2592000000000000L, ChronoUnit.NANOS.between(localDateTime1, localDateTime2));
	}

}
