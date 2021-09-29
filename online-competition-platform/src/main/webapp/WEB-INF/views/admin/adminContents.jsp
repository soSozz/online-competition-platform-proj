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

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-6"></div>
			<div class="dropdown col-sm-12 col-md-3">
			<select class="form-control" id="categDropdown" onchange="changeCompet(this.value)">
					<option value="">카테고리를 선택해주세요.</option>
					<c:forEach var="dropdown" items="${dropdown}" varStatus="status">
						<option id="categList" value="${status.count}">${dropdown.key}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="dropdown col-sm-12 col-md-3">
				<select class="form-control" id="competLists" name="competList" onchange="changeList(this.value)">
 					<option value="">대회를 선택해주세요.</option>
				</select>
			</div>
		</div>
<br />
		<h3>컨텐츠 조회</h3>
		<hr />
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div class="table-responsive">
								<div id="DataTables_Table_0_wrapper"
									class="dataTables_wrapper container-fluid dt-bootstrap4">
									<div class="row">
										<div class="col-sm-12 col-md-6">
											<div class="dataTables_length" id="DataTables_Table_0_length">
												<label>Show <select name="DataTables_Table_0_length"
													aria-controls="DataTables_Table_0"
													class="form-control form-control-sm">
														<option value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
												</select> entries
												</label>
											</div>
										</div>
										<div class="col-sm-12 col-md-6">
											<div id="DataTables_Table_0_filter" class="dataTables_filter">
												<label>Search:<input type="search"
													class="form-control form-control-sm" placeholder=""
													aria-controls="DataTables_Table_0">
												</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-striped table-bordered dataTable"
												id="DataTables_Table_0" role="grid"
												aria-describedby="DataTables_Table_0_info">
												<thead>
													<tr role="row">
														<th class="No" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1" aria-sort="ascending" aria-label="No"
															style="width: 145.531px;">No.</th>
														<th class="contents_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1" aria-label="contents_name"
															style="width: 236.656px;">컨텐츠</th>
														<th class="mem_nickname" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1" aria-label="mem_nickname"
															style="width: 105.656px;">닉네임</th>
														<th class="contents_processing_date" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="contents_processing_date : activate to sort column ascending"
															style="width: 95.7188px;">제출일</th>
													</tr>
												</thead>
												<tbody id="contentsList">
													
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-5">
											<div class="dataTables_info" id="DataTables_Table_0_info"
												role="status" aria-live="polite">Showing 1 to 10 of 57
												entries</div>
										</div>
										<div class="col-sm-12 col-md-7">
											<div class="dataTables_paginate paging_simple_numbers"
												id="DataTables_Table_0_paginate">
												<ul class="pagination">
													<li class="paginate_button page-item previous disabled"
														id="DataTables_Table_0_previous"><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="0"
														tabindex="0" class="page-link">Previous</a></li>
													<li class="paginate_button page-item active"><a
														href="#" aria-controls="DataTables_Table_0"
														data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="2"
														tabindex="0" class="page-link">2</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="3"
														tabindex="0" class="page-link">3</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="4"
														tabindex="0" class="page-link">4</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="5"
														tabindex="0" class="page-link">5</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="6"
														tabindex="0" class="page-link">Next</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
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
							<div class="table-responsive">
								<div id="DataTables_Table_0_wrapper"
									class="dataTables_wrapper container-fluid dt-bootstrap4">
									<div class="row">
										<div class="col-sm-12 col-md-6">
											<div class="dataTables_length" id="DataTables_Table_0_length">
												<label>Show <select name="DataTables_Table_0_length"
													aria-controls="DataTables_Table_0"
													class="form-control form-control-sm">
														<option value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
												</select> entries
												</label>
											</div>
										</div>
										<div class="col-sm-12 col-md-6">
											<div id="DataTables_Table_0_filter" class="dataTables_filter">
												<label>Search:<input type="search"
													class="form-control form-control-sm" placeholder=""
													aria-controls="DataTables_Table_0">
												</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-striped table-bordered dataTable"
												id="DataTables_Table_0" role="grid"
												aria-describedby="DataTables_Table_0_info">
												<thead>
													<tr role="row">
														<th class="No" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1" aria-sort="ascending" aria-label="No"
															style="width: 145.531px;">No.</th>
														<th class="contents_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1" aria-label="contents_name"
															style="width: 236.656px;">컨텐츠</th>
														<th class="mem_nickname" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1" aria-label="mem_nickname"
															style="width: 105.656px;">닉네임</th>
														<th class="contents_processing_date" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="contents_processing_date : activate to sort column ascending"
															style="width: 95.7188px;">승인일</th>
													</tr>
												</thead>
												<tbody id="apprContentsList">
													
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-5">
											<div class="dataTables_info" id="DataTables_Table_0_info"
												role="status" aria-live="polite">Showing 1 to 10 of 57
												entries</div>
										</div>
										<div class="col-sm-12 col-md-7">
											<div class="dataTables_paginate paging_simple_numbers"
												id="DataTables_Table_0_paginate">
												<ul class="pagination">
													<li class="paginate_button page-item previous disabled"
														id="DataTables_Table_0_previous"><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="0"
														tabindex="0" class="page-link">Previous</a></li>
													<li class="paginate_button page-item active"><a
														href="#" aria-controls="DataTables_Table_0"
														data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="2"
														tabindex="0" class="page-link">2</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="3"
														tabindex="0" class="page-link">3</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="4"
														tabindex="0" class="page-link">4</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="5"
														tabindex="0" class="page-link">5</a></li>
													<li class="paginate_button page-item "><a href="#"
														aria-controls="DataTables_Table_0" data-dt-idx="6"
														tabindex="0" class="page-link">Next</a></li>
												</ul>
											</div>
										</div>
									</div>
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
	console.log(compet_name);
	
	var $contentsTable = $("tbody[id='contentsList']");
	var $apprContentsTable = $("tbody[id='apprContentsList']");
	$.ajax({
		type : "POST",
		url : "/ocp/admin/selectContentsList.do",
		data : {"compet_name" : compet_name},
		dataType : "json",
		success : function(jsonInfo) {
			const contentsList = jsonInfo["contentsList"];
			const apprContentsList = jsonInfo["apprContentsList"];
			
			var contents_list = []
			var apprContents_list = []
			
			for(response of contentsList){
				contents_list.push(response["contents_name"]);
				contents_list.push(response["mem_id"]);
				contents_list.push(response["contents_processing_date"]);
			}
			
			for(response of apprContents_list){
				apprContents_list.push(response["contents_name"]);
				apprContents_list.push(response["mem_id"]);
				apprContents_list.push(response["contents_processing_date"]);
			}

			for(var i = 0; i < contents_list.length; i++){
				$contentsTable.append("<tr role='row'><td class='NO'>"+ i + 
									"</td><td class='contentsName'>" + contents_list[i].contents_name + 
									"</td><td class = 'mem_id'>" + contents_list[i].mem_id + 
									"</td><td class = 'contents_processing_date'" + contents_list[i].contents_processing_date + 
									"</td></tr>")
			}
			
			for(var i = 0; i < apprContents_list.length; i++){
				$apprContents_list.append("<tr role='row'><td class='NO'>"+ i + 
									"</td><td class='contentsName'>" + apprContents_list[i].contents_name + 
									"</td><td class = 'mem_id'>" + apprContents_list[i].mem_id + 
									"</td><td class = 'contents_processing_date'" + apprContents_list[i].contents_processing_date + 
									"</td></tr>")
			}
		},
		error: function(data, textStatus) {
			alert("에러")
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