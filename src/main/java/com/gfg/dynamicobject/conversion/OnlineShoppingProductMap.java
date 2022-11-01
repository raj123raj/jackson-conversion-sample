package com.gfg.dynamicobject.conversion;

import java.util.Map;

public class OnlineShoppingProductMap {

    private String productName;
    private String productCategory;
    private Map<String, Object> productDetails;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String category) {
        this.productCategory = category;
    }

    public Map<String, Object> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Map<String, Object> productDetails) {
        this.productDetails = productDetails;
    }

}
