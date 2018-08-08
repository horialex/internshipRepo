package com.tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.flow_steps.ApiCreateItemFlowSteps;
import com.steps.frontend.BookingsSteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.flow_steps.ItemBookingSteps;
import com.steps.validations.ItemValidationSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test01_BookItem extends BaseTest {
	
	@Steps
	LoginSteps loginSteps;
	@Steps
	ItemValidationSteps itemValidationSteps;
	@Steps
	ItemBookingSteps itemBookingSteps;
	@Steps
	ApiCreateItemFlowSteps apiCreateItemFlowSteps;
	@Steps
	HeaderSteps headerSteps;
	@Steps
	BookingsSteps bookingSteps;
	@Steps
	HomePageSteps homePageSteps;

	@Before
	public void setUp() throws IllegalAccessException, InstantiationException {
		 apiCreateItemFlowSteps.createItem();
	}

	@Test
	public void bookItemTest() throws Exception {
		homePageSteps.getHomePage();
		loginSteps.loginAsAdmin();
		itemBookingSteps.bookItem();
		headerSteps.goTo("BOOKINGS");
		bookingSteps.selectBookingsTab("My Bookings");
		itemValidationSteps.validateItemIsBooked();
	}
}
