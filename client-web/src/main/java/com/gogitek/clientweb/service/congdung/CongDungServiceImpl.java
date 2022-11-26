package com.gogitek.clientweb.service.congdung;

import com.gogitek.clientweb.JsonUtils;
import com.gogitek.clientweb.service.SocketConnection;
import com.gogitek.clientweb.entity.CongDung;
import com.gogitek.clientweb.entity.dto.Action;
import com.gogitek.clientweb.entity.dto.ModelReceiver;
import com.gogitek.clientweb.entity.dto.ObjectSender;
import com.gogitek.clientweb.entity.dto.ServerResponse;
import com.google.gson.Gson;
import org.apache.catalina.Server;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongDungServiceImpl extends SocketConnection implements CongDungService{
    private static final Gson gson = new Gson();
    @Override
    public void deleteCongDung(Long id) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.DELETE);
        sendObject.setModelReceiver(ModelReceiver.CONG_DUNG);
        sendObject.setObject(id + "");
        sendObject(gson.toJson(sendObject));
        Object object = getResult();

        if(!(ServerResponse.OK.toString().equals(JsonUtils.stringToObject(object.toString(), String.class)))){
            throw new RuntimeException("Xóa thất bại");
        }
    }

    @Override
    public void updateCongDung(CongDung congDung) {
        CongDung res = new CongDung(congDung.getId()+"", congDung.getMaCongDung(), congDung.getMota(), congDung.getTen());
        ObjectSender objectSender = new ObjectSender();
        objectSender.setAction(Action.MODIFY);
        objectSender.setModelReceiver(ModelReceiver.CONG_DUNG);
        objectSender.setObject(res);
        sendObject(gson.toJson(objectSender));
        Object object = getResult();
        if(!(ServerResponse.OK.toString().equals(JsonUtils.stringToObject(object.toString(), String.class)))){
            throw new RuntimeException("Xóa thất bại");
        }
    }

    @Override
    public List<CongDung> getListCongDungByKey(String key) {
        ObjectSender sendObject = new ObjectSender();
        sendObject.setAction(Action.SELECT);
        sendObject.setModelReceiver(ModelReceiver.CONG_DUNG);
        sendObject.setObject(key);
        sendObject(gson.toJson(sendObject));
        Object object = getResult().toString();
        List<CongDung> congDungList = JsonUtils.stringToArray(object.toString(), CongDung[].class);
        congDungList.forEach(System.err::println);
        return congDungList;
    }
}
