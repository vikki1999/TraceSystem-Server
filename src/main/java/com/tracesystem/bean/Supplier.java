package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-04-16 19:45
 **/
public class Supplier {
    private String supplierid;
    private String suppliername;
    private String suppliercategory;
    private String companyid;
    private String address;
    private String longitude;
    private String latitude;

    public String getSupplierid() {
        return supplierid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getSuppliercategory() {
        return suppliercategory;
    }

    public void setSuppliercategory(String suppliercategory) {
        this.suppliercategory = suppliercategory;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
