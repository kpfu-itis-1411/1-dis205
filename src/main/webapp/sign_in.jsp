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
    <title>Sign In Page</title>
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
                    <p class="fs-4 text-center">Sign In</p>

                    <c:if test="${not empty succMsg }">
                        <p class="text-center text-success fs-3">${succMsg}</p>
                        <c:remove var="succMsg" scope="session" />
                    </c:if>

                    <c:if test="${not empty errorMsg }">
                        <p class="text-center text-danger fs-5">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>

                    <form action="/SemestrWork1/signIn" method="post">
                        <div class="mb-3">
                            <label class="form-label">Email address</label> <input required
                                                                                   name="email" type="email" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label> <input required
                                                                              name="password" type="password" class="form-control" id="myInput">
                            <input type="checkbox" onclick="myFunction()"> Show Password

                            <script>
                                function myFunction() {
                                    var x = document.getElementById("myInput");
                                    if (x.type === "password") {
                                        x.type = "text";
                                    } else {
                                        x.type = "password";
                                    }
                                }
                            </script>
                        </div>
                        <button type="submit" class="btn bg-primary text-white col-md-12">Login</button>
                    </form>

                    <br> Don't have an account? <a href="sign_up.jsp"
                                                  class="text-decoration-none"> Create one</a>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

