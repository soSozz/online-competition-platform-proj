<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<link href="${contextPath}/resources/css/sidebar.css" rel="stylesheet">

<div class="card">
        <div class="card-body p-2">
        	<div class="row justify-content-center align-items-center">
				<div class="mr-lg-2"><i class="fas fa-calendar-check" style="color: black; font-size: 2em"></i></div>
				<div><h4 class="bold m-0">최근 종료된 대회</h4></div>
            </div>
            <div class="bootstrap-carousel">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                    	<c:forEach var="competMap" items="${sidebarMap }" varStatus="num">
							<!-- table start -->
							<c:choose>
								<c:when test="${num.count == 1}">
									<div class="carousel-item active">
								</c:when>
								<c:otherwise>
									<div class="carousel-item">
								</c:otherwise>
							</c:choose>

								<div class="card-title">
									<p class="m-lg-3 text-center leader-board-title">${competMap.key }</p>
								</div>
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th class="text-center">순위</th>
												<th class="text-center">닉네임</th>
												<th class="text-center">좋아요</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="ranker" items="${competMap.value}" varStatus="num">
												<tr>
													<c:choose>
														<c:when test="${num.count <= 3}">
															<th class="text-center"><p class="m-1"><i class="fas fa-crown"></i></p><span>${num.count }</span></th>
														</c:when>
														<c:otherwise>
															<th class="text-center">${num.count }</th>
														</c:otherwise>
													</c:choose>
													<td class="text-center">${ranker.mem_nickname}</td>
													<td class="text-center">${ranker.cnt }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- table end -->
						</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>