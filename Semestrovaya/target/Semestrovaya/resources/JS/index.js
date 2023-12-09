getDate()
function getDate() {
    const btn = document.querySelector('.btn_registr')
    btn.addEventListener("click",()=>{
        let dateCont = document.querySelector('.date_container');
        dateCont.style.display="block"
    })
    }