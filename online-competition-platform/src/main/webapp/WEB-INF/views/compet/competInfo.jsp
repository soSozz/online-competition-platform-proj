<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대회 안내</title>
</head>
<body>
	<div class = "poster"><a href = "<%-- ${contextPath}/compet/competInfo.do?compet_id=${competInfo.poster} --%>#"><img src = "/src/webapp/resources/images/imgs/1.jpg"/></a></div>
	
</body>
>>>>>>> branch 'master' of https://github.com/ITHwang/online-competition-platform-proj.git
</html>