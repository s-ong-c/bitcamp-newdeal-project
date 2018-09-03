'use strict'

$('#addBtn').click(()=> {
    var files = $('#input_imgs').files;
    var formData = new FormData($("#formData")[0]);

    for(var i=0, len=sel_files.length; i<len; i++) {
        formData.append('files', sel_files[i]);
    }
    
    console.log(formData);
    console.log(files);
    console.log(sel_files);
    
    if(sel_files.length < 1) {
        alert("한 개 이상의 파일을 선택해주세요.");
        return;
    } 
    
    $.ajax(`${serverApiAddr}/json/photo/album`, {
        data: formData,
        dataType: 'json',
        processData: false,
        contentType: false,
        method: 'POST',
        success: (result) => {
            location.href='list.html';
        },
        error: () => {
           alert('서버 실행 오류!');
        }
    });
});

var sel_files = [];

$(document).ready(function() {
    $("#input_imgs").on("change", handleImgFileSelect);
});

function fileUploadAction() {
    console.log("fileUploadAction");
    $("#input_imgs").trigger('click');
}

function handleImgFileSelect(e) {
    // 이미지 정보들을 초기화
    sel_files = [];
    $(".imgs_wrap").empty();
    
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);
    
    var index = 0;
    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")){
            return;
        }
        
        sel_files.push(f);
        
        var reader = new FileReader();
        reader.onload = function(e) {
            var html = "<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("+index+")\" id=\"img_id_"+index+"\"><img src=\"" + e.target.result + "\" data-file='"+f.name+"' class='selProductFile' title='Click to remove'></a>";
            $(".imgs_wrap").append(html);
            index++;
        }
        reader.readAsDataURL(f);
    });
}

// 이미지 클릭하면 삭제기능
function deleteImageAction(index) {
    console.log("index : " + index);
    sel_files.splice(index, 1);

    var img_id = "#img_id_" + index;
    $(img_id).remove();
    console.log(sel_files);
}