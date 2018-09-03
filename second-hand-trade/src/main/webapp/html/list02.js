"use strict"

var selectedNo = 0;

var tag1 = document.getElementById( "A_tag1" ); 
      tag1.title = "찜"; 
var tag2 = document.getElementById( "A_tag2" ); 
      tag2.title = "댓글 달기"; 

$.getJSON(serverApiAddr + `/json/board/view/${no}`, (result) => {
        if(data.status !== 'success'){ return ;
            selectedNo = 0;
            return;
        }
        selectedNo = no;
        
        $('#username').val(data.board.writer);
        $('#hour').val(data.board.createdate);
        $('#fContent').val(data.board.content);
        $('#fPhoto').val(data.board.photo);
});