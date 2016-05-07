<%@page import="com.bkhaled.squidws.client.modal.Profile"%>
<%@page import="com.bkhaled.squidws.persistence.ProfileRepos"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : Mar 26, 2016, 12:00:58 AM
    Author     : kimboo
--%>

<%@page import="com.bkhaled.squidws.client.modal.User"%>
<%@page import="com.bkhaled.squidws.persistence.UserRepos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
        <link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
        <script src="js/modernizr.js"></script> <!-- Modernizr -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <header>
            <h1>SQUID CONTROLE</h1>
        </header>
        <section class="cd-faq">
            <ul class="cd-faq-categories">
                <li><a class="selected" href="#basics">Manage Users</a></li>
                <li><a href="#mobile">Manage Profiles</a></li>
                <li><a href="#account">Proxy settings</a></li>
                <li><a href="#payments">Internet</a></li>
                <li><a href="#privacy">General Settings</a></li>
                <li><a href="#delivery">Help</a></li>
            </ul> <!-- cd-faq-categories -->
            <div class="cd-faq-items">
                <ul id="basics" class="cd-faq-group">
                    <li class="cd-faq-title"><h2>Users</h2></li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">Users list</a>
                        <div class="cd-faq-content">
                            <ul  class="cd-faq-title">
                                <table style="width: 100%">
                                    <tr style="background-color: #357ae8; font-style: normal;font-size: large; width: 20px">
                                        <th><font style="color: #ffffff"> Action</font></th>
                                        <th><font style="color: #ffffff">Name</font></th>
                                        <th><font style="color: #ffffff">Password</font></th>
                                        <th><font style="color: #ffffff">IP</font></th>
                                        <th><font style="color: #ffffff">Age</font></th>
                                    </tr>
                                    <tbody>
                                        <%

                                            for (User u : UserRepos.getInstance(true).getRepos().values()) {
                                        %>
                                        <tr>
                                    <form action="users" method="post" >
                                        <li>
                                        <td>
                                            <input type="hidden" name="delete_password" value="<%=u.getPassword()%>"/>
                                            <input type="submit" value="Delete"  class="login login-submit" name="log" />
                                            <input type="submit" value="Edit"    class="login login-submit" name="log"/>
                                        </td>
                                        <td>
                                            <img src="../img/user.png" width="16" height="16" alt="user"/>
                                            <% out.println(u.getName());%>
                                        </td>
                                        <td>
                                            <img src="../img/icon-password.png" width="16" height="16" alt="icon-password"/>
                                            <%  out.println(u.getPassword());%>
                                        </td>
                                        <td>
                                            <img src="../img/ip-40b-hover.png" width="16" height="16" alt="ip-40b-hover"/>
                                            <% out.println(u.getIpAdress()); %>  
                                        </td>
                                        <td>
                                            <img src="../img/pageAge.png" width="16" height="16" alt="pageAge"/>
                                            <% out.println(u.getAge()); %>
                                        </td>
                                        </li>
                                    </form>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </ul>
                        </div> <!-- cd-faq-content -->
                    </li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">Add new user</a>
                        <div class="cd-faq-content">
                            <br><br>
                            <table style="width: 100%">
                                <tbody>
                                <form action="users" method="post">
                                    <tr>
                                        <td>Name: </td>
                                        <td><input type="text" name="name" id="name"/></td>
                                    </tr>
                                    <tr>
                                        <td>Age:</td>
                                        <td><input type="number" name="age" id="age"/></td>
                                    </tr>
                                    <tr>
                                        <td>Password: </td>
                                        <td> <input type="text" name="password" id="password"/></td>
                                    </tr>
                                    <tr>
                                        <td>Type:</td>
                                        <td>
                                            <select name="type">
                                                <option>user</option>
                                                <option>admin</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr style="height: 50px">
                                        <td>
                                            <input type="submit" value="Add user" name="log" class="login-submit"/>
                                        </td>
                                    </tr>
                                </form>
                                </tbody>
                            </table>
                            <br><br>
                        </div> <!-- cd-faq-content -->
                    </li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">User-profile settings</a>
                        <div class="cd-faq-content"> 
                        </div> <!-- cd-faq-content -->
                    </li>
                </ul> <!-- cd-faq-group -->
                <ul id="mobile" class="cd-faq-group">
                    <li class="cd-faq-title"><h2>Profiles</h2></li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">Profiles list</a>
                        <div class="cd-faq-content">
                            <ul  class="cd-faq-title">
                                <table style="width: 100%">
                                    <tr style="background-color: #357ae8; font-style: normal;font-size: large; width: 20px">
                                        <th><font style="color: #ffffff">ID</font></th>
                                        <th><font style="color: #ffffff">Name</font></th>
                                        <th><font style="color: #ffffff">Description</font></th>
                                        <th><font style="color: #ffffff">Code</font></th>
                                    </tr>
                                    <tbody>
                                        <%

                                            for (Profile p : ProfileRepos.getInstance(true).getRepos().values()) {
                                        %>
                                        <tr>
                                    <form action="profiles" method="post">
                                        <li>
                                        <td>
                                            <input type="hidden" name="profile_id" value="<%= p.getId() %>"/>
                                            <input type="submit" value="Delete"  class="login login-submit" name="log"/>
                                        </td>
                                        <td>
                                            <img src="../img/user.png" width="16" height="16" alt="user"/>
                                            <% out.println(p.getId());%>
                                        </td>
                                        <td>
                                            <img src="../img/icon-password.png" width="16" height="16" alt="icon-password"/>
                                            <%  out.println(p.getName());%>
                                        </td>
                                        <td>
                                            <img src="../img/ip-40b-hover.png" width="16" height="16" alt="ip-40b-hover"/>
                                            <% out.println(p.getDescription()); %>  
                                        </td>
                                        <td>
                                            <img src="../img/pageAge.png" width="16" height="16" alt="pageAge"/>
                                            <% out.println(p.getCode()); %>
                                        </td>
                                        </li>
                                    </form>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </ul>
                        </div> <!-- cd-faq-content -->
                    </li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">Add new profile</a>
                        <div class="cd-faq-content">
                            <table style="width: 100%">
                                <tbody>
                                <form action="profiles" method="post">
                                    <tr>
                                        <td>Name: </td>
                                        <td><input type="text" name="name" id="name"/></td>
                                    </tr>
                                    <tr>
                                        <td>Description:</td>
                                        <td><input type="text" name="description" id="description"/></td>
                                    </tr>
                                    <tr>
                                        <td>Add policy </td>
                                        <td> <input type="button" name="add_policy" id="add_policy" value="Add policy"/></td>
                                    </tr>
                                    <tr>
                                        <td>Type:</td>
                                        <td>
                                            <select name="type">
                                                <option>user</option>
                                                <option>admin</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr style="height: 50px">
                                        <td>
                                            <input type="submit" value="Add prfile" name="log" class="login-submit"/>
                                        </td>
                                    </tr>
                                </form>
                                </tbody>
                            </table>
                            <br><br>
                        </div> <!-- cd-faq-content -->
                    </li>
                </ul> <!-- cd-faq-group -->
                <ul id="account" class="cd-faq-group">
                    <li class="cd-faq-title"><h2>Settings</h2></li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">How do I change my password?</a>
                        <div class="cd-faq-content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis earum autem consectetur labore eius tenetur esse, in temporibus sequi cum voluptatem vitae repellat nostrum odio perspiciatis dolores recusandae necessitatibus, unde, deserunt voluptas possimus veniam magni soluta deleniti! Architecto, quidem, totam. Fugit minus odit unde ea cupiditate ab aperiam sed dolore facere nihil laboriosam dolorum repellat deleniti aliquam fugiat laudantium delectus sint iure odio, necessitatibus rem quisquam! Ipsum praesentium quam nisi sint, impedit sapiente facilis laudantium mollitia quae fugiat similique. Dolor maiores aliquid incidunt commodi doloremque rem! Quaerat, debitis voluptatem vero qui enim, sunt reiciendis tempore inventore maxime quasi fugiat accusamus beatae modi voluptates iste officia esse soluta tempora labore quisquam fuga, cum. Sint nemo iste nulla accusamus quam qui quos, vero, minus id. Eius mollitia consequatur fugit nam consequuntur nesciunt illo id quis reprehenderit obcaecati voluptates corrupti, minus! Possimus, perspiciatis!</p>
                        </div> <!-- cd-faq-content -->
                    </li>        
                </ul> <!-- cd-faq-group -->
                <ul id="payments" class="cd-faq-group">
                    <li class="cd-faq-title"><h2>Internet</h2></li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">Can I have an invoice for my subscription?</a>
                        <div class="cd-faq-content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem delectus rerum eligendi mollitia, repudiandae quae beatae. Et repellat quam atque corrupti iusto architecto impedit explicabo repudiandae qui similique aut iure ipsum quis inventore nulla error aliquid alias quia dolorem dolore, odio excepturi veniam odit veritatis. Quo iure magnam, et cum. Laudantium, eaque non? Tempore nihil corporis cumque dolor ipsum accusamus sapiente aliquid quis ea assumenda deserunt praesentium voluptatibus, accusantium a mollitia necessitatibus nostrum voluptatem numquam modi ab, sint rem.</p>
                        </div> <!-- cd-faq-content -->
                    </li>      
                </ul> <!-- cd-faq-group -->
                <ul id="privacy" class="cd-faq-group">
                    <li class="cd-faq-title"><h2>General</h2></li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">Can I specify my own private key?</a>
                        <div class="cd-faq-content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem delectus rerum eligendi mollitia, repudiandae quae beatae. Et repellat quam atque corrupti iusto architecto impedit explicabo repudiandae qui similique aut iure ipsum quis inventore nulla error aliquid alias quia dolorem dolore, odio excepturi veniam odit veritatis. Quo iure magnam, et cum. Laudantium, eaque non? Tempore nihil corporis cumque dolor ipsum accusamus sapiente aliquid quis ea assumenda deserunt praesentium voluptatibus, accusantium a mollitia necessitatibus nostrum voluptatem numquam modi ab, sint rem.</p>
                        </div> <!-- cd-faq-content -->
                    </li>           
                </ul> <!-- cd-faq-group -->
                <ul id="delivery" class="cd-faq-group">
                    <li class="cd-faq-title"><h2>Help</h2></li>
                    <li>
                        <a class="cd-faq-trigger" href="#0">What should I do if my order hasn't been delivered yet?</a>
                        <div class="cd-faq-content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem delectus rerum eligendi mollitia, repudiandae quae beatae. Et repellat quam atque corrupti iusto architecto impedit explicabo repudiandae qui similique aut iure ipsum quis inventore nulla error aliquid alias quia dolorem dolore, odio excepturi veniam odit veritatis. Quo iure magnam, et cum. Laudantium, eaque non? Tempore nihil corporis cumque dolor ipsum accusamus sapiente aliquid quis ea assumenda deserunt praesentium voluptatibus, accusantium a mollitia necessitatibus nostrum voluptatem numquam modi ab, sint rem.</p>
                        </div> <!-- cd-faq-content -->
                    </li>      
                </ul> <!-- cd-faq-group -->
            </div> <!-- cd-faq-items -->
            <a href="#0" class="cd-close-panel">Close</a>
        </section> <!-- cd-faq -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/jquery.mobile.custom.min.js"></script>
        <script src="js/main.js"></script> <!-- Resource jQuery -->
    </body>
</html>
