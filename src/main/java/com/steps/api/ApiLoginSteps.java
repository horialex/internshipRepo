package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Login;
import com.tools.entities.User;
import com.tools.factories.LoginFactory;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiLoginSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void loginAsAdmin() {
		Login loginRequest = LoginFactory.getLoginInstance();
		User userResponse = createResource(ApiUrlConstants.LOGIN, loginRequest, User.class);
		AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + userResponse.getAuthenticationToken());
		userResponse.setPassword(loginRequest.getUser().getPassword());
		SessionUtils.putOnSession(SerenityKeyConstants.USER, userResponse);
	}
}
