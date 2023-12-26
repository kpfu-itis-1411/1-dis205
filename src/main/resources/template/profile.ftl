<!DOCTYPE html>
<html>
<head>
    <title>Профиль</title>
    <style>
        body {
            font-family: Montserrat, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #333;
            color: #f4f4f4;
            background-size: cover;
        }
        h1, h2, h3 {
            padding: 20px;
            background-color: rgba(52, 73, 94, 0.7);
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .header-button {
            background-color: #3498db;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .header-button:hover {
            background-color: #2980b9;
        }
        /* Стили для заголовка */
        h1 {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        table {
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(52, 73, 94, 0.7);
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 15px;
        }
        td {
            padding: 10px;
            color: #e74c3c;
        }
        .training {
            margin: 20px;
            padding: 20px;
            background-color: rgba(52, 73, 94, 0.7);
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 15px;
        }
        .unsubscribe-button {
            padding: 10px 20px;
            border: none;
            background-color: #e74c3c;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 10px;
        }
        .unsubscribe-button:hover {
            background-color: #c0392b;
        }
        .no-trainings {
            text-align: center;
            font-size: 24px;
            margin: 20px 0;
        }
        .subscribe-button {
            display: block;
            width: 200px;
            padding: 10px 20px;
            border: none;
            background-color: #3498db;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin: 20px auto;
        }
        .subscribe-button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<h1>
    <span>Добро пожаловать, ${client.name}!</span>
    <div>
        <a href="/dance_school/trainer_profile" class="header-button">Тренера</a>
        <a href="/dance_school/trainings" class="header-button">Тренировки</a>
    </div>
</h1>
<h2>Ваши данные</h2>
<table>
    <tr>
        <td>Имя:</td>
        <td>${client.name}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${client.email}</td>
    </tr>
    <tr>
        <td>Номер телефона:</td>
        <td>${client.phoneNumber}</td>
    </tr>
</table>
<#if text??>
    <p>${text}</p>
</#if>
<h2>Ваши тренировки</h2>
<#if trainings?size gt 0>
    <#list trainings as training>
        <div class="training">
            <h3>${training.title}</h3>
            <p>Рекомендуемый возраст: ${training.recommendedAge}</p>
            <p>Уровень: ${training.level}</p>
            <p>Дата: ${training.date}</p>
            <p>Время: ${training.time}</p>
            <form action="/dance_school/profile" method="post">
                <input type="hidden" name="trainingId" value="${training.trainingId}">
                <input type="submit" value="Я не пойду на тренировку" class="unsubscribe-button">
            </form>
        </div>
    </#list>
<#else>
    <p class="no-trainings">Тренировок не найдено</p>
    <a href="/dance_school/trainings"><button type="button" class="subscribe-button">Записаться</button></a>
</#if>
</body>
</html>
