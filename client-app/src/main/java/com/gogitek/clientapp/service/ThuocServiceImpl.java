package com.gogitek.clientapp.service;

import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.Thuoc;
import com.gogitek.clientapp.model.dto.Action;
import com.gogitek.clientapp.model.dto.ModelReceiver;
import com.gogitek.clientapp.model.dto.ObjectSender;
import com.google.gson.Gson;

public class ThuocServiceImpl implements ThuocService{
    private static final Gson gson = new Gson();
    SocketConnection socketConnection = new SocketConnection();


    @Override
    public SocketConnection updateThuoc(Long id, String maThuoc, String dangThuoc, Double giaThuoc, String tenThuoc, Long congDung) {
        Thuoc thuoc = new Thuoc(id+"", maThuoc, dangThuoc, giaThuoc, tenThuoc, congDung);
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.MODIFY);
        sendObject.setModelReceiver(ModelReceiver.THUOC);
        sendObject.setObject(thuoc);
        String s = gson.toJson(sendObject);
        socketConnection.openSocket();
        socketConnection.sendObject(s);
        return socketConnection;
    }

    @Override
    public SocketConnection deleteThuocById(Long id) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.DELETE);
        sendObject.setModelReceiver(ModelReceiver.THUOC);
        sendObject.setObject(id+"");
        socketConnection.openSocket();
        socketConnection.sendObject(gson.toJson(sendObject));
        return socketConnection;
    }

    @Override
    public SocketConnection findListThuocByKey(String key) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.SELECT);
        sendObject.setModelReceiver(ModelReceiver.THUOC);
        sendObject.setObject(key);
        socketConnection.openSocket();
        String s = gson.toJson(sendObject);
        socketConnection.sendObject(s);
        return socketConnection;
    }
}
