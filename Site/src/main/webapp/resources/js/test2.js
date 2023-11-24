function animateHead() {
    const head = document.getElementById("text_head");
    let text = "THE WORD OUT"
    head.style.fontFamily = "STHeiti, sans-serif"
    let index = 0;
    let interval = setInterval(function() {
        if (text.charAt(index) === "<"){
            index += 2
        }
        head.innerHTML = text.substring(0, index);
        index++;
        if (index > text.length) {
            clearInterval(interval);
            createField();
        }
    }, 100);
}



function animateText() {
    const message = document.getElementById("text");
    let text = "Welcome to website! <br> " +
    "Share your thoughts and read the opinions of others! <br>" +
    "To use the service, you need to log in!"
    message.style.fontFamily = "Mukta, sans-serif"
    let index = 0;
    let interval = setInterval(function() {
        if (text.charAt(index) === "<"){
            index += 2
        }
        message.innerHTML = text.substring(0, index);
        index++;
        if (index > text.length) {
            clearInterval(interval);
            createSingInBtn()
        }
    }, 20);
}
function animateButtonSingIn() {
    const btn = document.getElementById("sing-in");
    let text = "Sign in"
    let index = 0;
    let interval = setInterval(function() {
        btn.innerHTML = text.substring(0, index);
        index++;
        if (index > text.length) {
            clearInterval(interval);
            createSingUpBtn()
        }
    }, 50);
}
function animateButtonSingUp() {
    const btn = document.getElementById("sing-up");
    let text = "Sign up"
    let index = 0;
    let interval = setInterval(function() {
        btn.innerHTML = text.substring(0, index);
        index++;
        if (index > text.length) {
            clearInterval(interval);
        }
    }, 50);
}
document.addEventListener("DOMContentLoaded", () => {
    animateHead();
    createLogo()
    createPoster()
    changeLanguage()
});

function createField(){
    const field = document.getElementById("container")
    field.style.display = "block"
    animateText();
}
function createSingInBtn(){
    const singIn = document.getElementById("sing-in")
    singIn.style.display = "block"
    animateButtonSingIn(); // Call animateButton before createSingUpBtn
}

function createSingUpBtn(){
    const singUp = document.getElementById("sing-up")
    setTimeout(function (){
        singUp.style.display = "block"
    },200)
    animateButtonSingUp()
}

function createLogo(){
    const logo = document.querySelector(".logo-img")
    setTimeout(function (){
        logo.style.opacity = 1; // Set the opacity to 1 to make the logo appear
    },400)
}
function createPoster(){
    const poster = document.querySelector(".poster-img")
    setTimeout(function (){
        poster.style.opacity = 1; // Set the opacity to 1 to make the logo appear
    },400)
}
function changeLanguage() {
    const changeLanguageButton = document.getElementById('select-language');
    changeLanguageButton.addEventListener('change', handleLanguageChange);

    const textElement = document.getElementById('text');
    const signInButton = document.getElementById('sing-in');
    const signUpButton = document.getElementById('sing-up');
    const support = document.getElementById('support');
    const about = document.getElementById('about');
    const suggestions = document.getElementById('suggestions');

    let currentLanguage = 'en';

    function changeToRussian() {
        textElement.innerText = "Добро пожаловать на сайт!" + "\n" +
            "Делитесь мыслями и читайте мнения других!" + "\n" +
            "Чтобы воспользоваться сервисом, вам необходимо авторизоваться!";
        signInButton.innerText = 'Войти';
        signUpButton.innerText = 'Зарегистрироваться';
        support.innerText = "Поддержка";
        about.innerText = "О нас";
        suggestions.innerText = "Предложения";
        currentLanguage = 'ru';
    }

    function changeToEnglish() {
        textElement.innerText = "Welcome to website!" + "\n" +
            "Share your thoughts and read the opinions of others!" + "\n" +
            "To use the service, you need to log in!";
        signInButton.innerText = 'Sign In';
        signUpButton.innerText = 'Sign Up';
        support.innerText = "Support";
        about.innerText = "About us";
        suggestions.innerText = "suggestions";
        currentLanguage = 'en';
    }
    function handleLanguageChange() {
        if (currentLanguage === 'en') {
            changeToRussian();
        } else {
            changeToEnglish();
        }
    }
// Добавляем обработчик события на кнопку изменения языка
}
