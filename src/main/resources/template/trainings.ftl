<!DOCTYPE html>
<html>
<head>
    <title>Тренировки</title>
    <meta charset="utf-8"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #333;
            color: #f4f4f4;
            background-size: cover;
        }
        h1 {
            padding: 20px;
            background-color: rgba(52, 73, 94, 0.7);
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
            display: flex;
            justify-content: space-between;
            align-items: center;
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
        form {
            background-color: rgba(52, 73, 94, 0.7);
            padding: 20px;
            margin: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 15px;
        }
        table {
            margin: 0 auto;
        }
        input[type="text"], input[type="password"], input[type="date"] {
            padding: 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: #ecf0f1;
        }
        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: #3498db;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input[type="submit"]:hover {
            background-color: #2980b9;
        }
        div {
            text-align: center;
            margin: 20px;
        }
        .training {
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: space-between;
            margin-bottom: 20px;
            padding: 20px;
            background-color: rgba(52, 73, 94, 0.7);
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .training img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 50%;
        }
        .training h2 {
            margin: 0;
            margin-bottom: 20px;
            padding: 0;
            color: #3498db;
        }
        .training p {
            margin: 0;
            padding: 0;
            display: block;
            margin-bottom: 20px;
            color: #ecf0f1;
        }
        .center-text {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>
    <span>Тренировки на сегодня</span>
    <div>
        <a href="/dance_school/profile" class="header-button">Профиль</a>
        <a href="/dance_school/trainer_profile" class="header-button">Тренера</a>
    </div>
</h1>

<form method="post" action="/dance_school/trainings">
    <label for="date">Выберите дату:</label>
    <input type="date" id="date" name="date">
    <input type="submit" value="Показать тренировки">
</form>

<#if isRegistered??>
    <#if isRegistered>
        <p class="center-text">Вы успешно записаны на тренировку!</p>
    <#else>
        <p class="center-text">Вы уже записаны на эту тренировку.</p>
    </#if>
</#if>

<#list trainings as training>
    <div class="training">
        <img src="/dance_school/resources/images/discipline/${training.discipline.disciplineId}.jpg" alt="Изображение тренировки">
        <h2>${training.title}</h2>
        <p>Рекомендованный возраст: ${training.recommendedAge} и старше</p>
        <p>Уровень: ${training.level}</p>
        <p>Тренер: ${training.trainer.name}</p>
        <p>Дисциплина: ${training.discipline.name}</p>
        <form method="post" action="/dance_school/trainer_profile">
            <input type="hidden" name="trainerId" value="${training.trainer.trainerId}">
            <input type="submit" value="Перейти в профиль тренера">
        </form>
        <p>${training.date} в ${training.time}</p>
        <form method="post" action="/dance_school/trainings">
            <input type="hidden" name="trainingId" value="${training.trainingId}">
            <input type="submit" value="Записаться">
        </form>
    </div>
</#list>

</body>
</html>
