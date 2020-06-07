import {addClass, removeClass} from "./Constants.js";

export default function ImageSlider(images, imgUl, totalPageSpan, presentPageSpan, prevBtn, nextBtn, imgTemplate) {
    this.images = images;
    this.totalPageSpan = totalPageSpan;
    this.presentPageSpan = presentPageSpan;
    this.imgUl = imgUl;
    this.imgTemplate = imgTemplate;
    this.prevBtn = prevBtn;
    this.nextBtn = nextBtn;
    this.MAX_IMG_NUM = 2;

    this.slideImages();
}

ImageSlider.prototype = {
    slideImages  : function () {
        if (this.images.length < this.MAX_IMG_NUM) {
            this.totalPageSpan.innerText = 1;
            this.prevBtn.style.display = "none";
            this.nextBtn.style.display = "none";
        } else {
            for (let i = 1; i < this.images.length && i < this.MAX_IMG_NUM; i++) {
                this.bindImgTemplate(this.images[i].saveFileName);
            }

            this.totalPageSpan.innerText = this.MAX_IMG_NUM;
            this.prevBtn.onclick = () => {
                const newPresent = this.setImageSlide(Number(this.presentPageSpan.innerText) - 1, "right");
                this.presentPageSpan.innerText = newPresent + 1;
            }
            this.nextBtn.onclick = () => {
                const newPresentNum = this.setImageSlide(Number(this.presentPageSpan.innerText) - 1, "left");
                this.presentPageSpan.innerText = newPresentNum + 1;
            }
        }
    },
    bindImgTemplate(saveFileName) {
        const bindingData = {
            saveFileName: saveFileName
        }
        const bindingTemplate = Handlebars.compile(this.imgTemplate);
        this.imgUl.innerHTML += bindingTemplate(bindingData);
    },
    setImageSlide: function (presentNum, direction) {
        const visualImgLi = document.querySelector('.visual_img').children;
        let present = presentNum;
        let prev = 0;
        if (present === 0) {
            prev = 1;
        }
        const prevImg = visualImgLi[prev];
        const presentImg = visualImgLi[present];

        if (direction === "left") {
            prevImg.style.left = "100%";
        } else {
            prevImg.style.left = "-100%";
        }
        presentImg.style.left = "0%";
        addClass(prevImg, `move-${direction}`);
        addClass(presentImg, `move-${direction}`);

        setTimeout(() => {
            if (direction === "left") {
                presentImg.style.left = "-100%";
            } else {
                presentImg.style.left = "100%";
            }
            prevImg.style.left = "0%";
            removeClass(prevImg, `move-${direction}`);
            removeClass(presentImg, `move-${direction}`);
        }, 100);

        return prev;
    }
}