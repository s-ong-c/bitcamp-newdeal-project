'use strict'

/*var serverApiAddr = "http://localhost:8080/testjangter";

$('section#edit-content').load(`${serverApiAddr}/mypage2/form.html`);*/

$('#edit-menu-list').on('click', 'a', (e) => {
    $('#edit-menu-list a.active')
        .removeClass('active');
    $(e.target).addClass('active');
    
});

$('#edit-profile').click(()=>{
    $.ajax({
        type: 'GET',
        url: 'form.html',
        dataType: 'text',
        error: function(){
            alert('통신 실패!')
        },
        success: function(data){
            $('#edit-content').html(data);
        }
    })
})


$('#edit-pwd').click(()=>{
    $.ajax({
        type: 'GET',
        url: 'form-pwd.html',
        dataType: 'text',
        error: function(){
            alert('통신 실패!')
        },
        success: function(data){
            $('#edit-content').html(data);
        }
        
    })
})

$('#edit-zzim').click(()=>{
    $.ajax({
        type: 'GET',
        url: 'edit-zzim.html',
        dataType: 'text',
        error: function(){
            alert('통신 실패!')
        },
        success: function(data){
            $('#edit-content').html(data);
        }
    })
})


loadList();

function loadList(){
    $('#edit-menu-list a:first-child').click();
}
