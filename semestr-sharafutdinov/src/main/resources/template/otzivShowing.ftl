<!DOCTYPE html>
<style>
    body {
        position: relative;
        font-family: "Noto Sans", sans-serif;
        font-size: 16px;
        line-height: 1;
        color: #000;
        min-width: 320px;
        padding: 0;
        margin: 0;
    }

    .comment-block {
        list-style-type: none;
        width: 600px;
        margin: 0 auto;
    }

    .comment-element {
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        padding: 10px;
        position: relative;
    }

    .new-comment_link {
        display: block;
        width: fit-content;
        margin: 0 auto;
        background-color: blue;
        color: white;
        text-align: center;
        padding: 10px 20px;
        border-radius: 5px;
        text-decoration: none;
        margin-bottom: 30px;
    }

    .comment-author {
        font-weight: bold;
        position: absolute;
        top: 5px;
        left: 5px;
    }

    .comment-date {
        position: absolute;
        top: 5px;
        right: 5px;
        color: #888;
    }

    .comment-content {
        margin-top: 25px;
    }

    .no-comments {
        text-align: center;
        font-style: italic;
        margin-top: 20px;
    }


    .navbar-menu li{
        display:inline-block;
        color: black;
        opacity: 0.8;
        text-decoration: none;
    }
    .navbar-menu li a{
        display:inline-block;
        color: black;
        opacity: 0.8;
        text-decoration: none;
        padding: 10px;
        font-size: 18px;
    }
</style>
<html>
<head>
    <meta charset="UTF-8">
    <title>Комментарии</title>
</head>

<body>


<br>
<hr>
<br>
<h3 style="text-align: center">Комментарии к этому посту:</h3>
<a class="new-comment_link" href="headr.ftl">Создать новый комментарий</a>
<ul class="comment-block">
    <#if comments?size == 0>
        <div class="no-comments">Еще нет комментариев</div>
    <#else>
        <#list comments as comment>
            <li class="comment-element">
                <div class="comment-date">${comment.postId!""}</div>
                <div class="comment-content">${comment.text!""}</div>
                <div class="comment-author">${comment.author!""}</div>
            </li>
        </#list>
    </#if>
</ul>
</body>
</html>