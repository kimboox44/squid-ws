package com.bkhaled.squidws.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bkhaled.squidws.client.modal.User;
import java.io.File;

;

public class UserRepos {

    final static String HOME_PATH = System.getProperty("user.home");
    final static String DATA_PATH = HOME_PATH + "/squid_db_18";
    File file = new File(DATA_PATH);

    private static Map<Integer, User> repository = new HashMap<Integer, User>();

    private static UserRepos instance;

    public static Map<Integer, User> getRepos() {
        return repository;
    }

    public static UserRepos getInstance(Boolean refresh) {
        if (instance == null || refresh == true) {
            instance = new UserRepos();
        }
        return instance;
    }

    public UserRepos() {
        // TODO Auto-generated constructor stub

        System.out.println("com.bkhaled.squidws.persistence.UserRepos.<init>() > IF DATABASE DOESNT EXISTS...checking!");
        if (!file.exists()) {
            SqliteManager.creatDatabase();
            System.out.println("com.bkhaled.squidws.persistence.UserRepos.<init>() DATA NOT EXIST <0>");
            System.out.println("com.bkhaled.squidws.persistence.UserRepos.<init>() CREATING DATABASE");
        }
        System.out.println("com.bkhaled.squidws.persistence.UserRepos.<init>() > DATA EXIST <1>");

        repository.clear();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_PATH);
            System.out.println("Repos: " + connection.getSchema());
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM User";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIpAdress(rs.getString("ipAddress"));
                user.setCreationDate(rs.getString("date"));
                user.setType(rs.getString("type"));
                
                System.out.println("User password: " + user.getPassword());
                repository.put(user.getId(), user);
                System.out.println("User Name: " + (repository.get(user.getId())).getName());
            }

        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public User getUser(String password) {

        for (User u : repository.values()) {
            if (u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        // TODO Auto-generated method stub
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_PATH);

            Statement st = connection.createStatement();
            String sql = "UPDATE user SET "
                    + "age ='" + user.getAge() + "',"
                    + "name = '" + user.getName() + "',"
                    + "password='" + user.getPassword() + "',"
                    + "ipAddress='" + user.getIpAdress() + "',"
                    + "date='" + user.getCreationDate() + "',"
                    + "type='" + user.getType() + "'"
                    + "WHERE id='" + user.getId() + "';";
            st.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public void insertUser(User user) {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_PATH);
            System.out.println(DATA_PATH);
            Statement st = connection.createStatement();
            String sql = "insert into User(age,name,password,ipAddress,date,type) "
                    + "values ('" + user.getAge() + "','" + user.getName() + "','" + user.getPassword() + "','" + user.getIpAdress() + "','" + user.getCreationDate() + "','" + user.getType()+"');";
            st.execute(sql);

        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

    public void deleteUser(String password) {
 try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_PATH);

            Statement st = connection.createStatement();
            String sql = "DELETE FROM user WHERE password='"+password+"';";
            st.execute(sql);

        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

}
