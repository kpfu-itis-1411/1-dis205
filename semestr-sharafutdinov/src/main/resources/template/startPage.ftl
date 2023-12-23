<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Автомойки Казани</title>
    <style>
        /* Стили для страницы */
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
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-top: 50px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .post {
            background-color: #f9f9f9;
            padding: 20px;
            margin-bottom: 20px;
        }

        .post-title {
            font-size: 20px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }

        .post-content {
            font-size: 16px;
            color: #555;
        }

        .add-review-button {
            display: block;
            width: 160px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            text-decoration: none;
            border-radius: 5px;
        }

        .navbar {
            width: 100%;
            height: 50px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, .1);
            background-color: #007bff;
            padding: 0;
            margin: 0;
        }

        .navbar_container{
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

        .navbar-brand {
            font-weight: 700;
            font-size: 30px;
            text-decoration: none;
            color: white;
            margin-left: 100px;
        }

        .add-review-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div>
    <nav class="navbar">
        <div class="navbar_container">
            <a href="#" class="navbar-brand">${login!"Forum"}</a>

            <div class="navbar-wrap">
                <ul class="navbar-menu">
<#--                    <li><a href="profile.ftl">Мой профиль</a></li>-->
                    <li><a href="success.ftl">Поддержка</a></li>
                    <li><a href="login">Выйти</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <h1>Автомойки Казани</h1>

    <div style="overflow: auto; height: 400px;">
    <div class="post" id="carwash1">
        <h2 class="post-title">Автомойка "Чистый лосось"</h2>
        <p class="post-content">Отличная автомойка с приветливым персоналом и качественным обслуживанием.</p>
        <form action="Otziv" method="get" class="view-comments">
            <input type="hidden" name="postId" value="5">
            <input type="submit" value="Добавь отзыв">
            <a href="OtzivShow?postId=5">Посмотреть отзывы</a>
        </form>
    </div>

    <div class="post" id="carwash2">
        <h2 class="post-title">Автомойка "Авто-Парк"</h2>
        <p class="post-content">Быстрое и качественное мытье автомобилей. Рекомендую!</p>
        <form action="Otziv" method="get" class="view-comments">
            <input type="hidden" name="postId" value="4">
            <input type="submit" value="Добавить отзыв">
            <a href="OtzivShow?postId=4">Посмотреть отзывы</a>
        </form>
    </div>


    <div class="post" id="carwash3">
        <h2 class="post-title">Автомойка "Мой-Бро"</h2>
        <p class="post-content">Быстрое и качественное мытье автомобилей. Рекомендую!</p>
        <form action="Otziv" method="get" class="view-comments">
            <input type="hidden" name="postId" value="3">
            <input type="submit" value="Добавить отзыв">
            <a href="OtzivShow?postId=3">Посмотреть отзывы</a>
        </form>
    </div>
        <div class="post" id="carwash1">
            <h2 class="post-title">Автомойка "Чистый город"</h2>
            <p class="post-content">Отличная автомойка с приветливым персоналом и качественным обслуживанием.</p>
            <form action="Otziv" method="get" class="view-comments">
                <input type="hidden" name="postId" value="2">
                <input type="submit" value="Добавь отзыв">
                <a href="OtzivShow?postId=2">Посмотреть отзывы</a>
            </form>
        </div>

        <div class="post" id="carwash2">
            <h2 class="post-title">Автомойка "Парк Горького"</h2>
            <p class="post-content">Быстрое и качественное мытье автомобилей. Рекомендую!</p>
            <form action="Otziv" method="get" class="view-comments">
                <input type="hidden" name="postId" value="1">
                <input type="submit" value="Добавить отзыв">
                <a href="OtzivShow?postId=1">Посмотреть отзывы</a>
            </form>
        </div>


        <div class="post" id="carwash3">
            <h2 class="post-title">Автомойка "Мой сам"</h2>
            <p class="post-content">Быстрое и качественное мытье автомобилей. Рекомендую!</p>
            <form action="Otziv" method="get" class="view-comments">
                <input type="hidden" name="postId" value="0">
                <input type="submit" value="Добавить отзыв">
                <a href="OtzivShow?postId=0">Посмотреть отзывы</a>
            </form>
        </div>

    </div>
            <!-- Другие посты с автомойками -->
        </div>
        </body>
        </html>
<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Автомойки Казани</title>-->
<#--    <style>-->
<#--        /* Стили для страницы */-->
<#--        body {-->
<#--            font-family: Arial, sans-serif;-->
<#--            background-color: #f4f4f4;-->
<#--            margin: 0;-->
<#--            padding: 0;-->
<#--        }-->

<#--        .container {-->
<#--            max-width: 800px;-->
<#--            margin: 0 auto;-->
<#--            padding: 20px;-->
<#--            background-color: #fff;-->
<#--            box-shadow: 0 2px 5px rgba(0,0,0,0.1);-->
<#--        }-->

<#--        h1 {-->
<#--            text-align: center;-->
<#--            color: #333;-->
<#--        }-->

<#--        .post {-->
<#--            background-color: #f9f9f9;-->
<#--            padding: 20px;-->
<#--            margin-bottom: 20px;-->
<#--        }-->

<#--        .post-title {-->
<#--            font-size: 20px;-->
<#--            font-weight: bold;-->
<#--            color: #333;-->
<#--            margin-bottom: 10px;-->
<#--        }-->

<#--        .post-content {-->
<#--            font-size: 16px;-->
<#--            color: #555;-->
<#--        }-->

<#--        .add-review-button {-->
<#--            display: block;-->
<#--            width: 160px;-->
<#--            margin: 20px auto;-->
<#--            padding: 10px;-->
<#--            text-align: center;-->
<#--            background-color: #007bff;-->
<#--            color: #fff;-->
<#--            font-size: 16px;-->
<#--            font-weight: bold;-->
<#--            text-decoration: none;-->
<#--            border-radius: 5px;-->
<#--        }-->
<#--        .navbar{-->
<#--            width:100%;-->
<#--            height:50px;-->
<#--            box-shadow: 0 4px 10px rgba(0,0,0, .1);-->
<#--            background-color: mediumpurple;-->
<#--            padding: 0;-->
<#--            margin: 0;-->

<#--        }-->

<#--        .navbar .container{-->
<#--            height:inherit;-->
<#--            display:flex;-->
<#--            justify-content: space-between;-->
<#--            align-items:center;-->
<#--            margin-right: 100px;-->



<#--        }-->
<#--        .navbar-menu{-->
<#--            list-style-type:none ;-->
<#--            padding-left: 0;-->
<#--            margin-bottom:0;-->

<#--        }-->
<#--        .navbar-menu li{-->
<#--            display:inline-block;-->
<#--            color: black;-->
<#--            opacity: 0.8;-->
<#--            text-decoration: none;-->
<#--        }-->
<#--        .navbar-menu li a{-->
<#--            display:inline-block;-->
<#--            color: black;-->
<#--            opacity: 0.8;-->
<#--            text-decoration: none;-->
<#--            padding: 10px;-->
<#--            font-size: 18px;-->
<#--        }-->
<#--        .navbar-brand{-->
<#--            font-weight: 700;-->
<#--            font-size: 30px;-->
<#--            text-decoration: none;-->
<#--            color:black;-->
<#--            margin-left: 100px;-->

<#--        }-->

<#--        .add-review-button:hover {-->
<#--            background-color: #0056b3;-->
<#--        }-->
<#--    </style>-->
<#--</head>-->
<#--<body>-->
<#--<div>-->
<#--    <nav class = "navbar">-->
<#--        <div class = "container">-->
<#--            <a href = "#" class = "navbar-brand">Forum</a>-->

<#--            <div class = "navbar-wrap">-->
<#--                <ul class = "navbar-menu">-->
<#--                    <li><a href = "profile.ftl">Мой профиль</a></li>-->
<#--                    <li><a href = "myPost">Мои посты</a></li>-->
<#--                </ul>-->
<#--            </div>-->
<#--        </div>-->
<#--    </nav>-->
<#--</div>-->
<#--<div class="container">-->
<#--    <h1>Автомойки Казани</h1>-->
<#--    <div class="post">-->
<#--        <h2 class="post-title">Автомойка "Чистый лосось"</h2>-->
<#--        <p class="post-content">Отличная автомойка с приветливым персоналом и качественным обслуживанием.</p>-->
<#--        <a href="add_review.html" class="add-review-button">Добавить отзыв</a>-->
<#--    </div>-->
<#--    <div class="post">-->
<#--        <h2 class="post-title">Автомойка "Авто-Парк"</h2>-->
<#--        <p class="post-content">Быстрое и качественное мытье автомобилей. Рекомендую!</p>-->
<#--        <a href="add_review.html" class="add-review-button">Добавить отзыв</a>-->
<#--    </div>-->
<#--    <!-- Другие посты с автомойками &ndash;&gt;-->
<#--</div>-->
<#--</body>-->
<#--</html>-->