'use strict'
$('#loginBtn').click(() => {
	
	   
	   
	   let input = $('.validate-input .input100');
	   console.log(input);
	    var check = false;

	    (function () {
	        check = true;
	        for(var i=0; i<input.length; i++) {
	            if(validate(input[i]) === false){
	                showValidate(input[i]);
	                check=false;
	            }
	        }
	        return check;
	    })();


	    $('.validate-form .input100').each(function(){
	        $(this).focus(function(){
	            hideValidate(this);
	        });
	    });

	    function validate (input) {
	        if($(input).attr('type') === 'email' || $(input).attr('name') === 'email') {
	            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
	                return false;
	            }
	        }
	        else {
	            if($(input).val().trim() === ''){
	                return false;
	            }
	        }
	    }

	    function showValidate(input) {
	        var thisAlert = $(input).parent();
	        $(thisAlert).addClass('alert-validate');
	    }

	    function hideValidate(input) {
	        var thisAlert = $(input).parent();
	        $(thisAlert).removeClass('alert-validate');
	    }

	if (check) {

	
    $.post(`${serverApiAddr}/json/auth/signIn`, {
        'email': $('#fEmail').val(),
        'password': $('#fPassword').val(),
        'saveEmail':$('#fSaveEmail').prop('checked')
    }, (result) => {
        if(result.status==='success'){
        	location.href='html/main/main.html'
        }else{
        	alert('로그인 실패')
        }
        
    }, 'json')
    .fail(() => {
        alert('로그인 중에 오류 발생!')
    });
	}
});


