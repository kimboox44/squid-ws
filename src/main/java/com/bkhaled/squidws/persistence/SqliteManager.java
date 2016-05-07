/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkhaled.squidws.persistence;

import com.bkhaled.squidws.client.modal.User;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kimboo
 */
public class SqliteManager {

    final static String HOME_PATH = System.getProperty("user.home");
    final static String DATA_PATH = HOME_PATH + "/squid_db_18";
    File file = new File(DATA_PATH);

    public static void creatDatabase() {

        // CREATE DATABASE IN USER DIR/database -> GET PATH
        System.out.println("com.bkhaled.squidws.persistence.SqliteManager.creatDatabase() >" + DATA_PATH);
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_PATH);
            Statement st = connection.createStatement();
            String sqlProfile = "CREATE TABLE \"Profile\" (\n"
                    + "    \"id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                    + "    \"description\" TEXT,\n"
                    + "    \"lineStart\" INTEGER,\n"
                    + "    \"lineEnd\" INTEGER,\n"
                    + "    \"name\" TEXT,\n"
                    + "    \"code\" TEXT\n"
                    + ")";

            st.execute(sqlProfile);

            String sqlUser = "CREATE TABLE \"User\" (\n"
                    + "	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`age`	INTEGER DEFAULT (0),\n"
                    + "	`name`	TEXT,\n"
                    + "	`password`	TEXT NOT NULL,\n"
                    + "	`ipAddress`	TEXT,\n"
                    + "	`date`	TEXT,\n"
                    + "	`type`	TEXT\n"
                    + ")";

            st.execute(sqlUser);

            String sqlRelation = "CREATE TABLE \"relation\" (\n"
                    + "	`userId`	INTEGER NOT NULL,\n"
                    + "	`profileId`	INTEGER NOT NULL,\n"
                    + "	`create`	TEXT\n"
                    + ")";

            st.execute(sqlRelation);

        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }
}
