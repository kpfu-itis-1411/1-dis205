<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Sem</title>
    <meta charset="utf-8"/>
    <link rel="shortcut icon"
          href="/lab08/favicon.ico">
    <link rel="stylesheet" href='/Semestrovaya_war/resources/CSS/global.css'>
    <link rel="stylesheet" href='/Semestrovaya_war/resources/CSS/styleForServices.css'>
<#--    <script src='../JS/index.js'></script>-->

</head>
<body>
<div class="site">

    <input type="checkbox" id="hmt" class="hidden-menu-ticker">

    <label for="hmt" class="btn-menu">
        <span class="first"></span>
        <span class="second"></span>
        <span class="third"></span>
    </label>

    <ul class="hidden-menu">
        <li><a href="/Semestrovaya_war/account">Мой аккаунт</a></li>
        <li><a href="/Semestrovaya_war/support_list">${admin}</a></li>
    </ul>

    <div class = "main">

        <div class = "header">
            <div class="header_block">
                <div class="header_block_text">
                    <a href="/Semestrovaya_war/index" class="head_link" target="_blank">
                    <h1> Cut and Style </h1>
                    </a>

                </div>
            </div>

        </div>

        <div class="main_section">

            <div class = "main_section1">
                <div class = "main_section1_block">
                    <div class="main_section1_block1">
                        <div class="main_section1_block1_text">
                            <a href="/Semestrovaya_war/services" class="selected">Услуги</a>
                        </div>

                    </div>
                    <div class="main_section1_block1">
                        <div class="main_section1_block1_text">
                            <a href="/Semestrovaya_war/aboutUs" class="main_header">О нас</a>
                        </div>

                    </div>
                    <div class="main_section1_block1">
                        <div class="main_section1_block1_text">
                            <a href="#contacts" class="main_header">Контакты</a>
                        </div>

                    </div>
                    <div class="main_section1_block1">
                        <div class="main_section1_block1_text">
                            <a href="/Semestrovaya_war/salon" class="main_header">Салоны</a>
                        </div>

                    </div>
                </div>
            </div>

            <div class="main_section2_text">
                <p class="main_section2_text_head">
                    Cut and Style - это место,
                    где каждый клиент может получить идеальную стрижку и стильную укладку,
                    воплотив свои желания в реальность.
                </p>
            </div>


            <div class="main_section2">

                <div class = "main_section2_block">
                    <div class="main_section2_block1">
                        <div class="main_section2_block1_photo">

                            <img class="main__photo" src='\Semestrovaya_war\resources\IMG\hairCut.jpg' alt="Фото стрижки">

                        </div>

                        <div class="main_section2_block1_photo" >

                            <img class="main__photo" src='\Semestrovaya_war\resources\IMG\hairstyle.jpg' alt="Фото причёски">

                        </div>

                        <div class="main_section2_block2_photo">

                            <img class="main__photo" src='\Semestrovaya_war\resources\IMG\hairCare.jpg' alt="Фото ухода">

                        </div>

                        <div class="main_section2_block2_photo">

                            <img class="main__photo" src='\Semestrovaya_war\resources\IMG\hairColouring.jpg' alt="Фото окрашивания">

                        </div>
                    </div>
                </div>
            </div>

            <div class="services_block">
                <#list servicess as services>

                    <div class="services_name">
                        <form method="post" action="/Semestrovaya_war/master">
                            <input type="hidden" name="services" value="${services.id}">
                            <input type="submit" value="${services.name}">
                        </form>
                    </div>

                </#list>
            </div>



            <div class="block"></div>

            <div class = "footer" id="contacts">
                <div class = "footer_block1">
                    <div class="footer_block1_header">
                        <h5>Cut und Style Group</h5>
                    </div>

                    <div class="footer_block1_data">
                        <div class="footer_block1_inf">
                            <p class="footer_text">Пн-пт с 10:00 до 19:00</p>
                            <p class="footer_text">support@CutUndStyle.ru</p>
                            <p class="footer_text">+7 937 111 000</p>

                            <div class="footer__icons">

                                <a href="https://t.me/" class="footer_link" target="_blank">
                                    <img class="footer__photo" src="\Semestrovaya_war\resources\IMG\tg.png" alt="Иконка Телеграм">
                                </a>

                                <a href="https://vk.com/" class="footer_link" target="_blank">
                                    <img class="footer__photo" src="\Semestrovaya_war\resources\IMG\vk.png" alt="Иконка ВК">
                                </a>

                                <a href="https://instagram.com/" class="footer_link" target="_blank">
                                    <img class="footer__photo" src="\Semestrovaya_war\resources\IMG\insta.png" alt="Иконка инстаграмма">
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="block"></div>

            <div class="footer_block2">
                <p class="footer_text1">Все права защищены 2023</p>
            </div>

        </div>
    </div>
</div>
</body>
</html>