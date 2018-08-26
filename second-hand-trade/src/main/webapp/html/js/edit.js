'use strict'
var serverApiAddr = "http://localhost:8080/second-hand-trade";



$(() => {
	$('._28rsa > header').load(`${serverApiAddr}/html/editSide.html`)
});