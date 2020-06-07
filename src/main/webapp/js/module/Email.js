import {addClass, removeClass} from "./Constants.js";

export default function Email(emailElement, warningElement, activateReserveBtnFunc = () => {
}) {
    this.emailElement = emailElement;
    this.warningElement = warningElement;
    this.inputValue = false;
    this.activateReserveBtnFunc = activateReserveBtnFunc;

    this.registerEvent();
}

Email.prototype = {
    registerEvent: function () {
        this.emailElement.addEventListener('input', (e) => {
            this.inputValue = e.target.value;
            this.activateReserveBtnFunc();
            if (this.check()) {
                addClass(this.warningElement, "warning_msg");
            } else {
                removeClass(this.warningElement, "warning_msg");
            }
        })
    },
    check        : function () {
        if (!(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(this.inputValue))) {
            return false;
        }
        return true;
    }
}

