<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">


	<div class="card">
		<div class="card-body">
			<h4 class="card-title">관리 보드</h4>
			<div class="basic-list-group">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active">통계</a>
					<a href="#" class="list-group-item list-group-item-action">모니터링</a> 
					<a href="#" class="list-group-item list-group-item-action">회원</a>
					<a href="#" class="list-group-item list-group-item-action">컨텐츠</a> 
					<a href="#" class="list-group-item list-group-item-action">카테고리 및 대회</a> 
					<a href="#" class="list-group-item list-group-item-action">배너</a> 
					<a href="#" class="list-group-item list-group-item-action">푸시 알림 및 sms</a> 
					<a href="#" class="list-group-item list-group-item-action">관리자 설정</a> 
				</div>
			</div>
		</div>
	</div>

	<script src="${contextPath }/resources/plugins/common/common.min.js"></script>
    <script src="${contextPath }/resources/js/custom.min.js"></script>
    <script src="${contextPath }/resources/js/settings.js"></script>
    <script src="${contextPath }/resources/js/gleek.js"></script>
    <script src="${contextPath }/resources/js/styleSwitcher.js"></script>