function animateHead() {
    const head = document.getElementById("text");
    let text = "Добро пожаловать! <br> Если вы впервые на сайте, пожалуйста зарегистрируйтесь!"; // изменение текста для печатания "bye" с новой строки

    let index = 0;
    let interval = setInterval(function() {
        if (text.charAt(index) === "<"){
            index += 2
        }
        container.innerHTML = text.substring(0, index);
        index++;
        if (index > text.length) {
            clearInterval(interval);
            createButtons()
        }
    }, 50); // Настройте интервал для скорости набора текста
}
function createButtons(){
    const singIn = document.createElement("button")
    const singAp = document.createElement("button")
    const block = document.getElementById("btn")
    singIn.classList.add("btn")
    singAp.classList.add("btn")
    singIn.textContent = "Войти"
    singAp.textContent = "Зарегистрироваться"
    block.append(singIn, singAp)
}
document.addEventListener("DOMContentLoaded", () => {
    animateHead();
});



