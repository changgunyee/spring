import {API_URL} from "./Constants.js";

export default function Popup(container, titleSpan, dateElement, yesBtn, noBtn, exitBtn) {
    this.container = container;
    this.titleSpan = titleSpan;
    this.dateElement = dateElement;
    this.yesBtn = yesBtn;
    this.noBtn = noBtn;
    this.exitBtn = exitBtn;
    this.reservationId = null;

    this.registerEvents();
}

Popup.prototype = {
    open             : function (reservationId, title, date) {
        this.container.style.display = "block";
        this.titleSpan.innerText = title;
        this.dateElement.innerText = date;
        this.reservationId = reservationId;
    },
    close            : function () {
        this.container.style.display = "none";
    },
    registerEvents   : function () {
        this.yesBtn.addEventListener('click', () => {
            this.cancelReservation();
        })
        this.noBtn.addEventListener('click', () => {
            this.close();
        })
        this.exitBtn.addEventListener('click', () => {
            this.close();
        })
    },
    cancelReservation: function () {
        const oReq = new XMLHttpRequest();
        oReq.open("PUT", `${API_URL}/reservations/cancel/${this.reservationId}`);
        oReq.send();
        oReq.addEventListener('load', () => {
            window.location.reload();
        })
    }
}