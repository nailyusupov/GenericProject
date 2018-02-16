/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author nyusu131
 */
public class GenericMysqlPool {

    private static GenericMysqlPool datasource;
    private BasicDataSource ds;

    public static String Driver = "com.mysql.jdbc.Driver";
    public static String ConnectionString = "jdbc:mysql://127.0.0.1:3306/SCHEMA?useUnicode=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
    public static String Username = "root";
    public static String Password = "";

    private GenericMysqlPool() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName(Driver);
        ds.setUsername(Username);
        ds.setPassword(Password);
        ds.setUrl(ConnectionString);
    }

    public static GenericMysqlPool getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new GenericMysqlPool();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
}
