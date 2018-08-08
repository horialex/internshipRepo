package com.tools.factories;

import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Category;
import com.tools.entities.Item;
import com.tools.utils.FieldGenerator;
import com.tools.utils.SessionUtils;

public class ItemFactory {

	public static Item getCategoryItemInstance() {

		Category category = SessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);

		Item item = new Item();
		item.setTitle("Item - " + FieldGenerator.generateStringValue(4, FieldGenerator.TypeOfString.ALPHANUMERIC));
		item.setCustomFields(new Object[0]);
		item.setCategoryId(category.getId());

		return item;
	}
}
