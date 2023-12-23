<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Страница входа</title>
    <style>
        /* Стили для страницы входа */
        body {
            margin: 0;
        }

        .header {
            width: 100%;
            height: 70px; /* Задайте желаемую высоту шапки */
            background-color: #007bff; /* Задайте желаемый цвет фона */
            position: fixed;
            top: 0;
            left: 0;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .submit-btn {
            width: 100%;
            padding: 10px;
            border: none;
            background-color: #0056b3;
            color: #fff;
            font-weight: bold;
            text-transform: uppercase;
            cursor: pointer;
        }
    </style>
</head>
<body>
<header class="header">
    <h1>Оставь отзыв автомойкам</h1>
</header>
<div class="container">
    <h2>Вход</h2>
    <h3 style="color: red;">${message}</h3>
    <form action="/semestrWork_war/usercheck" method="post">
        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="login" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="submit-btn">Войти</button>
    </form>
    <p>Еще не зарегистрированы? <a href="/semestrWork_war/registration">Зарегистрироваться</a></p>
</div>
</body>
</html>
<#--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"-->
<#--        "http://www.w3.org/TR/html4/loose.dtd">-->
<#--<html xmlns="http://www.w3.org/1999/html">-->
<#--<head>-->
<#--    <title>Lab 10</title>-->
<#--    <meta charset="utf-8"/>-->
<#--</head>-->
<#--<body>-->
<#--<h1>Аунтификация</h1>-->
<#--<h2 color = "red">${message}</h2>-->
<#--<br>-->
<#--<form action="/semestrWork_war/usercheck" method="post">-->
<#--    <!-- <input> send params &ndash;&gt;-->
<#--    <table>-->
<#--        <tr>-->
<#--            <td><label>Имя: </label></td>-->
<#--            <td><input type="text" name = "username" placeholder = "введите имя пользователя"></td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td><label>Пароль: </label></td>-->
<#--            <td><input type="password" name = "password" placeholder = "введите пароль"></td>-->
<#--        </tr>-->
<#--    </table>-->
<#--    <div><input type="submit" value="Войти"/></div>-->
<#--</form>-->

<#--</body>-->
<#--</html>-->