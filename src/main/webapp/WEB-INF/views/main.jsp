<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Main Page</title>
	<!-- jQuery, bootstrap CDN -->
	<!-- CDN 방식은 URL 이기 때문에 ctrl 키를 누르면 링크가 나온다. -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script> <!-- msie 문제 해결 -->
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<!-- Zebra-Dialog CDN -->
	<script src="resources/js/dialog/zebra_dialog.src.js"></script>
	<link rel="stylesheet" href="resources/css/dialog/zebra_dialog.css" type="text/css"/>
	<!-- ProgressBar -->
	<link rel="stylesheet" href="resources/css/progressbar/progressbarcss.css" type="text/css"/>
</head>
<body>
	<div>
		<p id="intro"><strong style="color:Green; font-size: 40px">* Spring Framework Study</strong></p>
	</div>
	<br>
	<div id="study1">
		<p><strong style="color:Blue; font-size: 20px">1. Model,View - 1</strong></p>
		<label>* EL표기법 : 표현언어로 JSP 2.0에서 새로 추가된 스크립트 언어. 스프링 프레임워크에서 Model값 매핑 시 사용</label>
		<br>
		<label>Study topic : ${modelvalue}</label>
	</div>
	<br>
	<div id="study2">
		<p><strong style="color:Blue; font-size: 20px">2. Model, View - 2</strong></p>
		<input type="hidden" id="value1" value="${value1}">
		<input type="hidden" id="value2" value="${value2}">
		<label>(Console print...)</label>
	</div>
	<br>
	<div id="study3">
		<p><strong style="color:Blue; font-size: 20px">3. @Service, @Repository, @Autowired - 1</strong></p>
		<label>Search name is ${searchname}</label>
	</div>
	<br>
	<div id="study4">
		<p><strong style="color:Blue; font-size: 20px">4. @Service, @Repository, @Autowired - 2</strong></p>
		
	</div>
	<br>
	<div id="study5">
		<p><strong style="color:Blue; font-size: 20px">5. JSTL</strong></p>
		<a href="http://www.oracle.com/technetwork/java/index-jsp-135995.html">(JSTL 오라클 공식 사이트)</a>
		<br><br>
		<c:if test="${value == true}"> <!-- c:if --><!-- test라는 것을 이용해서 jstl 구문이 됨 -->
			<label>value is false</label>
			<br>
			<c:choose>
				<c:when test="${refType.type == 1}">
					<label>Choose type 1</label>
				</c:when>
				<c:when test="${refType.type == 2}">
					<label>Choose type 2</label>
				</c:when>
			</c:choose>
		</c:if>
		<c:if test="${value == false}">
			<label>value is false</label>
		</c:if>
	</div>
	<br>
	<!-- HTML JSTL  -->
<%-- 	<div id="study6">
		<p><strong style="color:Blue; font-size: 20px">6. JSTL, Table tag / 9. Zebra_Dialog, Ajax</strong></p>
		<table border="1">
			<!-- HTML에서 프로그래밍 적용 : JSTL -->
			<c:set var='userlist' value='${listuser}'/> <!-- c:set 은 변수를 선언(셋팅)한다 -->
			<c:if test="${fn:length(userlist) > 0}">
				<thead>
					<tr style="color:green;">
						<th>구분</th>
						<th>이름</th>
						<th>나이</th>
						<th>이미지</th>
						<th>조회</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${listuser}' var='user'>
						<c:set var='i' value='${i+1}'/>
						<tr>
							<td><c:out value='${i}'/></td>
							<td><c:out value='${user.userName}'/></td>
							<td><c:out value='${user.userAge}'/></td>
							<td><img src="./resources/images/${user.userImage}" width="100" height="100"></td>
							<td><button data-pid='${user.userName}'>조회</button></td>
							<td><button data-pid='${user.userName}'>삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if> 
			<c:if test="${fn:length(userlist) == 0}">
				<p id='info_sub1' style='font-size:14px; color:#586069; margin:0px'><b>등록된 사용자가 없습니다.</b></p>
			</c:if>
		</table> --%>
		<div id="study9">
		
		</div>
	</div>
	<br>
	<div id="study7">
		<p><strong style="color:Blue; font-size: 20px">7. @Component</strong></p>
		
	</div>
	<br>
	<div id="study8">
		<p><strong style="color:Blue; font-size: 20px">8. Form tag</strong></p>
		<form method="post" action='http://localhost:8080/controller/samplepage.do'>
			<label> * Name : </label>&nbsp;&nbsp;<input type="text" name="inputname">
			<br>
			<label> * Age : </label>&nbsp;&nbsp;<input type="text" name="inputage">
			<br>
			<p><button type='submit'>페이지 이동</button></p>
		</form>
	</div>
	
	<!-- 파일 업로드 다운로드 UI -->
	<div id="study10">
		<p><strong style="color:Blue; font-size: 20px">10. File Upload</strong></p>
		<div id="filetransdiv">
			<form>
				<label>* 주제:</label>&nbsp<input type="text" id="subject" placeholder="input subject"><br>
				<label>* 내용:</label>&nbsp<textarea class="form-control" rows="5" id="content" placeholder="input content"></textarea><br>
				<label>* 첨부파일 :</label>&nbsp<input type="file" class="btn btn-default form-join" id="uploadfile" multiple="multiple"/><br>
				<!-- 파일 업로드는 페이지 이동이 없기 때문에 action을 지정하지 않는다 -->
				<!-- ajax 방식이지만 파일 업로드는 http 통신의 프로토콜이 다르기 때문에 form 태그를 사용한다 -->
				<!-- multiple : 파일을 여러개 인식하기 위해서 multiple 을 붙여줌-->
			</form>
			<div id="filelist">
			</div>
			<button type="button" class="btn btn-primary" id="btn-enroll">등록</button>
		</div>
	</div>
	
	<br>
	<div id="study11">
		<p><strong style="color:Blue; font-size: 20px">11. Database (MyBatis) </strong></p>
		<div id="conditionfield">
			<label> * 조회 영역 </label>
			<div>
				<label> - 이름 : </label>&nbsp;<input type="text" id="in_name">
				<label> , 나이 : </label>&nbsp;<input type="number" id="in_age">
				<label> , 번호 : </label>&nbsp;<input type="text" id="in_no">
				<br>
				<button type="button" class="btn btn-primary" id="btn-search"> 검색 </button>
			</div>
		</div>
		<br>
		<div id="tablefield">
			<p> tabile field... </p>
		</div>
		<div class="wrap-loading display-none">
			<div><img src="resources/images/ajaxprogress/ajax-loader.gif"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){   // == document.ready(function(){}) 과 비슷함
	// html 이 먼저 만들어지고
	// 자바스크립트가 다 만들어지면
	// 준비상태가 된 것을 알려줌
	$("[data-pid]").on("click", function(){  	// function은 콜백함수 CallBack function
		var selUserName = $(this).data("pid");  // $(this) : 참조한 값을 가져옴
		console.log(selUserName);  				//자바스크립트는 new해서 형에 관계없이 받을 수 있음 
		
		// 수정 선택관련 다이얼로그
		// zebra_dialog 선언식
		var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>['+selUserName+'] 정보를 조회하시겠습니까?</p>',{
			title: 'Blog Test Dialog',
			type : 'question',
			print : false,
			width : 760,
			position : ['rignt - 20', 'top + 20'],
			buttons : ['취소', '조회'],
			onClose : function(caption){
				if(caption == '조회'){
					console.log('조회');
				}else if(caption == '취소'){
					console.log('update cancle');
				}
			}
		})
	});
	
	/* 유저 조회 */
	$('#btn-search').click(function(){
		var in_name = $('#in_name').val();
		var in_age = $('#in_age').val();
		var in_no = $('#in_no').val();
		
		console.log(in_name + ',' + in_age + ',' + in_no);
		
		var trans_object =
			{
				'searchName' : in_name,
				'searchAge'  : in_age,
				'searchNo'   : in_no
			}
		
		var trans_json = JSON.stringify(trans_object);  // json으로 변환
		// json 클래스에 있는 sringify 파일 메소드
		
		//ajax 통신 표준적인 폼
		$.ajax({
			url : "http://localhost:8080/controller/searchuserdb",  //통신할 서버의 주소
			type : 'POST',			// 서버와 어떻게 통신을 할 것인가 (get/post 방식)
			dataType : 'json',		// 서버에 전달할 데이터의 타입, 'json'
			data : trans_json,		// dataType에 따른 실제 데이터
			contentType : 'application/json',	// http 통신을 하는데 필요한 스펙, 명시하지 않아도 되지만, 프로토콜에 명시해주는 것을 권장함 
			mimeType : 'application/json',	 	// http 통신을 하는데 필요한 스펙, 명시하지 않아도 되지만, 프로토콜에 명시해주는 것을 권장함 
			beforeSend: function(){		//ajax success가 떨어지기 전에 수행
				$('.wrap-loading').removeClass('display-none');	//클래스를 제거
			},
			complete : function(){		// ajax success가 완료된 후에 수행
				$('.wrap-loading').addClass('display-none'); // 클래스를 추가
			},
			success : function(retVal){
				var userlist = []; //배열 데이터 저장//
				userlist = retVal.val;
				
				var listcount = userlist.length;
				
				$('#tablefield').empty(); //수정된 테이블을 다시 로드하기 위해서 기존 테이블 영역을 지운다.//
				
				var printHTML = '';
				
				if(listcount > 0){
					printHTML = "<div id='userlist'>";
					printHTML += "<table border='1'>";
			        	printHTML += "<thead>";
			        	printHTML += "<tr>";
			        	printHTML += "<th>구분</th>";
			        	printHTML += "<th>이름</th>";
			        	printHTML += "<th>나이</th>";
			        	printHTML += "<th>이미지</th>";
			        	printHTML += "<th>수정</th>";
			        	printHTML += "<th>제거</th>";
			        	printHTML += "</tr>";
			        	printHTML += "</thead>"; 
			        	printHTML += "<tbody>";
		            
		            //테이블에 들어갈 데이터를 삽입//
		            $.each(userlist, function(index,value) {
		            		printHTML += "<tr>";
			            	printHTML += "<td>"+value.USER_NO+"</td>";
			            	printHTML += "<td>"+value.USER_NAME+"</td>";
			            	printHTML += "<td>"+value.USER_AGE+"</td>";
			            	printHTML += "<td><img src='./resources/images/"+value.USER_IMAGE+"' width='100' height='100'></td>";
			            	printHTML += "<td><button value='"+value.USER_NAME+"' onclick='userinfoupdate(this.value)'>수정</button></td>";
			            	printHTML += "<td><button value='"+value.USER_NAME+"' onclick='userinfodelete(this.value)'>삭제</button></td>";
			            	printHTML += "</tr>";          			  
	       	 		});
		            
		            printHTML += "</tbody>";
		            printHTML += "</table>";
		            printHTML += "</div>";
				} else{
					printHTML = "<div id='userlist'>";
					printHTML += "<p id='info_sub1' style='font-size:14px;color:#586069; margin:0px'><b>조회된 사용자가 없습니다.</b></p>";
					printHTML += "</div>";
				}
				
				$('#tablefield').append(printHTML); //다시 테이블을 보여주기 위해서 HTML코드 적용//
			},
			error : function(retVal, status, er){
				alert("error: " + retVal + "status: " + status + "er: " + er);
			}
		
		
		});
	});
	
	//************************* 파일업로드
	var files = []; //파일이 저장될 배열//
	var filecount = 0;
	$('[data-toggle="tooltip"]').tooltip(); 
	//파일선택 시 발생하는 이벤트 처리(전송할 파일 목록에 등록)//
	$('#uploadfile').change(function(event){
		files[filecount]=event.target.files[0];
		
		var printHTML = "<label>첨부파일("+(filecount+1)+") " + event.target.files[0].name + "</label><br>";
		
		$('#filelist').append(printHTML);
		
		filecount++;
	});
	$('#btn-enroll').click(function(){
		var subjecttext = $('#subject').val();
		var contenttext = $('#content').val();
		var arraycount = files.length;
		
		//파일전송을 위한 FormData설정//
		var formData = new FormData();
		
		formData.append("subject", subjecttext);
		formData.append("content", contenttext);
		
		for(var i=0; i<arraycount; i++){
			formData.append("uploadfile["+i+"]", files[i]);
		}
		
		if(arraycount == 0){
			//수정 선택관련 다이얼로그//
			var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>현재 선택된 파일이 없습니다.</p>',{
				title: 'Blog Test Dialog',
				type: 'warning',
				print: false,
				width: 760,
				position: ['right - 20', 'top + 20'],
				buttons: ['닫기'],
				onClose: function(caption){
	
				}
			});
		} else{
			//ajax call//
			$.ajax({
				type : 'POST',
	    			url : 'http://localhost:8080/controller/enrollajax',
	    			data : formData,
	    			//파일 전송 시 processData, contentType을 null로 설정//
	   		 	processData : false,
	    			contentType : false,
		    		beforeSend:function(){
		                $('.wrap-loading').removeClass('display-none');
		            },
		            complete:function(){
		                $('.wrap-loading').addClass('display-none');
		            },
		    		success : function(retVal) {
		    			alert('enroll success...');
		    			
		    			$('#filelist').empty();
		    			filecount=0;
		    		},
		    		error : function(retVal, status, er) {
		    			alert("error: "+retVal+" status: "+status+" er:"+er);
		    		}
			});	
		}
	});	
});

////////////////////////////update////////////////////////////////////
function userinfoupdate(userName){
	var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>* ['+userName+'] 수정사항</p>'
			+ '- 나이: &nbsp;<input type=text id=updateage></input>'
	,{
		title: 'Blog Test Dialog',
		type: 'question',
		print: false,
		width: 760,
		position: ['right - 20', 'top + 20'],
		buttons: ['닫기', '수정'],
		onClose: function(caption){
			if(caption == '수정'){
				console.log('update userinfo');
				
				var updateAge = $('#updateage').val();
				
				var trans_objeect = 
				{
					'updateName': userName,
					'updateAge' : updateAge
				}
				var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
				
				$.ajax({
					url: "http://localhost:8080/controller/updateuserdb",
					type: 'POST',
					dataType: 'json',
					data: trans_json,
					contentType: 'application/json',
					mimeType: 'application/json',
					beforeSend:function(){
		            		$('.wrap-loading').removeClass('display-none');
		            	},
		            	complete:function(){
		            		$('.wrap-loading').addClass('display-none');
		            	},
					success: function(retVal){
						//alert("success ajax..." + '/' + retVal.val);
						if(retVal.resultCode == 1){
							var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>수정성공</p>',{
								title: 'Blog Test Dialog',
								type: 'confirmation',
								print: false,
								width: 760,
								position: ['right - 20', 'top + 20'],
								buttons: ['닫기'],
								onClose: function(caption){
									
								}
							});
						} else if(retVal.resultCode == 0){
							var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>수정실패</p>',{
								title: 'Blog Test Dialog',
								type: 'warning',
								print: false,
								width: 760,
								position: ['right - 20', 'top + 20'],
								buttons: ['닫기'],
								onClose: function(caption){
									
								}
							});
						}
						
						//console.log(in_name + ',' + in_age + ',' + in_no);
						var trans_objeect = 
						{
							'searchName': '',
							'searchAge' : '',
							'searchNo'  : ''
						}
						var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
						
						$.ajax({
							url: "http://localhost:8080/controller/searchuserdb",
							type: 'POST',
							dataType: 'json',
							data: trans_json,
							contentType: 'application/json',
							mimeType: 'application/json',
							beforeSend:function(){
				            		$('.wrap-loading').removeClass('display-none');
				            	},
				            	complete:function(){
				            		$('.wrap-loading').addClass('display-none');
				            	},
							success: function(retVal){
								//alert("success ajax..." + '/' + retVal.val);
								
								var userlist = []; //배열 데이터 저장//
								userlist = retVal.val;
								
								var listcount = userlist.length;
								
								$('#tablefield').empty(); //수정된 테이블을 다시 로드하기 위해서 기존 테이블 영역을 지운다.//
								
								var printHTML = '';
								
								if(listcount > 0){
									printHTML = "<div id='userlist'>";
									printHTML += "<table border='1'>";
							        	printHTML += "<thead>";
							        	printHTML += "<tr>";
							        	printHTML += "<th>구분</th>";
							        	printHTML += "<th>이름</th>";
							        	printHTML += "<th>나이</th>";
							        	printHTML += "<th>이미지</th>";
							        	printHTML += "<th>수정</th>";
							        	printHTML += "<th>제거</th>";
							        	printHTML += "</tr>";
							        	printHTML += "</thead>"; 
							        	printHTML += "<tbody>";
						            
						            //테이블에 들어갈 데이터를 삽입//
						            $.each(userlist, function(index,value) {
						            		printHTML += "<tr>";
							            	printHTML += "<td>"+value.USER_NO+"</td>";
							            	printHTML += "<td>"+value.USER_NAME+"</td>";
							            	printHTML += "<td>"+value.USER_AGE+"</td>";
							            	printHTML += "<td><img src='./resources/images/"+value.USER_IMAGE+"' width='100' height='100'></td>";
							            	//onclick속성을 이용해서 직접 함수를 호출하고 값으로 현재 button태그에 value값을(pid) 이용한다.//
							            	printHTML += "<td><button value='"+value.USER_NAME+"' onclick='userinfoupdate(this.value)'>수정</button></td>";
							            	printHTML += "<td><button value='"+value.USER_NAME+"' onclick='userinfodelete(this.value)'>삭제</button></td>";
							            	printHTML += "</tr>";          			  
					       	 		});
						            
						            printHTML += "</tbody>";
						            printHTML += "</table>";
						            printHTML += "</div>";
								} else{
									printHTML = "<div id='userlist'>";
									printHTML += "<p id='info_sub1' style='font-size:14px;color:#586069; margin:0px'><b>조회된 사용자가 없습니다.</b></p>";
									printHTML += "</div>";
								}
								
								$('#tablefield').append(printHTML); //다시 테이블을 보여주기 위해서 HTML코드 적용//
							},
							error: function(retVal, status, er){
								alert("error: "+retVal+" status: "+status+" er:"+er);
							}
						});
					},
					error: function(retVal, status, er){
						var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>잘못된 입력값으로 수정실패</p>',{
							title: 'Blog Test Dialog',
							type: 'warning',
							print: false,
							width: 760,
							position: ['right - 20', 'top + 20'],
							buttons: ['닫기'],
							onClose: function(caption){
								
							}
						});
					}
				});
			} else if(caption == '닫기'){
				console.log('close dialog');
			}
		}
	});
}


////////////////////////////delete/////////////////////////
function userinfodelete(userName){
	var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>삭제하시겠습니까?</p>'
	,{
		title: 'Blog Test Dialog',
		type: 'question',
		print: false,
		width: 760,
		position: ['right - 20', 'top + 20'],
		buttons: ['닫기', '삭제'],
		onClose: function(caption){
			if(caption == '삭제'){
				console.log('delete userinfo');
				
				var deleteAge = $('#updateAge').val();
				
				var trans_objeect = 
				{
					'deleteName': userName,
				}
				var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
				
				$.ajax({
					url: "http://localhost:8080/controller/deleteuserdb",
					type: 'POST',
					dataType: 'json',
					data: trans_json,
					contentType: 'application/json',
					mimeType: 'application/json',
					beforeSend:function(){
		            		$('.wrap-loading').removeClass('display-none');
		            	},
		            	complete:function(){
		            		$('.wrap-loading').addClass('display-none');
		            	},
					success: function(retVal){
						//alert("success ajax..." + '/' + retVal.val);
						if(retVal.resultCode == 1){
							var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>삭제성공</p>',{
								title: 'Blog Test Dialog',
								type: 'confirmation',
								print: false,
								width: 760,
								position: ['right - 20', 'top + 20'],
								buttons: ['닫기'],
								onClose: function(caption){
									
								}
							});
						} else if(retVal.resultCode == 0){
							var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>삭제실패</p>',{
								title: 'Blog Test Dialog',
								type: 'warning',
								print: false,
								width: 760,
								position: ['right - 20', 'top + 20'],
								buttons: ['닫기'],
								onClose: function(caption){
									
								}
							});
						}
						
						//console.log(in_name + ',' + in_age + ',' + in_no);
						var trans_objeect = 
						{
							'searchName': '',
							'searchAge' : '',
							'searchNo'  : ''
						}
						var trans_json = JSON.stringify(trans_objeect); //json으로 반환//
						
						$.ajax({
							url: "http://localhost:8080/controller/searchuserdb",
							type: 'POST',
							dataType: 'json',
							data: trans_json,
							contentType: 'application/json',
							mimeType: 'application/json',
							beforeSend:function(){
				            		$('.wrap-loading').removeClass('display-none');
				            	},
				            	complete:function(){
				            		$('.wrap-loading').addClass('display-none');
				            	},
							success: function(retVal){
								//alert("success ajax..." + '/' + retVal.val);
								
								var userlist = []; //배열 데이터 저장//
								userlist = retVal.val;
								
								var listcount = userlist.length;
								
								$('#tablefield').empty(); //수정된 테이블을 다시 로드하기 위해서 기존 테이블 영역을 지운다.//
								
								var printHTML = '';
								
								if(listcount > 0){
									printHTML = "<div id='userlist'>";
									printHTML += "<table border='1'>";
							        	printHTML += "<thead>";
							        	printHTML += "<tr>";
							        	printHTML += "<th>구분</th>";
							        	printHTML += "<th>이름</th>";
							        	printHTML += "<th>나이</th>";
							        	printHTML += "<th>이미지</th>";
							        	printHTML += "<th>수정</th>";
							        	printHTML += "<th>제거</th>";
							        	printHTML += "</tr>";
							        	printHTML += "</thead>"; 
							        	printHTML += "<tbody>";
						            
						            //테이블에 들어갈 데이터를 삽입//
						            $.each(userlist, function(index,value) {

						            	    console.log("userlist : " , userlist);
						            		console.log("index : " , index);
						            		console.log("value : " , value);
						            		
						            		printHTML += "<tr>";
							            	printHTML += "<td>"+value.USER_NO+"</td>";
							            	printHTML += "<td>"+value.USER_NAME+"</td>";
							            	printHTML += "<td>"+value.USER_AGE+"</td>";
							            	printHTML += "<td><img src='./resources/images/"+value.USER_IMAGE+"' width='100' height='100'></td>";
							            	//onclick속성을 이용해서 직접 함수를 호출하고 값으로 현재 button태그에 value값을(pid) 이용한다.//
							            	printHTML += "<td><button value='"+value.USER_NAME+"' onclick='userinfoupdate(this.value)'>수정</button></td>";
							            	printHTML += "<td><button value='"+value.USER_NAME+"' onclick='userinfodelete(this.value)'>삭제</button></td>";
							            	printHTML += "</tr>";          			  
					       	 		});
						            
						            printHTML += "</tbody>";
						            printHTML += "</table>";
						            printHTML += "</div>";
								} else{
									printHTML = "<div id='userlist'>";
									printHTML += "<p id='info_sub1' style='font-size:14px;color:#586069; margin:0px'><b>조회된 사용자가 없습니다.</b></p>";
									printHTML += "</div>";
								}
								
								$('#tablefield').append(printHTML); //다시 테이블을 보여주기 위해서 HTML코드 적용//
							},
							error: function(retVal, status, er){
								alert("error: "+retVal+" status: "+status+" er:"+er);
							}
						});
					},
					error: function(retVal, status, er){
						var infodialog = new $.Zebra_Dialog('<strong>Message:</strong><br><br><p>잘못된 입력값으로 삭제실패</p>',{
							title: 'Blog Test Dialog',
							type: 'warning',
							print: false,
							width: 760,
							position: ['right - 20', 'top + 20'],
							buttons: ['닫기'],
							onClose: function(caption){
								
							}
						});
					}
				});
			} else if(caption == '닫기'){
				console.log('close dialog');
			}
		}
	});
}



</script>
</html>
