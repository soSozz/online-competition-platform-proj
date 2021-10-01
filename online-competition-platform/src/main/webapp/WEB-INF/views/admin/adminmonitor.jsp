<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link href="${contextPath}/resources/plugins/bootstrap-datepicker/bootstrap-datepicker.min.css" rel="stylesheet">
<link href="${contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
<link href="${contextPath}/resources/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%
request.setCharacterEncoding("UTF-8");
%>

<div class="container">
    <div class="row mb-lg-3 d-flex align-items-center">
       
				<div class="bold mr-auto" style="font-size: 25px;">댓글</div>
				<div class="example mr-lg-3">
                   <input id="cmt_date" class="form-control input-daterange-datepicker" type="text" name="daterange" value="09/01/2021 - 09/30/2021">
                </div>
        		<button class="float-right" type="button" id="cmtview">조회하기</button>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
	<div class="row mb-lg-3 d-flex align-items-center">
       
				<div class="bold mr-auto" style="font-size: 25px;">좋아요</div>
				<div class="example mr-lg-3">
                   <input id="likes_date" class="form-control input-daterange-datepicker" type="text" name="daterange" value="09/01/2021 - 09/30/2021">
                </div>
        		<button class="float-right" type="button" id="view">조회하기</button>
    </div>
    <div class="row">
        <!-- single bar Chart -->
        <div class="col-lg-20">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-18">
                            <canvas id="singleBarChart1" width="1000px" height="300px"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>    



    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">실시간 댓글 현황</h4>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered zero-configuration">

                            <thead>
                                <tr>
                                    <th class="No">No.</th>
                                    <th class="contents_name">컨텐츠</th>
                                    <th class="cmt_text">댓글 내용</th>
                                    <th class="mem_id">작성자</th>
                                    <th class="cmt_date">작성 시각</th>


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


            </div>
        </div>
    </div>

</div>

<script>
    var button = document.getElementById("cmtview");
    button.addEventListener("click", function() {
    	const date = document.getElementById("cmt_date").value;
    	
    	var start_date = 
    	var end_date = 
    		
        $.ajax({

            type: "GET",
            url: "/ocp/admin/monitor/selectCmtgraph.do?start_date=" + start_date + "&end_date=" + end_date,
            success: function(data, textStatus) {
                var jsonInfo = JSON.parse(data);
                const responses = jsonInfo["responses"];

                const cmt_arr = []
                const date1_arr = []
                for (response of responses) {
                    cmt_arr.push(response["Cmts"]);
                    date1_arr.push(response["Date"]);
                }


                var ctx = document.getElementById("singleBarChart").getContext('2d');
                ctx.height = 20;
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: date1_arr,
                        datasets: [{
                            label: "댓글 수",
                            data: cmt_arr,
                            borderColor: "rgba(117, 113, 249, 0.9)",
                            borderWidth: "0",
                            backgroundColor: "rgba(117, 113, 249, 0.5)"
                        }]
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
    button.addEventListener("click", function() {
        $.ajax({

            type: "GET",
            url: "/ocp/admin/monitor/selectLikegraph.do",
            success: function(data, textStatus) {
                var jsonInfo = JSON.parse(data);
                const responses = jsonInfo["responses"];

                const like_arr = []
                const date_arr = []
                for (response of responses) {
                    like_arr.push(response["Likes"]);
                    date_arr.push(response["Date"]);
                }

                
                var ctx = document.getElementById("singleBarChart1").getContext('2d');
                ctx.height = 20;
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: date_arr,
                        datasets: [{
                            label: "좋아요 수",
                            data: like_arr,
                            borderColor: "rgba(117, 113, 249, 0.9)",
                            borderWidth: "0",
                            backgroundColor: "rgba(117, 113, 249, 0.5)"
                        }]
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
