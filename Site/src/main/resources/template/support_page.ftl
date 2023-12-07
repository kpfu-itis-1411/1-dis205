<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Lab 10</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/support_page.css'>
    <script src='/Site_war/resources/js/support_page.js'></script>
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
    </div>
</div>
<div class="page">
    <div class="container">
        <div class="container-singIn">Support</div>
        <div class="container-main">
            <div class="container-main-small">
                <form method="post" action="/Site_war/support" id="singInForm">
                    <div class="title-support-container">
                        <div class="login-text name">The title of the problem</div>
                        <div class="login-input">
                            <input id="login_id" type="text" name="title" class="input" required >
                        </div>
                    </div>
                    <div class="title-support-container">
                        <div class="login-text name">Your email</div>
                        <div class="login-input">
                            <input id="login_id" type="text" name="email" class="input" required >
                        </div>
                    </div>
                    <div class="message-support-container">
                        <div class="password-text name">Describe the problem</div>
                        <div class="password-input">
                            <textarea id="password_id" name="message_support" class="textarea-support" required ></textarea>
                        </div>
                    </div>
                    <div class="sing-in-btn">
                        <div class="btn-block">
                            <button type="submit" class="btn-sing-in" id="sing-in-btn">Send</button>
                        </div>
                    </div>
                </form>
            </div>
<#--            <div class="container-additional">-->
<#--                <a class="container-link" href="/Site_war/login">Sing in</a>-->
<#--            </div>-->
        </div>
    </div>
</div>
</body>
</html>
