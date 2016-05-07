package com.bkhaled.squidws.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.bkhaled.squidws.client.modal.Profile;
import com.bkhaled.squidws.client.modal.User;
import java.io.File;

public class ProfileRepos {

    final static String HOME_PATH = System.getProperty("user.home");
    final static String DATA_PATH = HOME_PATH + "/squid_db_18";
    
    File file = new File(DATA_PATH);

    private static Map<Integer, Profile> repository = new HashMap<Integer, Profile>();

    private static ProfileRepos instance;

    public static Map<Integer, Profile> getRepos() {
        return repository;
    }

    public static ProfileRepos getInstance(Boolean refresh) {
        if (instance == null || refresh == true) {
            instance = new ProfileRepos();
        }
        return instance;
    }
    
    
    public void insertProfile(Profile profile){
        
    }

    public ProfileRepos() {
        // TODO Auto-generated constructor stub
      
          if (!file.exists()) {
            SqliteManager.creatDatabase();
          }

        repository.clear();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_PATH);
            System.out.println("Repos: " + connection.getSchema());
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Profile";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Profile profile = new Profile();
                
                profile.setId(rs.getInt("id"));
                profile.setName(rs.getString("name"));
                profile.setLineEnd(rs.getInt("lineEnd"));
                profile.setLineStart(rs.getInt("lineStart"));
                profile.setDescription(rs.getString("desciption"));
                profile.setCode(rs.getString("code"));
                
                repository.put(profile.getId(), profile);
                
            }
            
            
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }

    }

}
