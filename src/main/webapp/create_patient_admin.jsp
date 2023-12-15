<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 15.12.2023
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create Patient</title>
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

<form action="/SemestrWork1/createPatientAdmin" method="post">
  <div class="box">
    <h2>Create patient</h2>
    <label for="patientname">Patient's name:</label>
    <input type="text" id="patientname" name="patientname"><br><br>

    <label for="patientsurname">Patient's surname:</label>
    <input type="text" id="patientsurname" name="patientsurname"><br><br>

    <label for="patientemail">Patient's email:</label>
    <input type="text" id="patientemail" name="patientemail"><br><br>

    <label for="patientdateofbirth">Patient's date of birth:</label>
    <input type="date" id="patientdateofbirth" name="patientdateofbirth"><br><br>

    <label for="patientpassword">Patient's password:</label>
    <input type="password" id="patientpassword" name="patientpassword"><br><br>

    <input type="submit" value="Create">
  </div>
</form>

</body>
</html>

