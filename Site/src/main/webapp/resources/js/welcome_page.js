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
    setOpacityAnimate();
    animateHead();
    createLogo()
    createPoster()
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
function createDownPoster(){
    const poster = document.querySelector(".background-join")
    setTimeout(function (){
        poster.style.opacity = 1; // Set the opacity to 1 to make the logo appear
    },200)
}
function animateJoinText() {
    const head = document.querySelector(".join-text")
    let text = "Be with us!"
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
            animateButtonJoin()
        }
    }, 100);
}
function animateButtonJoin() {
    const btn = document.querySelector(".join-btn");
    let text = "JOIN"
    let index = 0;
    let interval = setInterval(function() {
        btn.innerHTML = text.substring(0, index);
        index++;
        if (index > text.length) {
            clearInterval(interval);
            createJoinBtn()
        }
    }, 50);
}
function createJoinBtn(){
    const join = document.querySelector(".join-btn")
    join.style.display = "block"
}
function setOpacityAnimate(){
let hasAnimated = false;
window.addEventListener('scroll', function() {
    const aboutText = document.querySelector('.about_text-container');
    const aboutImage = document.querySelector('.about_image-container');
    const sloganImage = document.querySelector('.slogan_container-one');
    const sloganText = document.querySelector('.slogan_container-two');
    const declareText = document.querySelector('.declare_text-container');
    const declareImage = document.querySelector('.declare_image-container');
    const joinText = document.querySelector('.join-text');
    if (isScrolledIntoView(aboutText)) {
        aboutText.classList.add('show');
        aboutImage.classList.add('show');
    }
    if (isScrolledIntoView(sloganText)) {
        sloganText.classList.add('show');
        sloganImage.classList.add('show');
    }
    if (isScrolledIntoView(declareImage)) {
        declareText.classList.add('show');
        declareImage.classList.add('show');
    }
    if (!hasAnimated && isScrolledIntoView(joinText)) {
        setTimeout(function () {
            createDownPoster()
            animateJoinText();
        },400)
        hasAnimated = true;
    }
});
}
function isScrolledIntoView(el) {
    let rect = el.getBoundingClientRect();
    let elemTop = rect.top;
    let elemBottom = rect.bottom;

    // Only completely visible elements return true:
    return elemTop >= 0 && elemBottom - 200<= window.innerHeight;
}



