package com.gfg.dynamicobject.conversion;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class OnlineShoppingProduct {

    private String productName;
    private String productCategory;
    private Map<String, Object> productDetails = new LinkedHashMap<>();
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Map<String, Object> getProductDetails() {
		return productDetails;
	}
	@JsonAnySetter
	public void setProductDetails(String key, Object value) {
		productDetails.put(key,value);
	}

	

}
