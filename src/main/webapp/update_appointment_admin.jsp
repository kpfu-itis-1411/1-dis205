<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 15.12.2023
  Time: 03:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update appointment</title>
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

<form action="/SemestrWork1/updateAppointmentAdmin" method="post">
    <div class="box">
        <h2>To update select id appointment and enter new values</h2>
        <label for="idupdate">Id:</label>
        <input type="text" id="idupdate" name="idupdate"><br><br>

        <label for="procedurenameupdate">Procedure name:</label>
        <input type="text" id="procedurenameupdate" name="procedurenameupdate"><br><br>

        <label for="appointmentdateupdate">Date:</label>
        <input type="text" id="appointmentdateupdate" name="appointmentdateupdate"><br><br>

        <label for="doctoridupdate">Doctor ID:</label>
        <input type="text" id="doctoridupdate" name="doctoridupdate"><br><br>

        <label for="patientidupdate">Patient ID:</label>
        <input type="text" id="patientidupdate" name="patientidupdate"><br><br>

        <input type="submit" value="Update">
    </div>
</form>
</body>
</html>
