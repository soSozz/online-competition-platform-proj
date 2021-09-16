<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
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
<title>Insert title here</title>
</head>
<body>

</body>
</html>