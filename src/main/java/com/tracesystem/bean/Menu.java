package com.tracesystem.bean;

import java.util.List;

/**
 * Created by 刘佳 on 2019-03-27 10:20
 **/

public class Menu {
    private int id;
    private String path;
    private String name;
    private int number;
    private String icon;
    private String key;
    private String parentkey;
    private String power;
    private String moudelid;
    private List<Menu> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMoudel() {
        return moudelid;
    }

    public void setMoudel(String moudelid) {
        this.moudelid = moudelid;
    }

    public String getParentkey() {
        return parentkey;
    }

    public void setParentkey(String parentkey) {
        this.parentkey = parentkey;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", parentkey='" + parentkey + '\'' +
                ", number=" + number +
                ", icon='" + icon + '\'' +
                ", power='" + power + '\'' +
                ", moudelid='" + moudelid + '\'' +
                '}';

    }
}
