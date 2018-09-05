'use strict'


var taskListTemplateSrc = $('#taskList-template').text();
var taskListTemplate = Handlebars.compile(taskListTemplateSrc);
//var todayTemplateSrc = $('#today-template').text();
//var todayTemplate = Handlebars.compile(todayTemplateSrc);

loadList();
//todayList();
//$('#todayWork').click((e) => {
//    todayList();
//    $('body div.list-group-item-secondary').removeClass('list-group-item-secondary');
//    $(e.currentTarget).addClass('list-group-item-secondary');
//});


//$('#taskList').on('click', '.sideItems', (e) => {
//    var tno = $(e.currentTarget).attr('data-tno');
//    var title = $(e.currentTarget).attr('data-title');
//    $('body div.list-group-item-secondary').removeClass('list-group-item-secondary');
//    $(e.currentTarget).addClass('list-group-item-secondary');
//    $(document.body).trigger('show.detail', [tno, title]);
//});

//Handlebars.registerHelper('check', function(options){
//    if (this.chk === 'fail') {
//        return 'far fa-check-circle';        
//    } else if (this.chk === 'complete') {
//        return 'fas complete fa-check-circle';
//    } return "fas fa-arrow-circle-right"
//});
"use strict"
var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

loadList();

let cardbody = $('.post');
let data = null;


function loadList() {
    $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        var html = template(result);
        data = result;
       // console.log(html)
        console.log(data)
        $('#card').html(html);
    })
}
/*
function loadList() {
    $.getJSON(`${serverApiAddr}/json/main/mainTest`, (result) => {
        var html = taskListTemplate({list:result});
        $('#taskList').html(html);
    });
    //$('#todayWork').addClass('list-group-item-secondary');
}
*/