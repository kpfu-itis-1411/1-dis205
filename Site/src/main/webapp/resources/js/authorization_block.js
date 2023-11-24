let textCreated = false;
createBlock()
function createBlock() {
    document.addEventListener("DOMContentLoaded", () => {
        const container = document.querySelector("#login-block");
        container.style.animation = "expand-container 2s forwards";
        container.addEventListener("animationend", function () {
            animateText(container);
        });
    })
}

function addFields(container) {
    container.addEventListener("animationend", function() {
        if (!textCreated) {
            container.appendChild(createHeader());
            container.appendChild(createForm())
            textCreated = true;
        }

    });
}function createHeader(){
    const header = document.createElement("h1");
    header.textContent = "Вход";
    header.classList.add("container_header");
    header.style.animation = "appearance 1s forwards";
    return header
}
function createForm(){
    const form = document.createElement("form")
    form.method = "POST"
    form.action = "/Site_war/user_check"
    form.appendChild(createLogin())
    form.appendChild(createPassword())
    form.appendChild(buttonSubmit())
    return form
}
function createLogin(){
    const input = document.createElement("input")
    input.classList.add("container_input")
    input.placeholder = "Введите логин"
    return input
}
function createPassword(){
    const input = document.createElement("input")
    input.classList.add("container_input")
    input.placeholder = "Введите пароль"
    return input
}
function buttonSubmit(){
    const input = document.createElement('input')
    input.type = "submit"
    input.value = "Войти"
    return input
}
function animateText(container) {
    let text = "Но взял он меч, и взял он щит,\n" +
        "Высоких полон дyм.\n" +
        "В глущобу путь его лежит\n" +
        "Под дерево Тумтум."; // Замените на текст, который вы хотите анимировать

    let index = 0;
    let interval = setInterval(function() {
        container.innerHTML += text.charAt(index);
        index++;
        if (index === text.length) {
            clearInterval(interval);
        }
    }, 100); // Настройте интервал для скорости набора текста
}

