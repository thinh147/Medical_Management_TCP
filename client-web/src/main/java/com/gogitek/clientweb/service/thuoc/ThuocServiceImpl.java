package com.gogitek.clientweb.service.thuoc;

import com.gogitek.clientweb.JsonUtils;
import com.gogitek.clientweb.entity.CongDung;
import com.gogitek.clientweb.entity.Thuoc;
import com.gogitek.clientweb.entity.dto.Action;
import com.gogitek.clientweb.entity.dto.ModelReceiver;
import com.gogitek.clientweb.entity.dto.ObjectSender;
import com.gogitek.clientweb.entity.dto.ServerResponse;
import com.gogitek.clientweb.service.SocketConnection;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuocServiceImpl extends SocketConnection implements ThuocService {
    private static final Gson gson = new Gson();

    @Override
    public void deleteThuoc(Long id) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.DELETE);
        sendObject.setModelReceiver(ModelReceiver.THUOC);
        sendObject.setObject(id + "");
        sendObject(gson.toJson(sendObject));
        Object object = getResult();

        if(!(ServerResponse.OK.toString().equals(JsonUtils.stringToObject(object.toString(), String.class)))){
            throw new RuntimeException("Xóa thất bại");
        }
    }

    @Override
    public void updateThuoc(Thuoc thuoc) {
        Thuoc res = new Thuoc(thuoc.getId(), thuoc.getMaThuoc(), thuoc.getDangThuoc(), thuoc.getGiaThuoc(), thuoc.getTenThuoc(), thuoc.getCongDungId());
        ObjectSender objectSender = new ObjectSender();
        objectSender.setAction(Action.MODIFY);
        objectSender.setModelReceiver(ModelReceiver.THUOC);
        objectSender.setObject(res);
        sendObject(gson.toJson(objectSender));
        Object object = getResult();
        if(!(ServerResponse.OK.toString().equals(JsonUtils.stringToObject(object.toString(), String.class)))){
            throw new RuntimeException("Xóa thất bại");
        }
    }

    @Override
    public List<Thuoc> getListThuoc(String key) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.SELECT);
        sendObject.setModelReceiver(ModelReceiver.THUOC);
        sendObject.setObject(key);
        sendObject(gson.toJson(sendObject));
        Object object = getResult().toString();
        List<Thuoc> congDungList = JsonUtils.stringToArray(object.toString(), Thuoc[].class);
        congDungList.forEach(System.err::println);
        return congDungList;
    }
}
