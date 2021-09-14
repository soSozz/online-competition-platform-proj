<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %> <%@ taglib
uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
<link href="${contextPath}/resources/css/header.css" rel="stylesheet">

 <!--Header--> 
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-expand-lg navbar-light  ">
				<div class="container-fluid">
					<div class="header__logo">
						<a href="#"><img class="logo__icon" src="${contextPath }/resources/ocp/img/icon.png" alt="brand logo"></a>
					</div>
					<button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon btn-sm"></span>
					</button>
					<class class="collapse navbar-collapse " id="navbarSupportedContent">
						<ul class="navbar-nav me-auto ml-3 ">
							<li class="nav-item">
								<a class="nav-link fw-bold" style="font: small-caps bold 20px/1 sans-serif;" href="#">대회</a>
							</li>
							<li class="nav-item">
								<a class="nav-link fw-bold" style="font: small-caps bold 20px/1 sans-serif;" href="#">공지사항</a>
							</li>
							<li class="nav-item">
								<a class="nav-link fw-bold" style="font: small-caps bold 20px/1 sans-serif;" href="#">사이트 소개</a>
							</li>
						</ul>
					</class>
					
					<!-- 회원, 관리자, 비회원에 맞게 ui 제공 -->	
				   <c:choose>
					  <c:when test="회원 로그인 확인하는 조건문 작성하기">
						<div class="alert"><a href="#"><i class="far fa-bell fa-lg" style="color:#57CC99; "></i></a></div>
						<div class="login">
							<button type="button" class="btn btn-light btn-sm">Logout</button>
						</div>
						<div class="mypage">
							<button type="button" class="btn btn-light btn-sm">Mypage</button>
						</div>
					  </c:when>
					  <c:when test="관리자 로그인 확인하는 조건문 작성하기">

					  </c:when>
					  <c:otherwise>
						<!-- Sign Out-->
						<div class= "login">
							<button type="button" class="btn btn-light btn-sm">Login</button>
						</div>
					  </c:otherwise>
				   </c:choose>     
					
					<form class="d-flex">
						<input class="form-control me-2 mr-2 btn-sm rounded-pill " type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success btn-sm " type="submit">Search</button>
					</form>
				</div>
			</nav>
		</div>
	</div>

    