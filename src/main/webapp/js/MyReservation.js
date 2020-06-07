import Popup from "./module/Popup.js";

document.addEventListener("DOMContentLoaded", () => {
    const popupWrapper = document.querySelector(".popup_booking_wrapper");
    const noBtn = popupWrapper.querySelector('.btn_gray');
    const yesBtn = popupWrapper.querySelector('.btn_green');
    const titleSpan = popupWrapper.querySelector('.pop_tit span');
    const dateElement = popupWrapper.querySelector('.pop_tit small');
    const exitBtn = popupWrapper.querySelector('.popup_btn_close');
    const popup = new Popup(popupWrapper, titleSpan, dateElement, yesBtn, noBtn, exitBtn);

    document.querySelectorAll('.booking_cancel .btn_cancel').forEach((e) => {
        e.addEventListener('click', () => {
            const cardElement = e.parentElement.parentElement;
            popup.open(e.dataset.id, cardElement.querySelector('.tit').innerText, cardElement.querySelector('.detail li:nth-child(1) .item_dsc').innerText);
        })
    })
})
