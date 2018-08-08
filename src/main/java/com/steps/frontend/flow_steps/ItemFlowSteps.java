package com.steps.frontend.flow_steps;


import java.util.List;

import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.ItemSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Item;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Steps;

public class ItemFlowSteps {

	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	ItemSteps itemSteps;
	
	public void verifyItemsAreCreated() {
		  List<Item> items = SessionUtils.getFromSession(SerenityKeyConstants.ITEM);
	      items.forEach(s -> {
	    	  headerSteps.goTo("ITEMS");
	    	  categorySteps.selectCategory(s.getCategory().getName()); 
	    	  itemSteps.verifyItemIsPresent(s.getTitle());
	      });
	}

}
