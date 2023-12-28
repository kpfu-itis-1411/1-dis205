<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:avtorizLayout title="REGISTRATION">
<h1>Регистрация пользователя</h1>

<div id="error"></div>
<form method="post" action="/massage/registration" onsubmit="return validate()"> <!-- validate  -->
    <table>
        <tr>
            <td><label>Имя<span style="color:red">*</span>:</label></td>
            <td><input type="text" name="name" placeholder="ваше имя" required ></td>
        </tr>
        <tr>
            <td><label>Телефон:</label></td>
            <td><input type="text" name="phone" placeholder="+71111111111" required pattern="(8|(\+7))[0-9]{10}" ></td>
        </tr>
        <tr>
            <td><label>Пароль:</label></td>
            <td><input id="pwd" type="password" name="password" oninput="validatePassword(this)"></td>
        </tr>
        <tr>
            <td><label>Повторите пароль:</label></td>
            <td><input id="pwd1" type="password"></td>
        </tr>
    </table>
    <div><input type="submit" value="Регистрация"></div>
</form>

</t:avtorizLayout>