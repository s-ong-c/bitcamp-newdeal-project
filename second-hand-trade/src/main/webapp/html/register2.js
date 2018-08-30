'use strict'


$('#upload').click(()=>{
    $.post(`${serverApiAddr}/json/post/register`, {
        		
	    }, (result) => {
	    	console.log(result);
	    	
	    	if(result.status !='success'){
	    		return ;
	    	}else{
	    		alert('실패');
	    		console.log(result.message)
	    }, 'json')
	    .fail(() => {
	    });
})

});