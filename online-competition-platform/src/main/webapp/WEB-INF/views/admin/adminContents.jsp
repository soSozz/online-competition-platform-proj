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
<link
	href="${contextPath}/resources/plugins/tables/css/datatable/dataTables.bootstrap4.min.css"
	rel="stylesheet" />

</head>

<body>
	<div id="main-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-6"></div>
				<div class="dropdown col-sm-12 col-md-3">
					<select class="form-control" id="categDropdown"
						onchange="changeCompet(this.value)">
						<option value="">카테고리를 선택해주세요.</option>
						<c:forEach var="dropdown" items="${dropdown}" varStatus="status">
							<option id="categList" value="${status.count}">${dropdown.key}</option>
						</c:forEach>
					</select>
				</div>
				<div class="dropdown col-sm-12 col-md-3">
					<select class="form-control" id="competLists" name="competList"
						onchange="changeList(this.value)">
						<option value="">대회를 선택해주세요.</option>
					</select>
				</div>
			</div>
			<br />
			<h3>제출된 컨텐츠 조회</h3>
			<hr />
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title"></h4>
								<div class="table-responsive">
									<table class="table table-striped table-bordered ">
										<thead>
											<tr>
												<th style="width: 60.531px;">No.</th>
												<th style="width: 256.656px;">컨텐츠</th>
												<th style="width: 105.656px;">아이디</th>
												<th style="width: 130.7188px;">제출일</th>
											</tr>
										</thead>
										<tbody id="contentsList">

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<h3>컨텐츠 승인</h3>
			<hr />
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title"></h4>
								<div class="table-responsive">
									<table class="table table-striped table-bordered">
										<!-- 테이블 바꾸기 zero-configuration -->
										<thead>
											<tr>
												<th style="width: 60.531px;">No.</th>
												<th style="width: 256.656px;">컨텐츠</th>
												<th style="width: 105.656px;">아이디</th>
												<th style="width: 130.7188px;">승인일</th>
											</tr>
										</thead>
										<tbody id="apprContentsList">

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<script>
function changeList(e) {
	$("#competLists option:selected").prop("selected", false);
	$("#competLists").val(e).prop("selected", true);
	var compet_name = $("#competLists option:selected").text()
	
	var $contentsTable = $("tbody[id='contentsList']");
	var $apprContentsTable = $("tbody[id='apprContentsList']");
	
	$contentsTable.empty();
	$apprContentsTable.empty();
	
	$.ajax({
		type : "POST",
		url : "/ocp/admin/selectContentsList.do",
		data : {"compet_name" : compet_name},
		dataType : "json",
		success : function(jsonInfo) {
			const contentsList = jsonInfo["contentsList"];
			const apprContentsList = jsonInfo["apprContentsList"];

			for(var i = 0; i < contentsList.length; i++){
				$contentsTable.append("<tr role='row'><td class='NO'>"+ (i + 1) +
									"</td><td class='contentsName'>"+"<a href='${contextPath}/admin/adminContentsView.do?contents_id="
									+ contentsList[i].contents_id + "'>"
									+ contentsList[i].contents_name + "</a>" + 
									"</td><td class = 'mem_id'>" + contentsList[i].mem_id + 
									"</td><td class = 'contents_processing_date'>" + contentsList[i].contents_processing_date + 
									"</td></tr>")
			}
			
			for(var i = 0; i < apprContentsList.length; i++){
				$apprContentsTable.append("<tr role='row'><td class='NO'>"+ (i + 1) + 
									"</td><td class='contentsName'>" + apprContentsList[i].contents_name + 
									"</td><td class = 'mem_id'>" + apprContentsList[i].mem_id + 
									"</td><td class = 'contents_processing_date'>" + apprContentsList[i].contents_processing_date + 
									"</td></tr>")
			}
		},
		error: function(data, textStatus) {
			alert("컨텐츠가 없습니다.")
		},
		async : false
	});
}

function changeCompet(e) {
	$("#categDropdown option:selected").prop("selected", false);
	$("#categDropdown").val(e).prop("selected", true);
	var categ_name = $("#categDropdown option:selected").text()

	var $target = $("select[name='competList']");
	$target.empty();
	if(e == ""){
		$target.append("<option value=''>대회를 선택해주세요.</option>");
		return;
	}
	$.ajax({
		type : "POST",
		url : "/ocp/admin/selectCompetList.do",
		data : {"categ_name" : categ_name},
		dataType : "json",

		success : function(jsonInfo) {
			const responses = jsonInfo["responses"];

			var compet_list = []
			for (response of responses){
				compet_list.push(response["compet_name"]);
			}
			$target.append("<option value=''>대회를 선택해주세요.</option>");
			for(var i =0; i < compet_list.length; i++){
				$target.append("<option value="+ i +">"+ compet_list[i] +"</option>");
			}
		},
		error: function(data, textStatus) {
			alert("에러")
		},
		async : false
	});
	
}

</script>
</body>
</html>