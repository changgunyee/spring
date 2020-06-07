import {addClass, API_URL, removeClass} from "./module/Constants.js";
import TicketBodyController from "./module/TicketBodyController.js";
import Agreement from "./module/Agreement.js";
import Tel from "./module/Tel.js";
import Email from "./module/Email.js";

document.addEventListener("DOMContentLoaded", () => {
    const agreementBtnList = document.querySelectorAll('.agreement .btn_agreement');
    const agreementInput = document.querySelector('#chk3');
    const agreement = new Agreement(agreementBtnList, agreementInput, activateReserveBtn);

    const telElement = document.querySelector('#tel');
    const telWarningElement = telElement.parentElement.parentElement.querySelector('.inline_form .warning_msg');
    const tel = new Tel(telElement, telWarningElement, activateReserveBtn);

    const emailElement = document.querySelector('#email');
    const emailWarningElement = emailElement.parentElement.parentElement.querySelector('.inline_form .warning_msg');
    const email = new Email(emailElement, emailWarningElement, activateReserveBtn);

    const bkBtn = document.querySelector('.bk_btn_wrap');
    const totalCountElement = document.querySelector('#totalCount');
    let name = null;
    document.querySelector("#name").addEventListener('input', (e) => {
        name = e.target.value;
        activateReserveBtn();
    })

    document.querySelectorAll('.ticket_body').forEach(ticketBody => {
        const plusElement = ticketBody.querySelector('.ico_plus3');
        const minusElement = ticketBody.querySelector('.ico_minus3');
        new TicketBodyController(ticketBody, plusElement, minusElement, activateReserveBtn);
    });

    const reserveBtn = document.querySelector('.bk_btn_wrap .bk_btn');
    reserveBtn.addEventListener('click', () => {
        reserve(reserveBtn);
    })


    //전역함수 최소화
    function reserve(reserveBtn) {
        const displayInfoId = reserveBtn.dataset.displayInfoId;
        const ticketBodyList = document.querySelectorAll('.ticket_body');
        const prices = [];
        ticketBodyList.forEach((e) => {
            const count = parseInt(e.querySelector('.count_control_input').value);
            if (count) {
                prices.push({
                    "count"         : count,
                    "productPriceId": parseInt(e.dataset.productPriceId),
                })
            }
        })

        const name = document.querySelector('#name').value;
        const email = document.querySelector('#email').value;
        const tel = document.querySelector('#tel').value;
        const yearMonthDay = document.querySelector('.inline_form.last .inline_txt').innerText.split(',')[0];
        const requestBody = {
            displayInfoId          : displayInfoId,
            prices                 : prices,
            productId              : parseInt(reserveBtn.dataset.productId),
            reservationEmail       : email,
            reservationName        : name,
            reservationTelephone   : tel,
            reservationYearMonthDay: yearMonthDay
        }

        const oReq = new XMLHttpRequest();
        oReq.open("POST", `${API_URL}/reservations`);
        oReq.setRequestHeader('Content-Type', "application/json");
        oReq.send(JSON.stringify(requestBody));
        oReq.addEventListener('load', () => {
            window.location.href = `${window.location.origin}/detail?id=${displayInfoId}`;
        })
    }

    function activateReserveBtn() {
        const totalCount = parseInt(totalCountElement.innerText);
        if (email.check() && tel.check() && name && agreement.check() && totalCount) {
            removeClass(bkBtn, "disable");
        } else {
            addClass(bkBtn, "disable");
        }
    }
})

