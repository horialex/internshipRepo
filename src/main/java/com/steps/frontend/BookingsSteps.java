package com.steps.frontend;

import com.pages.BookingsPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Booking;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class BookingsSteps extends AbstractSteps {
 
	private static final long serialVersionUID = 1L;
	
	BookingsPage bookingsPage;

    @Step
	public void returnItem(){
        Booking booking = (Booking) SessionUtils.getFromSession(SerenityKeyConstants.BOOKING);
        bookingsPage.returnItem(booking);
    }
    
    @Step
    public void selectBookingsTab(String tabName) {
    	bookingsPage.selectBookingTab(tabName);
    }
}
