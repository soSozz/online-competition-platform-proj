<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title><tiles:insertAttribute name="title" /></title>

<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<!-- 구글 폰트 설정: Noto Sans Korean -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link href="${contextPath}/resources/css/font.css" rel="stylesheet">

<!-- 파비콘 -->
<link rel="shortcut icon" href="https://img.icons8.com/metro/40/000000/share.png">

</head>
<body>
	<div class="container-fluid" style="width:80%">
	
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-3">
				<tiles:insertAttribute name="side" />
			</div>
			<div class="col-lg-9">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
		
	</div>
    	
    <!--**********************************
        Scripts
    ***********************************-->
    <script src="${contextPath }/resources/plugins/common/common.min.js"></script>
    <script src="${contextPath }/resources/js/custom.min.js"></script>
    <script src="${contextPath }/resources/js/settings.js"></script>
    <script src="${contextPath }/resources/js/gleek.js"></script>
    <script src="${contextPath }/resources/js/styleSwitcher.js"></script>
    <!--**********************************
        table
    ***********************************-->
    <script src="${contextPath}/resources/plugins/tables/js/jquery.dataTables.min.js"></script>
<script src="${contextPath}/resources/plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
<script src="${contextPath}/resources/plugins/tables/js/datatable-init/datatable-basic.min.js"></script>

<script src="${contextPath}/resources/plugins/jqueryui/js/jquery-ui.min.js"></script>
<script src="${contextPath}/resources/plugins/moment/moment.min.js"></script>
<script src="${contextPath}/resources/plugins/fullcalendar/js/fullcalendar.min.js"></script>
<script src="${contextPath}/resources/js/plugins-init/fullcalendar-init.js"></script>

<script src="${contextPath }/resources/plugins/chart.js/Chart.bundle.min.js"></script>
<script src="${contextPath }/resources/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
<script src="${contextPath }/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
 <script src="${contextPath }/resources/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>

    <!--**********************************
        Scripts(adminmonitor.jsp)
    ***********************************-->
<script src="${contextPath }/resources/plugins/clockpicker/dist/jquery-clockpicker.min.js"></script>
<script src="${contextPath }/resources/plugins/moment/moment.js"></script>
<script src="${contextPath }/resources/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
<script src="${contextPath }/resources/plugins/chart.js/Chart.bundle.min.js"></script>
<script src="${contextPath }/resources/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="${contextPath }/resources/plugins/jquery-asColorPicker-master/libs/jquery-asColor.js"></script>
<script src="${contextPath }/resources/plugins/jquery-asColorPicker-master/libs/jquery-asGradient.js"></script>
<script src="${contextPath }/resources/plugins/jquery-asColorPicker-master/dist/jquery-asColorPicker.min.js"></script>
<script src="${contextPath }/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>

<script src="${contextPath }/resources/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${contextPath }/resources/js/plugins-init/form-pickers-init.js"></script>
    <!--**********************************
        Scripts(adminmonitor.jsp)
    ***********************************-->

<%-- 	<script src="${contextPath }/resources/plugins/chart.js/Chart.bundle.min.js"></script> --%>
</body>      
        
        