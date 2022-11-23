package com.gogitek.server.repository.entity.dto;

public class ThuocSearchRequest {
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
