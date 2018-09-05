"use strict"
var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);


var liTemplateSrc2 = $('#li-template2').text();
var template2 = Handlebars.compile(liTemplateSrc2);

loadList();

let cardbody = $('.post');
let data = null;
let data2 =null;

$('.sideItems').on('click', 'a',(e) => {
	console.log("클릭 모달을 띄우자 ")
    var no = $(e.target).attr('data-no');
	console.log(no);
    $.post(`${serverApiAddr}/json/post/detail`, {
        'postid': no
       
	    }, (result) => {
	    	var html2 = template2(result);
	    	console.log(result.name);
	    	data2 = result;
	    	console.log({list:result});
	    	console.log("aaaaa");
	    	console.log(result.profilephoto);
	    		$('#caption').html(result.caption);
	    		$('#p-content').html(result.content);
	    		$('#p-name').html(result.name);
	    		$("#p-photo").attr("src", "http://faint1122.s3.ap-northeast-2.amazonaws.com/faint1122"+result.profilephoto);
	    		$("#p-url").attr("src", "http://faint1122.s3.ap-northeast-2.amazonaws.com/faint1122"+result.url);
	        console.log(html2)
	        console.log(data)
	        //$('#myModal').html(html2);
	    });
	
});


function loadList() {
    $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        var html = template(result);
        data = result;
       // console.log(html)
        console.log(data)
        $('#card').html(html);
    })
}

