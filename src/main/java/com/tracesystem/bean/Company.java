package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-03-21 21:13
 **/
public class Company {
    private String companyid;
    private String companyname;
    private String abbreviation;
    private String certificate;
    private String address;
    private String parentid;
    private String createtime;

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getParentid() {
        return parentid;
    }
}
