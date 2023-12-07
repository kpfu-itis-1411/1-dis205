document.addEventListener("DOMContentLoaded", () =>{
    menu()
})
function menu() {
    document.getElementById('openButton').addEventListener('click', function () {
        document.getElementById('sidebar').classList.add('open');
    });

    document.getElementById('closeButton').addEventListener('click', function () {
        document.getElementById('sidebar').classList.remove('open');
    });
}