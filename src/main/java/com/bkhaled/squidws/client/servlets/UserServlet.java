/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkhaled.squidws.client.servlets;

import com.bkhaled.squidws.client.modal.User;
import com.bkhaled.squidws.persistence.UserRepos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kimboo
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String x = request.getParameter("log");

        switch (x) {
            case "Add user":
                System.out.println("\n\n -------- \n \ncom.bkhaled.squidws.client.servlets.UserServlet.doPost() " + x);
                response.sendRedirect("#");
                try {

                    System.out.println("AGE: " + request.getParameter("age"));
                    System.out.println("NAME: " + request.getParameter("name"));
                    System.out.println("PASSWORD: " + request.getParameter("password"));
                    System.out.println("TYPE: " + request.getParameter("type"));
                    
                    User user = new User();
                    user.setName(request.getParameter("name"));
                    user.setPassword(request.getParameter("password"));
                    user.setAge(Integer.parseInt(request.getParameter("age")));
                    user.setType(request.getParameter("type"));
                    
                    UserRepos.getInstance(false).insertUser(user);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case "Display users":
                System.out.println("\n\n -------- \n \ncom.bkhaled.squidws.client.servlets.UserServlet.doPost() " + x);
                response.sendRedirect("#");
                break;

            case "Delete":
                System.out.println("********************* PASSWORD: " + request.getParameter("delete_password"));
                String password = request.getParameter("delete_password");
                UserRepos.getInstance(true).deleteUser(password);
                response.sendRedirect("#");
                break;
        }

    }

}
