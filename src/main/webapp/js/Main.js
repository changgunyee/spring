import Category from "./module/Category.js";

document.addEventListener("DOMContentLoaded", () => {
    const productTemplate = document.querySelector("#product_list_template").innerText;
    const firstUl = document.querySelectorAll('.lst_event_box')[0];
    const secondUl = document.querySelectorAll('.lst_event_box')[1];
    const moreBtn = document.querySelector('.more .btn');
    const totalCountSpan = document.querySelector('.section_event_lst .event_lst_txt span');

    const categoryUl = document.querySelector(".event_tab_lst");
    new Category(categoryUl, moreBtn, renderProduct);

    setPromotionSlide();

    function setPromotionSlide() {
        const itemsParent = document.querySelector('.visual_img');
        const items = itemsParent.children;
        items[0].style.left = "0%";

        let first = true;
        let index = 1;
        setInterval(() => {
            if (index == items.length) {
                index = 0;
            }
            var before = index - 1;
            if (before < 0) {
                before = items.length - 1;
            }
            var before2 = before - 1;
            if (before2 < 0) {
                before2 = items.length - 1;
            }
            if (first) {
                first = false;
                items[before].style.transform = "translateX(-100%)";
            } else {
                items[0].style.left = "100%";
                items[before].style.transform = "translateX(-200%)";
            }
            items[index].style.zIndex = "10";
            items[before].style.zIndex = "10";
            items[before2].style.zIndex = "9";
            items[index].style.transform = "translateX(-100%)";
            items[before2].style.removeProperty("transform");
            index++;
        }, 1000)
    }

    function renderProduct(products, totalCount, start) {
        if (start === 0) {
            secondUl.innerHTML = "";
            firstUl.innerHTML = "";
            totalCountSpan.innerText = `${totalCount}개`;
        }

        const bindingTemplate = Handlebars.compile(productTemplate);
        products.forEach((item, index) => {
            if (index % 2) {
                secondUl.innerHTML += bindingTemplate(item);
            } else {
                firstUl.innerHTML += bindingTemplate(item);
            }
        })
    }
})



