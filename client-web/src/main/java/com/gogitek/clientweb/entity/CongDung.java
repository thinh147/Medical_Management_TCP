package com.gogitek.clientweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CongDung {
    private String id;
    private String maCongDung;
    private String mota;
    private String ten;

    public Long getLongId(){
        return Long.parseLong(this.id);
    }
    public CongDung(String id, String maCongDung, String mota, String ten) {
        this.id = id;
        this.maCongDung = maCongDung;
        this.mota = mota;
        this.ten = ten;
    }
}
