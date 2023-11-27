<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/edit_profile.css'>
    <title>Document</title>
</head>
<body>
<div class="navbar">
    <div class="navbar-container">
        <div class="navbar-logo">
            <a href="/Site_war/welcome">
                <img src="/Site_war/resources/img/logo.png" alt="logo" class="logo-img">
            </a>
        </div>
        <div class="navbar-text">
            <a href="/Site_war/welcome" class="navbar-text-link">THE WORD OUT</a>
        </div>
    </div>
    <form method="post" action="/Site_war/edit" enctype="multipart/form-data">
        <div class="username">@${client.userName}</div>
        <input type="text" name="client_name" value="${client.name}">
        <input type="text" name="client_password" value="${client.password}">
        <input type="text" name="client_phoneNumber" value="${client.phoneNumber}">
        <input type="text" name="client_status" value="${client.status}">
        <input type="text" name="client_birthday" value="${client.birthday}">
        <input type="text" name="client_about" value="${client.about}">
        <div class="avatar" style='background-image: url("data:image/jpeg;base64,${client.avatar}"); background-size: cover'></div>
        <input type="file" name="avatar" class="avatar">
        <input type="submit" value="Сохранить">
    </form>
</div>
</body>
</html>