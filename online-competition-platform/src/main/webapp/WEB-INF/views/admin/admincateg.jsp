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

<script src="${contextPath}/resources/plugins/common/common.min.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>
    <script src="${contextPath}/resources/js/settings.js"></script>
    <script src="${contextPath}/resources/js/gleek.js"></script>
    <script src="${contextPath}/resources/js/styleSwitcher.js"></script>
    
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
<style>
	.categ{
		font-size:30px; font-weight:bold;
	}
	.categ_add{
		
	}
</style>
</head>
<body>
	<div class="container">
	<h3>카테고리 및 대회</h3>
	<hr/>
	<h5>진행 중인 대회</h5>
	<div class="col-lg-6">
		<div class="card border-primary">
			<div class="card-header"><span class= "categ">알고리즘</span><button class="btn btn-primary float-right">추가하기</button></div>
			<div class="card-body">
				<h5 class="card-title">Primary card title</h5><a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
	</div>
</body>
</html>