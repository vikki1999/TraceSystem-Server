package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-03-22 09:57
 **/
public class Distribute {
    private String distributeid;
    private String distributename;
    private String address;
    private String companyid;
    private String createdate;

    public void setDistributeid(String distributeid) {
        this.distributeid = distributeid;
    }

    public String getDistributeid() {
        return distributeid;
    }

    public void setDistributename(String distributename) {
        this.distributename = distributename;
    }

    public String getDistributename() {
        return distributename;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
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

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatedate() {
        return createdate;
    }
}
