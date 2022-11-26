package com.gogitek.clientweb.service.thuoc;

import com.gogitek.clientweb.entity.CongDung;
import com.gogitek.clientweb.entity.Thuoc;

import java.util.List;

public interface ThuocService {
    void deleteThuoc(Long id);
    void updateThuoc(Thuoc thuoc);
    List<Thuoc> getListThuoc(String key);
}
