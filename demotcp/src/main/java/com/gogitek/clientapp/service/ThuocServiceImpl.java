package com.gogitek.clientapp.service;

import com.gogitek.clientapp.controller.SocketConnection;
import com.gogitek.clientapp.model.Thuoc;
import com.gogitek.clientapp.model.dto.Action;
import com.gogitek.clientapp.model.dto.ModelSender;
import com.gogitek.clientapp.model.dto.ObjectSender;

public class ThuocServiceImpl implements ThuocService{
    SocketConnection socketConnection = new SocketConnection();


    @Override
    public SocketConnection updateThuoc(Long id, String maThuoc, String dangThuoc, Double giaThuoc, String tenThuoc, Long congDung) {
        Thuoc thuoc = new Thuoc(id, maThuoc, dangThuoc, giaThuoc, tenThuoc, congDung);
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.MODIFY);
        sendObject.setModelSender(ModelSender.THUOC);
        sendObject.setObject(thuoc);
        socketConnection.openSocket();
        socketConnection.sendObject(sendObject);
        return socketConnection;
    }

    @Override
    public SocketConnection deleteThuocById(Long id) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.DELETE);
        sendObject.setModelSender(ModelSender.THUOC);
        sendObject.setObject(id);
        socketConnection.openSocket();
        socketConnection.sendObject(sendObject);
        return socketConnection;
    }

    @Override
    public SocketConnection findListThuocByKey(String key) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.SELECT);
        sendObject.setModelSender(ModelSender.THUOC);
        sendObject.setObject(key);
        socketConnection.openSocket();
        socketConnection.sendObject(sendObject);
        return socketConnection;
    }
}
