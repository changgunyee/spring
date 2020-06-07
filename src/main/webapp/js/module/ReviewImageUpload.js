export default function ReviewImageUpload(reviewImageInput, tbImage, deleteBtn) {
    this.reviewImageInput = reviewImageInput;
    this.tbImage = tbImage;
    this.deleteBtn = deleteBtn;

    this.registerEvents();
}

ReviewImageUpload.prototype = {
    VALID_IMAGE_TYPE: ['image/jpg', 'image/png'],
    registerEvents  : function () {
        this.reviewImageInput.addEventListener('change', (e) => {
            const image = e.target.files[0];
            if (image && !this.VALID_IMAGE_TYPE.includes(image.type)) {
                alert("jpg, png확장자의 사진만 업로드 해주세요");
                return this;
            }

            this.tbImage.src = window.URL.createObjectURL(image);
            this.tbImage.parentElement.style.removeProperty('display');
        })

        this.deleteBtn.addEventListener('click', (e) => {
            this.reviewImageInput.value = "";
            this.tbImage.src = "";
            this.tbImage.parentElement.style.display = "none";
        })
    }
}
