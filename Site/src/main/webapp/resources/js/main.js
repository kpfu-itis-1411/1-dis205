document.addEventListener("DOMContentLoaded", () => {
    const btn = document.querySelector(".submit-btn")
    btn.addEventListener('click', function () {
        const input = document.querySelector(".message-input")
        let message = input.value
        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/Site_war/post', true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function () {
            if (xhr.status === 200) {
                xhr.send(JSON.stringify({message: message}));
            } else {
                console.error('Error sending data: ' + xhr.statusText);
            }
        };
        xhr.send(JSON.stringify({message: message}));
    });
})
