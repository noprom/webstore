package com.huntdreams.domain;

/**
 * Address实体
 * Created by noprom on 1/30/16.
 */
public class Address {
    private String doorNo;//门牌号
    private String streetName;//街道名称
    private String areaName;//地区
    private String state;//洲
    private String country;//国家
    private String zipCode;//邮编

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (doorNo == null) {
            if (other.doorNo != null)
                return false;
        } else if (!doorNo.equals(other.doorNo) || !zipCode.equals(other.zipCode)
                ||!country.equals(other.country) || !state.equals(other.state)
                ||!areaName.equals(other.areaName) || !streetName.equals(other.streetName))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Address [doorNo = " + doorNo + ", streetName = " + streetName + ", areaName = " + areaName+
                ", state = " + state + ", country = " + country + ", zipCode = " + zipCode + "]";
    }
}
