<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
   
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
 
    <link href="./plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<div class="dropdown float-right">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   회원관리
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
    <button class="dropdown-item" type="button">10개씩보기</button>
    <button class="dropdown-item" type="button">50개씩보기</button>
    <button class="dropdown-item" type="button">100개씩보기</button>
  </div>
</div>

<div class="card-title">회원 관리</div>
<body>
<table class="table">
    <tr align="center"   bgcolor="#38A3A5"  style="color:white">
      <td><b>No.</b></td>
      <td><b>학번</b></td>
      <td><b>이름</b></td>
      <td><b>단과대학</b></td>
      <td><b>학과(부)</b></td>
      <td><b>학년</b></td>
   </tr>
   
 <c:forEach var="member" items="${membersList}" varStatus="seq" >     
   <tr align="center">
   	  <td>${seq.count }</td>
      <td>${member.mem_stu_id}</td>
      <td>${member.mem_name}</td>
      <td>${member.mem_dept}</td>
      <td>${member.mem_major}</td>
      <td>${member.mem_grade}</td>
 			   
    </tr>
  </c:forEach>   
</table>
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  	<li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>
</body>
</html>