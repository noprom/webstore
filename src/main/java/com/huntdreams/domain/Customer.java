package com.huntdreams.domain;

/**
 * 用户model
 * Created by noprom on 1/22/16.
 */
public class Customer {
    private String customerId;//用户id
    private String name;//姓名
    private String address;//地址

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
