<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link href="${contextPath}/resources/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
 <link href="${contextPath}/resources/css/font.css" rel="stylesheet">
<script src="${contextPath}/resources/plugins/jqueryui/js/jquery-ui.min.js"></script>
<script src="${contextPath}/resources/plugins/moment/moment.min.js"></script>
<script src="${contextPath}/resources/plugins/fullcalendar/js/fullcalendar.min.js"></script>
<script src="${contextPath}/resources/js/plugins-init/fullcalendar-init.js"></script>
<script src="${contextPath}/resources/plugins/common/common.min.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/js/settings.js"></script>
<script src="${contextPath}/resources/js/gleek.js"></script>
<script src="${contextPath}/resources/js/styleSwitcher.js"></script>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8" />
       <title>Insert title here</title>
      
      <script src="${contextPath}/resources/plugins/tables/js/jquery.dataTables.min.js"></script>
      <script src="${contextPath}/resources/plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
      <script src="${contextPath}/resources/plugins/tables/js/datatable-init/datatable-basic.min.js"></script>

      <script src="${contextPath}/resources/plugins/common/common.min.js"></script>
      <script src="${contextPath}/resources/js/custom.min.js"></script>
      <script src="${contextPath}/resources/js/settings.js"></script>
      <script src="${contextPath}/resources/js/gleek.js"></script>
      <script src="${contextPath}/resources/js/styleSwitcher.js"></script>
      


   </head>
 
    <body>
    
    <div class="col-lg-12">
      <ul class="nav nav-tabs mb-3 justify-content-lg-center">
		<li class="nav-item"><a class="nav-link" href="${contextPath}/compet/competInfo.do?compet_id=${compet_id}">대회안내</a></li>
		<li class="nav-item"><a class="nav-link" href="${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}">공지사항</a></li>
		<li class="nav-item"><a class="nav-link" href="#contact1">컨텐츠 게시판</a></li>
		<li class="nav-item"><a class="nav-link" href="#message1">제출</a></li>
		<li class="nav-item"><a class="nav-link" href="${contextPath}/qna/qna.do?compet_id=${compet_id}">문의</a></li>
		
	</ul>
    </div>
    
        <!-- row -->

        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">문의</h4>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered zero-configuration">
                                    <thead>
                                        <tr>
                                            <th>글 번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    <c:choose>
                                        <c:when test="${qnaList==null} ">
                                            <tr height="10">
                                                <td colspan="5">
                                                    <p align="center">
                                                        <b><span style="font-size: 9pt">등록된 글이 없습니다.</span></b>
                                                    </p>
                                                </td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach var="qna" items="${qnaList}" varStatus="articleNum">
                                                <tr align="center">
                                                    <td width="5%">${articleNum.count}</td>
                                                    <td width="25%" align="left" style="padding-left: 30px">
                                                        <c:choose>
                                                            <c:when test="${qna.level > 1 }">
                                                                <c:forEach begin="1" end="${qna.level }" step="1">
                                                                    <span style="padding-left: 25px"></span>
                                                                </c:forEach>
                                                                <span style="font-size: 12px">[답변]</span>
                                                                <a class="cls1" href="${contextPath}/qna/qnaDetail.do?articleNO=${qna.compet_qna_id}">${qna.compet_qna_title}</a>
                                                            </c:when>

                                                            <c:otherwise>
                                                                <a class="cls1" href="${contextPath}/qna/qnaDetail.do?articleNO=${qna.compet_qna_id}">${qna.compet_qna_title }</a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <td width="10%">
                                                        <c:choose>
                                                            <c:when test="${qna.mem_id !=null}">
                                                                ${qna.mem_id } 
                                                            </c:when>
                                                            <c:otherwise> 관리자 </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td width="10%">${qna.compet_qna_date }</td>
                                                    <td width="10%">${qna.compet_qna_view }</td>
                                                </tr>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </table>
                                <!-- 문의 게시판 하단 -->                               
                                    <div
                                        class="qna_write"
                                        style="
                                            float: right;
                                            margin:10px;
                                            
                                        "

                                    >                        
                                    <button type="button" class="btn btn-outline-secondary"  onClick="fn_articleForm('${loginStatus}')">글쓰기</button>                                                                       
                                    </div>                               

                                    </div>
                                </div>                               
                            </div>
                        </div>
                    </div>
                </div>
        
    <script>
    window.onload = () => {
    	document.getElementById("redirect").value =  "${contextPath}/qna/qna.do?compet_id=${compet_id}";
    }
    
	function fn_articleForm(loginStatus){
		
	  if (loginStatus == "member" || loginStatus == "admin"){
	    location.href= "${contextPath}/qna/qnaForm.do?compet_id=${compet_id}";
	  } else {
	    alert("로그인 후 글쓰기가 가능합니다.");
	  }
	}
</script>        

    
    </body>
</html>
