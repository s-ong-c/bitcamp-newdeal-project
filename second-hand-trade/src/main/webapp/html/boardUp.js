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
            $('#image_section').attr('src', e.target.result);
        }
 
        reader.readAsDataURL(input.files[0]);
    }
}
 
$("#fPhoto").change(function(){
    readURL(this);
});

/*$('#fPhoto').fileupload({
    url: '../html/board/boardUp',        // 서버에 요청할 URL
    dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
    sequentialUploads: true,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
    singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.   
    done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
      console.log('done()...');
      console.log(data.result);
      setTimeout(() => {
          // for (var filename of data.result.filenames) {...}
          // $.each(배열, 함수(인덱스, 항목) {...})
          //
          $.each(data.result.filenames, function(index, file) {
              $('<img>').attr('src', `../files/${filename}`)
                  .css('height', '60px')
                  .appendTo('#image_section');
          });
      }, 500);
    }
  }); */