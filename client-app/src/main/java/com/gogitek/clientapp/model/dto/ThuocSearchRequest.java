package com.gogitek.clientapp.model.dto;

import java.io.Serializable;

public class ThuocSearchRequest implements Serializable {
    private String keyword;
    private Long congDungId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getCongDungId() {
        return congDungId;
    }

    public void setCongDungId(Long congDungId) {
        this.congDungId = congDungId;
    }
}
