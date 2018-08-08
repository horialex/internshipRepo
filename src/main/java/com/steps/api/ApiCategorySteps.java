package com.steps.api;

import java.util.Arrays;
import java.util.List;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.CategoriesCollection;
import com.tools.entities.Category;
import com.tools.factories.CategoryFactory;
import com.tools.utils.MergeUtils;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiCategorySteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	// @Step
	// public void createCategory() throws IllegalAccessException,
	// InstantiationException {
	// Category categoryRequest = CategoryFactory.getCategoryInstance();
	// Category categoryResponse = createResource(ApiUrlConstants.CATEGORIES,
	// categoryRequest, Category.class);
	// categoryRequest= MergeUtils.mergeObjects(categoryRequest, categoryResponse);
	// SessionUtils.putOnSession(SerenityKeyConstants.CATEGORY, categoryRequest);
	// }

	@Step
	public void createCategory() throws IllegalAccessException, InstantiationException {
		Category categoryRequest = CategoryFactory.getCategoryInstance();
		Category categoryResponse = createResource(ApiUrlConstants.CATEGORIES, categoryRequest, Category.class);
		categoryRequest = MergeUtils.mergeObjects(categoryRequest, categoryResponse);
		SessionUtils.putOnSession(SerenityKeyConstants.CATEGORY, categoryRequest);
	}
	
	@Step
	public void createMultipleCategories(int numberOfCategories) throws IllegalAccessException, InstantiationException {
		for(int i = 0; i < numberOfCategories; i++) {
			Category categoryRequest = CategoryFactory.getCategoryInstance();
			Category categoryResponse = createResource(ApiUrlConstants.CATEGORIES, categoryRequest, Category.class);
			categoryRequest = MergeUtils.mergeObjects(categoryRequest, categoryResponse);
			SessionUtils.saveObjectListInSerenitySession(SerenityKeyConstants.CATEGORY, categoryRequest);
		}
	}

	@Step
	public void howManyCategories() {
		List<Category> categoriesList =  SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		System.out.println("Categories list size " + categoriesList.size());
	}
	
	@Step
	public void removeAllCategories() {
		CategoriesCollection[] categories = getResource(ApiUrlConstants.CATEGORIES + "?perPage=9999", CategoriesCollection[].class);
		List<CategoriesCollection> pojoList = Arrays.asList(categories);
		pojoList.forEach(s -> {
			deleteResource(ApiUrlConstants.CATEGORIES,  s.getId());
		});
		
	}

}
