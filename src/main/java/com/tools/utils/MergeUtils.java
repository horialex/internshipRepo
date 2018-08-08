package com.tools.utils;

import java.lang.reflect.Field;

public class MergeUtils {

	@SuppressWarnings("unchecked")
	public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
		Class<?> clazz = first.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Object returnValue = clazz.newInstance();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value1 = field.get(first);
			Object value2 = field.get(second);
			
			Object value = ((value1 == null || value1.equals(0)) && value2 != null) ? value2 : value1;
			field.set(returnValue, value);
		}
		return (T) returnValue;
	}

}
