/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.clientapp.model;

import java.io.Serializable;

/**
 *
 * @author bmtnt
 */
public class Thuoc implements Serializable {
    private String id;
    private String maThuoc;
    private String dangThuoc;
    private Double giaThuoc;
    private String tenThuoc;
    private Long congDungId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getDangThuoc() {
        return dangThuoc;
    }

    public void setDangThuoc(String dangThuoc) {
        this.dangThuoc = dangThuoc;
    }

    public Double getGiaThuoc() {
        return giaThuoc;
    }

    public void setGiaThuoc(Double giaThuoc) {
        this.giaThuoc = giaThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public Long getCongDungId() {
        return congDungId;
    }

    public void setCongDungId(Long congDungId) {
        this.congDungId = congDungId;
    }

    public Thuoc(String id, String maThuoc, String dangThuoc, Double giaThuoc, String tenThuoc, Long congDungId) {
        this.id = id;
        this.maThuoc = maThuoc;
        this.dangThuoc = dangThuoc;
        this.giaThuoc = giaThuoc;
        this.tenThuoc = tenThuoc;
        this.congDungId = congDungId;
    }

    public Thuoc(String maThuoc, String dangThuoc, Double giaThuoc, String tenThuoc, Long congDungId) {
        this.maThuoc = maThuoc;
        this.dangThuoc = dangThuoc;
        this.giaThuoc = giaThuoc;
        this.tenThuoc = tenThuoc;
        this.congDungId = congDungId;
    }
}
