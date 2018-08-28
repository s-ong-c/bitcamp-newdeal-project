'use strict'

$('#addBtn').click(()=> {
    var files = $('#input_imgs').files;
    var formData = new FormData($("#fileForm")[0]);

    for (var file in files) {
        formData.append('file' + i, files[i]);
    }

    console.log(formData);
    console.log(files);
    
    $.post(`${serverApiAddr}/json/photo/album`, {
        'file' : formData
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