<!DOCTYPE html>
<html>
<head>
    <title>Авторизация</title>
    <meta charset="utf-8"/>
    <style>
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
        h2 {
            color: #e74c3c;
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
        a {
            color: #3498db;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Добро пожаловать в нашу школу танцев!</h1>

<h2>${message}</h2>

<form method="post" action="/dance_school/usercheck">
    <table>
        <tr>
            <td><label>Почта:</label></td>
            <td><input type="text" name="email" placeholder="введите почту"></td>
        </tr>
        <tr>
            <td><label>Пароль:</label></td>
            <td><input type="password" name="password" placeholder="введите пароль"></td>
        </tr>
    </table>
    <div><input type="submit" value="Вход">
        <a href="/dance_school/registration"><button type="button" class="login-button">страница регистрации</button></a>
    </div>
</form>

</body>
</html>
