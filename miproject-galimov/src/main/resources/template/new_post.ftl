<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Новый пост</title>
    <link rel="stylesheet" href="/miproject_war/resources/css/headerstyle.css">
    <style>
        body{
            font-family : "Noto Sans", sans-serif;
            color: black;
        }
        .new-post_container{
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-top: 60px;
        }
        .form-group {
            padding: 10px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input[type="submit"]{
            padding: 10px 20px;
            background-color: dodgerblue;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin: 0 auto;
        }
        .form-group textarea {
            max-width: 360px;
            height: 100px;
        }
        .form-group input[type="text"],
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group input[type="submit"]:hover{
            background-color: blue ;
        }
    </style>

</head>

<body>
<div class="new-post_container">
    <h2 style="text-align: center">Создать новый пост</h2>
    <form action="createPost" method="post">
        <div class="form-group">
            <label for="title">Заголовок:</label>
            <input type="text" id="title" name="title" required placeholder="Введите заголовок">
        </div>
        <div class="form-group">
            <label for="content">Содержание:</label>
            <textarea id="content" name="content" rows="4" cols="50" required placeholder="Введите содержание поста"></textarea>
        </div>
        <div class="form-group">
            <input type="submit" value="Создать пост">
        </div>

    </form>
</div>

</body>

</html>