<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="/servlets_website/resources/css/profile-style.css" type="text/css">
</head>
<body>
<div class="header">
    <div class="logo">
        <a href="mainPage"><img src="/servlets_website/resources/images/service/logotype.png" alt="Логотип"></a>
    </div>
    <div class="navbar-menu">
        <a href="profile"><img src="/servlets_website\resources\images\service\profile.png" alt="Профиль"></a>
        <a href="exit"><img src="/servlets_website/resources/images/service/exit.png" alt="Выход"></a>
    </div>
</div>

<div class="profile-container">
    <div class="user-info">
        <img src="/servlets_website/resources/images/users/user1.jpg" alt="Аватар пользователя">
        <div>
            <h2>${userInfo.login}</h2>
            <p>Email: ${userInfo.email}</p>
        </div>
    </div>

    <h2>Ваши закладки:</h2>
    <div class="anime-list">
        <#list userAnimeList as anime>
            <a href="animeTitleInfo?anime_id=${anime.id}">
                <div class="anime-item">
                    <img src="/servlets_website/resources/images/anime-titles/${anime.id}.jpg" alt="${anime.name}">
                    <p>${anime.name}</p>
                </div>
            </a>
        </#list>
    </div>
</div>
</body>
</html>
