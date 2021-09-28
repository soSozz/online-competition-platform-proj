<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<style>
    h3,
    h4 {
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

    .competEdit {
        background: orange;
        height: 35px;
    }

    .categ_btn {}

    .container-fluid {}

    .endCompet {
        color: black;
        font-weight: bold;
    }

</style>
<compet-detail>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<h4 class="endCompet">공지사항</h4>
					<div class="table-responsive">
						<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="row">
								<div class="col-sm-12 col-md-6">
									<div class="dataTables_length" id="DataTables_Table_0_length">
										<label>Show <select name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" class="form-control form-control-sm">
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
										<label>Search:<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="DataTables_Table_0">
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-striped table-bordered dataTable" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info">
										<thead>
											<tr role="row">
												<th class="No" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="No" style="width: 145.531px;">No.</th>
												<th class="categ_name" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="categ_name" style="width: 236.656px;">제목</th>
												<th class="compet_name" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="compet_name" style="width: 105.656px;">작성자</th>
												<th class="compet_start" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="compet_start" style="width: 95.7188px;">작성일</th>
												<th class="compet_end sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="compet_end : activate to sort column ascending" style="width: 79.8906px;">조회수</th>

											</tr>
										</thead>
										<tbody>

											<c:if test="${noticeCompetList !=null }">
												<c:forEach var="compet_Notice" items="${noticeCompetList}" varStatus="noticeNum">
													<tr align="center">
														<td width="5%">${compet_Notice.compet_notice_id}</td>
														<td width="25%">${compet_Notice.compet_notice_title }</td>
														<td width="5%">${compet_Notice.admin_id}</td>
														<td width="5%">${compet_Notice.compet_notice_date}</td>
														<td width="5%">${compet_Notice.compet_notice_view}</td>
													</tr>
												</c:forEach>
											</c:if>

										</tbody>
									</table>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 col-md-5">
									<div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">Showing 1 to 10 of 57
										entries</div>
								</div>
								<div class="col-sm-12 col-md-7">
									<div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
										<ul class="pagination">
											<li class="paginate_button page-item previous disabled" id="DataTables_Table_0_previous"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" class="page-link">Previous</a></li>
											<li class="paginate_button page-item active"><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
											<li class="paginate_button page-item "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0" class="page-link">2</a></li>
											<li class="paginate_button page-item "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0" class="page-link">3</a></li>
											<li class="paginate_button page-item "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="4" tabindex="0" class="page-link">4</a></li>
											<li class="paginate_button page-item "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="5" tabindex="0" class="page-link">5</a></li>
											<li class="paginate_button page-item "><a href="#" aria-controls="DataTables_Table_0" data-dt-idx="6" tabindex="0" class="page-link">Next</a></li>
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
</compet-detail>
