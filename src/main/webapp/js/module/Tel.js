import {addClass, removeClass} from "./Constants.js";

export default function Tel(telElement, warningElement, activateReserveBtnFunc) {
    this.telElement = telElement;
    this.warningElement = warningElement;
    this.inputValue = false;
    this.activateReserveBtnFunc = activateReserveBtnFunc;

    this.registerEvent();
}

Tel.prototype = {
    registerEvent: function () {
        this.telElement.addEventListener('input', (e) => {
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
        if (!(/^01\d-\d{3,4}-\d{4}$/.test(this.inputValue))) {
            return false;
        }
        return true;
    }
}
