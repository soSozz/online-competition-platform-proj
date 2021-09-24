<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
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


<c:set var="competSmallFileType" value="${competPoster.competSmallPoster[0].compet_file_type}" />
<c:set var="competSmallFileName" value="${competPoster.competSmallPoster[0].compet_file_name}" />
<c:set var="competBigFileType" value="${competPoster.competBigPoster[0].compet_file_type}" />
<c:set var="competBigFileName" value="${competPoster.competBigPoster[0].compet_file_name}" />
<c:set var="compet_id" value="${competInfo.compet_id[0].compet_id}" />


<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대회 안내</title>
<style>

</style>
</head>
<body>
<div class="container justify-content-lg-center">
  <div class="row">
    <div class="col-lg-12">
      <div class = "poster"><a href = "${contextPath}/compet/competInfo.do?compet_id=${compet_id}"><img src="${contextPath}/competFile_download.do?compet_id=${compet_id}&compet_file_name=${competSmallFileName}&compet_file_type=${competSmallFileType}" width=100% height= 200px /></a></div>
    </div>
    <div class="col-lg-12">
      <ul class="nav nav-tabs mb-3 justify-content-lg-center">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="${contextPath}/compet/competInfo.do?compet_id=${compet_id}">대회안내</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#profile1">공지사항</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#contact1">컨텐츠 게시판</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#message1">제출</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="${contextPath}/compet/qna.do">문의</a></li>
	</ul>
    </div>
    <div class="col-lg-12">
      <div class = "competInfo">${competInfo.info[0].compet_text}</div>
	<div><img src="${contextPath}/competFile_download.do?compet_id=${compet_id}&compet_file_name=${competBigFileName}&compet_file_type=${competBigFileType}" width = 100% /></div>
    </div>
</div>
</div>
	
</body>
</html>