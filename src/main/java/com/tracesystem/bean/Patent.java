package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-03-22 09:57
 **/
public class Patent {

    private String patentid;
    private String patentname;
    private String createdate;
    private String patentcategory;
    private String companyname;

    public void setPatentid(String patentid) {
        this.patentid = patentid;
    }

    public String getPatentid() {
        return patentid;
    }

    public void setPatentname(String patentname) {
        this.patentname = patentname;
    }

    public String getPatentname() {
        return patentname;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setPatentcategory(String patentcategory) {
        this.patentcategory = patentcategory;
    }

    public String getPatentcategory() {
        return patentcategory;
    }
}
