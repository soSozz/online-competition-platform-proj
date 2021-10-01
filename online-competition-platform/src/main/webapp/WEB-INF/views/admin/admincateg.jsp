<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<script
	src="${contextPath}/resources/plugins/jqueryui/js/jquery-ui.min.js"></script>
<script src="${contextPath}/resources/plugins/moment/moment.min.js"></script>
<script
	src="${contextPath}/resources/plugins/fullcalendar/js/fullcalendar.min.js"></script>
<script
	src="${contextPath}/resources/js/plugins-init/fullcalendar-init.js"></script>
<script src="${contextPath}/resources/plugins/common/common.min.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/js/settings.js"></script>
<script src="${contextPath}/resources/js/gleek.js"></script>
<script src="${contextPath}/resources/js/styleSwitcher.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/font.css" rel="stylesheet">


<style>
h3, h4 {
	font-weight: bold;
}

.categ {
	font-size: 30px;
	font-weight: bold;
	color: black;
}

.competName {
	font-size: 20px;
	font-weight: bold;
	color: black;
	text-align: center;
}

.competList {
	/* background: orange; */
	height: 35px;
	margin: 1px;
}

.categ_btn {
	
}

.container-fluid {
	
}

.endCompet {
	color: black;
	font-weight: bold;
}

.categBtn {
	margin: 1px;
}
</style>
</head>
<div class="container">
	<span style="font-size: 25px; font-weight: bold; color: black;">카테고리
		및 대회</span>
	<a href = "#" class="addCateg float-right btn btn-primary" 
	data-toggle="modal" data-target="#add-categ">카테고리 추가</a>
	<hr />
	<h4>진행 중인 대회</h4>
	<div class="row">
	<c:forEach var="categ" items="${competInCateg}">
		<div class="col-lg-6">
			<div class="categList card border-primary">
				<div class="card-header">
					<span class="categ float-center">${categ.key}</span>
						
					<a href="#" data-toggle="modal" data-target="#add-compet"
						class="categBtn btn btn-primary float-right" onclick="fn_add_compet(event)">
						<i class="ti-plus f-s-12 m-r-5"></i> 대회 추가</a>
						
					<a href="#" class="categBtn btn btn-primary float-right" onclick="fn_delete_categ(event)">
						<i class="ti-minus f-s-12 m-r-5"></i> 카테고리 삭제</a>
					
				</div>
				<div class="card-body">
					<c:forEach var="compet" items="${categ.value}">
						<div class="competList">
							<div class="compet_name"><span>${compet.compet_name}</span>
							<button class="btn btn-primary float-right" style="height: 35px;"
									onclick="fn_finish_compet(event)">대회 종료</button>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
	<div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">종료된 대회</h4>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered zero-configuration">
                                        <thead>
                                            <tr>
                                                <th class="No">No.</th>
                                                <th class="categ_name">카테고리</th>
                                                <th class="compet_name">대회</th>
                                                <th class="compet_start">시작일</th>
                                                <th class="compet_end sorting">종료일</th>
                                                <th class="compet_create">생성일자</th>
                                                <th class="delete"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
												<c:set var="stat" value="0" />
												<c:forEach var="categ" items="${finishCompet}">
													<c:forEach var="compet" items="${categ.value}" varStatus="status">
													<tr role="row" class="even">
														<td class="NO">${status.count + stat}</td>
														<td class="categ_name"><span class="float-center">${categ.key}</span></td>
														<td class="compet_name">
															${compet.compet_name}</td>
														<td class="compet_start">${compet.compet_start}</td>
														<td class="compet_end">${compet.compet_end}</td>
														<td class="compet_create">${compet.compet_create}</td>
														<td class="deletebtn"><button class="deletebtn btn btn-primary float-center"
																			   onclick="fn_delete_compet(event)">삭제하기</button></td>
														</tr>
														<c:if test="${status.last == true}" >
														<c:set var="stat" value="${stat = status.count + stat}" />
														</c:if>
														</c:forEach>
												</c:forEach>
											
									
											</tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</div>
<div class="modal fade none-border" id="add-categ"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">
					<strong>대회 추가하기</strong>
				</h4>
			</div>
			<div id="modal-body" class="modal-body">
				<form action="${contextPath }/admin/addCateg.do" method="get">
					<div class="row">
							<label class="control-label">카테고리명</label> 
							<input
								class="form-control form-white" placeholder="카테고리명을 입력해주세요."
								type="text" name="categ_name">
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default waves-effect"
							data-dismiss="modal">닫기</button>
						<button type="submit" 
							class="btn btn-danger waves-effect waves-light save-category" >추가하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal fade none-border" id="add-compet"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">
					<strong>카테고리 추가하기</strong>
				</h4>
			</div>
			<div id="modal-body" class="modal-body">
				<form action="${contextPath }/admin/addCompet.do" method="post" enctype="multipart/form-data">
					<div class="row">
							<label id="categ-label" class="control-label"></label> 
							<input
								id="categ-input"
								class="form-control form-white"
								type="text" name="categ_name">
							<label class="control-label">대회명</label> 
							<input
								class="form-control form-white" placeholder="대회명을 입력해주세요."
								type="text" name="compet_name">
							<label class="control-label">시작일 ex) 0000-00-00</label> 
							<input
								class="form-control form-white" placeholder="대회 시작일을 입력해주세요."
								type="text" name="compet_start">
							<label class="control-label">종료일 ex) 0000-00-00</label> 
							<input
								class="form-control form-white" placeholder="대회 종료일을 입력해주세요."
								type="text" name="compet_end">
							<label class="control-label">간단한 설명</label> 
							<textarea
								class="form-control form-white" placeholder="대회 설명을 입력해주세요."
								name="compet_text">
							</textarea>
							<div>
							<label class="control-label">이미지 첨부(큰 포스터)</label>
							<div>
							<input 
								class="competBigImg btn btn-primary" type="file" name="BigPoster"/>
							</div>
							</div>
							<div>
							<label class="control-label">이미지 첨부(작은 포스터)</label>
							<div>
							<input 
								class="competSmallImg btn btn-primary" type="file" name="SmallPoster"/>
							</div>
							</div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default waves-effect"
							data-dismiss="modal">닫기</button>
						<button type="submit" 
							class="btn btn-danger waves-effect waves-light save-category" >추가하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script>
	function fn_delete_categ(e){
		const categ = e.target.parentNode.querySelector("span").innerHTML

 		location.href = "/ocp/admin/deleteCateg.do?categ_name=" + categ
	}

	function fn_add_categ(e){
		console.log(window.location.pathname);
		location.href = "/ocp/admin/addCateg.do"

	}

	function fn_add_compet(e){
		const categ = e.target.parentNode.querySelector("span").innerHTML
		
		const label = document.getElementById("categ-label");
		label.innerHTML = '카테고리명';
		const input = document.getElementById("categ-input");
		input.value = categ;
	}
	
	function fn_finish_compet(e){
		const compet_name = e.target.parentNode.querySelector("span").innerHTML
		
		location.href = "/ocp/admin/competFinish.do?compet_name=" + compet_name
	}
	
	function fn_delete_compet(e){
		const compet_name = e.target.parentNode.parentNode.querySelector(".compet_name").innerHTML
		
		location.href = "/ocp/admin/competDelete.do?compet_name=" + compet_name 
	}
</script>
</html>