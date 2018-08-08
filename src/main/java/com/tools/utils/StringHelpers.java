package com.tools.utils;

import org.apache.commons.lang.StringUtils;

public class StringHelpers {

	// TODO trebe ceva mai general aici.. daca no e 0023456 ?
	// am gasit o metoda mai buna, nu stiu cazul si daca e completa dar sigur e mai buna 
	public static String cleanZeroLeadingStrings(String no) {
//		String number = no.trim();
//		if (no.startsWith("0")) {
//			number = no.substring(1);
//		}
//		return number;
		
		return StringUtils.stripStart(no,"0");
	
	}
}
