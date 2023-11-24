<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Lab 10</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/login.css'>
    <script src='/Site_war/resources/js/login.js'></script>
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
            <div class="container-singIn">Sing In</div>
            <div class="container-message" id="message">${message}</div>
            <div class="container-main">
                <div class="container-main-small">
                    <form method="post" action="/Site_war/usercheck" id="singInForm">
                        <div class="login">
                            <div class="login-text name">Username</div>
                            <div class="login-input">
                                <input id="login_id" type="text" name="username" class="input">
                            </div>
                        </div>
                        <div class="password">
                            <div class="password-text name">Password</div>
                            <div class="password-input">
                                <input id="password_id" type="password" name="password" class="input">
                            </div>
                        </div>
                        <div class="remember name">
                            <input id="remember-input" type="checkbox" name="remember">
                            <label>Remember me</label>
                        </div>
                        <div class="sing-in-btn">
                            <div class="btn-block">
                                <button type="submit" class="btn-sing-in" id="sing-in-btn">Sing in</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="container-additional">
                    <div class="container-additional-small">For the first time on our website?</div>
                    <a class="container-link" href="/Site_war/reg_page">Create a new account</a>
                </div>
                <div class="container-additional">
                    <div class="container-additional-small">Having problems?</div>
                    <div class="container-additional-contact">
                        Contact us →
                        <a class="container-link" href="/Site_war/reg_page">help</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
