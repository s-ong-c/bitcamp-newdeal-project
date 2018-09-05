'use strict'

//header
//$('header').load(`${serverApiAddr}/html/main/header.html`);

//카테고리 분류 시작
function openBoard(evt, ctgrName){
    var i, aa2, ctgrLinks;
    
    aa2 = document.getElementsByClassName("aa2");
    for (i = 0; i < aa2.length; i++) {
        aa2[i].style.display = "none";
    }
    
    ctgrLinks = document.getElementsByClassName("ctgrLinks");
    for (i = 0; i < ctgrLinks.length; i++) {
        ctgrLinks[i].className = ctgrLinks[i].className.replace(" active", "");
    }
    
    document.getElementById(ctgrName).style.display = "block";
    evt.currentTarget.className += " active";
    
}
document.getElementById("ctgrDefaultOpen").click();
//카테고리 분류 끝

//본문 사진 슬라이드 시작
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active-d", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active-d";
}
//본문 사진 슬라이드 끝

//좋아요 버튼 체인지 start
    $('#heart-pic').click(() => {
        var src = ($('#heart-pic').attr('src') === '../../images/icons/heart-0.png') ? '../../images/icons/heart-1.png' : '../../images/icons/heart-0.png';
        $('#heart-pic').attr('src',src);
    });
//좋아요 버튼 체인지 끝
//메인 보드리스트 시작

//메인 보드리스트 끝
  $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        if (result.status !== 'success') {
            return;
        }
       console.log(result.loginUser.name);
       var name =  $('#login-name').html();
       $('#login-name').html(result.loginUser.name);
  	 $.getJSON(`${serverApiAddr}/json/edit/`+name, (result) => {
			console.log(result);
			
		    if (result.status !== 'success') {
		 
	            return;
	        }
		   $('#f-name').val(result.data.name);
	       $('#f-email').val(result.data.email);
	       $('#f-nickname').val(result.data.nickname);
	       $('#f-website').val(result.data.website);
	       $('#f-tel').val(result.data.phonenumber);
	       $('#f-email').val(result.data.email);
	       $('#f-intro').val(result.data.memo);
    })
  });
    
    $('#login-name').on('click',()=>{
    		console.log('이름')
    		 var name =  $('#login-name').html();
    		console.log()
    		
    		 $.getJSON(`${serverApiAddr}/json/edit/`+name, (result) => {
    			console.log(result);
    			
    		    if (result.status !== 'success') {
    		 
    	            return;
    	        }
    		   	  $('#f-name').val(result.data.name);
   		       $('#f-email').val(result.data.email);
   		       $('#f-nickname').val(result.data.nickname);
   		       $('#f-website').val(result.data.website);
   		       $('#f-tel').val(result.data.phonenumber);
   		       $('#f-email').val(result.data.email);
   		       $('#f-intro').val(result.data.memo);
   		       
   		    location.href=`${serverApiAddr}/html/edit.html`;
    			
    		 })
    })	
    
    
    //로그아웃
$('#logout').on('click',()=>{
	console.log("로그아웃")
    swal({
        title: '정말 로그아웃<br>하겠습니까?',
        type: 'danger',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d335d6',
        confirmButtonText: 'yes'
      }).then((result) =>{
        if (result.value) {
          swal(
            '로그아웃 성공',
            '로그아웃 되었습니다.',
            'success'
          	).then($.getJSON(`${serverApiAddr}/json/main/mainTest`,()=>{
          		console.log("aa")
          		location.href=`${serverApiAddr}/index.html`;
          	}))
          }
      })
})
