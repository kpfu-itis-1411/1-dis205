<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href='/Site_war/resources/css/global.css'>
    <link rel="stylesheet" href='/Site_war/resources/css/main.css'>
    <script src='/Site_war/resources/js/main.js'></script>

</head>
<body>
    <div class="navbar">
        <div class="section-navbar">
            <div class="navbar-container">
                <div class="container-block">
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
        </div>
        <div class="container-menu">
            <div class="menu">
                <div class="dropdown " onclick="toggleDropdown()">
                    <button class="dropbtn" id="dropdownBtn">Home</button>
                    <div class="dropdown-content" id="dropdown-list">
                        <a href="/Site_war/my_profile">Profile</a>
                        <a href="/Site_war/login">Log out</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="main">
        <div class="section_main-profile">
            <div class="container-profile">
                <div class="background-avatar">
                    <div class="background">
                        <div class="avatar" style='background-image: url("data:image/jpeg;base64,${client.avatar}"); background-size: cover'></div>
                    </div>
                </div>
                <div class="info">
                    <div class="name">${client.name}</div>
                    <div class="username">@${client.userName}</div>
                    <div class="status">${client.status}</div>
                </div>
                <div class="activity">
                    <div class="container-item">
                        <div class="item">${likes}</div>
                        <div class="item-text">likes</div>
                    </div>
                    <div class="line"></div>
                    <div class="container-item">
                        <div class="item">${countfollow}</div>
                        <div class="item-text">followers</div>
                    </div>
                </div>
                <div class="link">
                    <div class="container-link">
                        <form action="">
                            <a class="link-profile" href="/Site_war/my_profile">My Profile</a>
                        </form>
                    </div>
                </div>
            </div>
            <div class="container-friends">
                <div class="friends-header">
                    <div class="header-text">Subscriptions</div>
                </div>
                <div class="friends-list">
                    <div class="list-item">
                            <#list friends as friend>
                                    <form method="post" action="/Site_war/my_profile">
                                        <div class="friend-container">
                                            <div class="friend">
                                                <div class="friend-avatar" style='background-image: url("data:image/jpeg;base64,${friend.friend_id.avatar}"); background-size: cover'>
                                                </div>
                                                <div class="friend-info">
                                                    <div class="friend-name">${friend.friend_id.name}</div>
                                                    <div class="friend-username">@${friend.friend_id.userName}</div>
                                                </div>
                                            </div>
                                            <input type="hidden" name="friendid" value="${friend.friend_id.id}">
                                            <button class="submit-input" type="submit" value="profile">
                                                <img class="view" src="/Site_war/resources/img/view.png" alt="">
                                            </button>
                                        </div>
                                    </form>
                            </#list>
                    </div>
                </div>
                <div class="friends-more">
                    <div class="friends-more-container">
                        <a href="/Site_war/welcome" class="more-text">View More</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="section_main-tape">
            <div class="main-tape-write">
                <div class="tape-write-avatar" style='background-image: url("data:image/jpeg;base64,${client.avatar}"); background-size: cover'></div>
                <form>
                    <div class="tape-write-message">
                        <div class="message-container">
                            <textarea id="message_input" class="message-input" name="message" placeholder="What's new?"></textarea>
                        </div>
                        <div class="message-submit">
                            <button type="submit" class="submit-btn">Send</button>
                        </div>
                    </div>
                </form>
            </div>
            <div id="list-container" class="main-tape-list">
<#--                <#list posts as post>-->
<#--                    <div class="post-container">-->
<#--                        <div class="post-avatar" style='background-image: url("data:image/jpeg;base64,${post.client.avatar}"); background-size: cover'></div>-->
<#--                        <div class="post-content">-->
<#--                            <div class="post-content-user">-->
<#--                                <div class="post-name">${post.client.name}</div>-->
<#--                                <div class="post-username">@${post.client.userName}</div>-->
<#--                            </div>-->
<#--                            <div class="post-time">-->
<#--                                <div class="date">${post.date}</div>-->
<#--                                <div class="time">${post.time?string("HH:mm")}</div>-->
<#--                            </div>-->
<#--                            <div class="post-message">${post.message}</div>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </#list>-->
            </div>
        </div>
        <div class="section_main-panel"></div>
    </div>
</body>
</html>
