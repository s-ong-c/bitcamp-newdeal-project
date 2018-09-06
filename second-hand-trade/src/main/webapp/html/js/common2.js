'use strict'
var serverApiAddr = "http://192.168.0.9:8080/second-hand-trade";



$(() => {
	console.log('111');
	$('.container > header').load(`${serverApiAddr}/html/header.html`)
	$('.container > footer').load(`${serverApiAddr}/html/footer2.html`)
});