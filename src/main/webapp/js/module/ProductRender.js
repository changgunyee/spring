export default function ProductRender(productTemplate, firstUl, secondUl, totalCountSpan, moreBtn) {
    this.productTemplate = productTemplate;
    this.firstUl = firstUl;
    this.secondUl = secondUl;
    this.totalCountSpan = totalCountSpan;
}

ProductRender.prototype = {
    render: function (products, totalCount, start) {
        if (start === 0) {
            this.secondUl.innerHTML = "";
            this.firstUl.innerHTML = "";
            this.totalCountSpan.innerText = `${totalCount}개`;
        }

        const bindingTemplate = Handlebars.compile(this.productTemplate);
        products.forEach((item, index) => {
            if (index % 2) {
                this.secondUl.innerHTML += bindingTemplate(item);
            } else {
                this.firstUl.innerHTML += bindingTemplate(item);
            }
        })

    },
}