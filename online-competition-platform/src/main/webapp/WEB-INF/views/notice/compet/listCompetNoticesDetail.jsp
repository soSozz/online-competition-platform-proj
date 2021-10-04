<link href="${contextPath}/resources/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/style.css" rel="stylesheet" />

<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기</title>
<style>
     #tr_btn_modify{
       display:none;
     }
   
   </style>
</head>
<body>
<h1 style="text-align:center; font-weight: bold;">문의 게시판</h1>
    <div class=qna_box style="width: 100%;  padding: 0%; ">
        <form 
          name="articleForm" 
          method="post"   
          action="${contextPath}"  
          enctype="multipart/form-data"
          style="width: 50%; position: relative; left: 23%; margin: 40px;" >
         
             <div class="form-group"  style="width:30%; height:50px ; "  >
                <input type="text" size="20" class="form-control bg-transparent" name="noticeCompetDetail" value="${noticeCompetDetail.compet_notice_id }" placeholder="글번호"  readonly>
             </div> 
             
              <div  style="width:30%;  position: relative; left: 33%; bottom: 70px;">
                <div class="form-group"  >
                  <input type="text" class="form-control bg-transparent" name="date" value="${noticeCompetDetail.compet_notice_date }" placeholder="등록일자"  readonly>
                </div>
              </div>   
           
             <!-- 글 작성자 관리자 확인 -->
            <c:if test="${noticeCompetDetail.admin_id !=  0}">
           <div class="form-group"  >
                <input type="text" class="form-control bg-transparent" name="admin_id" value="${noticeCompetDetail.admin_id }" readonly placeholder=" 작성자">
            </div>
            </c:if>
            
            <div class="form-group" >
                <input type="text" class="form-control bg-transparent" name="title"  id="i_title"  value="${noticeCompetDetail.compet_notice_title }" readonly placeholder=" 글제목">
            </div>
            <div class="form-group">
                <textarea class="textarea_editor form-control bg-light" rows="15" name="notice"  id="i_notice" placeholder="글내용"  readonly>${noticeCompetDetail.compet_notice_text }</textarea>
            </div>
            <!-- 수정 반영하기  -->
             <div   id="tr_btn_modify"  align="center"  >           
                <button type="submit" class="btn btn-outline-secondary"  onClick="fn_modify_article(articleForm)">수정반영하기</button>
                <button type="submit" class="btn btn-outline-secondary"  onClick="backToList(articleForm)">취소</button>           
             </div>
             <!-- 수정하기 버튼  -->  
             <div id="tr_btn">                       
                  <c:choose>
	                  <c:when test="${loginInfo != null}">
					  	<c:choose>
							<c:when  test="${loginStatus == 'admin' }"> 
							    <button class="btn btn-outline-secondary" onClick="fn_enable(event)">수정하기</button>                    
								<button  class="btn btn-outline-secondary" onClick="fn_remove_article(${noticeCompetDetail.compet_notice_id})">삭제하기</button>                                                                 
								<button type="button" id="toList"class="btn btn-outline-secondary">목록보기</button>
							</c:when>
						</c:choose>
	                  </c:when>  
	                  <c:otherwise>
	                  	<button type="button" id="toList" class="btn btn-outline-secondary">목록보기</button>
	                  </c:otherwise>
                                                   
             </c:choose>    
                
             
                                           
                    
             </div>
           
           
                   
        </form>
        </div> 
        
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	document.getElementById("toList").addEventListener("click", ()=>{
		location.href="${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}";
	});
	
	 function fn_enable(event){
	 	 event.preventDefault();
	 	document.getElementById("i_title").removeAttribute("readonly");
	 	document.getElementById("i_notice").removeAttribute("readonly");
		 document.getElementById("tr_btn_modify").style.display="block";		 
		 document.getElementById("tr_btn").style.display="none";
	 }
	 </script>
</body>
</html>