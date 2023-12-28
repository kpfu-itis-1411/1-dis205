<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 <t:mainLayout title="Home">


    <header>
       <div class="container1">

          <nav>
             <a href="#main">Главная</a>
             <a href="#specialist">Специалисты</a>
             <a href="#services">Услуги</a>
             <a href="#contacts">Контакты</a>
          </nav>

          <div class="logo">
             <img src="/massage/images/img1.png" alt="Логотип студии массажа ТелоПросит">
          </div>

       </div>
    </header>


    <main id="main">

       <section class="about">
          <div class="container2">
             <h2>О нас</h2>
             <p>Студия массажа ТелоПросит предлагает широкий спектр услуг по массажу.<br> Наши специалисты имеют большой опыт работы и используют только качественные массажные масла.</p>
             <img src="/massage/images/img2.jpg" alt="Фото студии массажа ТелоПросит">
          </div>
       </section>

       <section id="specialist" class="specialists">
          <div class="container3">
             <h2>Специалисты</h2>
             <div class="specialists-list">
                <div class="specialist1">
                   <img src="/massage/images/img3.jpg" alt="Фото специалиста">
                   <h3>Александр</h3>
                   <p>Стаж работы: 11 лет</p>
                   <p>Специализация: классический, расслабляющий, лечебный массаж, Тайский массаж.</p>
                </div>

                <div class="specialist2">
                   <img src="/massage/images/massage.jpg" alt="Фото специалиста">
                   <h3>Елена</h3>
                   <p>Стаж работы: 8 лет</p>
                   <p>Специализация: Массаж лица, массаж для детей</p>
                </div>
             </div>
          </div>
       </section>

       <section id="services" class="services">
          <div class="container4">
             <h2>Услуги</h2>
             <ul>
                <li>Классический массаж</li>
                <li>Расслабляющий массаж</li>
                <li>Лечебный массаж</li>
                <li>Детский массаж</li>
                <li>Масссаж лица</li>
                <li>Тайский массаж</li>
                <li>Спортивный массаж</li>
             </ul>

             <div>
                <a href="/massage/login"><button class="button_signup">Записаться на массаж</button></a>
             </div>

          </div>
       </section>

       <section class="contacts">
          <div class="container5">
             <h2>Контакты</h2>
             <p>Адрес: г. Москва, ул. Ленина, д. 123</p>
             <p>Телефон: +7 (495) 123-45-67</p>
             <p>Email: info@teloprosit.ru</p>
          </div>
       </section>

    </main>

    <footer>
       <div id="contacts" class="container6">
          <p>© 2023 ТелоПросит</p>
       </div>
    </footer>

 </t:mainLayout>