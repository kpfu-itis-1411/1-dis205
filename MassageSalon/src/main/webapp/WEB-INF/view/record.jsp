<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:recordLayout title="Record">
    <div class="container1">

        <h2>${message}</h2>
        <h1>Запись на услугу</h1>
        <a href="/massage/home"><button class="button_home">Вернуться на главную</button></a>
        <form action="/massage/record" method="post">

            <div class="container1_3">
                <label>Услуга:</label>
                <select id="service" name="service">
                    <option>Relaxing massage</option>
                    <option>Thai massage</option>
                    <option>Facial massage</option>
                    <option>Sports massage</option>
                    <option>Therapeutic massage</option>
                    <option>Childrens massage</option>
                </select><br><br>
            </div>
            <div class="container1_4">
                <label>Дата:</label>
                <input type="date" name="date" required><br><br>
            </div>
            <div class="container1_5">
                <label>Время:</label>
                <input type="time" name="time" required><br><br>
            </div>

            <div class="buttonRecord">
                <button class="button_record" type="submit">Записаться</button>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        var successMessage = "${successMessage}";

        function showNotification(message) {
            var notification = document.createElement("div");
            notification.classList.add("notification"); // Добавляем класс "notification"
            notification.textContent = message;
            document.body.appendChild(notification);

            setTimeout(function() {
                notification.style.display = "none";
            }, 3000);
        }

        if (successMessage) {
            showNotification(successMessage);
        }

    </script>
</t:recordLayout>