package com.tests.api;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemsSteps;
import com.tests.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.ApiLoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ApiCreateItemTest extends BaseTest {
    @Steps
    public ApiLoginSteps apiLoginStepsSteps;
    @Steps
    public ApiCategorySteps apiCategoryStepsSteps;
    @Steps
    public ApiItemsSteps apiItemsStepsSteps;

    @Test
    public void createCategoryItem() throws IllegalAccessException, InstantiationException {
        apiLoginStepsSteps.loginAsAdmin();
        apiCategoryStepsSteps.createCategory();
        apiItemsStepsSteps.createItem();
        
        
    }
}