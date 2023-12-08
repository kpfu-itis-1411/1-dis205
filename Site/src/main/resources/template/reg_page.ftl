<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Registration</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/regpage.css'>
    <script src='/Site_war/resources/js/validate_form.js'></script>
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
        <div class="container-singIn">Sing Up</div>
        <div class="container-message" id="message">${message}</div>
        <div class="container-main">
            <div class="container-main-small">
                <form method="post" action="/Site_war/registration" id="singInForm" onsubmit="return validate()">
                    <div class="main-item">
                        <div class="item-text name">Name</div>
                        <div class="item-input">
                            <input id="name_id" type="text" name="name" class="input" required>
                        </div>
                    </div>
                    <div class="main-item">
                        <div class="item-text name">Username</div>
                        <div class="item-input">
                            <input id="username_id" type="text" name="username"  class="input" required >
                        </div>
                    </div>
                    <div class="main-item">
                        <div class="item-text name">Phone number</div>
                        <div class="item-input">
                            <input id="phone_id" type="text" name="phone" class="input"  required pattern="^((\+7|8)+([0-9]){10})$">
                        </div>
                    </div>
                    <div class="main-item">
                        <div class="item-text name">Password</div>
                        <div class="item-input">
                            <input id="password_id" type="password" name="password" class="input"  required placeholder="Minimum 6 symbols"  oninput="validatePassword(this)">
                        </div>
                    </div>
                    <div class="main-item">
                        <div class="item-text name">Password repeat</div>
                        <div class="item-input">
                            <input id="password_repeat_id" type="password" name="password-repeat"  placeholder="Minimum 6 symbols" class="input" required>
                        </div>
                    </div>
                    <div class="sing-up-btn">
                        <div class="btn-block">
                            <button type="submit" class="btn-sing-up" id="sing-up-btn">Sing Up</button>
                        </div>
                    </div>
                </form>
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
