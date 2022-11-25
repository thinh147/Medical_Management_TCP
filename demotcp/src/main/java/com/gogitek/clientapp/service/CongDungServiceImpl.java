package com.gogitek.clientapp.service;

import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.CongDung;
import com.gogitek.clientapp.model.dto.Action;
import com.gogitek.clientapp.model.dto.ModelSender;
import com.gogitek.clientapp.model.dto.ObjectSender;

import java.awt.*;
import java.util.List;

public class CongDungServiceImpl implements CongDungService {
    SocketConnection socketConnection = new SocketConnection();


    @Override
    public SocketConnection updateCongDung(Long id, String maCongDung, String tenCongDung, String mota) {
        CongDung congDung = new CongDung(id, maCongDung, mota, tenCongDung);
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.MODIFY);
        sendObject.setModelSender(ModelSender.CONG_DUNG);
        sendObject.setObject(congDung);
        socketConnection.openSocket();
        socketConnection.sendObject(sendObject);
        return socketConnection;
    }

    @Override
    public SocketConnection deleteCongDungById(Long id) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.DELETE);
        sendObject.setModelSender(ModelSender.CONG_DUNG);
        sendObject.setObject(id);
        socketConnection.openSocket();
        socketConnection.sendObject(sendObject);
        return socketConnection;
    }

    @Override
    public SocketConnection findListCongDungByKey(String key) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.SELECT);
        sendObject.setModelSender(ModelSender.CONG_DUNG);
        sendObject.setObject(key);
        socketConnection.openSocket();
        socketConnection.sendObject(sendObject);
        return socketConnection;
    }
}
