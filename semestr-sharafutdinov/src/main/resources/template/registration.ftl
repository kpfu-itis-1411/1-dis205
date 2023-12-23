<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Страница регистрации</title>
    <style>


        .header {
            width: 100%;
            height: 70px;
            background-color: #007bff;
            position: fixed;
            top: 0;
            left: 0;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            position:relative;
            height: 100vh;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 400px;
            margin: 80px auto 0; /* Adjust the margin-top value as needed */
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #666666;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #dddddd;
            border-radius: 3px;
        }

        .form-group input[type="submit"] {
            background-color: #0056b3;
            /*color: #ffffff;*/
            cursor: pointer;
        }

        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .form-group p {
            text-align: center;
            margin-top: 10px;
        }

        .form-group p a {
            color: #666666;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h3 style=" color: red; margin-top: 90px">${error!""}</h3>

<header class="header">
    <h1>Оставь отзыв автомойкам</h1>
</header>
<div class="container">
    <h2>Регистрация</h2>
    <form action="/semestrWork_war/regpage" method="post" onsubmit="return validate()">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="phone">Номер телефона:</label>
            <input type="tel" id="phone_number" name="phone_number" placeholder="89043213213" required pattern="(8|(\+7))[0-9]{10}">
        </div>
        <div class="form-group">
            <label for="username">Логин:</label>
            <input type="text" id="login" name="login" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="confirm_password1" name="password" oninput="validatePassword(this)" required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Повторите пароль:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Зарегистрироваться">
        </div>
    </form>
    <div class="form-group">
        <p>Уже зарегистрированы? <a href="login">Войти</a></p>
    </div>
    <script type = "text/javascript">
        function validate() {
            let password = confirm_password1.value;
            let password1 = confirm_password.value;

            if (password != password1) {
                alert("Пароли не совпадают");
                return false;
            }
            return true;
        }
        function validatePassword(input) {
            if (input.value.length < 8) {
                // необходимо вызвать setCustomValidity с сообщением о6 ошибке
                input.setCustomValidity("Слишком короткий пароль");
            } else {
                // очищаем сообщение об ошибке
                input.setCustomValidity("");
            }
        }
    </script>
</div>
</body>
</html>
<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Страница регистрации</title>-->
<#--    <style>-->
<#--        body {-->
<#--            margin: 0;-->
<#--        }-->

<#--        .header {-->
<#--            width: 100%;-->
<#--            height: 70px;-->
<#--            background-color: #4CAF50;-->
<#--            position: fixed;-->
<#--            top: 0;-->
<#--            left: 0;-->
<#--        }-->
<#--        body {-->
<#--            font-family: Arial, sans-serif;-->
<#--            background-color: #f2f2f2;-->
<#--            display: flex;-->
<#--            align-items: center;-->
<#--            justify-content: center;-->
<#--            height: 100vh;-->
<#--            margin: 0;-->
<#--            padding: 0;-->
<#--        }-->

<#--        .container {-->
<#--            width: 400px;-->
<#--            margin: auto;-->
<#--            padding: 20px;-->
<#--            background-color: #ffffff;-->
<#--            border-radius: 5px;-->
<#--            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);-->
<#--        }-->

<#--        h2 {-->
<#--            text-align: center;-->
<#--        }-->

<#--        .form-group {-->
<#--            margin-bottom: 20px;-->
<#--        }-->

<#--        .form-group label {-->
<#--            display: block;-->
<#--            margin-bottom: 5px;-->
<#--            color: #666666;-->
<#--        }-->

<#--        .form-group input {-->
<#--            width: 100%;-->
<#--            padding: 10px;-->
<#--            border: 1px solid #dddddd;-->
<#--            border-radius: 3px;-->
<#--        }-->

<#--        .form-group input[type="submit"] {-->
<#--            background-color: #4CAF50;-->
<#--            color: #ffffff;-->
<#--            cursor: pointer;-->
<#--        }-->

<#--        .form-group input[type="submit"]:hover {-->
<#--            background-color: #45a049;-->
<#--        }-->

<#--        .form-group p {-->
<#--            text-align: center;-->
<#--            margin-top: 10px;-->
<#--        }-->

<#--        .form-group p a {-->
<#--            color: #666666;-->
<#--            text-decoration: none;-->
<#--        }-->
<#--    </style>-->
<#--</head>-->
<#--<body>-->
<#--<h3 style=" color: red; margin-top: 40px">${error!""}</h3>-->

<#--<header class="header">-->
<#--    <h1>Оставь отзыв автомойкам</h1>-->
<#--</header>-->
<#--<div class="container">-->
<#--    <h2>Регистрация</h2>-->
<#--    <form action="/semestrWork_war/regpage" method="post">-->
<#--        <div class="form-group">-->
<#--            <label for="email">Email:</label>-->
<#--            <input type="email" id="email" name="email" required>-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <label for="phone">Номер телефона:</label>-->
<#--            <input type="tel" id="phone_number" name="phone_number" placeholder="89043213213" required pattern="(8|(\+7))[0-9]{10}">-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <label for="username">Логин:</label>-->
<#--            <input type="text" id="login" name="login" required>-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <label for="password">Пароль:</label>-->
<#--            <input type="password" id="password" name="password" oninput="validatePassword(this)" required>-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <label for="confirm_password">Повторите пароль:</label>-->
<#--            <input type="password" id="confirm_password" name="confirm_password" required>-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <input type="submit" value="Зарегистрироваться">-->
<#--        </div>-->
<#--    </form>-->
<#--    <div class="form-group">-->
<#--        <p>Уже зарегистрированы? <a href="login">Войти</a></p>-->
<#--    </div>-->
<#--<script type = "text/javascript">-->
<#--    function validate() {-->
<#--        let password = password.value;-->
<#--        let password1 = confirm_password.value;-->

<#--        if (password != password1) {-->
<#--            alert("Пароли не совпадают");-->
<#--            return false;-->
<#--        }-->
<#--        return true;-->
<#--    }-->
<#--    function validatePassword(input) {-->
<#--        if (input.value.length < 8) {-->
<#--            // необходимо вызвать setCustomValidity с сообщением о6 ошибке-->
<#--            input.setCustomValidity("Слишком короткий пароль");-->
<#--        } else {-->
<#--            // очищаем сообщение об ошибке-->
<#--            input.setCustomValidity("");-->
<#--        }-->
<#--    }-->
<#--    </script>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->
<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Registration</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>Registration</h1>-->
<#--<form action="/semestrWork_war/registration" method="POST">-->
<#--    <label for="username">Username:</label>-->
<#--    <input type="text" id="username" name="username" required>-->
<#--    <br>-->
<#--    <label for="password">Password:</label>-->
<#--    <input type="password" id="password" name="password" required>-->
<#--    <br>-->
<#--    <input type="submit" value="Register">-->
<#--</form>-->
<#--</body>-->
<#--</html>-->