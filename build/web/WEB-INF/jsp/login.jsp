<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <style>
            button {
                padding: 10px
            }

            label {
                cursor: pointer
            }
            form {
                margin: 0 auto;
                width: 300px
            }
            input {
                margin-bottom: 3px;
                padding: 10px;
                width: 100%;
                border: 1px solid #CCC
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <center>
            <h2>Login</h2>
            <form action="/Task2/success" method="post" >
                <input type="text" name="username" padding="10px" /> </br>
                <input type="password" name="password" /> </br> 
                <button type="submit">Log In </button> </br>
            </form>
            <a href="/Task2/register">Register</a>
        </center>
    </body>
</html>