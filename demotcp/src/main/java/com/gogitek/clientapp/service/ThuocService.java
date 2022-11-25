package com.gogitek.clientapp.service;

import com.gogitek.clientapp.controller.SocketConnection;

public interface ThuocService {
    SocketConnection updateThuoc(Long id, String maThuoc, String dangThuoc, Double giaThuoc, String tenThuoc, Long congDung);
    SocketConnection deleteThuocById(Long id);
    SocketConnection findListThuocByKey(String key);
}
