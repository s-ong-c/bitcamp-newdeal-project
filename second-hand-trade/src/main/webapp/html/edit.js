'use strict'

$(document.body).on('show.detail', (e, no) => {
    $('.form-control').addClass('form-control-plaintext')
        .removeClass('form-control');
    $('.edit-ctrl').css('display', 'none');
    $('.view-ctrl').css('display', '');
    
    formState = 'view';
    
    $.getJSON(`${serverApiAddr}/json/auth/${name}`, (result) => {
        if (result.status !== 'success') {
            selectedCardNo = 0;
            return;
        }
        selectedCardNo = no;
        
        $('#f-name').val(result.data.name);
        $('#f-mobile-tel').val(result.data.mobileTel);
        $('#f-tel').val(result.data.tel);
        $('#f-fax').val(result.data.fax);
        $('#f-email').val(result.data.email);
        $('#f-memo').val(result.data.memo);
    })
})
