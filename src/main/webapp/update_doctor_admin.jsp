<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 15.12.2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update doctor</title>
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
  <%@include file="component/allcss.jsp"%>
</head>
<body>
<%@include file="component/navbar.jsp"%>
<p class="empty-line"></p>
<a href="/SemestrWork1/personalAccount" class="home-button">
  <i class="fa-solid fa-house"></i> Home
</a>

<form action="/SemestrWork1/updateDoctorAdmin" method="post">
  <div class="box">
    <h2>To update select doctor's id and enter new values</h2>

    <label for="idupdate">Doctor's ID:</label>
    <input type="text" id="idupdate" name="idupdate"><br><br>

    <label for="nameupdate">Doctor's name:</label>
    <input type="text" id="nameupdate" name="nameupdate"><br><br>

    <label for="surnameupdate">Doctor's surname:</label>
    <input type="text" id="surnameupdate" name="surnameupdate"><br><br>

    <label for="emailupdate">Doctor's email:</label>
    <input type="text" id="emailupdate" name="emailupdate"><br><br>

    <label for="postupdate">Doctor's post:</label>
    <input type="text" id="postupdate" name="postupdate"><br><br>

    <label for="passwordupdate">Doctor's password:</label>
    <input type="password" id="passwordupdate" name="passwordupdate"><br><br>

    <input type="submit" value="Update">
  </div>
</form>
</body>
</html>

