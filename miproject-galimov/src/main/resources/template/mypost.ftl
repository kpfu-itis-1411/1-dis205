<html>
<head>
    <meta charset="UTF-8">
    <title>Мои посты</title>
    <link rel="stylesheet" href="/miproject/resources/css/mypost-page-style.css" type="text/css">
</head>
<body>
<div>
    <nav class = "navbar">
        <div class = "container">
            <a href = "#" class = "navbar-brand">Forum</a>

            <div class = "navbar-wrap">
                <ul class = "navbar-menu">
                    <li><a href = "profile.ftl">Мой профиль</a></li>
                    <li><a href = "homePage">Главная страница</a></li>
                    <li><a href = "exit">Выйти</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<ul class="mypost_container">
    <#if myposts?size == 0>
            <div class="no-post_message">Вы еще не создали ни одного поста</div>
    <#else>
        <#list myposts as mypost>
            <li class = "mypost_one">
                <div class="post-block">
                    <div class="post-title"> ${mypost.title}</div>
                    <div class="post-id"> ${mypost.id}</div>
                    <div class="post-date">${mypost.dateToRelease}</div>
                    <div class="post-content">${mypost.content}</div>
                    <div class="post-user-login">Автор: ${mypost.user_login}</div>
                    <form action="commentPage" method="get" class="view-comments">
                        <input type="hidden" name="postId" value="${mypost.id}">
                        <input type="submit" value="Комментарии">
                    </form>
                    <form action="deletePost" method="post" class="delete-button">
                        <input type="hidden" name="postId" value="${mypost.id}">
                        <input type="hidden" name="author" value="${mypost.user_login}">
                        <input type="submit" value="Удалить пост">
                    </form>
                </div>
            </li>
        </#list>
    </#if>
</ul>
<a href="new_post.ftl" class="new-post-link">Создать новый пост</a>
</body>
</html>