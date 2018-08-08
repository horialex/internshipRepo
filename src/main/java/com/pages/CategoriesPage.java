package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends AbstractPage {

	@FindBy(css = "ul#categories_container")
	WebElementFacade categoriesContainer;

	// TODO faceti 2 metode, una care doar returneaza o categorie, a doua care d
	// click pe ea sa se bazeze pe prima. Poate mai e nevoie si de altceva decat
	// click. Poate un assert ca exista.
//	public void selectCategory(String categoryName) {
//		List<WebElementFacade> categoryList = categoriesContainer.thenFindAll("h3 a");
//		for (WebElementFacade category : categoryList) {
//			if (category.getText().contentEquals(categoryName)) {
//				category.click();
//				break;
//			}
//		}
//	}
	
	public WebElement getCategory(String categoryName) {
		List<WebElementFacade> categoryList = categoriesContainer.thenFindAll("h3 a");
		for (WebElementFacade category : categoryList) {
			if (category.getText().contentEquals(categoryName)) {
				return category;
			}
		}
		return null;
	}
	
	public void selectCategory(String categoryName) {
		getCategory(categoryName).click();
	}
	
	public void categoryExists(String categoryName, boolean expected) {
		if(expected) {
			Assert.assertNotNull("Category " + categoryName + " was not found", getCategory(categoryName));
		}else {
			Assert.assertNull("Category " + categoryName + " was found", getCategory(categoryName));
		}
	}
	
	

}
