<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 15.12.2023
  Time: 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create appointment</title>
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

<form action="/SemestrWork1/createAppointmentAdmin" method="post">
  <div class="box">
  <h2>Create appointment</h2>
  <label for="procedurename">Procedure name:</label>
  <input type="text" id="procedurename" name="procedurename"><br><br>

  <label for="appointmentdate">Date:</label>
  <input type="text" id="appointmentdate" name="appointmentdate"><br><br>

  <label for="doctorid">Doctor ID:</label>
  <input type="text" id="doctorid" name="doctorid"><br><br>

  <label for="patientid">Patient ID:</label>
  <input type="text" id="patientid" name="patientid"><br><br>

  <input type="submit" value="Create">
  </div>
</form>

</body>
</html>
