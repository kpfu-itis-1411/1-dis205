<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/"/>">Home</a></li>
                <c:if test="${user != null}">
                    <li><a href="<c:url value="/cinema/new"/>">New Cinema</a></li>
                </c:if>
                <c:if test="${user == null}">
                    <li><a href="<c:url value="/register"/>">Register</a></li>
                    <li><a href="<c:url value="/signIn"/>">Log in</a></li>
                </c:if>
                <li><a href="<c:url value="/movies"/>">Movies</a></li>
            </ul>
        </div>
    </div>
</nav>