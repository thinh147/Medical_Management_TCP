package com.gogitek.clientapp.model;

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

    public CongDung(Long id, String maCongDung, String mota, String ten) {
        this.id = id;
        this.maCongDung = maCongDung;
        this.mota = mota;
        this.ten = ten;
    }
}
