document.addEventListener("DOMContentLoaded", () => {
    sendSupport()

})
function sendSupport(){
    const email_inp = document.querySelector(".support_email_input")
    const message_inp = document.getElementById("support_message_textarea")
    const button = document.querySelector(".support_send")
    button.addEventListener("click", () => {
    fetch("/Semestrovaya_war/support", {
        method: "POST",
        body: JSON.stringify(data(email_inp,message_inp)),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then(() => {
            email_inp.value = ""
            message_inp.value = ""
        })
})
}
function data(email_inp, message_inp) {
    return {
        email: email_inp.value,
        message: message_inp.value
    }
}