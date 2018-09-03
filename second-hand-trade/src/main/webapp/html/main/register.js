//'use strict'
//
//		$("#write-C").on("click",function(event){
//			event.preventDefault();
//			
//			var form = $("#uploadForm");
//			//파일 개수
//			var files = ${files};
//			console.log(files);
//			var str = "";
//
//			$(files).each(function(index){
//				console.log(index + this.fileUrl);
//				str += "<input type='hidden' name='files[" + index
//				+ "]' value='" + this.fileUrl
//				+ "'> ";
//				var filter ="";
//				if(typeof this.filter == "undefined" || this.filter == null) {
//					filter = " ";
//				}else{
//					filter = this.filter;
//				}
//				
//				str += "<input type='hidden' name='filters' value='" + filter
//				+ "'> ";
//			}); 
//							
//			//첨부파일 추가
//			form.append(str);
////			if(typeof $(':radio[name="categorys"]:checked').val() == "undefined"){
////				alert("카테고리를 선택하세요.");
////				return false;
////			}
//			
//			//카테고리 추가
//			//$("#cateid").val($(':radio[name="categorys"]:checked').val());
//			//위치 추가
//			//$("#location").val($("#address").text());
//			form.attr("action", `${serverApiAddr}/json/post/register/submit`);
//			form.submit(); 
//		});
//		
////
////$('#write-C').click(() => {
////	
////	
////    $.post(`${serverApiAddr}/json/post/register/submit`, {
////    	 	'email': $('#f-title').val(),
////         'name': $('#f-content').val(),
////         'password': $('#fPassword').val()
////    	
////    }, (result) => {
////    	
////    })
////});