package com.huntdreams.domain;

import java.io.Serializable;

/**
 * 用户model
 * Created by noprom on 1/22/16.
 */
public class Customer implements Serializable{

    private String customerId;//用户id
    private String name;//姓名
    private Address shippingAddress;//地址
    private String phoneNumber;//电话

    public Customer() {
        super();
        this.shippingAddress = new Address();
    }

    public Customer(String customerId, String name) {
        super();
        this.customerId = customerId;
        this.name = name;
    }

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

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else if (!customerId.equals(other.customerId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((customerId == null) ? 0 : customerId.hashCode());
        return result;
    }
}