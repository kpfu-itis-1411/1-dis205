<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:mainLayout title="Sign IN">
    <div>${message}</div>
    <form id="loginForm" class="form-horizontal" action="<c:url value="/signIn"/>" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-3" for="username">Email</label>
            <div class="controls col-sn-9">
                <input id="username" name="username" class="form-control" type="text" value=""/>
            </div>
        </div><div class="form-group">
            <label class="control-label col-sm-3" for="password">Password</label>
            <div class="controls col-sm-9">
                <input id="password" name="password" class="form-control" type="password" value=""/>
            </div>
        </div><button type="submit" class="btn btn-success">Sign in</button>
    </form>

    <%--<div class="authorisation-form">--%>
    <%--    <h3 style="text-align: center;color: red; margin-top: 40px">${errormessage!""}</h3>--%>
    <%--    <h2>Вход</h2>--%>
    <%--    <form action="usercheck" method="post">--%>
    <%--        <div class="form-group">--%>
    <%--            <label for="login">Логин:</label>--%>
    <%--            <input type="text" id="login" name="login" required placeholder="Введите логин">--%>
    <%--        </div>--%>

    <%--        <div class="form-group">--%>
    <%--            <label for="password">Пароль:</label>--%>
    <%--            <input type="password" id="password" name="password" required placeholder="Введите пароль">--%>
    <%--        </div>--%>
    <%--        <input type="submit" value="Войти" class="btn">--%>

    <%--        <div style="text-align: center; margin-top: 20px;">--%>
    <%--            <a href="/servlets_website/registration">Зарегистрироваться</a>--%>
    <%--        </div>--%>
    <%--    </form>--%>




</t:mainLayout>

