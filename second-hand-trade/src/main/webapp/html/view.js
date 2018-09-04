'use strict'

var paramMap = $.parseQuery(location.href)
var selectedBNo = paramMap.no;

var data = null;
var {no, page, size} = $.parseQuery(location.href);

$('.edit-ctrl').css('display', 'none');

if (no == undefined) { // 입력 폼
    $('.viewform').css('display', 'none');
    $('#f-writer').removeAttr("readonly");
    
} else { // 상세 보기 폼
    $('.newform').css('display', 'none');

    $.getJSON(serverApiAddr + `/json/board/view/${no}`, 
        function(result) { 
            data = result; 
            console.log(result); 
            console.log('=====') 
            if (data.board == null) {
                alert('게시글이 무효합니다.'); 
                location.href = "list.html"; 
                return; 
            }
            $('#f-writer').val(data.board.writer); 
            $('#f-title').val(data.board.title);
            $('#f-content').val(data.board.content); 
            $('#f-photo').val(data.board.photo);
    }); 
}

function readURL(input) {
    
    if (input.files && input.files[0]) {
        var reader = new FileReader();
 
        reader.onload = function (e) {
            $('#img').attr('src', e.target.result);
        }
 
        reader.readAsDataURL(input.files[0]);
    }
}
 
$("#f-photo").change(function(){
    readURL(this);
});

$('#list-btn').click(function() {
    if (page) {
        location.href = `list.html?page=${page}&size=${size}`;
    } else {
        location.href = 'list.html';
    }
});

$('#update-btn').click(function(){
    $.post(serverApiAddr + '/json/board/update', 
        {
            no: selectedBNo,
            writer: $('#f-writer').val(),
            title: $('#f-title').val(),
            content: $('#f-content').val(),
            photo: $('#f-photo').val()
        },
        function(data){
            console.log(data)
            if (data.status == 'success') {
                location.href = `list.html?page=${page}&size=${size}`;
            } else {
                alert('변경 오류입니다!')
                console.log(data.error)
            }
        }, 
        'json');
});

$('#delete-btn').click(function() {
    $.getJSON(serverApiAddr + `/json/board/delete?no=${selectedBNo}`, 
        function(data) {
            if (data.status == 'success') {
                location.href = `list.html?page=${page}&size=${size}`;
            } else {
                alert('삭제 오류입니다!');
                console.log(data.error);
            }
    });
});

$('#add-btn').click(function() {
    $.post(serverApiAddr + '/json/board/boardUp', 
        {
            writer: $('#f-writer').val(),
            title: $('#f-title').val(),
            content: $('#f-content').val(),
            photo: $('#f-photo').val()
        },
        function(data) {
            location.href = 'list.html';
        },
        'json');
});