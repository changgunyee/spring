import {addClass, API_URL, removeClass} from "./Constants.js";

export default function Category(categoryUl, moreBtn, renderProduct) {
    this.categoryUl = categoryUl;
    this.moreBtn = moreBtn;
    this.renderProduct = renderProduct;
    this.start = 0;
    this.selectedCategoryLi = categoryUl.children[0];

    this.getProducts();
    this.registerEvents();
}

Category.prototype = {
    registerEvents: function () {
        this.categoryUl.addEventListener('click', (e) => {
            this.start = 0;
            if (e.target.tagName === "LI" || e.target.tagName === "SPAN" || e.target.tagName === "A") {
                this.moreBtn.style.display = "";
                removeClass(this.selectedCategoryLi.querySelector('a'), "active");

                if (e.target.tagName === "LI") {
                    this.selectedCategoryLi = e.target;
                } else if (e.target.tagName === "A") {
                    this.selectedCategoryLi = e.target.parentElement;
                } else if (e.target.tagName === "SPAN") {
                    this.selectedCategoryLi = e.target.parentElement.parentElement;
                } else {
                    return undefined;
                }

                addClass(this.selectedCategoryLi.querySelector('a'), "active");
                this.getProducts();
            }
        })
        this.moreBtn.addEventListener('click', (e) => {
            this.getProducts();
        })
    },
    getProducts   : function () {
        const categoryId = this.selectedCategoryLi.dataset.category;
        let url;
        if (categoryId === 0) {
            url = `${API_URL}/products?start=${this.start}`;
        } else {
            url = `${API_URL}/products?categoryId=${categoryId}&start=${this.start}`;
        }

        const oReq = new XMLHttpRequest();
        oReq.open("GET", url);
        oReq.send();
        const categoryObject = this;
        oReq.addEventListener("load", function () {
            const response = JSON.parse(this.responseText);
            categoryObject.renderProduct(response.items, response.totalCount, categoryObject.start);

            categoryObject.start += response.items.length;
            if (categoryObject.start >= response.totalCount) {
                categoryObject.moreBtn.style.display = "none";
            }
        });
    },
}