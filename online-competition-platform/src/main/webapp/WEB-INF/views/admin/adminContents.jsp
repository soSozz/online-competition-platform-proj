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
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-7"></div>
			<div class="dropdown col-sm-12 col-md-2">
				<button class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">카테고리</button>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 37px, 0px);">
					<c:forEach var="dropdown" items="${dropdown}">
						<a class="dropdown-item" href="#">${dropdown.key}</a>
					</c:forEach>
				</div>

			</div>
			<div class="dropdown col-sm-12 col-md-3">
				<button class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">대회</button>
				<div class="dropdown-menu" x-placement="bottom-start"
					style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 37px, 0px);">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div>
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
												<tbody>
													<tr role="row" class="odd">
														<td class="sorting_1">Airi Satou</td>
														<td>Accountant</td>
														<td>Tokyo</td>
														<td>33</td>
													</tr>
													<tr role="row" class="even">
														<td class="sorting_1">Angelica Ramos</td>
														<td>Chief Executive Officer (CEO)</td>
														<td>London</td>
														<td>47</td>
													</tr>
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
												<tbody>
													<tr role="row" class="odd">
														<td class="sorting_1">Airi Satou</td>
														<td>Accountant</td>
														<td>Tokyo</td>
														<td>33</td>
													</tr>
													<tr role="row" class="even">
														<td class="sorting_1">Angelica Ramos</td>
														<td>Chief Executive Officer (CEO)</td>
														<td>London</td>
														<td>47</td>
													</tr>
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

</body>
</html>