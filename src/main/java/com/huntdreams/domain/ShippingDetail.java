package com.huntdreams.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情
 * Created by noprom on 1/30/16.
 */
public class ShippingDetail implements Serializable {

    private String name;//名称

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;//时间

    private Address shippingAddress;//地址

    public ShippingDetail() {
        this.shippingAddress = new Address();
    }
}