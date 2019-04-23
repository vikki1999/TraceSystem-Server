package com.tracesystem.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    /**
     * Created by 刘佳 on 2019/2/12
     */

    private int userid;
    private String username;//用户姓名
    private String loginpwd;//登陆密码
    private String mobilephone;//电话号码
    private String email;//邮箱
    private String permissions;//权限
    private String local;//地区
    private String gender;//性别
    private String createtime;//账号创建时间
    private String roleid;//角色编码
    private String rolename;//角色名
    private String companyid;//公司编码
    private String power;//权限
    private String moudelid;//模块编码
    private String indexpage;//首页路径

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }


    public String getGender() { return gender;    }

    public void setGender(String gender) { this.gender = gender;    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleid() {
        return roleid;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setMoudelid(String moudelid) {
        this.moudelid = moudelid;
    }

    public String getMoudelid() {
        return moudelid;
    }

    public String getIndexpage() {
        return indexpage;
    }

    public void setIndexpage(String indexpage) {
        this.indexpage = indexpage;
    }

    @Override
        public String toString() {
            return "User{" +
                    "userid=" + userid +
                    ", username='" + username + '\'' +
                    ", loginpwd='" + loginpwd + '\'' +
                    ", mobilephone='" + mobilephone + '\'' +
                    ", email='" + email + '\'' +
                    ", permissions='" + permissions + '\'' +
                    ", local='" + local + '\'' +
                    ", gender='" + gender + '\'' +
                    ", createtime='" + createtime + '\'' +
                    ", roleid='" + roleid + '\'' +
                    ", companyid='" + companyid + '\'' +
                    ", power='" + power + '\'' +
                    ", moudelid='" + moudelid + '\'' +
                    ",indexpage='"+indexpage+'\''+
                    '}';
        }

}
