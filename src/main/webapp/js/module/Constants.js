const API_URL = "http://localhost:8080/api";

const addClass = (element, classString) => {
    element.className = element
        .className
        .split(' ')
        .filter((name) => {
            return name !== classString;
        })
        .concat(classString)
        .join(' ');
}

const removeClass = (element, classString) => {
    element.className = element
        .className
        .split(' ')
        .filter((name) => {
            return name !== classString;
        })
        .join(' ');
}

export {
    addClass, removeClass, API_URL
}