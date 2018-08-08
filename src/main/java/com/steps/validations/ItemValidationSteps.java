package com.steps.validations;

import java.lang.reflect.InvocationTargetException;

import com.pages.BookingsPage;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.utils.FieldGenerator;
import com.tools.utils.SessionUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ItemValidationSteps {
	BookingsPage bookingsPage;

	@Steps
	SoftValidation softValidation;

	@Step
	public void validateItemIsBooked()
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Booking expectedBooking = SessionUtils.getFromSession(SerenityKeyConstants.BOOKING);
		Booking actualdBooking = bookingsPage.getBookingModel(expectedBooking);
		valdiateItemBooking(expectedBooking, actualdBooking);
	}

	@Step
	public void validateItemIsReturned()
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Booking expectedBooking = (Booking) SessionUtils.getFromSession(SerenityKeyConstants.BOOKING);
		expectedBooking.setEndDate(FieldGenerator.getCurrentDate());
		Booking actualdBooking = bookingsPage.getBookingModel(expectedBooking);
		valdiateItemBooking(expectedBooking, actualdBooking);
		bookingsPage.verifyObjectsIgnoreNull(expectedBooking, actualdBooking);
	}

	private void valdiateItemBooking(Booking expectedBooking, Booking actualdBooking) {
		SoftValidation.verifyStringValues("booking status", expectedBooking.getBookingStatus(),
				actualdBooking.getBookingStatus());
		SoftValidation.verifyStringValues("end date", expectedBooking.getEndDate(), actualdBooking.getEndDate());
		SoftValidation.verifyStringValues("start date", expectedBooking.getStartDate(), actualdBooking.getStartDate());
		SoftValidation.verifyStringValues("user", expectedBooking.getUser().getName(),
				actualdBooking.getUser().getName());
		SoftValidation.verifyStringValues("item", expectedBooking.getItem().getTitle(),
				actualdBooking.getItem().getTitle());
		softValidation.printErrors();
	}
}
