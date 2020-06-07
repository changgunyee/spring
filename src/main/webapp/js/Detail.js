import {API_URL} from "./module/Constants.js";
import More from "./module/More.js";
import Tab from "./module/Tab.js";
import ImageSlider from "./module/ImageSlider.js";

document.addEventListener("DOMContentLoaded", () => {
    const storeDetails = document.querySelector('.store_details');
    const detailOpen = document.querySelector('._open');
    const detailClose = document.querySelector('._close');
    new More(storeDetails, detailOpen, detailClose);


    const infoTabUl = document.querySelector('.info_tab_lst');
    const pathTab = document.querySelector('._path');
    const detailTab = document.querySelector('._detail');
    const detailAreaWrap = document.querySelector('.detail_area_wrap');
    const detailLocation = document.querySelector('.detail_location');
    new Tab(infoTabUl, pathTab, detailTab, detailAreaWrap, detailLocation);


    const totalPageSpan = document.querySelector('.off span');
    const presentPageSpan = document.querySelector('.num');
    const visualImgUl = document.querySelector('.visual_img');
    const visualImgTemplate = document.querySelector('#visual_img_template').innerText;
    const prevButton = document.querySelector('.btn_prev');
    const nextButton = document.querySelector('.btn_nxt');

    const oReq = new XMLHttpRequest();
    oReq.open("GET", `${API_URL}/products/${Number(window.location.search.replace("?id=", ""))}`);
    oReq.send();
    oReq.addEventListener("load", function () {
        const responseJson = JSON.parse(this.responseText);
        new ImageSlider(responseJson.productImages, visualImgUl, totalPageSpan, presentPageSpan, prevButton, nextButton, visualImgTemplate);
    });
})
