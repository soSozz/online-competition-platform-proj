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


.endCompet{
	color: black;
	font-weight: bold;
}

.chart{
       display: flex;
       justify-content: center;
       position: relative;
       left: 240px;
   } 
.allbox{
 width: 100%
}


</style>
</head>
<body>
<div class="allbox">
    <div class="container">
        <div class="row my-3">
    <span style="font-size: 25px; font-weight:bold; color:black;">좋아요</span>
     <div class="general-button">
		 <button type="button" class="btn mb-1 btn-select">조회하기</button>
	     </div>
        </div>
        
<div class="row">
                    <!-- single bar Chart -->
                    <div class="col-lg-12">
                        <div class="card">
                        
                            <div class="card-body">
                            <div class="row">
                            <div class="col-lg-3">
                                <canvas id="singleBarChart" width="300" height="250"></canvas>
                            </div>
                            <div class="col-lg-3">
                                <canvas id="singleBarChart1" width="300" height="250"></canvas>
                            </div>
                               
                            </div>
                          </div>
                        </div>
                    </div>
                </div>
</div>
<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h4 class="endCompet">실시간 댓글 현황</h4>
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
														<th class="contents_name" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="contents_name"
															style="width: 145.531px;">컨텐츠</th>
														<th class="cmt_text" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="cmt_text"
															style="width: 236.656px;">댓글 내용</th>
														<th class="mem_id" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="mem_id"
															style="width: 145.531px;">작성자</th>
														<th class="cmt_date" tabindex="0"
															aria-controls="DataTables_Table_0" rowspan="1"
															colspan="1"
															aria-label="cmt_date"
															style="width: 105.656px;">작성 시각</th>
														
														
													</tr>
												</thead>
												 <tbody>
												
                                            <c:if test="${adminCmtList !=null }">
                                                <c:forEach var="admin_CmtList" items="${adminCmtList}" varStatus="adminNum">
                                                    <tr align="center">
                                                        <td width="5%"></td>
                                                        <td width="15%">${admin_CmtList.contents_name}</td>
                                                        <td width="20%">${admin_CmtList.cmt_text}</td>
                                                        <td width="10%">${admin_CmtList.mem_id}</td>
                                                        <td width="10%">${admin_CmtList.cmt_date}</td>
                                                        
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
</div>          
      
<script src="${contextPath }/resources/plugins/chart.js/Chart.bundle.min.js"></script>
<script>
<!-- single bar chart -->
    var ctx = document.getElementById("singelBarChart");
    ctx.height = 150;
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            datasets: [
                {
                    label: 
                    data: 
                    borderColor: "rgba(117, 113, 249, 0.9)",
                    borderWidth: "0",
                    backgroundColor: "rgba(117, 113, 249, 0.5)"
                }
            ]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
    
    var ctx = document.getElementById("singelBarChart1");
    ctx.height = 150;
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            datasets: [
                {
                    label: "좋아요 수"
                    data: response
                    borderColor: "rgba(117, 113, 249, 0.9)",
                    borderWidth: "0",
                    backgroundColor: "rgba(117, 113, 249, 0.5)"
                }
            ]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });

    </script> 
</body>
</html>