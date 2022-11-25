/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.server.repository.entity;

import java.io.Serializable;

/**
 *
 * @author bmtnt
 */
public class CongDung implements Serializable {
    private Long id;
    private String maCongDung;
    private String mota;
    private String ten;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaCongDung() {
        return maCongDung;
    }

    public void setMaCongDung(String maCongDung) {
        this.maCongDung = maCongDung;
    }
    
    
}
