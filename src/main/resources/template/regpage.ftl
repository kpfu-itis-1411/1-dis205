<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Регистрация</title>
    <meta charset="utf-8"/>

    <script src='/dance_school/resources/js/validate_form.js'></script>

    <style type="text/css">
        body {
            font-family: Montserrat, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #333;
            color: #f4f4f4;
            background-size: cover;
        }
        h1 {
            padding: 20px;
            background-color: rgba(52, 73, 94, 0.7);
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        form {
            background-color: rgba(52, 73, 94, 0.7);
            padding: 20px;
            margin: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 15px;
        }
        table {
            margin: 0 auto;
        }
        input[type="text"], input[type="password"] {
            padding: 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: #ecf0f1;
        }
        input[type="submit"], .login-button {
            padding: 10px 20px;
            border: none;
            background-color: #3498db;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input[type="submit"]:hover, .login-button:hover {
            background-color: #2980b9;
        }
        div {
            text-align: center;
            margin: 20px;
        }
        #error {
            color: #e74c3c;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Регистрация в нашей школе танцев!</h1>

<div id="error">${error!" "} </div>
<form method="post" action="/dance_school/registration" onsubmit="return validate()"> <!-- validate  -->
    <table>
        <tr>
            <td><label>Имя<span style="color:red">*</span>:</label></td>
            <td><input type="text" name="name" placeholder="ваше имя" required ></td>
        </tr>
        <tr>
            <td><label>Почта:</label></td>
            <td><input id="email" type="text" name="email" placeholder="email"></td>
        </tr>
        <tr>
            <td><label>Телефон:</label></td>
            <td><input id="phone" type="text" name="phone" placeholder="+71111111111" ></td>
        </tr>
        <tr>
            <td><label>Пароль:</label></td>
            <td><input id="pwd" type="password" name="password"></td>
        </tr>
        <tr>
            <td><label>Повторите пароль: </label></td>
            <td><input id="pwd1" type="password"></td>
        </tr></table>
    <div>
        <input type="submit" value="зарегистрироваться">
        <a href="/dance_school/login"><button type="button" class="login-button">страница входа</button></a>
    </div>
</form>

</body>
</html>
