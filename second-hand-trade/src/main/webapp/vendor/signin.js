'use strict'
$('#loginBtn').click(() => {	

    $.post(`${serverApiAddr}/json/auth/signIn`, {
        'email': $('#fEmail').val(),
        'password': $('#fPassword').val(),
        'saveEmail':$('#fSaveEmail').prop('checked')
 
    }, (result) => {
    		console.log(result);
    		console.log(result.status);
    		console.log('왜안될까??/');
    		console.log('왜안될까??/');
    		console.log('왜안될까??/');
    		if(result.status==='success'){
            	location.href='index1.html'
         }else{
            	alert('로그인 실패')
            }

        
    }, 'json')
    .fail(() => {
        alert('로그인 중에 오류 발생!')
    });
});

