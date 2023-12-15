<%@ page import="org.example.models.Patient" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 15.12.2023
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Show patients</title>
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

  </style>
  <%@include file="component/allcss.jsp"%>
</head>
<body>
<%@include file="component/navbar.jsp"%>
<p class="empty-line"></p>
<a href="/SemestrWork1/personalAccount" class="home-button">
  <i class="fa-solid fa-house"></i> Home
</a>

<h2>Patients:</h2>

<%
  List<Patient> patients = (List<Patient>) request.getAttribute("patientsadmin");
  if (patients != null && !patients.isEmpty()) {
%>

<table style="border-collapse: collapse; width: 100%; border: 2px solid #333;">
  <tr style="background-color: #f2f2f2; color: #333;">
    <th style="padding: 10px; border: 1px solid #333;">ID</th>
    <th style="padding: 10px; border: 1px solid #333;">NAME</th>
    <th style="padding: 10px; border: 1px solid #333;">APPOINTMENT DATE</th>
    <th style="padding: 10px; border: 1px solid #333;">DOCTOR ID</th>
    <th style="padding: 10px; border: 1px solid #333;">PATIENT ID</th>
  </tr>
  <% for (Patient patient : patients) { %>
  <tr style="background-color: #fff; color: #333;">
    <td style="padding: 10px; border: 1px solid #333;"><%= patient.getId() %></td>
    <td style="padding: 10px; border: 1px solid #333;"><%= patient.getName() %></td>
    <td style="padding: 10px; border: 1px solid #333;"><%= patient.getSurname() %></td>
    <td style="padding: 10px; border: 1px solid #333;"><%= patient.getEmail() %></td>
    <td style="padding: 10px; border: 1px solid #333;"><%= patient.getDateOfBirth() %></td>
  </tr>
  <% } %>
</table>

<% } else { %>
<!-- Если patients равен null или пуст -->
<p>No patients available.</p>
<% } %>
</body>
</html>
