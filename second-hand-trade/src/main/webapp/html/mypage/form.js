'use strict'
var selectedMNO = 0;
var valNick = "";
//var {no} = $.parseQuery(location.href);

$(document.body).on('show.detail', (e, name) => {
    
    $.getJSON(`${serverApiAddr}/json/edit3/${name}`, (result) => {
        console.log("리졸트"+result);
        
        if(result.status !== 'success'){
            selectedMNO = 0;
            return;
        }
        selectedMNO = result.data.no;
        //console.log(selectedMNo);
        
        valNick = result.data.nickname;
        
        $('#f-name').val(result.data.name);
        $('#f-nickname').val(result.data.nickname);
        $('#f-email').val(result.data.email);
        $('#f-site').val(result.data.website);
        $('#f-phone').val(result.data.phonenumber);
        $('#f-memo').val(result.data.intro);
        $('#f-sex').val(result.data.sex);
    })
})


$('#update-btn').click(()=>{
    console.log("나와랏"+selectedMNO);
    
    $.post(`${serverApiAddr}/json/edit3/update`, {
        'no': selectedMNO,
        'name': $('#f-name').val(),
        'nickname': $('#f-nickname').val(),
        'email': $('#f-email').val(),
        'website': $('#f-site').val(),
        'phonenumber': $('#f-phone').val(),
        'intro': $('#f-memo').val(),
        'sex': $('#f-sex').val()
    }, (result)=>{
        if(result.status !== 'success') return;
        alert('수정 완료!');
        
        $(document.body).trigger('refresh.list');
        
    }, 'json').fail(()=>{
        alert('서버 요청 중 오류 발생!')
    });
})
/*
var errFlag = false;
$(document).ready(function(){
    $('#update-btn').on('click', function(event){
        event.preventDefault();
        $('.err').each(function(){
            console.log(this.id);
            console.log($(this).css('color'));
        })
    })

}) 

//길이 제한
function lengthCheck(obj, limit) {
   var msg = "이 값이 최대 " + limit + "개의 글자인지 확인하세요.";
   //길이 초과 할 경우 알림 발생, 초과 글자 제거
   if (obj.value.length > limit) {
      alert(msg);
      obj.value = obj.value.substr(0, limit);
      return false;
   }

    return true;
}

function validCheck(obj){
    var chkStr = "";
    var maxLen = 0;
    
    console.log(obj.id);
    
    switch(obj.id){
    
    //사용자이름
    case 'f-nickname':
        maxLen = 30;
        var nick = obj.value;
        console.log(nick);
        var orgNick = valNick;
        console.log(orgNick);
        
        //입력 가능 형식 문자, 숫자, 밑줄, 마침표
        if(nick == null || nick.length ==0){
            //길이가 0이면 에러표시 지우고 리턴
            $('#chkResult').css('color','red');
            $('#chkResult').text('사용자 이름을 입력하시오.');
            return;
            
        }
        //길이체크
        if (!lengthCheck(obj, maxLen)) return;
        
        //원래 이름과 같으면
        if (orgNick == nick) {
            $("#chkResult").css("color", "#999");
            $("#chkResult").text("");
            return;
        }
        
        //체크 정규식 설정
        if (nick.length <= 2) {
            //길이가 2보다 작으면
            chkStr = /^[A-Za-z0-9_]*$/;
        } else {
            //길이가 2보다 크면
            chkStr = /^[A-Za-z0-9_]+[a-zA-Z0-9_\.]+[A-Za-z0-9_]$/;
        }
        
        $.getJSON('${serverApiAddr}/json/edit3/auth/chkNick',{
            'nick':
        }, function(data){
           //data = 0 중복아님, != 0 중복
            if
        });
        
        
        
        
        
    }
    
}

*/