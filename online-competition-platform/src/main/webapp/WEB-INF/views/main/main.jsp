<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %> <%@ taglib
uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<link href="${contextPath}/resources/css/main.css" rel="stylesheet">

    <div id="carousel" class="row justify-content-lg-center my-lg-3">
        <div class="col-lg-10">
        <div class="bootstrap-carousel">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                	<c:forEach var="item" items="${bannerFileList }" varStatus="cnt">
                		<c:choose>
							<c:when test="${cnt.count == 1}">
								<div class="carousel-item active">
							</c:when>
							<c:otherwise>
                    			<div class="carousel-item">
							</c:otherwise>
                		</c:choose>
                        <img class="d-block w-100 h-100" src="/ocp/bannerFile_download.do?banner_id=${item.banner_id }&banner_file_name=${item.banner_file_name }&banner_file_type=${item.banner_file_type}" alt="${cnt.count}">
                    	</div>
                	</c:forEach>
                </div>
            </div>
        </div>
        </div>
    </div>
    	<c:forEach var="categ" items="${competsMap}">
			<!-- start card --> 
			<div class="row justify-content-lg-center">
				<div class="card">
					<div class="card-body">
						<div class="mb-lg-3">
							<span id="compet_title" class="mb-lg-3 bold">${categ.key }</span>
							<a href="#" class="float-right"><span>더보기</span></a>
						</div>
						<div class="row justify-content-lg-center">
							<div class="col-lg-12">
								<div class="row">
									<c:forEach var="compet" items="${categ.value }">
										<!-- Start Col -->
										<div class="col-lg-4">
											<div class="card">
												<img src="${contextPath }/thumbnails.do?compet_file_name=${compet.compet_file_name}&compet_file_type=${compet.compet_file_type }&compet_id=${compet.compet_id}" alt="" />
												<div class="card-body">
													<h5 class="card-title">${compet.compet_name }</h5>
													<p class="card-text text-truncate">
														${compet.compet_start } ~ ${compet.compet_end}
													</p>
												</div>
												<div class="card-footer">
													<a href="#" class="card-link float-right"><small>자세히 보기</small></a>
												</div>
											</div>
										</div>
									<!-- End Col -->
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end card --> 
       	</c:forEach> 