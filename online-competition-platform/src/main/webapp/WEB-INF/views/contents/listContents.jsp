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
</head>
<body>
<div id="main-wrapper">
	<div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered zero-configuration">
                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>제목</th>
                                                <th>닉네임</th>
                                                <th>작성일</th>
                                                <th>조회수</th>
                                                <th>좋아요</th>
                                                <th>댓글</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="listContents" items="${listContents}" varStatus="status">
                                            <tr>
                                            	<td>${status.count}</td>
                                            	<td><a href="#">${listContents.contents_name}</a></td>
                                            	<td>${listContents.mem_nickname}</td>
                                            	<td>${listContents.contents_processing_date}</td>
                                            	<td>${listContents.contents_view}</td>
                                            	<td>${listContents.likes1}</td>
                                            	<td>${listContents.cmt1}</td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                        
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</div>
</body>
</html>