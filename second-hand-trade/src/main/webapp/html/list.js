"use strict"

var trTemplateSrc = $('#tr-template-src').text();
var trTemplateFn = Handlebars.compile(trTemplateSrc);

var {page, size} = $.parseQuery(location.href);

let tbody = $('#eListTable > tbody'); 
let data = null;

if (page != undefined && size != undefined) {
    loadList(page, size);
} else {
    loadList(1, 15);
}

$(ePrevBtn).click(function() {
    loadList(data.page - 1, data.size);
});

$(eNextBtn).click(function() {
    loadList(data.page + 1, data.size);
});

function loadList(page, size) {
    $.getJSON(serverApiAddr + '/json/board/list', // ../..을 못써서 serverApiAddr롤 분리시킴 
        {
            page: page,
            size: size
        }, function() {
            console.log("로딩 성공!")
            console.log(page)
            console.log(size)
        })
     .done(function(result) {
       data = result;

       var trListHTML = trTemplateFn({list: data.list});
       tbody.html(trListHTML);
       
       $(ePageNo).html(data.page);
       if (data.page <= 1)
           $(ePrevBtn).attr('disabled', '');
       else 
           $(ePrevBtn).removeAttr('disabled');
       
       if (data.page >= data.totalPage)
           $(eNextBtn).attr('disabled', '');
       else
             $(eNextBtn).removeAttr('disabled');
    });
}

tbody.on('click', 'a.viewLink', function(event) {
    event.preventDefault();
    var no = $(event.target).attr('data-id');
    console.log(no);
    console.log('=====')
    location.href = `view.html?no=${no}&page=${data.page}&size=${data.size}`;
});