package com.steps.api.flow_steps;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemsSteps;
import com.steps.api.ApiLoginSteps;
import net.thucydides.core.annotations.Steps;

public class ApiCreateItemFlowSteps {
    @Steps
    ApiLoginSteps apiLoginStepsSteps;
    @Steps
    ApiCategorySteps apiCategoryStepsSteps;
    @Steps
    ApiItemsSteps apiItemsStepsSteps;

    public void createItem() throws IllegalAccessException, InstantiationException{
        apiLoginStepsSteps.loginAsAdmin();
        apiCategoryStepsSteps.createCategory();
        apiItemsStepsSteps.createItem();
    }
}
