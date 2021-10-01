<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>

<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath }/resources/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
<!-- 구글 폰트 설정: Noto Sans Korean -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link href="${contextPath}/resources/css/font.css" rel="stylesheet">

<!-- 파비콘 -->
<link rel="shortcut icon" href="https://img.icons8.com/metro/40/000000/share.png">

</head>
<body>
	<div class="container-fluid" style="width:80%">
	
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
		
	</div>
    <!--**********************************
        Scripts(대회 상세 페이지들)
    ***********************************-->
<script>
	class competDetail extends HTMLElement {
		constructor() {
			super();
			this.containerBodyInner = this.innerHTML;
			this.innerHTML = "";
		}

		connectedCallback() {
			this.render();
		}

		render() {
			const container = this.createContainer();

			const containerHeader = document.createElement("div");
			containerHeader.id = "container-header";
			const row = this.createRow();
			const nav = this.createNav();
			row.querySelector("div.col-lg-12").appendChild(nav);
			containerHeader.appendChild(row);

			const containerBody = document.createElement("div");
			containerBody.id = "container-body";
			containerBody.innerHTML = this.containerBodyInner;

			container.appendChild(containerHeader);
			container.appendChild(containerBody);
			this.appendChild(container);
		}

		createContainer() {
			const div = document.createElement("div");
			div.classList.add("container", "justify-content-lg-center");
			return div;
		}

		createRow() {
			const div = document.createElement("div");
			div.classList.add("row");

			const div2 = document.createElement("div");
			div2.classList.add("col-lg-12");

			div.appendChild(div2);
			return div;
		}

		createNav() {
			const ul = document.createElement("ul");
			ul.classList.add("nav", "nav-tabs", "mb-3", "justify-content-lg-center");

			const hrefArr = [
				"${contextPath}/compet/competInfo.do?compet_id=${compet_id}",
				"${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}",
				"${contextPath }/contents/listContents.do?compet_id=${compet_id}",
				"javascript:submitContents('${loginStatus}');",
				"${contextPath}/qna/qna.do?compet_id=${compet_id}"
			];
			const innerHTMLArr = ["대회안내", "공지사항", "컨텐츠 게시판", "제출", "문의"];

			for (let i = 0; i < hrefArr.length; i++) {
				const li = document.createElement("li");
				li.classList.add("nav-item");

				const a = document.createElement("a");
				a.classList.add("nav-link");
				a.href = hrefArr[i];
				a.innerHTML = innerHTMLArr[i];

				li.appendChild(a);
				ul.appendChild(li);
			}

			return ul;
		}
	}

	window.customElements.define("compet-detail", competDetail);
</script>
<script>
	function submitContents(loginStatus) {
		if (loginStatus != null && loginStatus != '') {
			if (loginStatus === 'member') {
				location.href = "${contextPath}/contents/contentsForm.do?compet_id=${compet_id}&mem_id=" + "${loginInfo.mem_id}";
			} else {
				alert("회원만 대회 참여가 가능합니다");
			}
		} else {
			alert("로그인 후 대회 참여가 가능합니다");
		}
	
	}
</script>
    
        <!--**********************************
        Scripts
    ***********************************-->
    <script src="${contextPath }/resources/plugins/common/common.min.js"></script>
    <script src="${contextPath }/resources/js/custom.min.js"></script>
    <script src="${contextPath }/resources/js/settings.js"></script>
    <script src="${contextPath }/resources/js/gleek.js"></script>
    <script src="${contextPath }/resources/js/styleSwitcher.js"></script>
    
    <!--**********************************
        Scripts(qna.jsp)
    ***********************************-->
<script src="${contextPath }/resources/plugins/tables/js/jquery.dataTables.min.js"></script>
<script src="${contextPath }/resources/plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
<script src="${contextPath }/resources/plugins/tables/js/datatable-init/datatable-basic.min.js"></script>
    
    <!--**********************************
        Scripts(contentsForm.jsp)
    ***********************************-->
<script src="${contextPath }/resources/plugins/summernote/dist/summernote.min.js"></script>
<script src="${contextPath }/resources/plugins/summernote/dist/summernote-init.js"></script>
      	

</body>      
</html>