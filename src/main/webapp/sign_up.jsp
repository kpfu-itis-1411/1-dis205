<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 14.11.2023
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Ug Page</title>
    <%@include file="component/allcss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<%@include file="component/navbar.jsp"%>

<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-4 text-center">Sign Up</p>

                    <c:if test="${not empty succMsg }">
                        <p class="text-center text-success fs-3">${succMsg}</p>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>

                    <c:if test="${not empty errorMsg }">
                        <p class="text-center text-danger fs-5">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>

                    <form action="/SemestrWork1/signUp" method="post" onsubmit="return validateForm()">
                        <div class="mb-3">
                            <label class="form-label">Email address <span style="color:red">*</span></label> <input required
                                                                                                                    id="email" name="email" type="email" class="form-control" >
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Name <span style="color:red">*</span></label> <input required
                                                                                  id="name" name="name" type="text" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Surname <span style="color:red">*</span></label> <input required
                                                                                   id="surname" name="surname" type="text" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Date of birth<span style="color:red">*</span></label> <input required
                                                                                   id="dateofbirth" name="dateofbirth" type="date" class="form-control">
                        </div>


                        <div class="mb-3">
                            <label class="form-label">Password <span style="color:red">*</span></label> <input required
                                                                               name="password" type="password" class="form-control" id="password">
                            <input type="checkbox" onclick="myFunction()"> Show Password

                            <script>
                                function myFunction() {
                                    var x = document.getElementById("password");
                                    if (x.type === "password") {
                                        x.type = "text";
                                    } else {
                                        x.type = "password";
                                    }
                                }
                            </script>
                        </div>
                        <button type="submit" class="btn bg-primary text-white col-md-12">Register</button>
                    </form>



                </div>
            </div>
        </div>
    </div>
</div>
<script src='${pageContext.request.contextPath}/js/validate_form.js'></script>

</body>
</html>
