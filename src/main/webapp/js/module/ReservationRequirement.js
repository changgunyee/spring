import {addClass, removeClass} from "./Constants.js";
import Agreement from "./Agreement.js";
import Tel from "./Tel.js";
import Email from "./Email.js";

export default function ReservationRequirement(bkBtn, totalCountElement) {
    this.bkBtn = bkBtn;
    this.totalCountElement = totalCountElement;

    const agreementBtnList = document.querySelectorAll('.agreement .btn_agreement');
    const agreementInput = document.querySelector('#chk3');
    this.agreement = new Agreement(agreementBtnList, agreementInput, this.activateReserveBtn.bind(this));

    const telElement = document.querySelector('#tel');
    const telWarningElement = telElement.parentElement.parentElement.querySelector('.inline_form .warning_msg');
    this.tel = new Tel(telElement, telWarningElement, this.activateReserveBtn.bind(this));

    const emailElement = document.querySelector('#email');
    const emailWarningElement = emailElement.parentElement.parentElement.querySelector('.inline_form .warning_msg');
    this.email = new Email(emailElement, emailWarningElement, this.activateReserveBtn.bind(this));

    this.name = null;
    document.querySelector("#name").addEventListener('input', (e) => {
        this.name = e.target.value;
        this.activateReserveBtn();
    })
}

ReservationRequirement.prototype = {
    activateReserveBtn: function () {
        const totalCount = parseInt(this.totalCountElement.innerText);
        if (this.email.check() && this.tel.check() && this.name && this.agreement.check() && totalCount) {
            removeClass(this.bkBtn, "disable");
        } else {
            addClass(this.bkBtn, "disable");
        }
    }
}
