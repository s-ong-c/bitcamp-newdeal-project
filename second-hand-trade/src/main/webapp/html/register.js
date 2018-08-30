'use strict'

var contentTemplateSrc = $('#content-template').text();
var contentTemplate = Handlebars.compile(contentTemplateSrc);

$(document.body).on('show.detail', (e, no, title) => {
    $.getJSON(`${location.origin}/json/plan/list/${no}`, (result) => {
        var html = contentTemplate({list:result});
        $('#content').html(html);
        $('#title').html(title);
        
        $('.fa-check-circle').click((e) => {
            var pno = $(e.target).attr('data-pno');
            $.getJSON(`${location.origin}/json/plan/check/${pno}`, (result) => {
                if ($(e.target).attr('class') === 'planIcon fas complete fa-check-circle') {
                    $(e.target).attr('class', 'planIcon far fa-check-circle');
                } else {
                    $(e.target).attr('class', 'planIcon fas complete fa-check-circle');
                }
            });
        })
    });
});