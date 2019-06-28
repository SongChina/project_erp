package com.cskaoyan.bean;

public class COrderDetail extends COrder{
    public Product product;
    public Custom custom;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }
}
