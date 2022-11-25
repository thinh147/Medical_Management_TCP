/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.gogitek.server.repository.CongDungDao;
import com.gogitek.server.repository.ThuocDao;
import com.gogitek.server.repository.entity.CongDung;
import com.gogitek.server.repository.entity.Thuoc;
import com.gogitek.server.repository.entity.dto.ObjectReceiver;
import com.gogitek.server.repository.entity.dto.ServerResponse;
import com.gogitek.server.repository.entity.dto.ThuocSearchRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
            oos.writeObject(res);
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

    private void congDungHandler(ObjectReceiver object) {
        switch (object.getAction()) {
            case MODIFY:
                if (congDungDao.save((CongDung) object.getObject())) {
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
                if(congDungDao.delete((Long) object.getObject())){
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
                if (thuocDao.save((Thuoc) object.getObject())) {
                    sendObject(ServerResponse.OK);
                    message("");
                } else {
                    sendObject(ServerResponse.FAIL);
                }
                break;
            case DELETE:
                if (thuocDao.delete((Long) object.getObject())) {
                    sendObject(ServerResponse.OK);
                    message("sua thanh cong");
                }else {
                    sendObject(ServerResponse.FAIL);
                }
                break;
            case SELECT:
                ThuocSearchRequest req = (ThuocSearchRequest) object.getObject();
                List<Thuoc> congDungList = thuocDao.getAllByKeyword(req.getKeyword(), req.getCongDungId());
                sendObject(congDungList);
                message("get list cong dung " + congDungList.toString());
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
            object = (ObjectReceiver) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    private void message(String message) {
        System.err.println(message);
    }
}
