'use strict'

	
  $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        if (result.status !== 'success') {
            return;
        }
       console.log(result.loginUser.name);
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
