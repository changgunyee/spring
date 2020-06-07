import {addClass, removeClass} from "./Constants.js";

export default function More(container, openBtn, closeBtn) {
    this.container = container;
    this.openBtn = openBtn;
    this.closeBtn = closeBtn;

    this.registerEvents();
}

More.prototype = {
    registerEvents: function () {
        this.openBtn.addEventListener('click', () => {
            this.closeBtn.style.removeProperty("display");
            this.openBtn.style.display = "none";
            removeClass(this.container, "close3");
        })
        this.closeBtn.onclick = () => {
            this.openBtn.style.removeProperty("display");
            this.closeBtn.style.display = "none";
            addClass(this.container, "close3");
        }
    }
}
