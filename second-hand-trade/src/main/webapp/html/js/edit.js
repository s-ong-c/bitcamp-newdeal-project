'use strict'
var serverApiAddr = "http://localhost:8080/second-hand-trade";



$(() => {
	$('._28rsa > header').load(`${serverApiAddr}/html/editSide2.html`)
	$('._75z9k > header2').load(`${serverApiAddr}/html/modifyProfilePhoto.html`)
});