<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>  
<div class="container">
		
	<div class="row">
		<p class="bold" style="font-size: 25px; color: black;">배너 관리</p>
		<hr class="w-100" />
	</div>
	<c:forEach var="item" items="${bannerFileList }">
		<div class="row">
				<div class="card mb-3 col-lg-8">
					<div class="row g-0">
						<div class="col-lg-6 p-0">
							<img src="${contextPath }/bannerFile_download.do?banner_file_name=${item.banner_file_name }&banner_file_type=${item.banner_file_type }&banner_id=${item.banner_id }" class="img-fluid h-100 p-1" alt="ss">
						</div>
						<div class="col-lg-6">
							<div class="card-body">
								<h5 class="card-title">${item.banner_name }</h5>
								<p class="card-text">광고 기간</p>
								<p class="card-text"><small class="text-muted">2021.09.10. ~ 2021.10.10.</small></p>
							</div>
						</div>
					</div>
				</div>
		</div>
	</c:forEach>
</div>


	