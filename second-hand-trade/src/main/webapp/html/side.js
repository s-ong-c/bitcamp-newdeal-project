'use strict'

$('#edit2').on('click', (e) => {
	console.log("edit2 클릭");
    $('#edit2')
        .removeClass('_fvhml _etlo6');
    $(e.target).addClass('._fvhml _t0stc');
    
    $('#edit1').removeClass('._fvhml _t0stc');
    		$(e.target).addClass('_fvhml _etlo6');
    	  
});

$('#edit1').on('click', (e) => {
	console.log("edit1 클릭");
    $('#edit1')
        .removeClass('_fvhml _etlo6');
    $(e.target).addClass('._fvhml _t0stc');
    
    $('#edit2').removeClass('._fvhml _t0stc');
    		$(e.target).addClass('_fvhml _etlo6');
});
console.log("aa");
//회원탈퇴
$('#edit3').on('click', (e) => {
	
	swal({
		  title: '정말 탈퇴하겠습니까?',
		  text: "기존 게시글은 삭제가 됩니다.",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonClass: "btn-danger",
		  confirmButtonText: "네 정말 삭제하겠습니다.",
		  cancelButtonText: "아니요",
		  closeOnConfirm: false,
		  closeOnCancel: false
	},
		  function(isConfirm) {
		    if (isConfirm) {
		      swal("삭제완료!!", "기존 회원님에 정보는 삭제되었습니다.", "success");
		    } else {
		      swal("취소!!", "취소 되었습니다. :)", "error");
		    }
		  });

})
   

$('#edit2').on('click', (e) => {
	console.log("비밀번호 변경하러가자")
	  $.ajax({
	        type: 'GET',
	        url: 'pwdChange.html',
	        dataType: 'text',
	        error: function(){
	            alert('통신 실패!')
	        },
	        success: function(data){
	        	 	console.log(data)
	        	 	$('#contants').html('');
	            $('#contants').html(data);
	        }
	        
	    })
})

 
    




