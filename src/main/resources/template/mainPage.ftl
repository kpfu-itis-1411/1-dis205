<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MainPage</title>
  <link rel="stylesheet" href="/servlets_website/resources/css/main-page-style.css" type="text/css">
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

<form action="mainPage" method="get">
  <label for="genre">Choose genre: </label>
  <select name="genre" id="genre">
    <option value="">Not chosen</option>
    <#list genres as genre>
    <option value="${genre.name}">${genre.name}</option>
  </#list>
  </select>
  <input type="submit" value="Filter">
</form>

<div class="row">
  <#list animelist as animetitle>
    <div class="col">
      <a href="animeTitleInfo?anime_id=${animetitle.id}">
      <div class="card shadow-sm">
        <img src="/servlets_website/resources/images/anime-titles/${animetitle.id}.jpg" alt="${animetitle.name}" class="bd-placeholder-img card-img-top" width="100%" height="225">
        <div class="card-body">
          <h3 class="card-text">${animetitle.name}</h3>
          <p class="card-text">Тип: ${animetitle.type}</p>
          <p class="card-text">Статус: ${animetitle.status}</p>
          <p class="card-text">Жанр: ${animetitle.genre}</p>
          <div class="d-flex justify-content-between align-items-center">
          </div>
        </div>
      </div>
      </a>
    </div>
  </#list>
</div>
</body>
</html>
