function validateEmail(email) {
    let re = /\S+@\S+\.\S+/;
    return re.test(email);
}

//В JavaScript, пустая строка ("") будет преобразована в false при приведении к булевому типу.
function validatePassword(password, password1) {
    if (password.trim() === "" || password1.trim() === "" || password != password1) {
        return false;
    }
    if (password.length < 6) {
        return false;
    }
    return true;
}


function validatePhone(phone) {
    let re = /(8|(\+7))[0-9]{10}/;
    return re.test(phone);
}

function validate() {
    let password = document.getElementById('pwd').value;
    let password1 = document.getElementById('pwd1').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;

    if (!validatePassword(password, password1)) {
        let d = document.getElementById('error');
        d.innerHTML = '<span style="color:red">Пароли не совпадают или пусты!</span>';
        return false;
    }

    if (!validateEmail(email)) {
        let d = document.getElementById('error');
        d.innerHTML = '<span style="color:red">Неверный формат электронной почты!</span>';
        return false;
    }

    if (!validatePhone(phone)) {
        let d = document.getElementById('error');
        d.innerHTML = '<span style="color:red">Неверный формат телефона!</span>';
        return false;
    }

    return true;
}
