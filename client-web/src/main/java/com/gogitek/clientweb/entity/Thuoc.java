package com.gogitek.clientweb.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thuoc {
    private String id;
    private String maThuoc;
    private String dangThuoc;
    private Double giaThuoc;
    private String tenThuoc;
    private Long congDungId;

    public Thuoc() {
    }

    public Thuoc(String id, String maThuoc, String dangThuoc, Double giaThuoc, String tenThuoc, Long congDungId) {
        this.id = id;
        this.maThuoc = maThuoc;
        this.dangThuoc = dangThuoc;
        this.giaThuoc = giaThuoc;
        this.tenThuoc = tenThuoc;
        this.congDungId = congDungId;
    }
}
