function validatePassword(input) {
    if (input.value.length < 8) {
        // необходимо вызвать setCustomValidity с сообщением об ошибке
        input.setCustomValidity("Длина пароля должна быть не меньше 8 символов");
    }
    else {
        // очищаем сообщение об ошибке
        input.setCustomValidity("");
    }
}
function validateEmail(input) {
    // Регулярное выражение для проверки формата почты
    var emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

    if (!emailRegex.test(input.value)) {
        input.setCustomValidity("Некорректный формат почты");
    }
    else {
        input.setCustomValidity("");
    }
}
function validateLogin(input) {

    var loginRegex = /^[A-Za-z]+$/;

    if (!loginRegex.test(input.value)) {
        input.setCustomValidity("Логин должен состоять только из английских символов");
    } else {
        input.setCustomValidity("");
    }
}