package com.tools.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {
	// TODO nu m-am uitat peste ea mult, dar nu-mi place. In primul rand as
	// parametriza-o cu format-ul. Regex-ul ala sau ce e, nu-l inteleg
	// TODO aici trebe o metoda gen formatDate(String date, String
	// initialFormat, String finalFormat)
	// Daca Stringul ce reprezinta data nu are niciun format cunoscut, se face
	// prelucrarea stringului la un format cunoscut si pe urma se paseaza la
	// metoda formatDate de care ziceam
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	public static String formatDate(String date) {
		String dateFormatted[] = date.replaceAll("[^0-9]", " ").split(" ");
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, h:mm aaa");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(dateFormatted[0]));
		cal.set(Calendar.MONTH, Integer.valueOf(dateFormatted[1]));
		cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dateFormatted[2]));
		cal.set(Calendar.HOUR, Integer.valueOf(dateFormatted[3]));
		cal.set(Calendar.MINUTE, Integer.valueOf(dateFormatted[4]));

		return sdf.format(cal.getTime());
	}
	
	public static String parseDate(String dateString, String initialFormatString, String finalFormatString) {
		DateFormat formatInitial = new SimpleDateFormat(initialFormatString);
		DateFormat formatFinal = new SimpleDateFormat(finalFormatString);
		Date date = new Date();
		try {
			date = formatInitial.parse(dateString);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return String.valueOf(formatFinal.format(date));

	}

	// pe astea de mai jos le-am adaugat eu

	/**
	 * @param minutes
	 * @returns new Date object with days added. If days is a negative number,
	 *          the number of days are going to be subtracted from current date.
	 */
	public static Date addDaysToCurrentDate(int days) {

		Calendar date = Calendar.getInstance();
		date.add(Calendar.DATE, days);

		return date.getTime();
	}

	/**
	 * @param minutes
	 * @returns new Date object with minutes added. If minutes is a negative
	 *          number, the number of minutes are going to be subtracted from
	 *          current date.
	 */
	public static Date addMinutesToCurrentDate(int minutes) {

		Calendar date = Calendar.getInstance();
		date.add(Calendar.MINUTE, minutes);

		return date.getTime();
	}

	/**
	 * @param date
	 * @param format
	 * @return returns formatted date as String
	 */
	public static String formatDate(Date date, SimpleDateFormat format) {

		return format.format(date.getTime());
	}
}
