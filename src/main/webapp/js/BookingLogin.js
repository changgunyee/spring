import Email from "./module/Email.js";

document.addEventListener("DOMContentLoaded", () => {
    const emailElement = document.querySelector('#resrv_id');
    const emailWarningElement = emailElement.parentElement.querySelector('.warning_msg');
    const email = new Email(emailElement, emailWarningElement);

    const loginBtn = document.querySelector(".booking_login .login_btn");
    emailElement.addEventListener('input', (e) => {
        if (email.check()) {
            loginBtn.disabled = false;
        } else {
            loginBtn.disabled = true;
        }
    })
})
