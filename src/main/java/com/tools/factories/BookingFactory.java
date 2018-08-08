package com.tools.factories;

import com.tools.constants.EntityConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.entities.Item;
import com.tools.entities.User;
import com.tools.utils.FieldGenerator;
import com.tools.utils.SessionUtils;

public class BookingFactory {

	public static Booking getBookingInstance() {
		Booking booking = new Booking();
		
		booking.setBookingStatus(EntityConstants.ACCEPTED);
		booking.setStartDate(FieldGenerator.getDate(0) + ", " + FieldGenerator.getHour(5));
		booking.setEndDate(FieldGenerator.getDate(1) + ", " + FieldGenerator.getHour(30));
		
//		booking.setItem(new Item());
		booking.setUser(new User());

//		Item sessionItem =  SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		User sessionUser =  SessionUtils.getFromSession(SerenityKeyConstants.USER);

//		booking.getItem().setTitle(sessionItem.getTitle());
		booking.getUser().setName(sessionUser.getName());

		return booking;
	}

	public static Booking getApiBookingInstance() {
		Booking booking = new Booking();

//		Item itemsRequest =  SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		User userRequest = (User) SessionUtils.getFromSession(SerenityKeyConstants.USER);

//		booking.setItemId(itemsRequest.getId());
		booking.setUserId(userRequest.getId());
//		booking.setItem(itemsRequest);
		booking.setUser(userRequest);
		booking.setBookingStatus(EntityConstants.COMPLETED);
		booking.setStartDate(FieldGenerator.getCurrentDate());
		booking.setEndDate(FieldGenerator.getEndDate(30));
		booking.setClientTime(FieldGenerator.getCurrentDate());

		return booking;
	}
}
