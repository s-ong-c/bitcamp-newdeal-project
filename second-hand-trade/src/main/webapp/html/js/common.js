'use strict'
var serverApiAddr = "http://192.168.0.9:8080/second-hand-trade";


$(() => {
    $('footer').load(`${serverApiAddr}/html/footer.html`);
});

