'use strict'

	
  $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        if (result.status !== 'success') {
            return;
        }
       console.log(result.loginUser.name);
       $('#login-name').html(result.loginUser.name);
    })
