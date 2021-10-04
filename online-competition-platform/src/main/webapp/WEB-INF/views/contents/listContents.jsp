<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>


<compet-detail>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div class="table-responsive">
								<table
									class="table table-striped table-bordered zero-configuration">
									<thead>
										<tr>
											<th>No.</th>
											<th>제목</th>
											<th>닉네임</th>
											<th>작성일</th>
											<th>조회수</th>
										</tr>
									</thead>
									<c:choose>
							<c:when test="${listContents == null} ">
								<tr height="10">
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 9pt">등록된 댓글이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
									<tbody>
										<c:forEach var="listContents" items="${listContents}" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td><a href="${contextPath}/contents/contentsView.do?contents_id=${listContents.contents_id}">${listContents.contents_name}</a></td>
												<td>${listContents.mem_name}</td>
												<td>${listContents.contents_processing_date}</td>
												<td>${listContents.contents_view}</td>
											</tr>
										</c:forEach>
									</tbody>
									</c:otherwise>
									</c:choose>
									<tfoot>

									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			</compet-detail>