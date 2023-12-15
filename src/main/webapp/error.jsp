<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 30.11.2023
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointment Form</title>
    <%@include file="component/allcss.jsp"%>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1, h2 {
            color: #333;
        }

        .home-button {
            position: initial;
            top: 10px;
            right: 10px;
            font-size: 20px;
            text-decoration: none;
            color: #333;
        }

        .empty-line {
            margin-bottom: 10px;
        }

        .box {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #f2f2f2;
            padding: 20px;
            margin: 10px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.3);
            text-align: center;
        }

    </style>
</head>
<body>
<%@include file="component/navbar.jsp"%>
<p class="empty-line"></p>
<a href="/SemestrWork1/personalAccount" class="home-button">
    <i class="fa-solid fa-house"></i> Home
</a>
<h1>Appointment Form</h1>

<%--<form action="/SemestrWork1/succes" method="post">--%>
<div class="box">
    <p>An error has occurred! Try again</p>
</div>
<%--</form>--%>
</body>
</html>
