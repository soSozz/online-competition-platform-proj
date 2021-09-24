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
            <h3 class="m-lg-2 text-center"><b>최근 종료된 대회</b></h3>
            <div class="bootstrap-carousel">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <!-- table start -->
                        <div class="carousel-item active">
                            <div class="card-title">
                                <h4>대회1</h4>
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
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">1</span></th>
                                            <td class="text-center">치킨치킨</td>
                                            <td class="text-center">100</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">2</span></th>
                                            <td class="text-center">푸른하루</td>
                                            <td class="text-center">95</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">3</span></th>
                                            <td class="text-center">실력자</td>
                                            <td class="text-center">90</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">4</th>
                                            <td class="text-center">닉네임1</td>
                                            <td class="text-center">85</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">5</th>
                                            <td class="text-center">닉네임2</td>
                                            <td class="text-center">80</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">6</th>
                                            <td class="text-center">닉네임3</td>
                                            <td class="text-center">75</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">7</th>
                                            <td class="text-center">닉네임4</td>
                                            <td class="text-center">70</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">8</th>
                                            <td class="text-center">닉네임5</td>
                                            <td class="text-center">65</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">9</th>
                                            <td class="text-center">닉네임6</td>
                                            <td class="text-center">60</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">10</th>
                                            <td class="text-center">닉네임7</td>
                                            <td class="text-center">55</td>
                                        </tr>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- table end -->
                        <!-- table start -->
                        <div class="carousel-item">
                            <div class="card-title">
                                <h4>대회2</h4>
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
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">1</span></th>
                                            <td class="text-center">치킨치킨</td>
                                            <td class="text-center">100</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">2</span></th>
                                            <td class="text-center">푸른하루</td>
                                            <td class="text-center">95</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">3</span></th>
                                            <td class="text-center">실력자</td>
                                            <td class="text-center">90</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">4</th>
                                            <td class="text-center">닉네임1</td>
                                            <td class="text-center">85</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">5</th>
                                            <td class="text-center">닉네임2</td>
                                            <td class="text-center">80</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">6</th>
                                            <td class="text-center">닉네임3</td>
                                            <td class="text-center">75</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">7</th>
                                            <td class="text-center">닉네임4</td>
                                            <td class="text-center">70</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">8</th>
                                            <td class="text-center">닉네임5</td>
                                            <td class="text-center">65</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">9</th>
                                            <td class="text-center">닉네임6</td>
                                            <td class="text-center">60</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">10</th>
                                            <td class="text-center">닉네임7</td>
                                            <td class="text-center">55</td>
                                        </tr>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- table end -->
                        <!-- table start -->
                        <div class="carousel-item">
                            <div class="card-title">
                                <h4>대회3</h4>
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
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">1</span></th>
                                            <td class="text-center">치킨치킨</td>
                                            <td class="text-center">100</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">2</span></th>
                                            <td class="text-center">푸른하루</td>
                                            <td class="text-center">95</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center"><span class="badge badge-success px-2">3</span></th>
                                            <td class="text-center">실력자</td>
                                            <td class="text-center">90</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">4</th>
                                            <td class="text-center">닉네임1</td>
                                            <td class="text-center">85</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">5</th>
                                            <td class="text-center">닉네임2</td>
                                            <td class="text-center">80</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">6</th>
                                            <td class="text-center">닉네임3</td>
                                            <td class="text-center">75</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">7</th>
                                            <td class="text-center">닉네임4</td>
                                            <td class="text-center">70</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">8</th>
                                            <td class="text-center">닉네임5</td>
                                            <td class="text-center">65</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">9</th>
                                            <td class="text-center">닉네임6</td>
                                            <td class="text-center">60</td>
                                        </tr>
                                        <tr>
                                            <th class="text-center">10</th>
                                            <td class="text-center">닉네임7</td>
                                            <td class="text-center">55</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- table end -->
                    </div>
                </div>
            </div>
        </div>
    </div>