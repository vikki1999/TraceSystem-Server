package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-04-15 22:09
 **/
public class ProductMakeItem {
    private String productmakeid;
    private String productmakeitemid;
    private String time;
    private String status;
    private String productid;
    private String productmakename;
    private int step;
    private String companyname;
    private String technologyname;
    private String productname;
    private String traceid;

    public void setProductmakeid(String productmakeid) {
        this.productmakeid = productmakeid;
    }

    public String getProductmakeid() {
        return productmakeid;
    }

    public void setProductmakename(String productmakename) {
        this.productmakename = productmakename;
    }

    public int getStep() {
        return step;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getProductmakename() {
        return productmakename;
    }

    public void setTechnologyname(String technologyname) {
        this.technologyname = technologyname;
    }

    public String getTechnologyname() {
        return technologyname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public String getProductmakeitemid() {
        return productmakeitemid;
    }

    public void setProductmakeitemid(String productmakeitemid) {
        this.productmakeitemid = productmakeitemid;
    }

    public String getStatus() {
        return status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProductid() {
        return productid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getTime() {
        return time;
    }

    public String getTraceid() {
        return traceid;
    }

    public void setTraceid(String traceid) {
        this.traceid = traceid;
    }
}
