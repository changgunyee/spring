export default function ReviewText(reviewWriteAnchor, reviewTextArea, charCountSpan) {
    this.reviewWriteAnchor = reviewWriteAnchor;
    this.reviewTextArea = reviewTextArea;
    this.charCountSpan = charCountSpan;

    this.registerEvents();
}

ReviewText.prototype = {
    registerEvents: function () {
        this.reviewWriteAnchor.addEventListener('click', () => {
            this.reviewWriteAnchor.style.display = "none";
            this.reviewTextArea.focus();
        })

        this.reviewTextArea.addEventListener('blur', (e) => {
            if (!e.target.textLength) {
                this.reviewWriteAnchor.style.display = "block";
            }
        })

        this.reviewTextArea.addEventListener('input', (e) => {
            this.charCountSpan.innerText = e.target.textLength;
        })
    },
    isValid       : function () {
        const textLength = this.reviewTextArea.textLength;
        if (textLength > 4 && textLength < 401) {
            return true;
        }
        return false;
    }
}