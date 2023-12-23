<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AnimeTitleInfo</title>
    <link rel="stylesheet" href="/servlets_website/resources/css/anime-title-style.css" type="text/css">
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

<div class="anime-info">
    <img src="/servlets_website/resources/images/anime-titles/${animeInfo.id}.jpg" alt="Название аниме">
    <div class="anime-text">
        <div>
            <h2>${animeInfo.name}</h2>
            <p>Тип: ${animeInfo.type}</p>
            <p>Статус: ${animeInfo.status}</p>
            <p>Жанр: ${animeInfo.genre}</p>
            <p>Эпизоды: ${animeInfo.episodes_count}</p>
            <p>Дата выхода первого эпизода: ${animeInfo.start_date}</p>
            <p>Описание: ${animeInfo.description}</p>
        </div>
        <#if alreadyAdded>
            <p class="bookmark-info">Уже в закладках</p>
        <#else>
            <form action="animeTitleInfo" method="post">
                <input type="submit" value="Добавить в закладки">
            </form>
        </#if>
    </div>
</div>
</body>
</html>
