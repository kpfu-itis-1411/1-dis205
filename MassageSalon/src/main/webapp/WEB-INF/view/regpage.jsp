<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:regpageLayout title="REGISTRATION">
    <div class="registr">
        <h1>Регистрация пользователя</h1>
        <a href="/massage/home"><button class="button_home">Вернуться на главную</button></a>

        <h2>${message}</h2>
        <div id="error"></div>
        <form method="post" action="/massage/registration" onsubmit="return validate()"> <!-- validate  -->
            <table>
                <tr>
                    <td><label>Имя<span style="color:red">*</span>:</label></td>
                    <td><input type="text" name="name" placeholder="ваше имя" required ></td>
                </tr>
                <tr>
                    <td><label>Телефон:</label></td>
                    <td><input type="text" name="phone" placeholder="+71111111111" required pattern="(8|(\+7))[0-9]{10}" ></td>
                </tr>
                <tr>
                    <td><label>Пароль:</label></td>
                    <td><input id="pwd" type="password" name="password" oninput="validatePassword(this)"></td>
                </tr>
                <tr>
                    <td><label>Повторите пароль:</label></td>
                    <td><input id="pwd1" type="password"></td>
                </tr>
            </table>
            <div><input type="submit" value="Регистрация"></div>
        </form>
    </div>






















































    <style>
        .registr {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .registr h1 {
            font-size: 35px;
            color: #938383;
        }

        .registr h2 {
            font-size: 20px;
            color: red;
        }

        .registr #error {
            color: red;
            margin-bottom: 10px;
        }

        .registr form {
            margin-top: 20px;
        }

        .registr label {
            font-size: 25px;
            color: #938383;
        }

        .registr input[type="text"],
        .registr input[type="password"] {
            font-size: 25px;
            color: #938383;
            border: none;
            border-bottom: 2px solid #938383;
            padding: 5px;
            margin-bottom: 10px;
        }

        .registr input[type="text"]::placeholder,
        .registr input[type="password"]::placeholder {
            color: #938383;
        }

        .registr input[type="submit"] {
            font-size: 25px;
            color: white;
            background-color: #938383;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .registr table {
            margin-top: 10px;
        }

        .registr table tr td:first-child {
            width: 200px;
        }

        .registr table tr td:last-child {
            padding-left: 20px;
        }

        .registr table tr td label span {
            color: red;
        }

        .registr table tr td input:invalid {
            border-color: red;
        }

        .registr table tr td input:valid {
            border-color: #938383;
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
</t:regpageLayout>