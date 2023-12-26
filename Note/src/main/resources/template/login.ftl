<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
    <meta charset="utf-8"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            font-size: 24px;
            color: #333;
            text-align: center;
            padding: 20px 0;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-size: 16px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;

        }

        input[type="submit"] {
            background-color: cornflowerblue;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 18px;
            cursor: pointer;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Вход</h1>
<body>
<div style="position: relative;">
    <h1 style="text-align: left;"><span style="color: cornflowerblue;">Заметки</span> хранятся здесь
        <div style="position: absolute; top: 0; right: 10px;">
            <a href="./registration"><button type="button" class="signup-button">Register</button></a>
        </div>
    </h1>
</div>

<form action="#" method="post">
    <label for="username">Логин:</label>
    <input type="text" id="username" name="username" required><br>
    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password" required><br>
    <input type="submit" value="Войти">
</form>
</body>
</html>
