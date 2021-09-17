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
						<a href="${contextPath }/main/main.do"><img class="logo__icon" src="${contextPath }/resources/ocp/img/icon.png" alt="brand logo"></a>
					</div>
					<button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon btn-sm"></span>
					</button>
					<class class="collapse navbar-collapse " id="navbarSupportedContent">
						<ul class="navbar-nav me-auto ml-3 ">
							<li class="nav-item">
								<a class="nav-link fw-bold" style="font: small-caps bold 20px/1 sans-serif;" href="${contextPath }/compet/competList.do">대회</a>
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
					  <div class="bootstrap-modal">
					  	<!-- Sign Out-->
						<div class= "login">
							<button type="button" class="btn btn-light btn-sm" data-toggle="modal" data-target="#ModalCenter">Login</button>
						</div>
						<!-- Modal -->
						<div class="modal fade" id="ModalCenter">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="text-center">
										<img class="w-50" src="${contextPath }/resources/images/ocp/logo/icon.png" alt="" />
									</div>
									<div class="modal-body">
										<form class="mt-5 mb-5 login-input">
											<div class="form-group">
												<input type="email" class="form-control" placeholder="아이디" id="id"/>
											</div>
											<div class="form-group">
												<input type="password" class="form-control" placeholder="비밀번호" id="pwd"/>
											</div>
											<div class="row justify-content-center">
												<button type="button" class="btn btn-success col-lg-3 mr-3" onclick="login_submit()" >
													<b>로그인</b>
												</button>
												<button type="button" class="btn btn-secondary col-lg-3" data-dismiss="modal">
													닫기
												</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
        				</div>
					  </c:otherwise>
				   </c:choose>     
					
					<form class="d-flex">
						<input class="form-control me-2 mr-2 btn-sm rounded-pill " type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success btn-sm " type="submit">Search</button>
					</form>
				</div>
			</nav>
				<hr style= "position:relative; bottom:15px;">
		</div>
	</div>

	<!-- 자바스크립트 -->
	<script>
		function login_submit(){
			//input 태그에 입력된 아이디와 비밀번호 값 가져오기
			const id = document.getElementById("id");
			const pwd = document.getElementById("pwd");
			
			//form 태그 하나, input 태그 두 개 만들기
			const formObj = document.createElement("form");
		    const i_id = document.createElement("input");
		    const i_pwd = document.createElement("input");

		    //각 input 태그에 name, value 속성 부여하기
		    i_id.name = "id";
		    i_id.value = id;
		    i_pwd.name = "pwd";
		    i_pwd.value = pwd;
		    
		    //form 태그 안에 두 개의 input 태그 넣고, form 태그를 body 태그 안에 넣기
		    formObj.appendChild(i_id);
		    formObj.appendChild(i_pwd);
		    document.body.appendChild(formObj);

		    formObj.method="post";
		    formObj.action="${contextPath}/member/login.do";
		    formObj.submit()
		}
	</script>
    