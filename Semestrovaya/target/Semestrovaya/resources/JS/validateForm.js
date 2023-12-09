
function validate() {
    let password = document.getElementById("password_id");
    let password_repeat = document.getElementById("password_repeat_id");

    if (password.value !== password_repeat.value) {
        let message = document.getElementById('message');
        message.textContent = 'Пароли не совпадают!';
        return false;
    }
    return true;
}


function validatePassword(input) {
    if (input.value.length < 4) {
        input.setCustomValidity("Слишком короткий пароль");
    }
    else {
        input.setCustomValidity("");
    }
}