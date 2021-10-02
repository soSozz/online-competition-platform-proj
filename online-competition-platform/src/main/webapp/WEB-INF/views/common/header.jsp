<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<% request.setCharacterEncoding("utf-8"); %>

<script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc"
	crossorigin="anonymous"></script>
<link href="${contextPath}/resources/css/header.css" rel="stylesheet">

<!--Header-->
<div class="row">
	<nav class="navbar navbar-expand-lg navbar-light col-lg-12">
		<div class="col-lg-7">
			<div class="row">
				<a href="${contextPath }/main/main.do" class="m-3"><img class="logo__icon"
						src="${contextPath }/resources/images/ocp/logo/icon.png" alt="brand logo"></a>
				<button class="navbar-toggler " type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon btn-sm"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto ml-3 ">
						<li class="nav-item">
							<a class="nav-link fw-bold bold"
								href="${contextPath }/compet/competList.do?categ_name=전체보기">대회</a>
						</li>
						<li class="nav-item">
							<a class="nav-link fw-bold bold"
								href="#">공지사항</a>
						</li>
						<li class="nav-item">
							<a class="nav-link fw-bold bold"
								href="#">사이트
								소개</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="col-lg-5">
			<div class="row align-items-center">
				<div class="col-lg-6">
					<form class="d-flex justify-content-between align-items-center">
						<div class="mr-2" style="font-size: 2em; color: green;">
							<i class="fas fa-search"></i>
						</div>
						<input class="mr-2 form-control btn-sm rounded-pill " type="search"
							placeholder="검색어를 입력해주세요" aria-label="Search">
						<button class="btn btn-outline-success btn-sm " type="submit">검색</button>
					</form>
				</div>
				<div class="col-lg-6">
					<c:choose>
						<c:when test="${loginStatus == 'member'}">
							<div class="mb-lg-2 row justify-content-center align-items-center ">
								<div class="mr-lg-1">
									<i class="fas fa-user" style="font-size: 2em; color: black;"></i>
								</div>
								<div><span class="bold">${loginInfo.mem_nickname}</span> 님 안녕하세요!</div>
							</div>
							<div class="row justify-content-center align-items-center">
								<div class="mr-lg-2"><a href="#"><i class="fas fa-bell"
											style="color:#57CC99; font-size: 2em;"></i></a>
								</div>
								<div>
									<a href="${contextPath }/member/logout.do"><button type="button"
											class="btn btn-light btn-sm">로그아웃</button></a>
								</div>
								<div>
									<a href="#"><button type="button"
											class="btn btn-light btn-sm">마이페이지</button></a>
								</div>
							</div>
						</c:when>
						<c:when test="${loginStatus == 'admin'}">

							<div class="mb-lg-2 row justify-content-center align-items-center ">
								<div class="mr-lg-1">
									<i class="fas fa-user-cog" style="font-size: 2em; color: black;"></i>
								</div>
								<div><span class="bold">${loginInfo.admin_name}</span> 님 안녕하세요!</div>
							</div>
							<div class="row justify-content-center">
								<div>
									<a href="${contextPath }/member/logout.do"><button type="button"
											class="btn btn-light btn-sm">로그아웃</button></a>
								</div>
								<div>
									<a href="${contextPath }/admin/stat/adminStat.do"><button type="button"
											class="btn btn-light btn-sm">관리</button></a>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="bootstrap-modal">
								<!-- Sign Out-->
								<div class="login row justify-content-center">
									<button type="button" class="btn btn-light btn-lg"
										data-toggle="modal" data-target="#ModalCenter">로그인</button>
								</div>
								<!-- Modal -->
								<div class="modal fade" id="ModalCenter">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="text-center">
												<img class="w-50"
													src="${contextPath }/resources/images/ocp/logo/icon.png"
													alt="" />
											</div>
											<div class="modal-body">
												<form class="mt-5 mb-5 login-input">
													<div class="form-group">
														<input type="email" class="form-control"
															placeholder="아이디" id="id" />
													</div>
													<div class="form-group">
														<input type="password" class="form-control"
															placeholder="비밀번호" id="pwd" />
													</div>
													<div class="row justify-content-center">
														<button type="button"
															class="btn btn-success col-lg-3 mr-3"
															onclick="login_submit()">
															<b>로그인</b>
														</button>
														<button type="button"
															class="btn btn-secondary col-lg-3"
															data-dismiss="modal">
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
				</div>
			</div>
		</div>
	</nav>
</div>
<hr style="position:relative; bottom:15px;">

<!-- 로그인 성공 시 태그 값에 있는 요청 url로 이동 -->
<input id="redirect" type="text" value="${contextPath}/main/main.do" hidden/>

<!-- 자바스크립트 -->
<script>
	function login_submit() {
		//input 태그에 입력된 아이디와 비밀번호 값 가져오기
		const id = document.getElementById("id").value;
		const pwd = document.getElementById("pwd").value;
		const url = document.getElementById("redirect").value;

		//ajax 요청 객체 생성
		const xhr = new XMLHttpRequest();

		//서버에게 비동기 응답을 받았을 때 발생하는 이벤트 함수 정의
		xhr.onreadystatechange = function () {
			if (xhr.readyState === xhr.DONE && xhr.status === 200) { //정상 응답 시
				if (xhr.responseText === 'true') { //로그인 되었으면 메인페이지로 이동
					location.href = url;
				} else { // 로그인에 실패했으면 알림창 이후 초기화
					alert("아이디 혹은 비밀번호가 일치하지 않습니다.");
					document.getElementById("id").value = '';
					document.getElementById("pwd").value = '';
				}
			}
		};

		//요청 방식과 요청 url 설정
		//true: 비동기 설정
		xhr.open('POST', '${contextPath}/member/login.do', true);
		//서버에 요청 보내기
		xhr.send(JSON.stringify({
			"id": id,
			"pwd": pwd
		}))
	}

</script>
    