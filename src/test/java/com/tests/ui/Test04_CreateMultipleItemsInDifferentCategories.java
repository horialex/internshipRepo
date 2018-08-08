package com.tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemsSteps;
import com.steps.api.ApiLoginSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.ItemSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.flow_steps.ItemFlowSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test04_CreateMultipleItemsInDifferentCategories extends BaseTest {

	@Steps
	LoginSteps loginSteps;
	@Steps
	public ApiLoginSteps apiLoginStepsSteps;
	@Steps
	ApiCategorySteps apiCategoryStepsSteps;
	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	HomePageSteps homePageSteps;
	@Steps
	ApiItemsSteps apiItemsStepsSteps;
	@Steps
	ItemSteps itemSteps;
	@Steps
	ItemFlowSteps itemFlowSteps;
	
	@Before
	public void testPreparation() throws Exception {
		apiLoginStepsSteps.loginAsAdmin();
		apiCategoryStepsSteps.removeAllCategories();
		apiCategoryStepsSteps.createCategory();
		apiItemsStepsSteps.createItem();
		apiCategoryStepsSteps.createCategory();
		apiItemsStepsSteps.createItem();
	}

	@Test
	public void createMultipleItemsTest() {
		homePageSteps.getHomePage();
		loginSteps.loginAsAdmin();
		itemFlowSteps.verifyItemsAreCreated();
	}

}
