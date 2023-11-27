<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/profile.css'>
    <script src='/Site_war/resources/js/login.js'></script>
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
    </div>
    <div class="main">
        <div class="section_panel"></div>
        <div class="section_profile">
            <div class="profile-header"></div>
            <div class="avatar" style='background-image: url("data:image/jpeg;base64,${client.avatar}"); background-size: cover'></div>
            <div class="name-username-container">
                <div class="name">${client.name}</div>
                <div class="username">@${client.userName}</div>
            </div>
            <div>
                <a href="/Site_war/edit">
                    <button>Изменить профиль</button>
                </a>
            </div>
            <div class="information">
                <div class="information_status">${client.status}</div>
                <div class="information_birthday">${client.birthday}</div>
                <div class="information_birthday">${client.about}</div>
            </div>
        </div>
    </div>
</body>
</html>
