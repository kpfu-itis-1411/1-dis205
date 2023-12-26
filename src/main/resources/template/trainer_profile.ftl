<!DOCTYPE html>
<html>
<head>
    <title>Профиль тренера</title>
    <meta charset="utf-8"/>
    <style>
        body {
            font-family: Montserrat, sans-serif;
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
            justify-content: space-between;
            align-items: center;
            display: flex;
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
        /* Стили для контейнера кнопок */
        .button-container {
            position: absolute;
            top: 0;
            right: 0;
            padding: 10px;
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
        div {
            text-align: center;
            margin: 20px;
        }
        .trainer {
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
        .trainer img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 50%;
        }
        .trainer h2 {
            margin: 0;
            margin-bottom: 20px;
            padding: 0;
            color: #3498db;
        }
        .trainer p {
            margin: 0;
            padding: 0;
            display: block;
            margin-bottom: 20px;
            color: #ecf0f1;
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
        .training h4 {
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
    </style>
</head>
<body>
<div class="button-container">
    <a href="/dance_school/profile" class="header-button">Профиль</a>
    <a href="/dance_school/trainings" class="header-button">Тренировки</a>
</div>
<#if trainer??>
    <div class="trainer">
        <h1>Профиль тренера</h1>
        <img src="/dance_school/resources/images/trainer/${trainer.trainerId}.jpg" alt="Изображение тренера">
        <h2>${trainer.name}</h2>
        <p>${trainer.description}</p>
        <p>Почта: ${trainer.email}</p>
        <h3>Тренировки:</h3>
        <#if isRegistered??>
            <#if isRegistered>
                <p class="center-text">Вы успешно записаны на тренировку!</p>
            <#else>
                <p class="center-text">Вы уже записаны на эту тренировку.</p>
            </#if>
        </#if>
        <#list trainings as training>
            <div class="training">
                <h4>${training.title}</h4>
                <p>${training.date} в ${training.time}</p>
                <form method="post" action="/dance_school/trainer_profile">
                    <input type="hidden" name="trainingId" value="${training.trainingId}">
                    <input type="hidden" name="trainerId" value="${trainer.trainerId}">
                    <input type="submit" value="Записаться">
                </form>
            </div>
        </#list>
    </div>
<#else>
    <h1>Все тренеры</h1>
    <#list trainers as trainer>
        <div class="trainer">
            <img src="/dance_school/resources/images/trainer/${trainer.trainerId}.jpg" alt="Изображение тренера">
            <h2>${trainer.name}</h2>
            <p>${trainer.description}</p>
            <form method="post" action="/dance_school/trainer_profile">
                <input type="hidden" name="trainerId" value="${trainer.trainerId}">
                <input type="submit" value="Просмотреть профиль тренера">
            </form>
        </div>
    </#list>
</#if>

</body>
</html>