<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link href="${contextPath}/resources/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet" />
<link href="${contextPath}/resources/css/style.css" rel="stylesheet" />

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
      <h1 style="text-align:center; font-weight: bold;">문의 답변</h1>
    <div class=qna_box style="width: 100%;  padding: 0%; ">
        <form 
          name="articleForm" 
          method="post"   
          action="${contextPath}/qna/addReply.do"  
          enctype="multipart/form-data"
          action="#" 
          style="width: 50%; position: relative; left: 23%; margin: 40px;"
          
          >

            <div class="form-group" >
                <input type="text" class="form-control bg-transparent" value="20210907" readonly placeholder=" 작성자">
            </div>
            <div class="form-group" >
                <input type="text" class="form-control bg-transparent" name="title" placeholder=" 글제목">
            </div>
            <div class="form-group">
                <textarea class="textarea_editor form-control bg-light" rows="15" name="content" placeholder="글내용"></textarea>
            </div>
            <button type="submit" class="btn btn-outline-secondary">답글쓰기</button>
            <button type="button" class="btn btn-outline-secondary">취소</button>
        </form>
        
    </div> 
        
    </body>
</html>
