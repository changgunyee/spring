import {addClass, removeClass} from "./Constants.js";

export default function Rating(ratingDiv, rankSpan, ratingHiddenInput) {
    this.ratingDiv = ratingDiv;
    this.rankSpan = rankSpan;
    this.ratingHiddenInput = ratingHiddenInput

    this.registerEvents();
}

Rating.prototype = {
    registerEvents() {
        this.ratingDiv.addEventListener('click', (e) => {
            if (e.target.tagName !== "INPUT") {
                return this;
            }

            const ratingCount = Number(e.target.getAttribute('value'));
            this.ratingDiv.querySelectorAll(".rating_rdo").forEach((cur, idx) => {
                if (idx < ratingCount) {
                    addClass(cur, "checked");
                } else {
                    removeClass(cur, "checked");
                }
            })
            if (ratingCount === 0) {
                addClass(this.rankSpan, "gray_star");
            } else {
                removeClass(this.rankSpan, "gray_star");
            }
            this.ratingHiddenInput.value = ratingCount;
            this.rankSpan.innerText = ratingCount;
        })
    }
}