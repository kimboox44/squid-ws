package com.bkhaled.squidws.client.services;

import com.bkhaled.squidws.client.modal.User;
import com.bkhaled.squidws.client.proxy.SquidConfigManager;
import com.bkhaled.squidws.persistence.UserRepos;

public class UserService {

    SquidConfigManager squidManager = new SquidConfigManager();

    public void validate(User user) {

        // Prepare function;
        // Get log and history files
        squidManager.connectUser(user);
        System.out.println("com.bkhaled.squidws.client.services.UserService.validate()");
    }

    public Boolean login(String password) {

        System.out.println("com.bkhaled.squidws.client.services.UserService.login()");

        for (User u : UserRepos.getInstance(true).getRepos().values()) {

                System.out.println("Entred password -> "+password +" -> user passowrd -> "+u.getPassword());
            if (u.getPassword().equals(password)) {
                return true;
            }

        }

        return false;

    }

}
