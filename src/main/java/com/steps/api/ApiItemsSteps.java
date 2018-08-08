package com.steps.api;

import com.tools.constants.ApiUrlConstants;
import com.tools.constants.SerenityKeyConstants;
import com.tools.entities.Item;
import com.tools.factories.ItemFactory;
import com.tools.utils.MergeUtils;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiItemsSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

    @Step
    public void createItem() throws IllegalAccessException, InstantiationException {
        Item itemsRequest = ItemFactory.getCategoryItemInstance();
        Item itemsResponse = createResource(ApiUrlConstants.ITEMS, itemsRequest, Item.class);
        itemsRequest = MergeUtils.mergeObjects(itemsRequest, itemsResponse);
        SessionUtils.saveObjectListInSerenitySession(SerenityKeyConstants.ITEM, itemsRequest);
    }
    
}
