package com.gogitek.clientapp.service;

import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.CongDung;

import java.util.List;


public interface CongDungService {
    SocketConnection updateCongDung(Long id, String maCongDung, String tenCongDung, String mota);
    SocketConnection deleteCongDungById(Long id);
    SocketConnection findListCongDungByKey(String key);
}
