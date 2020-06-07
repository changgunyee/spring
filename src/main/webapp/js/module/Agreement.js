import {addClass, removeClass} from "./Constants.js";

export default function Agreement(agreementBtnList, agreementInput, activateReserveBtnFunc) {
    this.agreementBtnList = agreementBtnList;
    this.agreementInput = agreementInput;
    this.inputValue = false;
    this.activateReserveBtnFunc = activateReserveBtnFunc;

    this.registerEvent();
}

Agreement.prototype = {
    registerEvent: function () {
        this.agreementBtnList.forEach((e) => {
            e.addEventListener('click', () => {
                const parentElement = e.parentElement;
                if (parentElement.className.includes("open")) {
                    removeClass(parentElement, "open");
                } else {
                    addClass(parentElement, "open");
                }
            })
        })
        this.agreementInput.addEventListener('click', (e) => {
            this.inputValue = e.target.checked;
            this.activateReserveBtnFunc();
        })
    },
    check        : function () {
        if (this.inputValue) {
            return true;
        }
        return false;
    }
}
