<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body{
            font-family : "Noto Sans", sans-serif;
            color: black;
        }
        .comment-container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-top: 60px;
        }

        .form-group {
            padding: 20px;

        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .form-group textarea {
            max-width: 360px;
            height: 100px;
        }

        .form-group button {
            padding: 10px 20px;
            background-color: dodgerblue;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin: 0 auto;
        }

        .form-group button:hover {
            background-color: blue ;
        }
    </style>
</head>
<body>
<div class="comment-container">
    <h2 style="text-align: center">Создать новый комментарий</h2>
    <form action="newComment" method="post">
        <div class="form-group">
            <label for="comment">Комментарий:</label>
            <textarea id="comment" name="comment" placeholder="Введите ваш комментарий" required></textarea>
        </div>
        <div class="form-group">
            <button type="submit">Создать</button>
        </div>
    </form>
</div>
</body>
</html>