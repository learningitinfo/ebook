package com.leshan.ebook.mybatis.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;
    private String name;
    private Integer status;
    private String navable;

    public Category() {
    }

    public Category(Integer id, String name, Integer status, String navable) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.navable = navable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNavable() {
        return navable;
    }

    public void setNavable(String navable) {
        this.navable = navable;
    }
}
