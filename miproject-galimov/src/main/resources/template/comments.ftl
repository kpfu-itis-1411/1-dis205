<html>
<head>
    <meta charset="UTF-8">
    <title>Комментарии</title>
    <link rel="stylesheet" href="/miproject/resources/css/comments-page-style.css" type="text/css">
</head>

<body>
<div>
    <nav class = "navbar">
        <div class = "container">
            <a href = "#" class = "navbar-brand">Forum</a>

            <div class = "navbar-wrap">
                <ul class = "navbar-menu">
                    <li><a href = "homePage">Главная страница</a></li>
                    <li><a href = "profile.ftl">Мой профиль</a></li>
                    <li><a href = "myPost">Мои посты</a></li>
                    <li><a href = "exit">Выйти</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<h2 style="text-align: center;margin-top: 30px">Пост: </h2>
<div class="post_block">
    <div class="post-title"> ${postbyid.title}</div>
    <div class="post-content"> ${postbyid.content}</div>
</div>
<br>
<hr>
<br>
<h3 style="text-align: center">Комментарии к этому посту:</h3>
<a class="new-comment_link" href="new_comment.ftl">Создать новый комментарий</a>
<ul class="comment-block">
    <#if comments?size == 0>
        <div class="no-comments">Еще нет комментариев</div>
    <#else>
        <#list comments as comment>
            <li class="comment-element">
                <div class="comment-author">${comment.user_login!""}</div>
                <div class="comment-date">${comment.date!""}</div>
                <div class="comment-content">${comment.content!""}</div>
            </li>
        </#list>
    </#if>
</ul>
</body>
</html>