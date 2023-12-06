<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/profile.css'>
    <script src='/Site_war/resources/js/profile.js'></script>
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
                <div class="menu">
                    <div class="dropdown">
                        <button class="dropbtn" id="dropdownBtn">Profile</button>
                        <div class="dropdown-content" id="dropdown-list">
                            <a href="/Site_war/index">Home</a>
                            <a href="/Site_war/login">Log out</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="section_profile">
            <div class="information-container">
                <div class="profile-header"></div>
                <div class="avatar" style='background-image: url("data:image/jpeg;base64,${client.avatar}"); background-size: cover'></div>
                <div class="name-username-edit-container">
                    <div class="name-username-container">
                        <div class="name">${client.name}</div>
                        <div class="username">@${client.userName}</div>
                    </div>
                    <div class="edit-profile-container">
                        <form class="form-edit" method="get" action="/Site_war/${editlink}">
                            <button type="submit" class="edit-profile-btn">${edit}</button>
                            <input type="hidden" id="profile-edit-hidden" name="profile-edit-hidden" value="${client.userName}">
                        </form>
                    </div>
                </div>
                <div class="information">
                    <div class="information-left">
                        <fieldset class="fieldset-status">
                            <legend>STATUS</legend>
                            <div class="information_status">${client.status}</div>
                        </fieldset>
                        <fieldset class="fieldset-information">
                            <legend>INFORMATION</legend>
                            <div class="information-item-container">
                                <div class="information_item">Birthday: ${client.birthday}</div>
                                <div class="information_item">Phone number: ${client.phoneNumber}</div>
                                <div class="information_item">Likes: ${likes}</div>
                                <div class="information_item">Followers: ${countfollow}</div>
                                <div class="information_item">Subscriptions: ${countSubs}</div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="information-right">
                        <fieldset class="fieldset-about">
                            <legend>ABOUT ME</legend>
                            <div class="container-about">
                                <div class="about-text">${client.about}</div>
                            </div>
                        </fieldset>
                    </div>
                </div>
                <div class="posts">
                    <div class="post-header">Posts</div>
                    <#list posts as post>
                        <a class="post-container">
                            <div class="post">
                                <div class="data_time-container">
                                    <div class="post-date">${post.date}</div>
                                    <div class="post-time">${post.time}</div>
                                </div>
                                <div class="post-message">
                                    <div class="message">${post.message}</div>
                                </div>
                            </div>
                        </a>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
