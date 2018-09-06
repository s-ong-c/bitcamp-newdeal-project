'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);


$('#edit-menu-list').on('click', 'li', (e) => {
    $('#edit-menu-list li.active')
        .removeClass('active');
    $(e.target).addClass('active');
    
});

$('#edit-menu-list').on('click','#edit-profile', (e) =>{
    $('section#edit-content').load(`${serverApiAddr}/html/mypage/form.html`,()=>{
        console.log("헐헐");
        var name = $(e.target).attr('data-name');
        console.log("data네임"+name);
        $(document.body).trigger('show.detail', [name]);
    });
    
})

$('#edit-menu-list').on('click','#edit-pwd', (e) =>{
    $('section#edit-content').load(`${serverApiAddr}/html/mypage/form-pwd.html`, ()=>{
        console.log("비번")
    });
})

$('#edit-menu-list').on('click','#edit-zzim', (e) =>{
    $('section#edit-content').load(`${serverApiAddr}/html/mypage/edit-zzim.html`,()=>{
        console.log("찜")
    });
})

loadList();

$(document.body).on('refresh.list', () => loadList());

function loadList(){
    $.getJSON(`${serverApiAddr}/json/edit3/${name}`, (result) => {
        console.log(result);
        var html = template(result);
        console.log(html)
        $('#edit-menu-list').html(html);
        console.log(html);
        $('#edit-menu-list li:first-child').click();
    })
}