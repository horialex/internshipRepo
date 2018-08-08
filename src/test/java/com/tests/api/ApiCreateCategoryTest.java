package com.tests.api;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiLoginSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ApiCreateCategoryTest extends BaseTest {
    @Steps
    public ApiLoginSteps apiLoginStepsSteps;
    @Steps
    ApiCategorySteps apiCategoryStepsSteps;

    @Test
    public void createCategory() throws Exception {
        apiLoginStepsSteps.loginAsAdmin();
        apiCategoryStepsSteps.createCategory();
    }
}