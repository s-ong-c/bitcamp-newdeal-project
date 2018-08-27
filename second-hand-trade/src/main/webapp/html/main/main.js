'use strict'

	
  $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        if (result.status !== 'success') {
            return;
        }
       
        
        console.log(result.data.name);
        console.log("")
        $('#f-name').val(result.data.name);
        $('#f-mobile-tel').val(result.data.mobileTel);
        $('#f-tel').val(result.data.tel);
        $('#f-fax').val(result.data.fax);
        $('#f-email').val(result.data.email);
        $('#f-memo').val(result.data.memo);
    })
