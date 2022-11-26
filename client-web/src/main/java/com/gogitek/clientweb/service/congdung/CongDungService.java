package com.gogitek.clientweb.service.congdung;

import com.gogitek.clientweb.entity.CongDung;

import java.util.List;

public interface CongDungService {
    void deleteCongDung(Long id);
    void updateCongDung(CongDung congDung);
    List<CongDung> getListCongDungByKey(String key);
}
