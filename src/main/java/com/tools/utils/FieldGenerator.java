package com.tools.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mifmif.common.regex.Generex;

public class FieldGenerator {

	public static enum TypeOfString {
		ALPHA_CAPS, ALPHA, ALPHANUMERIC, NUMERIC, ALPHANUMERICSCHAR, EMAIL,
	}

	public static String generateStringValue(int lenght, TypeOfString type) {

		String value = "";

		switch (type) {

		case ALPHA_CAPS:
			value = "[A-Z]{" + lenght + "}";
			break;

		case ALPHA:
			value = "[A-Za-z]{" + lenght + "}";
			break;

		case NUMERIC:
			value = "[0-9]{" + lenght + "}";
			break;

		case ALPHANUMERIC:
			value = "[0-9a-zA-Z]{" + lenght + "}";
			break;

		case ALPHANUMERICSCHAR:
			value = "[^0-9a-zA-Z]{" + lenght + "}";
			break;

		case EMAIL:
			value = "[0-9a-z]{" + lenght + "}";

			break;
		}
		Generex generex = new Generex(value);
		value = generex.random();

		return value;
	}

	// TODO rename in addDaysToCurrentDate(int days)
	public static String getDate(int days) {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, days);

		date = sdf.format(cal.getTime());

		return date;
	}

	// TODO comun la toate metodele de date, eu as pune metodele in DateUtils,
	// le-as parametriza corect si cu "format" si le-as numi foarte general, sa
	// poate fi folosite ep orice proeict
	// Apoi, daca vreau sa scap de format si sa le dau un nume sugestiv, le-as
	// chema in step sau unde trebuie si le-as da argumente.
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, h:mm aaa");
		Calendar cal = Calendar.getInstance();

		return sdf.format(cal.getTime());
	}

	// TODO asta e o metoda generala de DateUtils, nu ii da nume asa specific.
	public static String getEndDate(int addMinutes) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, h:mm aaa");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, addMinutes);

		return sdf.format(cal.getTime());
	}

	// TODO o metoda getHour te astepti sa returneze ora curenta.
	// Daca vreti o metoda care sa faca asta, faceti una
	// addHoursToCurrentDate(int hours) sau addMinutesToCurrentDate(int
	// minutes), nu getMere si adaugi jumate de para :)
	public static String getHour(int addMinutes) {
		String hour = "";
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm aaa");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, addMinutes);
		for (int i = cal.get(Calendar.MINUTE); i <= cal.getActualMaximum(Calendar.MINUTE); i++) {
			if (i % 5 == 0) {
				cal.set(Calendar.MINUTE, i);
				break;
			}
		}
		hour = sdf.format(cal.getTime());

		return String.valueOf(hour);
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
