package com.gogitek.clientapp.service;

import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.CongDung;
import com.gogitek.clientapp.model.dto.Action;
import com.gogitek.clientapp.model.dto.ModelReceiver;
import com.gogitek.clientapp.model.dto.ObjectSender;
import com.google.gson.Gson;

public class CongDungServiceImpl implements CongDungService {
    SocketConnection socketConnection = new SocketConnection();
    private static final Gson gson = new Gson();

    @Override
    public SocketConnection updateCongDung(Long id, String maCongDung, String tenCongDung, String mota) {
        CongDung congDung = new CongDung(id+"", maCongDung, mota, tenCongDung);
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.MODIFY);
        sendObject.setModelReceiver(ModelReceiver.CONG_DUNG);
        sendObject.setObject(congDung);
        socketConnection.openSocket();
        String s = gson.toJson(sendObject);
        socketConnection.sendObject(s);
        return socketConnection;
    }

    @Override
    public SocketConnection deleteCongDungById(Long id) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.DELETE);
        sendObject.setModelReceiver(ModelReceiver.CONG_DUNG);
        sendObject.setObject(id + "");
        socketConnection.openSocket();
        String s = gson.toJson(sendObject);
        socketConnection.sendObject(s);
        return socketConnection;
    }

    @Override
    public SocketConnection findListCongDungByKey(String key) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.SELECT);
        sendObject.setModelReceiver(ModelReceiver.CONG_DUNG);
        sendObject.setObject(key);
        socketConnection.openSocket();
        String s = gson.toJson(sendObject);
        socketConnection.sendObject(s);
        return socketConnection;
    }
}
