package com.team3.baby.rxbus.event;

/**
 * data:2017/5/25
 * author:郭彦君(Administrator)
 * function:
 */
public class Account_shoppingcar {
    private String price;
    private String count;

    public Account_shoppingcar(String price, String count) {
        this.price = price;
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
