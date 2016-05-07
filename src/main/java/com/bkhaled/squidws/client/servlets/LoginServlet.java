/**
 *  IMPLEMENTAION:
 * 	USERS ACCESS THIS PAGE TO LOGIN WITH A APASSWORD
 * 	THE SERVLET CHECKS IF THE USERS EXIST, AND HOLD OF THE IP ADDRESS
 * 	SEND THE IP TO CONTROLSERVICE.CLASS
 *
 */
package com.bkhaled.squidws.client.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkhaled.squidws.client.modal.User;
import com.bkhaled.squidws.client.services.UserService;
import com.bkhaled.squidws.persistence.UserRepos;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserService userService = new UserService();

    /**
     * Default constructor.
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("log").equals("login")) {

            String ipAddress = request.getHeader("X-FORWARDED-FOR");
            System.err.println("ipAddress");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }

            // WORK TO LOGIN HERE
            String passwd = request.getParameter("passwd");
            if (passwd != "" && passwd != "") {

                System.out.println("LoginServlet before login ");
                if (userService.login(passwd)) {

                    System.out.println("LoginServlet inside login ");
                    System.out.println("LoginServlet inside login IP: " + ipAddress);

                    User user = UserRepos.getInstance(true).getUser(passwd);

                    request.getSession().setAttribute("ip", ipAddress);
                    request.getSession().setAttribute("user", user);

                    System.out.println("LoginServlet inside login " + user.getPassword());

                    // UPDATE IP ADDRESS OF THE USER
                    if (!ipAddress.equals(user.getIpAdress())) {
                        user.setIpAdress(ipAddress);
                        UserRepos.getInstance(false).updateUser(user);
                    }
                    
                    userService.validate(user);
                    response.sendRedirect("validate.jsp");

                } else {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.getWriter().print("<html><head><title>Wrong password!</title></head>");
                    response.getWriter().print(
                            "<body>Wrong password user, please contact ADMIN to optain your password! <a href='/squidws'>RETURN</a></body>");
                    response.getWriter().println("</html>");
                }

            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().print("<html><head><title>Wrong password!</title></head>");
                response.getWriter().print("<body>Password not valide!</body>");
                response.getWriter().println("</html>");
            }
        } else if (request.getParameter("log").equals("loginAdmin")) {

            String passwd = request.getParameter("passwd");
            if (passwd != "" && passwd != "") {

                System.out.println("LoginServlet before login ");
                if (userService.login(passwd)) {

                    User user = UserRepos.getInstance(true).getUser(passwd);
                    System.out.println("user --------------> "+ user.getType());
                    if (user.getType().equals("admin")) {
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("faq/index.jsp");
                    } else {
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        response.getWriter().print("<html><head><title>NOT ADMIN!</title></head>");
                        response.getWriter().print(
                                "<body>You're not administrator, please retry with admin password! <a href='/squidws'>RETURN</a></body>");
                        response.getWriter().println("</html>");
                    }

                } else {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.getWriter().print("<html><head><title>Wrong password!</title></head>");
                    response.getWriter().print(
                            "<body>Wrong password admin, please contact ADMIN to optain your password! <a href='/squidws'>RETURN</a></body>");
                    response.getWriter().println("</html>");
                }

            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().print("<html><head><title>Wrong password!</title></head>");
                response.getWriter().print("<body>Password not valide!</body>");
                response.getWriter().println("</html>");
            }

        }
    }

}
