<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 15.11.2023
  Time: 02:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="component/allcss.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personal Account</title>
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

        .welcome-box {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            margin: 20px;
            border-radius: 5px;
        }

        .welcome-box p {
            margin: 5px 0;
        }

        .info-box {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            margin: 20px;
            border-radius: 5px;
        }

        .info-box p {
            margin: 5px 0;
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
<h1>You're personal account</h1>

<c:if test="${role == 'doctor'}">
    <div class="welcome-box">
        <h2>Welcome, ${doctor1.name}!</h2>
        <p>Name: ${doctor1.name}</p>
        <p>Surname: ${doctor1.surname}</p>
        <p>Email: ${doctor1.email}</p>
        <p>Post: ${doctor1.post}</p>
    </div>

    <div class="box">
        <h2>Appointment for procedures to the doctor ${doctor1.name} ${doctor1.surname}</h2>
        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/doctorProcedureList"><i class="fa-solid fa-list"></i>   Procedure List</a>
        </li>
    </div>
</c:if>

<c:if test="${role == 'patient'}">
    <div class="welcome-box">
        <h2>Welcome, ${patient1.name}!</h2>
        <p><strong>Name:</strong> ${patient1.name}</p>
        <p><strong>Surname:</strong> ${patient1.surname}</p>
        <p><strong>Email:</strong> ${patient1.email}</p>
        <p><strong>Date of birth:</strong> ${patient1.dateOfBirth}</p>
    </div>

<div class="boxes">
    <div class="box">
        <h3></h3>
        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/createAppointment"><i class="fa-solid fa-calendar-check"></i>   Make an appointment</a>
        </li>
    </div>

    <div class="box">
        <h3>If you do not know about the available procedures, you can study the list of procedures and choose the appropriate one!</h3>
        <li class="select-items">
            <a style="font-size: 18px" href="procedure_list.jsp"><i class="fa-solid fa-list"></i>   Procedure List</a>
        </li>
    </div>

    <div class="box">
        <h2>Appointment for procedures to the patient ${patient1.name} ${patient1.surname}</h2>
        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/patientProcedureList"><i class="fa-solid fa-list"></i>   Appointments List</a>
        </li>
    </div>

</c:if>

<c:if test="${role == 'admin'}">
    <div class="welcome-box">
        <h2>Welcome, admin!</h2>
    </div>
    <div class="box">
        <h2>Appointment</h2>
        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/createAppointmentAdmin"><i class="fa-solid fa-plus"></i>   Create appointment</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/showAppointmentsAdmin"><i class="fa-solid fa-border-all"></i>   Show all appointments</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/updateAppointmentAdmin"><i class="fa-solid fa-pen-nib"></i>   Update appointment</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/deleteAppointmentAdmin"><i class="fa-solid fa-delete-left"></i>   Delete appointment</a>
        </li>
    </div>

    <div class="box">
        <h2>Patient</h2>
        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/createPatientAdmin"><i class="fa-solid fa-plus"></i>   Create Patient</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/showPatientsAdmin"><i class="fa-solid fa-border-all"></i>   Show all Patients</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/updatePatientAdmin"><i class="fa-solid fa-pen-nib"></i>   Update Patient</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/deletePatientAdmin"><i class="fa-solid fa-delete-left"></i>   Delete Patient</a>
        </li>
    </div>

    <div class="box">
        <h2>Doctor</h2>
        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/createDoctorAdmin"><i class="fa-solid fa-plus"></i>   Create Patient</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/showDoctorsAdmin"><i class="fa-solid fa-border-all"></i>   Show all Patients</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/updateDoctorAdmin"><i class="fa-solid fa-pen-nib"></i>   Update Patient</a>
        </li>

        <li class="select-items">
            <a style="font-size: 18px" href="${pageContext.request.contextPath}/deleteDoctorAdmin"><i class="fa-solid fa-delete-left"></i>   Delete Patient</a>
        </li>
    </div>



</c:if>

</body>
</html>
