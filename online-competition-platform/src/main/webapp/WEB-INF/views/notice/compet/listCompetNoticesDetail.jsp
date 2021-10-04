<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
    <div class=notice_box style="width: 100%;  padding: 0%; ">
        <form 
          name="articleForm" 
          method="post"   
          action="${contextPath}"  
          enctype="multipart/form-data"
          style="width: 50%; position: relative; left: 23%; margin: 40px;" >
          
           <div class="form-group"  style="width:30%; height:50px ; "  >
                <input type="text" size="20" class="form-control bg-transparent" name="articleNO" value="${compet_Notice.compet_notice_id}" placeholder="글번호"  readonly>
             </div> 
             
              <div  style="width:30%;  position: relative; left: 33%; bottom: 70px;">
                <div class="form-group"  >
                  <input type="text" class="form-control bg-transparent" name="date" value="${article.compet_qna_date }" placeholder="등록일자"  readonly>
                </div>
              </div>   
           
            <div style=" position: relative; bottom: 65px;">
</form>
</div>
</body>
</html>