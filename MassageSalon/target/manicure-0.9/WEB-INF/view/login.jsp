<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:avtorizLayout title="Main">
    <h1>Аутентификация</h1>

<h2 color="red">${message}</h2>

<form method="post" action="/massage/usercheck">
    <table>
        <tr>
            <td><label>Имя:</label></td>
            <td><input type="text" name="username" placeholder="введите имя пользователя"></td>
        </tr>
        <tr>
            <td><label>Пароль:</label></td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>
    <div><input type="submit" value="Вход"></div>
</form>

<div>
    <a href="/massage/regpage">Регистрация</a>
</div>
</t:avtorizLayout>