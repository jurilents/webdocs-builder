@@include('slick.min.js');

$(function () {
    // WEBP format
    function testWebP(callback) {
        var webP = new Image()
        webP.onload = webP.onerror = function () {
            callback(webP.height === 2)
        }
        webP.src = "data:image/webp;base64,UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA";
    }

    console.log('Hello JS!');
});