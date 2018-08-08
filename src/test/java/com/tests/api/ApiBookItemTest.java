package com.tests.api;

import com.steps.api.ApiBookingSteps;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemsSteps;
import com.steps.api.ApiLoginSteps;
import com.tests.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ApiBookItemTest extends BaseTest{
    @Steps
    public ApiLoginSteps apiLoginStepsSteps;
    @Steps
    public ApiCategorySteps apiCategoryStepsSteps;
    @Steps
    public ApiItemsSteps apiItemsStepsSteps;
    @Steps
    public ApiBookingSteps apiBookingStepsSteps;

    @Test
    public void apiBookItem() throws IllegalAccessException, InstantiationException {
        apiLoginStepsSteps.loginAsAdmin();
        apiCategoryStepsSteps.createCategory();
        apiItemsStepsSteps.createItem();
        apiBookingStepsSteps.bookItem();
    }
}
