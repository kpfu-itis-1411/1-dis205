document.addEventListener("DOMContentLoaded", () => {
   start()
})
function start() {
    fetch('/Site_war/session', {
        method: 'GET',
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((data) => {
            connect(data)
        })
        .catch((err) => console.log(err));
}
function connect(name) {
    let webSocket = new WebSocket('ws://localhost:8081/Site_war/msg/' + name);
    let button = document.querySelector(".submit-btn")
    button.addEventListener("click", () => {
        let message = document.querySelector(".message-input")
        webSocket.send(message.value);
    })
    webSocket.onmessage = function(response) {
        let data = response['data'];
        let json = JSON.parse(data);
        createFields(json)
    };

    webSocket.onerror = function() {
        alert('Ошибка подключения к серверу');
    };
}

function likeButton(post) {
    const div = document.createElement("div")
    const button = document.createElement("button")
    const img = document.createElement("img")
    const count = document.createElement("div")
    count.textContent = `${post.likes}`
    count.classList.add("count-like")
    img.src = "/Site_war/resources/img/like.png"
    button.classList.add("button-like")
    img.classList.add("img-like")
    button.appendChild(img)
    div.classList.add("like-container")
    div.appendChild(button)
    div.appendChild(count)
    let countClick = 0;
    button.addEventListener("click", function() {
        if (countClick % 2 === 0) {
            post.likes += 1;
        } else {
            post.likes -= 1;
        }
        countClick++
        sendLike(post, count)
    })
    return div
}
function sendLike(post, count) {
    fetch('/Site_war/activity', {
        method: 'POST',
        body: JSON.stringify(post),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((data) => {
            count.textContent = `${data.likes}`;
        })
}
function dislikeButton(post) {
    const div = document.createElement("div")
    const button = document.createElement("button")
    const img = document.createElement("img")
    const count = document.createElement("div")
    count.textContent = `${post.dislikes}`
    count.classList.add("count-dislike")
    img.src = "/Site_war/resources/img/dislike.png"
    button.classList.add("button-dislike")
    img.classList.add("img-dislike")
    button.appendChild(img)
    div.classList.add("dislike-container")
    div.appendChild(button)
    div.appendChild(count)
    let countClick = 0;
    button.addEventListener("click", function() {
        if (countClick % 2 === 0) {
            post.dislikes += 1;
        } else {
            post.dislikes -= 1;
        }
        countClick++
        sendDislike(post, count)
    })
    return div
}
function sendDislike(post, count) {
    fetch('/Site_war/activity', {
        method: 'POST',
        body: JSON.stringify(post),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((data) => {
            count.textContent = `${data.dislikes}`;
        })
}
function createFields(post){
    const container = document.getElementById("list-container")
    container.classList.add("main-tape-list")
    post.forEach((item) => {
        const div = document.createElement("div")
        div.classList.add("post-container")
        div.appendChild(avatarContainer(item))
        div.appendChild(contentContainer(item))
        container.appendChild(div)
    })
}

function avatarContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-avatar")
    div.style.backgroundImage = `url('data:image/jpeg;base64,${post.client.avatar}')`
    div.style.backgroundSize = "cover"
    return div
}
function contentContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-content")
    div.appendChild(usernameUserViewContainer(post))
    div.appendChild(timeDateContainer(post))
    div.appendChild(messageContainer(post))
    div.appendChild(likeDislike(post))
    return div
}
function likeDislike(post){
    const div = document.createElement("div")
    div.classList.add("like-dislike-container")
    div.appendChild(likeButton(post))
    div.appendChild(dislikeButton(post))
    return div;
}
function usernameUserViewContainer(post){
    const div = document.createElement("div")
    div.classList.add("usernameUserView")
    div.appendChild(usernameUserContainer(post))
    div.appendChild(viewProfile(post))
    return div
}
function usernameUserContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-content-user")
    div.appendChild(nameContainer(post))
    div.appendChild(usernameContainer(post))
    return div
}
function nameContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-name")
    div.textContent = `${post.client.name}`
    return div
}
function usernameContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-username")
    div.textContent = `@${post.client.userName}`
    return div
}
function timeDateContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-time")
    div.appendChild(dateContainer(post))
    div.appendChild(timeContainer(post))
    return div
}
function dateContainer(post){
    const div = document.createElement("div")
    div.classList.add("date")
    div.textContent = `${post.date}`
    return div
}
function timeContainer(post){
    const div = document.createElement("div")
    div.classList.add("time")
    div.textContent = `${post.time}`
    return div
}
function messageContainer(post){
    const div = document.createElement("div")
    div.classList.add("post-message")
    div.textContent = `${post.message}`
    return div
}
function toggleDropdown() {
    const list = document.getElementById("dropdown-list")
    list.classList.toggle("show")
}
function viewProfile(post){
    const form = document.createElement("form")
    const inputHidden = document.createElement("input")
    const btnSend = document.createElement("button")
    const img = document.createElement("img")
    form.method = "post"
    form.action = "/Site_war/my_profile"
    inputHidden.type = "hidden"
    inputHidden.value = `${post.client.id}`
    inputHidden.name = "friendid"
    btnSend.type = "submit"
    btnSend.value = "Send"
    btnSend.classList.add("view-btn")
    img.src = "/Site_war/resources/img/view.png"
    img.classList.add("view_profile")
    btnSend.appendChild(img)
    form.appendChild(inputHidden)
    form.appendChild(btnSend)
    return form
}
