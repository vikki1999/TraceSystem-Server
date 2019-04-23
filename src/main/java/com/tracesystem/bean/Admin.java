package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-03-19 15:20
 **/
public class Admin {
    private int adminid;
    private int userid;
    private String username;//用户名
    private String gender;//性别
    private String mobilephone;//手机号码
    private String email;//email
    private String local;
    private String ethaccount;//区块链账号
    private String ethpwd;//区块链密码


    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setEthpwd(String ethpwd) {
        this.ethpwd = ethpwd;
    }

    public String getEthpwd() {
        return ethpwd;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEthaccount(String ethaccount) {
        this.ethaccount = ethaccount;
    }

    public String getEthaccount() {
        return ethaccount;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", adminid='" + adminid + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", email='" + email + '\'' +
                ", ethaccount='" + ethaccount + '\'' +
                ", local='" + local + '\'' +
                ", gender='" + gender + '\'' +
                ", ethpwd='" + ethpwd + '\'' +
                '}';
    }
}
