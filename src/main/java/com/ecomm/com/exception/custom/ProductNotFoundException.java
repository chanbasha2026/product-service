package com.ecomm.com.exception.custom;

public class ProductNotFoundException  extends RuntimeException{
    private String message;
    public ProductNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
