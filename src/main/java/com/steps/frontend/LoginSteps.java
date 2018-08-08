package com.steps.frontend;

import com.pages.LoginPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.User;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Steps
	HomePageSteps homeSteps;
	LoginPage loginPage;

	@StepGroup
	public void loginAsAdmin() {
		User user = (User) SessionUtils.getFromSession(SerenityKeyConstants.USER);
		homeSteps.clickLogin();
		login(user.getEmail(), user.getPassword());
	}
	
	@Step
	public void login(String email, String password) {
		loginPage.login(email, password);
	}
}
