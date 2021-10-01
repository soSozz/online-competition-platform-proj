<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<div id="main-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header bg-white">
						<h4 class="card-title" style="font-size: 25px">
							<strong>${contentsView[0].contents_name}</strong>
						</h4>
						<h5>
							<span class=" text-muted">제출자 : </span>${contentsView[0].mem_id}
						</h5>
						<h5 class="card-subtitle mb-2">
							<span class=" text-muted">제출일 : </span>
							${contentsView[0].contents_processing_date}
						</h5>
						<hr />
					</div>
					<div class="card-body">
						<p class="card-text">${contentsView[0].contents_text}</p>
						<img class="img-fluid" 
					src="${contextPath}/contentsFile_download.do?contents_file_id=${contentsFileView[0].contents_file_id}&contents_file_name=${contentsFileView[0].contents_file_name}&contents_file_type=${contentsFileView[0].contents_file_type}">
					</div>
					<div class="card-footer">
						<button type="button"
							class="btn btn-primary waves-effect waves-light float-right"
							data-toggle="modal" data-target="#contentsRefusal" style="margin:3px;">기각</button>
						<button type="button"
							class="btn btn-primary waves-effect waves-light float-right" style="margin:3px;" onclick="location.href='${contextPath}/admin/adminContentsAppr.do?contents_id=${contentsView[0].contents_id}'">승인</button>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 기각 모달창 -->
<div class="modal fade none-border" id="contentsRefusal"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">
					<strong>기각 사유</strong>
				</h4>
			</div>
			<div id="modal-body" class="modal-body">
				<form action="${contextPath}/admin/adminContentsRefusal.do"
					method="get">
					<div class="row">
					<input class="contents_id" type="hidden" name="contents_id" value="${contentsView[0].contents_id}">
					<input class="form-control form-white" placeholder="기각 사유를 입력해주세요."
							type="text" name="contents_reject_reason" style="margin:3px;">
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default waves-effect"
							data-dismiss="modal">닫기</button>
						<button type="submit"
							class="btn btn-danger waves-effect waves-light save-category">기각</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
