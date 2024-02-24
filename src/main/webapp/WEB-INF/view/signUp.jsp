
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Sign Up">
    <form method="post" action="/signUp">
        <label for="firstName">Введите ваше имя:</label>
        <input id="firstName" name="firstName" placeholder="Имя">
        <br>
        <label for="lastName">Введите вашу фамилию:</label>
        <input id="lastName" name="lastName" placeholder="Фамилия">
        <br>
        <label for="email">Введите вашу почту:</label>
        <input id="email" type="email" name="email" placeholder="Почта">
        <br>
        <label for="password">Введите ваш пароль:</label>
        <input id="password" type="password" name="password" placeholder="Пароль">
        <br>
        <br>
        <input type="submit" value="Sign Up">
    </form>
</t:mainLayout>