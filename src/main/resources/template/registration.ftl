<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="/servlets_website/resources/css/registration-style.css" type="text/css">
</head>
<body>
<div class="registration-form">
    <h3 style="text-align: center; color: red; margin-top: 40px">${errormessage!""}</h3>
    <h2>Регистрация</h2>
    <form action="registration" method="post">
        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="login" required placeholder="Придумайте логин">
        </div>

        <div class="form-group">
            <label for="username">Имя:</label>
            <input type="text" id="username" name="username" required placeholder="Иван">
        </div>

        <div class="form-group">
            <label for="email">Электронная почта:</label>
            <input type="email" id="email" name="email" required placeholder="example@gmail.com">
        </div>

        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required placeholder="Придумайте пароль">
        </div>

        <div class="form-group">
            <label for="password_repeat">Повторите пароль:</label>
            <input type="password" id="password_repeat" name="password_repeat" required placeholder="Подтвердите пароль">
        </div>
        <div>
        <input type="submit" value="Зарегистрироваться" class="btn">
        </div>

        <div style="text-align: center; margin-top: 20px;">
            <a href="/servlets_website/login">Уже зарегистирован</a>
        </div>
    </form>
</div>
</body>
</html>
