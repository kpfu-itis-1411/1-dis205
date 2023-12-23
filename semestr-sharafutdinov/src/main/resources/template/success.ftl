<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Страница поддержки</title>
<style>
    body {
        background-image: url("/semestrWork_war/resources/img;//scale_1200.jpeg");
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        font-family: Arial, sans-serif;
        /*background-color: #f4f4f4;*/
        margin: 0;
        padding: 0;
        height: 100vh;
        width: 100%;
    }

    .container {
        background-color: #fff;
        max-width: 600px;
        margin: 80px auto;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        color: #333;
    }

    label {
        display: block;
        font-weight: bold;
        margin-top: 10px;
    }

    input[type="text"],
    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        resize: vertical;
    }

    button {
        background-color: #007bff ;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 20px;
    }
    .navbar {
        width: 100%;
        height: 50px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, .1);
        background-color: #007bff;
        padding: 0;
        margin: 0;
    }

    .navbar .container1{
        height: inherit;
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-right: 100px;
    }

    .navbar-menu {
        list-style-type: none;
        padding-left: 0;
        margin-bottom: 0;
    }

    .navbar-menu li {
        display: inline-block;
        color: white;
        opacity: 0.8;
        text-decoration: none;
    }

    .navbar-menu li a {
        display: inline-block;
        color: white;
        opacity: 0.8;
        text-decoration: none;
        padding: 10px;
        font-size: 18px;
    }

    button:hover {
        background-color: #8041cc;
    }
    .navbar-brand{
        text-decoration: none;
        font-size:30px;
        color: white;
        margin-left: 100px;
    }
</style>
</head>
<div>
    <nav class = "navbar">
        <div class = "container1">
            <a href = "#" class = "navbar-brand">Поддержка</a>

            <div class = "navbar-wrap">
                <ul class = "navbar-menu">
                    <li><a href = "startPage.ftl">Главная страница</a></li>
<#--                    <li><a href = "profile.ftl">Мой профиль</a></li>-->
                    <li><a href = "login">Выйти</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<body>
<div class="container">
    <h1>Страница поддержки</h1>
    <form>
        <label for="question">Ваш вопрос:</label>
        <textarea id="question" name="question" rows="4" placeholder="Напишите свой вопрос здесь..."></textarea>
        <button type="submit">Отправить</button>
    </form>
</div>
</body>
</html>