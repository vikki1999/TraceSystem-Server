package com.tracesystem.bean;


/**
 * Created by 刘佳 on 2019-04-10 10:41
 **/
public class ProductMake {
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
    private String designdate;
    private int id;
    private String rawname;

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

    public String getDesigndate() {
        return designdate;
    }

    public void setDesigndate(String designdate) {
        this.designdate = designdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRawname(String rawname) {
        this.rawname = rawname;
    }

    public String getRawname() {
        return rawname;
    }
}
