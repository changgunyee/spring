import {addClass, removeClass} from "./Constants.js";

export default function Tab(tabUl, firstTab, secondTab, firstTabDetail, secondTabDetail) {
    this.tabUl = tabUl;
    this.firstTab = firstTab;
    this.secondTab = secondTab;
    this.firstTabDetail = firstTabDetail;
    this.secondTabDetail = secondTabDetail;

    this.registerEvents();
}

Tab.prototype = {
    registerEvents: function () {
        this.tabUl.addEventListener('click', (e) => {
            let target = null;
            if (e.target.tagName === "A") {
                target = e.target.parentElement;
            } else if (e.target.tagName === "LI") {
                target = e.target;
            } else if (e.target.tagName === "SPAN") {
                target = e.target.parentElement.parentElement;
            } else {
                return undefined;
            }

            if (target === this.firstTab) {
                this.activateTab(this.firstTab.querySelector('a'), this.firstTabDetail);
                this.hideTab(this.secondTab.querySelector('a'), this.secondTabDetail);
            } else if (target === this.secondTab) {
                this.activateTab(this.secondTab.querySelector('a'), this.secondTabDetail);
                this.hideTab(this.firstTab.querySelector('a'), this.firstTabDetail);
            }
        })
    },
    activateTab   : function (tabAnchor, tabDetail) {
        addClass(tabAnchor, "active");
        removeClass(tabDetail, "hide");
    },
    hideTab       : function (tabAnchor, tabDetail) {
        removeClass(tabAnchor, "active");
        addClass(tabDetail, "hide");
    }
}