<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
    <meta charset="utf-8">
    <link href="css/style.css" rel="stylesheet">
    <style>
        hr {
            border-top: 3px solid gray;
        }
    </style>
</head>

<div class="container">
    <!-- sub-header -->
    <div class="row my-3">
        <h2><b>대회 목록</b></h2>
        <hr class="w-100 my-2">
    </div>
    <!-- dropdowns -->
    <div class="row my-lg-3">
        <div class="col-lg-9">
            <div class="row mb-3">
                <div class="basic-dropdown col-lg-2 mb-1">
                    <div class="dropdown">
                        <button type="button" id="categ-btn" class="btn btn-success dropdown-toggle"
                            data-toggle="dropdown">
                            <b>카테고리</b>
                        </button>
                        <div class="dropdown-menu" id="dropdown-menu">
                            <a class="dropdown-item" href="#">알고리즘</a>
                            <a class="dropdown-item" href="#">빅데이터</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- competition start -->
    <div class="row">
        <div class="card mb-3 col-lg-12">

            <div class="row g-0">
                <div class="col-lg-4">
                    <img src="images/imgs/1.jpg" class="img-fluid h-100 p-1" alt="...">
                </div>
                <div class="col-lg-6">
                    <div class="card-body">
                        <h5 class="card-title">해양과학 빅데이터 활용 경진대회</h5>
                        <p class="card-text">
                            This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.
                        </p>
                        <p class="card-text"><small class="text-muted">2021-08-01 ~ 2021-08-31</small></p>
                    </div>
                </div>
                <div class="col-lg-2 mb-md-3 my-auto text-center">
                    <div class="btn btn-outline-success">
                        <b>자세히 보기</b>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- competition end -->
    <!-- competition start -->
    <div class="row">
        <div class="card mb-3 col-lg-12">

            <div class="row g-0">
                <div class="col-lg-4">
                    <img src="images/imgs/2.png" class="img-fluid h-100 p-1" alt="...">
                </div>
                <div class="col-lg-6">
                    <div class="card-body">
                        <h5 class="card-title">해양과학 빅데이터 활용 경진대회</h5>
                        <p class="card-text">
                            This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.
                        </p>
                        <p class="card-text"><small class="text-muted">2021-08-01 ~ 2021-08-31</small></p>
                    </div>
                </div>
                <div class="col-lg-2 mb-md-3 my-auto text-center">
                    <div class="btn btn-outline-success">
                        <b>자세히 보기</b>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- competition end -->
    <!-- competition start -->
    <div class="row">
        <div class="card mb-3 col-lg-12">

            <div class="row g-0">
                <div class="col-lg-4">
                    <img src="images/imgs/3.png" class="img-fluid h-100 p-1" alt="...">
                </div>
                <div class="col-lg-6">
                    <div class="card-body">
                        <h5 class="card-title">해양과학 빅데이터 활용 경진대회</h5>
                        <p class="card-text">
                            This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.
                        </p>
                        <p class="card-text"><small class="text-muted">2021-08-01 ~ 2021-08-31</small></p>
                    </div>
                </div>
                <div class="col-lg-2 mb-md-3 my-auto text-center">
                    <div class="btn btn-outline-success">
                        <b>자세히 보기</b>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- competition end -->
</div>

<!--**********************************
        Scripts
    ***********************************-->
<script src="plugins/common/common.min.js"></script>
<script src="js/custom.min.js"></script>
<script src="js/settings.js"></script>
<script src="js/gleek.js"></script>
<script src="js/styleSwitcher.js"></script>
<script>
    const dropdownItems = Array.from(document.getElementById("dropdown-menu").children); //카테고리 드랍다운 메뉴들

    dropdownItems.forEach(e => {
        e.addEventListener('click', (evt) => {
            window.location.href = '${contextPath}/compet/competList.do?categ=' + evt.target.innerText;
        })
    });
</script>
</body>

</html>