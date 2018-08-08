package com.pages;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.common.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject {

	public void waitForElementsByCssLocator(String cssLocator) {
		(new WebDriverWait(getDriver(), 20))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssLocator)));

	}

	// TODO bagati soft assert aici de vreti
	// AM modificat cu Soft-assert-ul de la Cipri - nu sunt sigur ca merge daca
	// merge scot cometariile
	public <T> void verifyObjects(T obj1, T obj2)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		for (Field field : obj1.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.get(obj1) == null) {
				Assert.verify(field.get(obj2).equals(null));
			} else {
				Assert.verify(((String) (field.get(obj2))).contentEquals((String) field.get(obj1)),
						"<< " + field.getName() + " >> doesn't match !! Expected : " + field.get(obj1) + " Actual "
								+ field.get(obj2));
			}
		}
	}

	// TODO bagati soft assert aici de vreti
	// AM modificat cu Soft-assert-ul de la Cipri - nu sunt sigur ca merge daca
	// merge scot cometariile
	public <T> void verifyObjectsIgnoreNull(T obj1, T obj2)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		for (Field field : obj1.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (!(field.get(obj1) == null && field.get(obj2) == null)) {
				Assert.verify(((String) (field.get(obj2))).contentEquals((String) field.get(obj1)),
						"<< " + field.getName() + " >> doesn't match !! Expected : " + field.get(obj1) + " Actual "
								+ field.get(obj2));
			}
		}
	}

	// Can be used when you ant to populate request with suplemetary
	// data that is comming from the response, eg: id obj1 = request,
	// obj2 = response
	public static Object mergeObjects(Object obj1, Object obj2) throws Exception {
		Field[] allFields = obj1.getClass().getDeclaredFields();
		for (Field field : allFields) {
			field.setAccessible(true);
			if (field.get(obj1) == null && field.get(obj2) != null) {
				field.set(obj1, field.get(obj2));
			}
		}
		return obj1;
	}

}
