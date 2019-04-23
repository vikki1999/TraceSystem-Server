package com.tracesystem.bean;

/**
 * Created by 刘佳 on 2019-04-07 10:57
 **/
public class Role {
    private String roleid;
    private String rolename;
    private String note;
    private String department;
    private String power;

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", note='" + note + '\'' +
                ", departmentid='" + department + '\'' +
                ", power='" + power + '\'' +
                '}';

    }
}
