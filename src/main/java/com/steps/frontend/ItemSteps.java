package com.steps.frontend;

import java.util.List;

import com.pages.ItemsPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.entities.Item;
import com.tools.factories.BookingFactory;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ItemSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	ItemsPage itemsPage;

	
	@Step
	public void verifyItemIsPresent() {
		List<Item> items =  SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		itemsPage.itemExists(items.get(0).getTitle(), true);
	}
	
	@Step
	public void verifyItemIsPresent(String itemTitle) {
		itemsPage.itemExists(itemTitle, true);
	}
	
	@Step
	public void verifyItemIsNotPresent() {
		List<Item> items =  SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		itemsPage.itemExists(items.get(0).getTitle(), false);
	}
	
	@Step
	public void verifyItemsArePresent() {
		List<Item> items =  SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		items.forEach(s -> {
			itemsPage.itemExists(s.getTitle(), true);
		});
	}
	
	
	@StepGroup
	public void bookItem(Item item) {
		Booking booking = BookingFactory.getBookingInstance();
		booking.setItem(item);
		itemsPage.clickBookItem(item.getTitle());
		itemsPage.selectStartDate(booking.getStartDate());
		itemsPage.selectStartHour(booking.getStartDate());
		itemsPage.selectEndDate(booking.getEndDate());
		itemsPage.selectEndHour(booking.getEndDate());
		itemsPage.saveBooking();
		SessionUtils.putOnSession(SerenityKeyConstants.BOOKING, booking);
	}
	
	@StepGroup
	public void bookItem() {
		Booking booking = BookingFactory.getBookingInstance();
		clickBookItem(booking.getItem().getTitle());
		selectStartDate(booking.getStartDate());
		selectStartHour(booking.getStartDate());
		selectEndDate(booking.getEndDate());
		selectEndHour(booking.getEndDate());
		saveBooking();
		SessionUtils.putOnSession(SerenityKeyConstants.BOOKING, booking);
	}

	@Step
	public void selectStartHour(String startHour) {
		itemsPage.selectStartHour(startHour);
	}

	@Step
	public void selectEndHour(String endHour) {
		itemsPage.selectEndHour(endHour);
	}

	@Step
	public void clickBookItem(String itemName) {
		itemsPage.clickBookItem(itemName);

	}

	@Step
	public void selectStartDate(String startDate) {
		itemsPage.selectStartDate(startDate);
	}

	@Step
	public void selectEndDate(String endDate) {
		itemsPage.selectEndDate(endDate);
	}

	@Step
	public void saveBooking() {
		itemsPage.saveBooking();
	}
}
