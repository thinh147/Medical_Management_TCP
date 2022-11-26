/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.gogitek.server.repository.CongDungDao;
import com.gogitek.server.repository.JsonUtils;
import com.gogitek.server.repository.ThuocDao;
import com.gogitek.server.repository.entity.CongDung;
import com.gogitek.server.repository.entity.Thuoc;
import com.gogitek.server.repository.entity.dto.ObjectReceiver;
import com.gogitek.server.repository.entity.dto.ServerResponse;
import com.gogitek.server.repository.entity.dto.ThuocSearchRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author bmtnt
 */
public class SocketConnection {
    private final int port;
    private final CongDungDao congDungDao;
    private final ThuocDao thuocDao;
    private ServerSocket socket;
    private final List<Socket> list;
    private static final Gson gson = new Gson();
    public static void start() {
        new SocketConnection();
    }

    public SocketConnection() {
        port = 1908;
        congDungDao = new CongDungDao();
        thuocDao = new ThuocDao();
        list = new ArrayList<>();
        while (true) {
            try {
                openSocket();
                System.err.println("Listen to port: " + port);
                Socket s = socket.accept();
                list.add(s);
                System.out.println(s);
                execute(s);
                closeSocket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendObject(Object res) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(list.get(list.size() - 1).getOutputStream());
            System.out.println(gson.toJson(res));
            oos.writeObject(gson.toJson(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void execute(Socket s) {
        try {
            ObjectReceiver object = receiveObject(s);
            switch (object.getModelReceiver()) {
                case CONG_DUNG:
                    congDungHandler(object);
                    break;
                case THUOC:
                    thuocHandler(object);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T stringToArray(Object s, Class<T> clazz) {
        return new Gson().fromJson(s.toString(), clazz);
    }

    private void congDungHandler(ObjectReceiver object) {
        switch (object.getAction()) {
            case MODIFY:
                if (congDungDao.save(stringToArray(object.getObject(), CongDung.class))) {
                    sendObject(ServerResponse.OK);
                    message("");
                } else {
                    sendObject(ServerResponse.FAIL);
                }
                break;
            case SELECT:
                List<CongDung> congDungList = congDungDao.getAllByKeyword((String) object.getObject());
                sendObject(congDungList);
                message("get list cong dung " + congDungList.toString());
                break;
            case DELETE:
            if(congDungDao.delete(Long.parseLong(object.getObject().toString()))){
                    thuocDao.deleteByCongDungId(Long.parseLong(object.getObject().toString()));
                    sendObject(ServerResponse.OK);
                    message("Xóa Thành công");
                }else {
                    sendObject(ServerResponse.FAIL);
                }
                break;
        }
    }

    private void thuocHandler(ObjectReceiver object) {
        switch (object.getAction()) {
            case MODIFY:
                if (thuocDao.save(stringToArray(object.getObject(), Thuoc.class))) {
                    sendObject(gson.toJson(ServerResponse.OK));
                    message("");
                } else {
                    sendObject(gson.toJson(ServerResponse.FAIL));
                }
                break;
            case DELETE:
                if (thuocDao.delete(Long.parseLong(object.getObject().toString()))) {
                    sendObject(gson.toJson(ServerResponse.OK));
                    message("sua thanh cong");
                }else {
                    sendObject(gson.toJson(ServerResponse.FAIL));
                }
                break;
            case SELECT:
                List<Thuoc> thuocList = thuocDao.getAllByKeyword((String) object.getObject());
                sendObject(thuocList);
                message("get list thuoc " + thuocList.toString());
                break;
        }
    }

    private void openSocket() {
        try {
            socket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeSocket() {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObjectReceiver receiveObject(Socket s) {
        ObjectReceiver object = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            object = gson.fromJson(ois.readObject().toString(), ObjectReceiver.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    private void message(String message) {
        System.err.println(message);
    }
}
