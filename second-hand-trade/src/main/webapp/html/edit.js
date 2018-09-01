'use strict'

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



