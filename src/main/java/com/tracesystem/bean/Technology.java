package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-02-24 14:40
 **/
public class Technology {
    private int technologyid;
    private String technologyname;
    private String note;
    private String patentid;
    private String companyid;
    private String patentcategory;

    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }

    public void setTechnologyid(int technologyid) {
        this.technologyid = technologyid;
    }

    public int getTechnologyid() {
        return technologyid;
    }

    public void setTechnologyname(String technologyname) {
        this.technologyname = technologyname;
    }

    public String getTechnologyname() {
        return technologyname;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setPatentid(String patentid) {
        this.patentid = patentid;
    }

    public String getPatentid() {
        return patentid;
    }

    public void setPatentcategory(String patentcategory) {
        this.patentcategory = patentcategory;
    }

    public String getPatentcategory() {
        return patentcategory;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
