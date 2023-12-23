<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body{
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
        .profileContainer {

            max-width: 400px;
            margin: 0 auto;
            margin-top: 100px;
            padding: 20px;
            border: 1px solid #afef0c;
            background-color: #fff;
            border-radius: 5px;
        }

        h3 {
            text-align: center;
        }

        table {
            margin: 0 auto;
            width: 100%;
        }

        th,
        td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
            color: black;
        }

        th {
            font-weight: bold;
        }

        .hidden {
            display: none;
        }

        .visible {
            display: inline-block;
            color: blue;
            cursor: pointer;
        }
        .navbar{
            width:100%;
            height:50px;
            box-shadow: 0 4px 10px rgba(0,0,0, .1);
            background-color: #007bff;
            padding: 0;
            margin: 0;

        }

        .navbar .container{
            height:inherit;
            display:flex;
            justify-content: space-between;
            align-items:center;
            margin-right: 100px;



        }
        .navbar-menu{
            list-style-type:none ;
            padding-left: 0;
            margin-bottom:0;

        }
        .navbar-menu li{
            display:inline-block;
            color: white;
            opacity: 0.8;
            text-decoration: none;
        }
        .navbar-menu li a{
            display:inline-block;
            color: white;
            opacity: 0.8;
            text-decoration: none;
            padding: 10px;
            font-size: 18px;
        }
        .navbar-brand{
            font-weight: 700;
            font-size: 30px;
            text-decoration: none;
            color:white;
            margin-left: 100px;}
    </style>
    <script>
        function togglePassword() {
            var passwordField = document.getElementById("passwordField");

            if (passwordField.classList.contains("hidden")) {
                passwordField.classList.remove("hidden");
            } else {
                passwordField.classList.add("hidden");
            }
        }

        function showChangePasswordForm() {
            var renameForm = document.getElementById("rename_form");
            renameForm.style.display = "block";
        }

    </script>
</head>
<div>
    <nav class = "navbar">
        <div class = "container">
            <a href = "#" class = "navbar-brand">Мой профиль</a>

            <div class = "navbar-wrap">
                <ul class = "navbar-menu">
                    <li><a href = "startPage.ftl">Главная страница</a></li>
                    <li><a href = "success.ftl">Поддержка</a></li>
                    <li><a href = "login">Выйти</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<body>
<div id="profileContainer" class="profileContainer">
    <h3>Ваш профиль</h3>
    <table>
        <tr>
            <th>Название</th>
            <th>Ваши данные</th>
        </tr>
<#--        <tr>-->
<#--            <td>Логин</td>-->
<#--            <td>${profiles.login!"Ваш логин"}</td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td>Почта</td>-->
<#--            <td>${profiles.email!"Ваша почта"}</td>-->
<#--        </tr>-->
        <tr>
            <td>Пароль</td>
            <td>
                <span class="hidden" id="passwordField">${profiles.password}</span>
                <span class="visible" onclick="togglePassword()">Показать пароль</span>
            </td>
        </tr>
    </table>
    <br>
    <hr>
</div>
</body>

</html>