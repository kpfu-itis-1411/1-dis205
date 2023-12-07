<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/edit_profile.css'>
    <script src='/Site_war/resources/js/validate_form.js'></script>
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
</div>
<div class="main">
    <div class="section_profile">
        <div class="information-container">
            <form method="post" action="/Site_war/edit" enctype="multipart/form-data">
                <div class="profile-header"></div>
                <div class="avatar" style='background-image: url("data:image/jpeg;base64,${client.avatar}"); background-size: cover'></div>
                <div class="name-username-edit-container">
                    <div class="name-username-container">
                        <input type="text" name="client_name" class="edit_name"  required value="${client.name}">
                        <div class="username">@${client.userName}</div>
                    </div>
                    <input class="edit_avatar" type="file" name="avatar" >
                    <input class="edit_save" type="submit" value="Save changes">
                </div>
                <div class="information">
                    <div class="information-left">
                        <fieldset class="fieldset-status">
                            <legend>STATUS</legend>
                            <input type="text" name="client_status" class="edit_status" value="${client.status}">
                        </fieldset>
                        <fieldset class="fieldset-information">
                            <legend>INFORMATION</legend>
                            <div class="information-item-container">
                                <label class="label_edit" for="client_birthday">Birthday:</label>
                                <input type="text" name="client_birthday" class="edit_info" value="${client.birthday}">
                                <label class="label_edit" for="client_phoneNumber">Phone number:</label>
                                <input type="text" name="client_phoneNumber" class="edit_info" value="${client.phoneNumber}">
                                <label class="label_edit" for="client_phoneNumber">Password</label>
                                <input type="text" name="client_password" required class="edit_info"  value="${client.password}"  oninput="validatePassword(this)">
                            </div>
                        </fieldset>
                    </div>
                    <div class="information-right">
                        <fieldset class="fieldset-about">
                            <legend>ABOUT ME</legend>
                            <div class="container-about">
                                <textarea class="edit_about" type="text" name="client_about" >${client.about}</textarea>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>