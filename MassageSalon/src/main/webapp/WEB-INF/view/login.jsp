<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:loginLayout title="Login">

    <div class="auten">
        <h1>Аутентификация</h1>
        <a href="/massage/home"><button class="button_home">Вернуться на главную</button></a>

        <h2 color="red">${message}</h2>

        <form method="post" action="/massage/usercheck">
            <table style="display: block; justify-content: center">
                <tr>
                    <td><label>Имя:</label></td>
                    <td><input type="text" name="username" placeholder="введите имя пользователя"></td>
                </tr>
                <tr>
                    <td><label>Пароль:</label></td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <div><input type="submit" value="Вход"></div>
        </form>

        <div>
            <a href="/massage/regpage">Регистрация</a>
        </div>
    </div>









































































    <style>.auten {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .auten h1 {
        font-size: 35px;
        color: #938383;
    }

    .auten h2 {
        font-size: 20px;
        color: red;
    }

    .auten form {
        margin-top: 20px;
    }

    .auten label {
        font-size: 25px;
        color: #938383;
    }

    .auten input[type="text"],
    .auten input[type="password"] {
        font-size: 25px;
        color: #938383;
        border: none;
        border-bottom: 2px solid #938383;
        padding: 5px;
        margin-bottom: 10px;
    }

    .auten input[type="text"]::placeholder,
    .auten input[type="password"]::placeholder {
        color: #938383;
    }

    .auten input[type="submit"] {
        font-size: 25px;
        color: white;
        background-color: #938383;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }

    .auten a {
        font-size: 25px;
        color: #938383;
        margin-top: 10px;
        text-decoration: none;
    }

    .auten a:hover {
        text-decoration: underline;
    }
    .button_home {
        position: fixed;
        top: 10px;
        left: 10px;
        background-color: #938383;
        color: white;
        padding: 10px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    </style>

</t:loginLayout>