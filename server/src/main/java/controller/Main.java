package controller;

import service.SocketConnection;

public class Main {
    public static void main(String[] args) {
        System.err.println("Server start running!!!");
        SocketConnection.start();
    }
}
