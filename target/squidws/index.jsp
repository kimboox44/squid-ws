<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <title>Log-in</title>



        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>

        <link rel="stylesheet" href="css/style.css">




    </head>

    <body>

        <div class="login-card">
            <h2>URL BLOCKED!</h2><br>
            <h1>Log-in</h1><br>
            <form action="login" method="POST">
                <input type="password" name="passwd" placeholder="Password">
                <input type="submit" name="log" class="login login-submit" value="login">
           

            <div class="login-help">
                <a href="#">PFE Project @2016</a><br><a href="#">Bouziane khaled - Bensadi Zakaria</a>
            </div>
            <br>
           
                <input type="submit" value="loginAdmin" name="log" class="login login-submit"/>
                
            </form>
        </div>

        <!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>





    </body>


</html>