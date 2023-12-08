document.addEventListener("DOMContentLoaded", () => {
    followBtn()
})
function followBtn(){
    const btn = document.querySelector(".edit-profile-btn")
    const input = document.getElementById("profile-edit-hidden")
    btn.addEventListener("click", () => {
            fetch("/Site_war/follow", {
                method: "POST",
                body: input.value
            }).then(() => console.log("200"))
    })
}


