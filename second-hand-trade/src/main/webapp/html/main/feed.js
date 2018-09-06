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
	    	console.log(result)
	    	console.log(result.nickname);
	    	console.log(result.profilephoto);
	    		$('#caption').html(result.caption);
	    		$('#p-content').html(result.content);
	    		$('#p-name').html(result.name);
	    		$('#p-nickname').html(result.nickname);
	    		$('.btnContainer').attr('title',result.postid);
	    		$('.replyContainer').attr('title',result.postid);
	    		$('.s2_2_1').attr('title',result.postid);
	    		$('.s2_4_1').attr('title',result.postid);
	    		$("#p-photo").attr("src", "http://faint1122.s3.ap-northeast-2.amazonaws.com/faint1122"+result.profilephoto);
	    		$("#p-url").attr("src", "http://faint1122.s3.ap-northeast-2.amazonaws.com/faint1122"+result.url);
	        console.log(html2)
	        console.log(data)
	        //$('#myModal').html(html2);
	        console.log($('.btnContainer').attr("title"))
	        reply();
            
            //게시물 수정버튼 삽입
            if(result.userid==$('#login-name').attr("title")){
          	  $(".s2_4_1").append("<span style='cursor: pointer; '><i id='postEdit' class='glyphicon glyphicon-option-horizontal'></i></span>")
          	  $(".replyRegist").css("width", "94%");
            }
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


//각 게시물에 댓글리스트 등록 처음 4개 이후 +20개씩('댓글 더보기' 기능이 수행)
function reply(){
	$(".replyContainer").each(function(){
		var moreReply=$(this).children("#moreReply");
		var pid=$('.btnContainer').attr("title"); //게시물 id값 title에 넣어서 이동
		var limit = $(this).data("limit"); //댓글 출력제한자
		var replyContainer = this;
		
		console.log(pid);
		console.log('에러?? 여기서? ')
		$.getJSON(`${serverApiAddr}/json/reply/post/`+ pid, function(rpldata){
			//게시물의 댓글 등록창
			var replyRegist=
				"<div class='_replyRegister' title="+pid+">"
				+"<input type='textarea' onkeypress='registReply(this, event);' class='replyRegist' placeholder='댓글입력'/>"
				+"</div>";
			$(replyContainer).html(replyRegist);
			var userid = $('#login-name').attr("title");
			//전체 댓글 수가 4개 이하 or 제한자*20+4개면 댓글더보기 삭제
		 	if(rpldata.length<=4+5*limit){ //20개씩 더 출력
		 		$(replyContainer).siblings(".moreReply").remove();
			}else if($(replyContainer).siblings(".moreReply")[0]==undefined){
				$(replyContainer).before("<span class='moreReply' data-limit='0'><a href='javascript:;'>댓글더보기</a></span>");
			}
			
			// 게시물에 대한 댓글리스트 + 삭제버튼(해당 유저의 게시글일 경우만)
			var replystr="";
			$(rpldata).each(function(index){
					console.log(this);
				//댓글 최신 4개까지만 우선 출력 및 제한자에 따른 댓글 출력
				if( $(rpldata).length-(4+5*limit) <= index && index < $(rpldata).length ){ //20개씩 더 출력
					replystr +="<li style='list-style:none;margin-left:33px;' title='"+this.id+"'>"+
						"<a href='#"+this.name+"'>" + this.name +"</a>	<span>"+this.comment+"</span>";
					if(this.userid==userid){
						replystr+="<a class='replyDelete' onclick='deleteReply(this);' ><i class='material-icons' style='color:lightgray; font-size:18px;'>X</i></a></li>";
					}else{
						replystr+="</li>";
					};
					
					$(replyContainer).html(replystr+replyRegist);
				}
			});
			
			//댓글더보기 클릭시 제한자 +1 및 댓글 목록 재출력
			$(replyContainer).siblings(".moreReply").children().on("click", function(){
				$(replyContainer).data("limit", limit+1);
				reply();
			})
			//댓글 및 게시물에 태그 검색 필터
//			searchFilter();
		});
	});
}


//댓글등록함수 = 댓글입력창에서 onkeypress로 작동 (태그 객체와 event키값 매개변수로 받음)
function registReply(thisTag, key){
	var enter=key.keyCode||key.which;
	var comment=$(thisTag).val();
	var userid = $('#login-name').attr("title");
	console.log(userid+'현재사용자 번호')
	
	//enter친 순간 앞뒤 공백 제거된 value값의 길이확인 
	if(enter==13 && comment.trim().length>0){
//		var userid=30;
		//var postid=$(thisTag).parent().attr("title");
		var postid=$('.btnContainer').attr("title");
		console.log(postid+'sss')
		$.ajax({
			type:"post",
			url:`${serverApiAddr}/json/reply`,
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType:"text",
			data:JSON.stringify({
				postid:postid,
				userid:userid,
				comment:comment.trim()
			}),
			success:function(result){
				if(result=="SUCCESS"){
					reply();
				};
			}
		});
	}
}

//댓글 삭제함수 = 댓글 삭제버튼에서 사용(태그객체 받음)
function deleteReply(thisTag){
	var rid=$(thisTag).parent().attr("title");
	$.ajax({
		type:"delete",
		url:`${serverApiAddr}/json/reply/`+rid,
		headers:{
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "DELETE"
		},
		dataType:"text",
		success:function(result){
			if(result=="SUCCESS"){
				//리플리스트 초기화 및 게시물의 댓글 피드 재호출
				reply();
			};
		}
	});
}

/*댓글 시 포커싱  */
 //css - 댓글달기 버튼 클릭시 커서 포커스
function replyCursor(thisBtn){
   $(".replyRegist").focus();
}
