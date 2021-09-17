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
    <script src="${contextPath}/resources/plugins/jqueryui/js/jquery-ui.min.js"></script>
    <script src="${contextPath}/resources/plugins/moment/moment.min.js"></script>
    <script src="${contextPath}/resources/plugins/fullcalendar/js/fullcalendar.min.js"></script>
    <script src="${contextPath}/resources/js/plugins-init/fullcalendar-init.js"></script>
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
<style>
h3,h4{
	font-weight:bold;
}
.categ {
	font-size: 30px;
	font-weight: bold;
	color: black;
}
.competName{
	font-size: 20px;
	font-weight: bold;
	color: black;
	text-align:center;
}
.competEdit{
	background: orange;
	height: 35px;
}
.categ_btn {
	
}

.container-fluid {
	
}
.endCompet{
	color: black;
	font-weight: bold;
}
</style>
</head>
	<div class="container">
		<span style="font-size: 25px; font-weight:bold; color:black;">카테고리 및 대회</span>
		<button class="categEdit float-right btn btn-primary">카테고리 편집</button>
		<hr />
		<h4>진행 중인 대회</h4>
		<div class="col-lg-6">
			<div class="card border-primary">
				<div class="card-header">
					<span class="categ float-center">알고리즘</span>
					<a href="#" data-toggle="modal" data-target="#add-category" class="categ_btn btn btn-primary float-right"><i class="ti-plus f-s-12 m-r-5"></i> 추가하기</a>
				</div>
				<div class="card-body">
					<div class="competEdit">
					<span class="competName">AAA 경진대회</span>
					<a href="#" class="btn btn-primary float-right" style="height:35px;">대회 종료</a>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h4 class="endCompet">종료된 대회</h4>
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
															colspan="1" aria-sort="ascending"
															aria-label="No"
															style="width: 145.531px;">No.</th>
														<th class="categ_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="categ_name"
															style="width: 236.656px;">카테고리</th>
														<th class="compet_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_name"
															style="width: 105.656px;">대회</th>
														<th class="compet_start" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_start"
															style="width: 95.7188px;">시작일</th>
														<th class="compet_end sorting" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_end : activate to sort column ascending"
															style="width: 79.8906px;">종료일</th>
														<th class="compet_create" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_create"
															style="width: 79.8906px;">생성일자</th>
														<th class="delete" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="delete"
															style="width: 79.8906px;"></th>
													</tr>
												</thead>
												<tbody>
													<tr role="row" class="odd">
														<td class="sorting_1">Airi Satou</td>
														<td>Accountant</td>
														<td>Tokyo</td>
														<td>33</td>
														<td>2008/11/28</td>
														<td>$162,700</td>
														<td><button class="deletebtn btn btn-primary">삭제하기</button></td>
													</tr>
													<tr role="row" class="even">
														<td class="sorting_1">Angelica Ramos</td>
														<td>Chief Executive Officer (CEO)</td>
														<td>London</td>
														<td>47</td>
														<td>2009/10/09</td>
														<td>$1,200,000</td>
														<td><button class="deletebtn btn btn-primary">삭제하기</button></td>
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
	
<div class="modal fade none-border" id="add-category" style="display: none;" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title"><strong>Add a category</strong></h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <label class="control-label">Category Name</label>
                                                                <input class="form-control form-white" placeholder="Enter name" type="text" name="category-name">
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label class="control-label">Choose Category Color</label>
                                                                <select class="form-control form-white" data-placeholder="Choose a color..." name="category-color">
                                                                    <option value="success">Success</option>
                                                                    <option value="danger">Danger</option>
                                                                    <option value="info">Info</option>
                                                                    <option value="pink">Pink</option>
                                                                    <option value="primary">Primary</option>
                                                                    <option value="warning">Warning</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-danger waves-effect waves-light save-category" data-dismiss="modal">Save</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
</html>