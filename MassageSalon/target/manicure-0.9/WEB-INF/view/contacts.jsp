<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:mainLayout title="Contacts">
    <div class="contact-info">
        <h2>Наш адрес</h2>
        <div style="position:relative;overflow:hidden;"><a href="https://yandex.ru/maps/org/konechno_mozhno/238978322526/?utm_medium=mapframe&utm_source=maps" style="color:#eee;font-size:12px;position:absolute;top:0px;">Конечно Можно</a><a href="https://yandex.ru/maps/43/kazan/category/beauty_salon/184105814/?utm_medium=mapframe&utm_source=maps" style="color:#eee;font-size:12px;position:absolute;top:14px;">Салон красоты в Казани</a><a href="https://yandex.ru/maps/43/kazan/category/cosmetology/892508964/?utm_medium=mapframe&utm_source=maps" style="color:#eee;font-size:12px;position:absolute;top:28px;">Косметология в Казани</a><iframe src="https://yandex.ru/map-widget/v1/org/konechno_mozhno/238978322526/?ll=49.037374%2C55.786611&z=11.81" width="560" height="400" frameborder="1" allowfullscreen="true" style="position:relative;"></iframe></div>
    </div>
    <div class="contact-form">
        <div class="formContact">
            <h2>Задать вопрос</h2>
            <form action="/submit-question" method="post">
                <label for="question">Ваш вопрос:</label>
                <textarea id="question" name="question"></textarea>
                <label for="name">Ваше имя:</label>
                <input type="text" id="name" name="name">
                <label for="phone">Контактный телефон:</label>
                <input type="text" id="phone" name="phone">
                <button type="submit">Задать вопрос</button>
            </form>
        </div>
        <div class="containerContacts">
            <div class="block">
                <img class="contacts" src="C:\Users\runga\IdeaProjects\ManicureService\src\main\webapp\images\телефон.png" alt="Картинка телефона">
                <div class="text">+79534862110</div>
            </div>
            <div class="block">
                <img class="contacts" src="/src/main/webapp/images/почта.png" alt="Картинка почты">
                <div class="text">manicurekonechnomojno@icloud.com</div>
            </div>
            <div class="block">
                <img class="contacts" src="/webapp/images/вк.png" alt="Картинка вк">
                <div class="text">КонечноМожно</div>
            </div>
            <div class="block">
                <img class="contacts" src="webapp/images/инста.png" alt="Картинка инстаграмма">
                <div class="text">konechnoMojnoKazan</div>
            </div>
        </div>
    </div></t:mainLayout>