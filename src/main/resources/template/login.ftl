<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/servlets_website/resources/css/login-style.css" type="text/css">
</head>
<body>
<div class="authorisation-form">
    <h3 style="text-align: center;color: red; margin-top: 40px">${errormessage!""}</h3>
    <h2>Вход</h2>
    <form action="usercheck" method="post">
        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="login" required placeholder="Введите логин">
        </div>

        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required placeholder="Введите пароль">
        </div>
        <input type="submit" value="Войти" class="btn">

        <div style="text-align: center; margin-top: 20px;">
            <a href="/servlets_website/registration">Зарегистрироваться</a>
        </div>
    </form>
</div>
</body>
</html>
