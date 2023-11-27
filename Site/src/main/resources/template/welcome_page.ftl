<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/welcome.css'>
    <script src='/Site_war/resources/js/welcome_page.js'></script>
    <title>THEWORDOUT</title>
</head>
<body>
<div class="navbar">
    <div class="navbar-container">
        <div class="navbar-logo">
            <a href="/Site_war/welcome">
                <img src="/Site_war/resources/img/logo.png" alt="logo" class="navbar-logo-img">
            </a>
        </div>
        <div class="navbar-text">
            <a href="/Site_war/welcome" class="navbar-text-link">THE WORD OUT</a>
        </div>
    </div>
</div>
    <div class="header">
        <div class="section-poster">
            <div class="container-poster">
                <div class="poster">
                    <div class="poster-img" id="poster-id"></div>
                </div>
            </div>
        </div>
        <div class="section-main">
            <div class="container-logo">
                <div class="logo">
                    <div class="logo-img"></div>
                </div>
            </div>
            <div class="container-head">
                <div class="text-head" id="text_head"></div>
            </div>
            <div class="container" id="container">
                <div class="container-small">
                    <div class="container-small-text" id="text"></div>
                </div>
            </div>
            <div class="container-btns">
                <div class="container-small-btns" id="btns">
                    <div class="btn-block">
                        <a class="link" href="/Site_war/login">
                            <button class="btn one" id="sing-in"></button>
                        </a>
                    </div>
                    <div class="btn-block">
                        <a class="link" href="/Site_war/reg_page">
                            <button class="btn two" id="sing-up"></button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="main_section-about">
            <div class="about_text-container">
                <div class="about-text">We are a new social <br> network!</div>
            </div>
            <div class="about_image-container">
                <div class="about-image"></div>
            </div>
        </div>
        <div class="main_section-slogan">
            <div class="slogan_container-one">
                <div class="container_one-image-one">
                    <div class="image-one"></div>
                </div>
            </div>
            <div class="slogan_container-two">
               <div class="container_two-text-one">Share your thoughts!</div>
               <div class="container_two-text-two">Dreams!</div>
               <div class="container_two-text-three">Ideas!</div>
            </div>
        </div>
        <div class="main_section-declare">
            <div class="declare_text-container">
                <div class="declare-text">Declare yourself!</div>
            </div>
            <div class="declare_image-container">
                <div class="declare-image"></div>
            </div>
        </div>
        <div class="main_section-background">
            <div class="background-join"></div>
            <div class="join-text"></div>
            <div class="join-button">
                <a class="link-join"  href="/Site_war/login">
                    <button class="join-btn">JOIN</button>
                </a>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="footer_name">© 2023 «THE WORD OUT»</div>
        <div class="footer_link"><a class="footer_item-link footer_item" href="/Site_war/login">SUPPORT</a></div>
        <div class="footer_language footer_item">
            <select class="footer_select-language" name="language" id="">
                <option value="russian">Русский</option>
                <option value="english" selected>English</option>
            </select>
        </div>
        <div class="footer_link"><a class="footer_item-link footer_item" href="/Site_war/login">ABOUT US</a></div>
    </div>
</body>
</html>

