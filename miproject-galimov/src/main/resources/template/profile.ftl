<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Профиль</title>
    <link rel="stylesheet" href="/miproject/resources/css/profile-style.css" type="text/css">
    <script src="/miproject/resources/js/change_profile.js"></script>
</head>
<div>
    <nav class = "navbar">
        <div class = "container">
            <a href = "#" class = "navbar-brand">Forum</a>

            <div class = "navbar-wrap">
                <ul class = "navbar-menu">
                    <li><a href = "homePage">Главная страница</a></li>
                    <li><a href = "myPost">Мои посты</a></li>
                    <li><a href = "exit">Выйти</a></li>
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
        <tr>
            <td>id</td>
            <td>${profiles.id!"Ваш id"}</td>
        </tr>
        <tr>
            <td>Полное имя</td>
            <td>${profiles.fullName!"Ваше полное имя"}</td>
        </tr>
        <tr>
            <td>Логин</td>
            <td>${profiles.login!"Ваш логин"}</td>
        </tr>
        <tr>
            <td>Почта</td>
            <td>${profiles.email!"Ваша почта"}</td>
        </tr>
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
    <div>
        <div id="rename_form" style="display:none;">
            <h3>Изменить пароль</h3>
            <form action="profile" method="post">
                <input type="password" name="newPassword" placeholder="Новый пароль" required>
                <button type="submit">Изменить</button>
            </form>
        </div>

        <br>
        <button id="reset-button" onclick="showChangePasswordForm()">Изменить пароль</button>
    </div>

</div>
</body>

</html>