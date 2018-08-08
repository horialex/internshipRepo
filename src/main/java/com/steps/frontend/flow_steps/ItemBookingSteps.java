package com.steps.frontend.flow_steps;

import java.util.List;

import com.steps.frontend.BookingsSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.ItemSteps;
import com.steps.frontend.UsersSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Item;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class ItemBookingSteps {
	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	ItemSteps itemSteps;
	@Steps
	UsersSteps usersSteps;
	@Steps
	BookingsSteps bookingsSteps;

	@StepGroup
	public void bookItem() {
		List<Item> items = SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		headerSteps.goTo("ITEMS");
		categorySteps.selectCategory();
		itemSteps.bookItem(items.get(0));
	}

	@StepGroup
	public void goToUser() {
		headerSteps.goTo("USERS");
		usersSteps.selectUser();
	}

	@StepGroup
	public void returnItem() {
		bookingsSteps.returnItem();
	}

	@StepGroup
	public void bookAllItems() {
		List<Item> items = SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		for (Item item : items) {
			headerSteps.goTo("ITEMS");
			categorySteps.selectCategory(item.getCategory().getName());
			itemSteps.bookItem(item);
		}
	}

}
