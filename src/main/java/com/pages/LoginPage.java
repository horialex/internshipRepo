package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "input#email")
    private WebElement emailInput;
    
    @FindBy(css = "input#pass")
    private WebElement passwordInput;
    
    @FindBy(css = "input[class*='signin']")
    private WebElement signInButton;

    
    public void login(String email, String password) {
    	emailInput.sendKeys(email);
    	passwordInput.sendKeys(password);
    	signInButton.click();
    }
}
