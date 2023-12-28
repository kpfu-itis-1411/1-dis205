<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:avtorizLayout title="Main">
<div>
    Неверный логин или пароль, повторите ввод!
</div>
<form action="/massage/login" method="post">
    <!-- <input> send params -->
    <div>
        Login:<input type="text" name="login">
    </div>
    <div>
        Password:<input type="text" name="password">
    </div>
    <input type="submit" value="SEND"/>
</form>
</t:avtorizLayout>