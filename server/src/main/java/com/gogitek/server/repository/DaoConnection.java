/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.server.repository;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bmtnt
 */
public abstract class DaoConnection {
    public Connection getConnection(){
        String dbUrl = "jdbc:mysql://localhost:3306/quan_ly_thuoc";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(dbClass);
            return DriverManager.getConnection(dbUrl, "thinh12", "tnt01239997213");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
