'use strict'

$('#addBtn').click(()=> {
    $.post(`${serverApiAddr}/json/board/boardUp`, {
        'writer': $('#fWriter').val(),
        'title': $('#fTitle').val(),
        'content': $('#fContent').val(),
        'photo': $('#fPhoto').val()
    }, (result) => {
        if(result.status == "success"){
            location.href = 'list.html'
        } else {
            alert('게시글 등록 실패!')
            console.log(result.message)
        }
    }, 'json')
    .fail(() => {
        alert('서버 연결 중 오류!');
    });
});

function readURL(input) {
    
    if (input.files && input.files[0]) {
        var reader = new FileReader();
 
        reader.onload = function (e) {
            $('#img').attr('src', e.target.result);
        }
 
        reader.readAsDataURL(input.files[0]);
    }
}
 
$("#fPhoto").change(function(){
    readURL(this);
});