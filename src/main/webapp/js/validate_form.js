function validateForm() {
    // Получаем значения полей формы
    var name = document.getElementById('name').value.trim();
    var surname = document.getElementById('surname').value.trim();
    var email = document.getElementById('email').value.trim();
    var password = document.getElementById('password').value.trim();

    // Регулярные выражения для проверки
    var nameRegex = /^[A-Z][a-z]+$/;
    var emailRegex = /^[A-Za-z0-9!#$%&'*+-.=?^_`{}½~]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

    // Проверка имени и фамилии
    if (!nameRegex.test(name) || !nameRegex.test(surname)) {
        alert("The first and last name must consist of letters from A to Z (upper or lower case) without spaces!");
        return false;
    }

    // Проверка email
    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address!");
        return false;
    }

    // Проверка длины пароля
    if (password.length < 5) {
        alert("The password must contain at least 5 characters!");
        return false;
    }

    // Проверка успешна
    return true;
}





// const form = document.forms["form"];
// const button = form.elements["button"];
//
// const inputArr = Array.from(form);
// const validInput = [];
//
// inputArr.forEach((el) => {
//     if (el.hasAttribute("data-reg")) {
//         el.setAttribute("is-valid", "0");
//         validInput.push(el);
//     }
// });
//
// form.addEventListener("input", inputHandler);
// button.addEventListener("click", buttonHandler);
//
// function inputHandler({ target }) {
//     if (target.hasAttribute("data-reg")) {
//         inputCheck(target);
//     }
// }
//
// function inputCheck (el) {
//     const inputValue = el.value;
//     const inputReg = el.getAttribute("data-reg");
//     const reg = new RegExp(inputReg);
//     console.log(reg);
//
//     if (reg.test(inputValue)) {
//         el.setAttribute('style', 'border: 1px solid #7de517');
//         el.setAttribute("is-valid", "1");
//         console.log(el.getAttribute("is-valid"));
//     } else {
//         el.setAttribute('style', 'border: 1px solid #e60548');
//         el.setAttribute("is-valid", "0");
//         console.log(el.getAttribute("is-valid"));
//     }
// }
//
// function buttonHandler (el) {
//     const isAllValid = [];
//     validInput.forEach((el) => {
//         isAllValid.push(el.getAttribute("is-valid"));
//     });
//
//     const isValid = isAllValid.reduce((acc, curr) => {
//         return acc && curr;
//     });
//
//     if (!Boolean(Number(isValid))) {
//         el.preventDefault();
//     }
// }