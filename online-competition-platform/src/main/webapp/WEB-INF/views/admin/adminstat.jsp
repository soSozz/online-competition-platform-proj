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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> <!-- 차트 링크 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
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

<body>
    <div class="container">
        <div class="row my-3">
            <div class="col">
    <span style="font-size: 25px; font-weight:bold; color:black;">카테고리별 통계</span>
            </div>
        </div>
        <div class="row py-2">
            <div class="col-md-4 py-1">
                <div class="card">
                    <div class="card-body"> <canvas id="chDonut1"></canvas> </div>
                </div>
            </div>
            <div class="col-md-4 py-1">
                <div class="card">
                    <div class="card-body"> <canvas id="chDonut2"></canvas> </div>

                </div>
            </div>
            <div class="col-md-4 py-1">
                <div class="card">
                    <div class="card-body"> <canvas id="chDonut3"></canvas> </div>
                </div>
            </div>
        </div>
    </div> 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
    <script>
        var colors = ['red', 'skyblue', 'yellowgreen', '#c3e6cb', '#dc3545', '#6c757d'];
        var donutOptions = {
            cutoutPercentage: 30,
            legend: {
                position: 'bottom',
                padding: 5,
                labels: {
                    pointStyle: 'circle',
                    usePointStyle: true
                }
            }
        };
        
        
        var VOList = ${adminContentsList}
        var ctgNames = []
        var Numcontents = []
        for (var i=0; i<VOList.length; i++){
        	ctgNames.add(VOList[i].ctgName)
        	Numcontents.add(VOList[i].viw)
        
        }
        

     
        var chDonutData1 = {
            labels: ctgNames
            datasets: [{
                backgroundColor: colors.slice(0, 3),
                borderWidth: 0,
                data: Numcontents
            }]
        };
        var chDonut1 = document.getElementById("chDonut1");
        if (chDonut1) {
            new Chart(chDonut1, {
                type: 'pie',
                data: chDonutData1,
                options: donutOptions
            });
        }

        /* var chDonutData2 = {
            labels: ctgList
            datasets: [{
                backgroundColor: colors.slice(0, 3),
                borderWidth: 0,
                data: viewList
            }]
        };
        var chDonut2 = document.getElementById("chDonut2");
        if (chDonut2) {
            new Chart(chDonut2, {
                type: 'pie',
                data: chDonutData2,
                options: donutOptions
            });
        }
      
        var chDonutData3 = {
            labels: ctgList
            datasets: [{
                backgroundColor: colors.slice(0, 3),
                borderWidth: 0,
                data: likeList
            }]
        };
        var chDonut3 = document.getElementById("chDonut3");
        if (chDonut3) {
            new Chart(chDonut3, {
                type: 'pie',
                data: chDonutData3,
                options: donutOptions
            });
        } */

    </script>
    <div class="container">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h4 class="endCompet">전체조회</h4>
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
															style="width: 95.7188px;">No.</th>
														<th class="categ_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="categ_name"
															style="width: 145.531px;">카테고리</th>
														<th class="copet_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="copet_name"
															style="width: 145.531px;">대회</th>
														<th class="copet_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="cotents_name"
															style="width: 236.656px;">컨텐츠</th>
														<th class="cotents_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_name"
															style="width: 105.656px;">닉네임</th>
														<th class="compet_start" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_start"
															style="width: 95.7188px;">작성일</th>
														<th class="compet_end sorting" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_end : activate to sort column ascending"
															style="width: 79.8906px;">조회수</th>
														<th class="compet_end sorting" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_end : activate to sort column ascending"
															style="width: 79.8906px;">좋아요</th>
														<th class="compet_end sorting" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="compet_end : activate to sort column ascending"
															style="width: 79.8906px;">댓글</th>
														
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
