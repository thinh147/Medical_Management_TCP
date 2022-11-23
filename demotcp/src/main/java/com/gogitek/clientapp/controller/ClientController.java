/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gogitek.clientapp.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Hiep
 */
public class ClientController {

    private int port;
    private String host;
    private Socket mySocket;
    private ArrayList<Socket> list;

    public ClientController() {
        host = "localhost";
        port = 8000;
    }

    public void openSocket() {
        try {
            mySocket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public String getResult() {
        String res = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res = (String) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void closeConnection() {
        try {
            mySocket.close();
        } catch (Exception e) {
        }
    }
}
