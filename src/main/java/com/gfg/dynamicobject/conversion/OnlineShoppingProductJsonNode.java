package com.gfg.dynamicobject.conversion;

import com.fasterxml.jackson.databind.JsonNode;

public class OnlineShoppingProductJsonNode {

    private String productName;
    private String productCategory;
    private JsonNode productDetails;

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

    public JsonNode getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(JsonNode productDetails) {
        this.productDetails = productDetails;
    }

}
