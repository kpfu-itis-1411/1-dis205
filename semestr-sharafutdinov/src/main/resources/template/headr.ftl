<!DOCTYPE html>
<html>
<head>
    <title>Отзывы автомоек</title>
</head>
<body>
<h1>Отзывы автомоек</h1>

<ul id="reviews">
    <!-- Здесь будут отображаться отзывы -->
</ul>

<h2>Добавить отзыв</h2>

<form id="reviewForm" action="headr" method="post">

    <label for="comment">Отзыв:</label><br>
    <textarea id="comment" name="comment" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="Добавить отзыв">
</form>

<script>
    // document.getElementById("reviewForm").addEventListener("submit", function(event) {
    //     event.preventDefault();
    //
    //     var name = document.getElementById("name").value;
    //     var comment = document.getElementById("comment").value;
    //     var carwashId = document.getElementById("carwashId").value; // Получение идентификатора мойки
    //
    //     // Отправка данных на сервер
    //     var xhr = new XMLHttpRequest();
    //     xhr.open("POST", "save-review", true);
    //     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //     xhr.onreadystatechange = function() {
    //         if (xhr.readyState === 4 && xhr.status === 200) {
    //             // Обработка ответа от сервера
    //             var response = JSON.parse(xhr.responseText);
    //             if (response.success) {
    //                 // Отзыв сохранен успешно
    //                 var review = document.createElement("li");
    //                 review.innerHTML = "<strong>" + name + "</strong>: " + comment;
    //                 document.getElementById("reviews-" + carwashId).appendChild(review); // Используется идентификатор мойки для получения соответствующего элемента
    //
    //                 document.getElementById("name").value = "";
    //                 document.getElementById("comment").value = "";
    //             } else {
    //                 // Ошибка сохранения отзыва
    //                 alert("Не удалось сохранить отзыв. Пожалуйста, попробуйте еще раз.");
    //             }
    //         }
    //     };
    //     xhr.send("name=" + encodeURIComponent(name) + "&comment=" + encodeURIComponent(comment) + "&carwashId=" + encodeURIComponent(carwashId)); // Отправка идентификатора мойки на сервер
    // });
</script>
</body>
</html>


<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Отзывы</title>-->
<#--    <style>-->
<#--        body {-->
<#--            font-family: Arial, sans-serif;-->
<#--            background-color: #f7f7f7;-->
<#--            padding: 20px;-->
<#--            box-sizing: border-box;-->
<#--        }-->

<#--        .review-container {-->
<#--            max-width: 600px;-->
<#--            margin: 10px auto;-->
<#--            background-color: #fff;-->
<#--            border-radius: 5px;-->
<#--            padding: 20px;-->
<#--            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);-->
<#--        }-->

<#--        .review-title {-->
<#--            font-size: 24px;-->
<#--            font-weight: bold;-->
<#--            margin-bottom: 10px;-->
<#--        }-->

<#--        .review-content {-->
<#--            font-size: 16px;-->
<#--            color: #555;-->
<#--            margin-bottom: 20px;-->
<#--        }-->

<#--        .review-author {-->
<#--            font-size: 14px;-->
<#--            color: #888;-->
<#--        }-->

<#--        .review-form {-->
<#--            margin-top: 20px;-->
<#--        }-->

<#--        .review-form input,-->
<#--        .review-form textarea {-->
<#--            width: 100%;-->
<#--            padding: 10px;-->
<#--            margin-bottom: 10px;-->
<#--        }-->

<#--        .review-form button {-->
<#--            padding: 10px 20px;-->
<#--            background-color: #4CAF50;-->
<#--            color: #fff;-->
<#--            border: none;-->
<#--            cursor: pointer;-->
<#--        }-->
<#--        .navbar{-->
<#--            width:100%;-->
<#--            height:50px;-->
<#--            box-shadow: 0 4px 10px rgba(0,0,0, .1);-->
<#--            background-color: #007bff;-->
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
<#--            color: white;-->
<#--            opacity: 0.8;-->
<#--            text-decoration: none;-->
<#--        }-->
<#--        .navbar-menu li a{-->
<#--            display:inline-block;-->
<#--            color: white;-->
<#--            opacity: 0.8;-->
<#--            text-decoration: none;-->
<#--            padding: 10px;-->
<#--            font-size: 18px;-->
<#--        }-->
<#--        .navbar-brand{-->
<#--            font-weight: 700;-->
<#--            font-size: 30px;-->
<#--            text-decoration: none;-->
<#--            color:white;-->
<#--            margin-left: 100px;}-->
<#--    </style>-->
<#--</head>-->
<#--<div>-->
<#--    <nav class="navbar">-->
<#--        <div class="navbar_container">-->
<#--            <a href="#" class="navbar-brand">${login!"Forum"}</a>-->

<#--            <div class="navbar-wrap">-->
<#--                <ul class="navbar-menu">-->
<#--                    <li><a href="profile.ftl">Мой профиль</a></li>-->
<#--                    <li><a href="success.ftl">Поддержка</a></li>-->
<#--                    <li><a href="login">Выйти</a></li>-->
<#--                </ul>-->
<#--            </div>-->
<#--        </div>-->
<#--    </nav>-->
<#--</div>-->
<#--<body>-->
<#--<div class="review-container">-->
<#--    <h2 class="review-title">Отличная мойка!</h2>-->
<#--    <p class="review-content">Я очень доволен качеством работы. Мою машину тут уже несколько раз и каждый раз остаюсь доволен. Рекомендую!</p>-->
<#--    <p class="review-author">Алексей</p>-->
<#--</div>-->

<#--<div class="review-form">-->
<#--    <h3>Напишите свой отзыв:</h3>-->
<#--    <form action="/submit_review" method="POST">-->
<#--        <input type="email" name="email" placeholder="Ваш email" required>-->
<#--        <textarea name="review" placeholder="Ваш отзыв" required></textarea>-->
<#--        <button type="submit">Отправить отзыв</button>-->
<#--    </form>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->