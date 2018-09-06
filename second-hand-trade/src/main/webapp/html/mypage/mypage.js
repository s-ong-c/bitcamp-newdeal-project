'use strict'

var {name} = $.parseQuery(location.href);


/* -------- view ------- */
$.getJSON(`${serverApiAddr}/json/edit3/${name}`, (result) => {
    console.log(result);
    
    if(result.status !== 'success'){
        return;
    }
    
    console.log(result.data.name);
    var name =result.data.name;
    
    $('#name-test').html(`${name}-store`)
    
})

$('#edit-btn').on('click', ()=>{
    var name2 =$('#name-test').html();
    var name3 = name2.substring(0, name2.indexOf("-"));
    console.log(name3);
    
    location.href=`${serverApiAddr}/html/mypage/mypage-edit.html?name=${name3}`;    
    
/*  
    $.getJSON(`${serverApiAddr}/json/edit2/${name3}`, (result) => {
        console.log(result);
        
        if(result.status !== 'success'){
            return;
        }
        
        console.log(result.data.name);
        
        location.href=`${serverApiAddr}/html/mypage/mypage-edit.html`;
        
    })*/
})
