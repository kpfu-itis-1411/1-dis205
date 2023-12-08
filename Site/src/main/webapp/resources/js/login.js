document.addEventListener("DOMContentLoaded", () => {
    remember()
    setRemember()
})
function remember(){
    const rememberBtn = document.getElementById("remember-input")
    const login = document.getElementById("login_id")
    const password = document.getElementById("password_id")
    rememberBtn.addEventListener("change", () => {
        localStorage.setItem("login", login.value)
        localStorage.setItem("password", password.value)
    })
}
function setRemember(){
    const login = document.getElementById("login_id")
    const password = document.getElementById("password_id")
    login.value =  localStorage.getItem("login")
    password.value = localStorage.getItem("password")
}