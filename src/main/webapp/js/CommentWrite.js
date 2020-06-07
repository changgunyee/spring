import Rating from "./module/Rating.js"
import ReviewText from "./module/ReviewText.js";
import ImageUpload from "./module/ReviewImageUpload.js";

document.addEventListener("DOMContentLoaded", () => {
    const ratingDiv = document.querySelector(".rating");
    const rankSpan = document.querySelector('.star_rank');
    const ratingHiddenInput = document.querySelector('input[name="score"]');
    new Rating(ratingDiv, rankSpan, ratingHiddenInput);

    const reviewWriteAnchor = document.querySelector('.review_write_info');
    const reviewTextArea = document.querySelector('.review_textarea');
    const charCountSpan = document.querySelector('.guide_review span');
    const reviewTextObj = new ReviewText(reviewWriteAnchor, reviewTextArea, charCountSpan);

    const reviewImageInput = document.querySelector('#reviewImageFileOpenInput');
    const tbImage = document.querySelector(".item_thumb");
    const deleteBtn = document.querySelector('.lst_thumb .anchor');
    new ImageUpload(reviewImageInput, tbImage, deleteBtn);

    const productIdInput = document.querySelector('input[name="productId"]');
    const reservationInfoIdInput = document.querySelector('input[name="reservationInfoId"]');

    const commentForm = document.querySelector('#comment_write');
    document.querySelector('.bk_btn').addEventListener('click', () => {
        if (reviewTextObj.isValid()) {
            commentForm.submit();
        } else {
            alert("텍스트 글자 수를 맞춰주세요");
        }
    })
})

