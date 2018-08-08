package com.tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiLoginSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test05_CreateMultipleCategories extends BaseTest {

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

	@Before
	public void testPreparation() throws Exception {
		apiLoginStepsSteps.loginAsAdmin();
		apiCategoryStepsSteps.removeAllCategories();
		apiCategoryStepsSteps.createMultipleCategories(2);
	}

	@Test
	public void createMultipleCategoriesTest() {
		homePageSteps.getHomePage();
		loginSteps.loginAsAdmin();
		headerSteps.goTo("ITEMS");
		categorySteps.verifyCategoriesArePresent();
	}

}
