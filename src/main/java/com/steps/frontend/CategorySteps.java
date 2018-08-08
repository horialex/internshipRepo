package com.steps.frontend;

import java.util.List;

import com.pages.CategoriesPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Category;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class CategorySteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	CategoriesPage categoriesPage;

	@Step
	public void selectCategory() {
		Category category = SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		categoriesPage.selectCategory(category.getName());
	}
	
	@Step
	public void selectCategory(String categoryName) {
		categoriesPage.selectCategory(categoryName);
	}

	@Step
	public void verifyCategoryIsPresent() {
		Category category = SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		categoriesPage.categoryExists(category.getName(), true);
	}

	@Step
	public void verifyCategoryIsNotPresent() {
		Category category =  SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		categoriesPage.categoryExists(category.getName(), false);
	}

	public void verifyCategoriesArePresent() {
		List<Category> categoriesList = SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		categoriesList.forEach(s -> {
			categoriesPage.categoryExists(s.getName(), true);
		});
	}

}
