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
        <span style="font-size: 25px; font-weight:bold; color:black;">댓글</span>
         <div class="card">
                            <div class="card-body">
                                <h4 class="card-title"></h4>
                                <div class="row">
                                    <div class="col-md-11">
                                        <div class="example">
                                        
                                            <input class="form-control input-daterange-datepicker" type="text" name="daterange" value="01/01/2015 - 01/31/2015">
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
     <div class="general-button">
		 <button type="button" id="cmtview">조회하기</button>
	     </div>
    <span style="font-size: 25px; font-weight:bold; color:black;">좋아요</span>
     <div class="card">
                            <div class="card-body">
                                <h4 class="card-title"></h4>
                                <div class="row">
                                    <div class="col-md-11">
                                        <div class="example">
                                        
                                            <input class="form-control input-daterange-datepicker" type="text" name="daterange" value="01/01/2015 - 01/31/2015">
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
     <div class="general-button">
		 <button type="button" id="view">조회하기</button>
	     </div>
	     
        </div>
       <div class="row">
                    <!-- single bar Chart -->
                    <div class="col-lg-20">
                        <div class="card">
                        
                            <div class="card-body">
                            <div class="row">
                            <div class="col-lg-18">
                                <canvas id="singleBarChart" width="1000px" height="300px"></canvas>
                            </div>
                            <div class="col-lg-18">
                                <canvas id="singleBarChart1" width="1000px" height="300px"></canvas>
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
<script>
var button = document.getElementById("cmtview");
button.addEventListener("click", function(){
    $.ajax({
    	
    	type : "GET",
    	url : "/ocp/admin/monitor/selectCmtgraph.do",
    	success : function(data, textStatus) {
    		var jsonInfo = JSON.parse(data);
    		const responses = jsonInfo["responses"];
    		
    		const cmt_arr = []
    		const date1_arr = []
    		for (response of responses){
    			cmt_arr.push(response["Cmts"]);
    			date1_arr.push(response["Date"]);
    		}
    		
    		<!-- single bar chart -->
    	    var ctx = document.getElementById("singleBarChart").getContext('2d');
    	    ctx.height = 20;
    	    var myChart = new Chart(ctx, {
    	        type: 'bar',
    	        data: {
    	            labels: date1_arr,
    	            datasets: [
    	                {
    	                    label: "댓글 수",
    	                    data: cmt_arr,
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
    	}
    });
})
</script>         
<script>
   var button = document.getElementById("view");
    button.addEventListener("click", function(){
        $.ajax({
        	
        	type : "GET",
        	url : "/ocp/admin/monitor/selectLikegraph.do",
        	success : function(data, textStatus) {
        		var jsonInfo = JSON.parse(data);
        		const responses = jsonInfo["responses"];
        		
        		const like_arr = []
        		const date_arr = []
        		for (response of responses){
        			like_arr.push(response["Likes"]);
        			date_arr.push(response["Date"]);
        		}
        		
        		<!-- single bar chart -->
        	    var ctx = document.getElementById("singleBarChart1").getContext('2d');
        	    ctx.height = 20;
        	    var myChart = new Chart(ctx, {
        	        type: 'bar',
        	        data: {
        	            labels: date_arr,
        	            datasets: [
        	                {
        	                    label: "좋아요 수",
        	                    data: like_arr,
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
        	}
        });
    })
    
    
     
</script> 

<script>
   $(document).ready(function() {
      setDateBox();
   });

   // select box 연도 , 월 표시
   function setDateBox() {
      var dt = new Date();
      var com_year = dt.getFullYear();
      var com_month = dt.getMonth() + 1;
      var com_day = dt.getDate();

      for (var y = com_year - 1; y <= com_year; y++) {
         $("#start_day_year").append(
               "<option value='" + y + "'>" + y + "</option>");
         $("#end_day_year").append(
               "<option value='" + y + "'>" + y + "</option>");
      }

      // 월 뿌려주기(1월부터 12월)

      for (var i = 1; i <= 12; i++) {

         $("#start_day_month").append(
               "<option value='" + i + "'>" + i + "</option>")
      }

      if (com_month != 1) {
         for (var i = 1; i <= com_month; i++) {
            $("#end_day_month").append(
                  "<option value='" + i + "'>" + i + "</option>");

         }
      } else {
         for (var i = 1; i <= com_month; i++) {
            $("#end_day_month").append(
                  "<option value='" + i + "'>" + i + "</option>");
            $("#end_day_month").append(
                  "<option value='" + i + "'>" + i + "</option>");
         }
      }

      $("#end_day_month").append(
            "<option value='" + ""  + "'>" + "&nbsp;&nbsp;&nbsp;&nbsp;"
                  + "</option>");

      // 일 뿌려주기(1일부터 31일)
      for (var i = 1; i <= 30; i++) {
         $("#start_day_day").append(
               "<option value='" + i + "'>" + i + "</option>");
         $("#end_day_day").append(
               "<option value='" + i + "'>" + i + "</option>");
      }

      end_year = com_year - 1

      $("#start_day_year > option[value=" + end_year + "]").attr("selected",
            "true");
      $("#start_day_month > option[value=" + com_month + "]").attr(
            "selected", "true");
      $("#start_day_day > option[value=" + com_day + "]").attr("selected",
            "true");

      $("#end_day_year > option[value=" + com_year + "]").attr("selected",
            "true");
      $("#end_day_month > option[value=" + com_month + "]").attr(
            "selected", "true");
      $("#end_day_day > option[value=" + com_day + "]").attr("selected",
            "true");

   }
</script>

<script src="${contextPath }/resources/plugins/chart.js/Chart.bundle.min.js"></script>
<script src="${contextPath }/resources/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
 <script src="${contextPath }/resources/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
</body>
</html>