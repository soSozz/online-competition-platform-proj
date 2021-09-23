<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %> <%@ taglib
uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<link href="${contextPath}/resources/css/main.css" rel="stylesheet">

    <div id="carousel" class="row justify-content-lg-center my-lg-3">
        <div class="col-lg-12">
        <div class="bootstrap-carousel">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100 h-100" src="/ocp/bannerFile_download.do?banner_id=${bannerFileList[0].banner_id }&banner_file_name=${bannerFileList[0].banner_file_name }&banner_file_type=${bannerFileList[0].banner_file_type}" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100 h-100" src="/ocp/bannerFile_download.do?banner_id=2&banner_file_name=banner2.jpg&banner_file_type=img" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100 h-100" src="/ocp/bannerFile_download.do?banner_id=3&banner_file_name=banner3.jpg&banner_file_type=img" alt="Third slide">
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
    <div class="row justify-content-lg-center">
        <!-- start card -->
        <div class="card">
            <div class="card-body">
                <h2 class="mb-lg-3"><strong>알고리즘</strong></h2>
                <div class="row justify-content-lg-center">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card">
                                    <img class="img-fluid" src="https://via.placeholder.com/400x400.png?text=Visit+WhoIsHostingThis.com+Buyers+Guide" alt="" />
                                    <div class="card-body">
                                        <h5 class="card-title">최단경로 찾기</h5>
                                        <p class="card-text text-truncate">
                                            2021.09.10. ~ 2021.10.10.
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#" class="card-link float-right"><small>자세히 보기</small></a>
                                    </div>
                                </div>
                            </div>
                            <!-- End Col -->
                            <div class="col-lg-4">
                                <div class="card">
                                    <img class="img-fluid" src="https://via.placeholder.com/400x400.png?text=Visit+WhoIsHostingThis.com+Buyers+Guide" alt="" />
                                    <div class="card-body">
                                        <h5 class="card-title">버블탐색</h5>
                                        <p class="card-text text-truncate">
                                            2021.05.13. ~ 2021.06.08.
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#" class="card-link float-right"><small>자세히 보기</small></a>
                                    </div>
                                </div>
                            </div>
                            <!-- End Col -->
                            <div class="col-lg-4">
                                <div class="card">
                                    <img class="img-fluid" src="https://via.placeholder.com/400x400.png?text=Visit+WhoIsHostingThis.com+Buyers+Guide" alt="" />
                                    <div class="card-body">
                                        <h5 class="card-title">하노이의 탑</h5>
                                        <p class="card-text text-truncate">
                                            2021.11.13. ~ 2021.12.25.
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#" class="card-link float-right"><small>자세히 보기</small></a>
                                    </div>
                                </div>
                            </div>
                            <!-- End Col -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end card -->
        <!-- start card -->
        <div class="card">
            <div class="card-body">
                <h2 class="mb-lg-3"><strong>빅데이터</strong></h2>
                <div class="row justify-content-lg-center">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card">
                                    <img class="img-fluid" src="https://via.placeholder.com/400x400.png?text=Visit+WhoIsHostingThis.com+Buyers+Guide" alt="" />
                                    <div class="card-body">
                                        <h5 class="card-title">AI대회</h5>
                                        <p class="card-text text-truncate">
                                            2021.08.10. ~ 2021.10.01.
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#" class="card-link float-right"><small>자세히 보기</small></a>
                                    </div>
                                </div>
                            </div>
                            <!-- End Col -->
                            <div class="col-lg-4">
                                <div class="card">
                                    <img class="img-fluid" src="https://via.placeholder.com/400x400.png?text=Visit+WhoIsHostingThis.com+Buyers+Guide" alt="" />
                                    <div class="card-body">
                                        <h5 class="card-title">교통 데이터 시각화 대회</h5>
                                        <p class="card-text text-truncate">
                                            2021.07.05. ~ 2021.08.03.
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#" class="card-link float-right"><small>자세히 보기</small></a>
                                    </div>
                                </div>
                            </div>
                            <!-- End Col -->
                            <div class="col-lg-4">
                                <div class="card">
                                    <img class="img-fluid" src="https://via.placeholder.com/400x400.png?text=Visit+WhoIsHostingThis.com+Buyers+Guide" alt="" />
                                    <div class="card-body">
                                        <h5 class="card-title">인공지능 모델 경진 대회</h5>
                                        <p class="card-text text-truncate">
                                            2021.07.05. ~ 2021.08.03.
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#" class="card-link float-right"><small>자세히 보기</small></a>
                                    </div>
                                </div>
                            </div>
                            <!-- End Col -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<!-- end card -->
	</div>
	<!-- end row -->