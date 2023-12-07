<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/support_list.css'>
    <script src='/Site_war/resources/js/menu.js'></script>

    <title>Document</title>
</head>
<body>
<div class="navbar">
    <div class="navbar-container">
        <div class="navbar-logo">
            <a href="/Site_war/welcome">
                <img src="/Site_war/resources/img/logo.png" alt="logo" class="logo-img">
            </a>
        </div>
        <div class="navbar-text">
            <a href="/Site_war/welcome" class="navbar-text-link">THE WORD OUT</a>
        </div>
        <div class="container-menu">
            <button id="openButton" class="menu-btn">
                <img class="menu-img" src="/Site_war/resources/img/menu.png" alt="">
            </button>

            <div id="sidebar" class="menu">
                <button id="closeButton" class="menu-btn-open">
                    <img class="cansel-img" src="/Site_war/resources/img/cansel.png" alt="">
                </button>
                <div class="menu-links">
                    <a href="/Site_war/index"><div class="menu-item">Home</div></a>
                    <a href="/Site_war/my_profile"><div class="menu-item">Profile</div></a>
                    <a href="/Site_war/support"><div class="menu-item">Support</div></a>
                    <a href="/Site_war/login"><div class="menu-item"> Log out</div></a>
                </div>
            </div>
        </div>
    </div>

    <div>
        <#list supports as support>
            <div>${support.title}</div>
            <div>${support.email}</div>
            <div>${support.message}</div>
        </#list>
    </div>
</div>
</body>
</html>