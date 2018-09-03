'use strict'

/*
 * var formState = 'view'; var selectedCardNo = 0;
 * 
 * $(document.body).on('show.detail', (e, no) => { formState = 'view';
 * 
 * $.getJSON(`${serverApiAddr}/json/board/view/${no}`, (result) => {
 * if(result.status !== 'success') {return; selectedCardNo = 0; return; }
 * selectedCardNo = no;
 * 
 * $('#f-title').val(result.data.title); $('#f-writer').val(result.data.writer);
 * $('#f-content').val(result.data.content);
 * $('#f-photo').val(result.data.photo); }) })
 */

var data = null;
var {no, page, size} = $.parseQuery(location.href);

if (no == undefined) { // 입력 폼
    $('.viewform').css('display', 'none');
    $(f-no).removeAttr("readonly");
    
} else { // 상세 보기 폼
    $('.newform').css('display', 'none');

    $.getJSON(serverApiAddr + `/json/board/view/${no}`, 
        function(result) {
            data = result;
            if (data.board == null) {
                alert('게시글이 무효합니다.');
                location.href = "list.html";
                return;
            }
            $(f-no).val(data.board.no);
            $(f-writer).val(data.board.writer);
            $(f-title).val(data.board.title);
            $(f-content).val(data.board.content);
            $(f-photo).val(data.board.photo);
    });
}

 $('#update-btn').click(function() {
     $.post(serverApiAddr + `/json/board/view/{no}`, {
         'writer' : $('#fWriter').val(),
         'title' : $('#fTitle').val(),
         'contnet' : $('#fContent').val()
     }, function(data) {
         if (data.status == 'success') {
             // location.href = `list.html?page=${page}&size=${size}`;
             location.href = 'boardUp.html';
         } else {
             alert('변경 오류입니다!');
             console.log(data.error);
         }
     }, 'json');
 });
 
 $('#list-btn').click(function() {
     if (page) {
         location.href = `list.html?page=${page}&size=${size}`;
     } else {
         location.href = 'list.html';
     }
 });
 
/*
 * $.getJSON(`${serverApiAddr}/json/detailView/${no}`, function(result) { data =
 * result; if (data.board == null) { alert('게시글이 존재하지 않습니다.'); location.href =
 * "list.html"; return; } $('#fWriter').val(data.board.writer);
 * $('#fTitle').val(data.board.title); $('#fContent').val(data.board.content); })
 */


/*
 * $(document.body).on('show.detail', (e, no) => { formState = 'view';
 * 
 * $.getJSON(`${serverApiAddr}/json/board/view/${no}`, (result) => {
 * if(result.status !== 'success') {return; selectedCardNo = 0; return; }
 * selectedCardNo = no;
 * 
 * $('#f-title').val(result.data.title); $('#f-writer').val(result.data.writer);
 * $('#f-content').val(result.data.content); }) .done(function(res) { var $list =
 * $('#store-list'); // 초기화 $list.html('');
 * $("#btn-view-more").addClass("d-none"); // 결과 없으면 종료 if (res.length == 0)
 * return;
 * 
 * $.each(res, function (i, row) { var media = $('<div class="media"></div>');
 * media.append( $('<div class="img mr-3"><img
 * src="/night/uploadfile/storephoto/' + row.store_photo + '"/></div>'), $('<div
 * class="media-body"></div>').append( $('<a class="font-weight-bold"></a>').attr('href',
 * '/night/store/storeInfo?store_id=' + row.store_id).text(row.store_name), $('<div></div>').text(row.store_jibunaddr),
 * $('<div></div>').text(row.store_pnum1 + '-' + row.store_pnum2 + "-" +
 * row.store_pnum3) ) ); var $li = $('<li class="list-group-item"></li>').append(media);
 * $li.appendTo($list); }); $("#btn-view-more").removeClass("d-none"); });
 * return false; });
 */