package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class UsersPage extends AbstractPage {
	@FindBy(css = "div[class*='list-container'] ul")
	WebElementFacade usersContainer;

	// TODO la fel, o metoda care sa returneze un WebElement user si alta care
	// sa faca click pe user
	public void selectUser(String userName) {
		List<WebElementFacade> usersList = usersContainer.thenFindAll(By.cssSelector("h3 a"));
		for (WebElementFacade user : usersList) {
			if (user.getText().trim().contentEquals(userName)) {
				user.click();
				break;
			}
		}
	}
}
