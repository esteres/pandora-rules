package com.pandora.api.facts;

import java.lang.Double;
import java.lang.String;
import java.lang.System;

public class Item {
    private String sku;
    private Double price;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void printMessage() {
        System.out.println("The final price with  discount of 10%  applied to price is "+String.format( "%.2f", price )+" of the item that contain this sku: " +sku);
    }
}