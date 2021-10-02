<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container p-5 my-5 border">
  		<img src="${contextPath }/bannerFile_download.do?banner_file_name=banner1.jpg&banner_file_type=img&banner_id=1" alt="ss" align="middle" style="margin-left: auto; margin-right: auto; display: block;">

	</div>

	<div class="container p-5 my-5 bg-dark text-white">
  		<img src="${contextPath }/bannerFile_download.do?banner_file_name=banner2.jpg&banner_file_type=img&banner_id=2" alt="ss" align="middle" style="margin-left: auto; margin-right: auto; display: block;">
  		
	</div>

	<div class="container p-5 my-5 bg-primary text-white">
  		<img src="${contextPath }/bannerFile_download.do?banner_file_name=banner3.png&banner_file_type=img&banner_id=3" alt="ss" align="middle" style="margin-left: auto; margin-right: auto; display: block;">
  		
	</div>



	<img src="${contextPath }/bannerFile_download.do?banner_file_name=banner1.jpg&banner_file_type=img&banner_id=1" alt="ss" align="middle" style="margin-left: auto; margin-right: auto; display: block;">
	<img src="${contextPath }/bannerFile_download.do?banner_file_name=banner2.jpg&banner_file_type=img&banner_id=2" alt="ss" align="middle" style="margin-left: auto; margin-right: auto; display: block;">
	<img src="${contextPath }/bannerFile_download.do?banner_file_name=banner3.png&banner_file_type=img&banner_id=3" alt="ss" align="middle" style="margin-left: auto; margin-right: auto; display: block;">
</body>
</html>