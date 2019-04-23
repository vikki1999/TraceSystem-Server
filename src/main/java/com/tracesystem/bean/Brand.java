package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-03-22 09:57
 **/
public class Brand {
    private String brandid;
    private String brandname;
    private String history;
    private String category;
    private String createtime;
    private String companyname;
    private String src;
    private String companyid;

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyid() {
        return companyid;
    }
}
