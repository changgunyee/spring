import {addClass, removeClass} from "./Constants.js";

export default function TicketBodyController(ticketBody, plusElement, minusElement, activateReserveBtn) {
    this.ticketPrice = Number(ticketBody.querySelector('.price').innerText.replace(",", ""));
    this.ticketBody = ticketBody;
    this.plusElement = plusElement;
    this.minusElement = minusElement;
    this.activateReserveBtn = activateReserveBtn;

    this.registerEvents();
    this.setTotalTicketCount();
}

TicketBodyController.prototype = {
    registerEvents     : function () {
        this.minusElement.addEventListener('click', this.ticketCountHandler.bind(this));
        this.plusElement.addEventListener('click', this.ticketCountHandler.bind(this));
    },
    ticketCountHandler : function (e) {
        const countElement = this.ticketBody.querySelector('.count_control_input');
        let count;
        if (e.target.className.includes("ico_minus3")) {
            count = Number(countElement.getAttribute('value')) - 1;
        } else if (e.target.className.includes("ico_plus3")) {
            count = Number(countElement.getAttribute('value')) + 1;
        }

        if (count === 0) {
            addClass(countElement, 'disabled');
            addClass(this.ticketBody.querySelector('.ico_minus3'), 'disabled');
        } else if (count === 1) {
            removeClass(countElement, 'disabled');
            removeClass(this.ticketBody.querySelector('.ico_minus3'), 'disabled');
        }

        this.ticketBody.querySelector('.count_control_input').setAttribute('value', count);
        this.ticketBody.querySelector('.total_price').innerText = (this.ticketPrice * count).toLocaleString();
        this.setTotalTicketCount();
    },
    setTotalTicketCount: function () {
        const ticketCountArray = document.querySelectorAll('.count_control_input');
        let totalCount = 0;
        for (let i = 0; i < ticketCountArray.length; i++) {
            totalCount += Number(ticketCountArray[i].getAttribute('value'));
        }
        document.querySelector('#totalCount').innerText = totalCount;
        this.activateReserveBtn();
    }
}