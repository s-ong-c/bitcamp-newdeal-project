'use strict'
var serverApiAddr = "http://localhost:8080/second-hand-trade";



$(() => {
	console.log('111');
	$('footer').load(`${serverApiAddr}/html/footer.html`)
});