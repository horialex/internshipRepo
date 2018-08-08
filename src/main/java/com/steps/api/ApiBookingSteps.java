package com.steps.api;

import java.util.List;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.entities.Item;
import com.tools.factories.BookingFactory;
import com.tools.utils.DateFormatter;
import com.tools.utils.MergeUtils;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiBookingSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void bookItem() throws IllegalAccessException, InstantiationException {
		Booking bookingRequest = BookingFactory.getApiBookingInstance();

		Booking bookingResponse = createResource(ApiUrlConstants.BOOKINGS, bookingRequest, Booking.class);
		bookingResponse.setStartDate(DateFormatter.formatDate(bookingResponse.getStartDate()));
		bookingResponse.setEndDate(DateFormatter.formatDate(bookingResponse.getEndDate()));
		bookingRequest = MergeUtils.mergeObjects(bookingRequest, bookingResponse);
		SessionUtils.putOnSession(SerenityKeyConstants.BOOKING, bookingRequest);
	}
	
	@Step
	public void apiBookItem() throws IllegalAccessException, InstantiationException {
		List<Item> items = SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		for (Item item : items) {
		Booking bookingRequest = BookingFactory.getApiBookingInstance();
		bookingRequest.setItem(item);
		bookingRequest.setItemId(item.getId());
		Booking bookingResponse = createResource(ApiUrlConstants.BOOKINGS, bookingRequest, Booking.class);
		
		bookingResponse.setStartDate(DateFormatter.formatDate(bookingResponse.getStartDate()));
		bookingResponse.setEndDate(DateFormatter.formatDate(bookingResponse.getEndDate()));
		bookingRequest = MergeUtils.mergeObjects(bookingRequest, bookingResponse);
		SessionUtils.putOnSession(SerenityKeyConstants.BOOKING, bookingRequest);
		}
	}
}
