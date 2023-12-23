function togglePassword() {
    var passwordField = document.getElementById("passwordField");

    if (passwordField.classList.contains("hidden")) {
        passwordField.classList.remove("hidden");
    } else {
        passwordField.classList.add("hidden");
    }
}

function showChangePasswordForm() {
    var renameForm = document.getElementById("rename_form");
    renameForm.style.display = "block";
}