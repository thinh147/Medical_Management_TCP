package com.gogitek.clientweb.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class SocketConnection {
    private static final int port= 1908;
    private static final String host= "localhost";
    private Socket mySocket;

    private void openSocket() {
        try {
            mySocket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object) {
        openSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getResult() {
        Object res = new Object();
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res =  ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void closeConnection() {
        try {
            mySocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
