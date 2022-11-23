/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.server.repository.entity;

/**
 *
 * @author bmtnt
 */
public class Thuoc {
    private Long id;
    private String maThuoc;
    private String dangThuoc;
    private Double giaThuoc;
    private String tenThuoc;
    private Long congDungId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
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

    public String getDangThuoc() {
        return dangThuoc;
    }

    public void setDangThuoc(String dangThuoc) {
        this.dangThuoc = dangThuoc;
    }
}
