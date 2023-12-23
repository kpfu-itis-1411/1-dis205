<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <link rel="stylesheet" href="/miproject/resources/css/home-style.css" type="text/css">
</head>
<body>
<div>
    <nav class = "navbar">
        <div class = "container">
            <a href = "#" class = "navbar-brand">Forum</a>

            <div class = "navbar-wrap">
                <ul class = "navbar-menu">
                    <li><a href = "profile">Мой профиль</a></li>
                    <li><a href = "myPost">Мои посты</a></li>
                    <li><a href = "exit">Выйти</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<h2 class="go-to_relations">
    <#if posts?size == 0>
        <!-- Текст не отображается, если нет постов -->
    <#else>
        Присоединяйтесь к общению!
    </#if>
</h2>
<a href="createPost" class="new-post-link">Создать новый пост</a>
<ul style="list-style-type: none" class="post_container">
    <#if posts?size == 0>
        <h2 class="no-post_message">Еще нет постов. Создайте первый!</h2>
    <#else>
        <ul>
            <#list posts as post>
                <li class="post_one">
                    <div class="post-block">
                        <div class="post-title">${post.title}</div>
                        <div class="post-id">${post.id}</div>
                        <div class="post-date">${post.dateToRelease}</div>
                        <div class="post-content">${post.content}</div>
                        <div class="post-user-login">Автор: ${post.user_login}</div>
                        <form action="commentPage" method="get" class="view-comments">
                            <input type="hidden" name="postId" value="${post.id}">
                            <input type="submit" value="Комментарии">
                        </form>
                    </div>
                </li>
            </#list>
        </ul>
    </#if>
</ul>

</body>
</html>