<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%-- <c:set var="compet_id" value="${competInfo.compet_id[0].compet_id}" /> --%>
<c:set var="competSmallFileType" value="${competPoster.competSmallPoster[0].compet_file_type}" />
<c:set var="competSmallFileName" value="${competPoster.competSmallPoster[0].compet_file_name}" />
<%
request.setCharacterEncoding("UTF-8");
%>

<style>
    h3,
    h4 {
        font-weight: bold;
    }

    .categ {
        font-size: 30px;
        font-weight: bold;
        color: black;
    }

    .competName {
        font-size: 20px;
        font-weight: bold;
        color: black;
        text-align: center;
    }

    .competEdit {
        background: orange;
        height: 35px;
    }

    .categ_btn {}

    .container-fluid {}

    .endCompet {
        color: black;
        font-weight: bold;
    }

</style>
<!DOCTYPE html>
<html>
  <head>
        <meta charset="UTF-8" />
        <title>공지사항</title>
        <style></style>
    </head>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					
					<div class="table-responsive">
						<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="col-lg-12">
                    <div class="poster">
                        <a href="${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}"
                            ><img
                                src="${contextPath}/competNoticeFile_download.do?compet_notice_id=${compet_notice_id}&compet_notice_file_name=${competSmallFileName}&compet_notice_file_type=${competSmallFileType}"
                                width="100%"
                                height="200px"
                        /></a>
                    </div>
                </div>
                 <div class="col-lg-12">
                    <ul class="nav nav-tabs mb-3 justify-content-lg-center">
                        <li class="nav-item"> <a class="nav-link" href="${contextPath}/compet/competInfo.do?compet_id=${compet_id}">대회안내</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}" >공지사항</a > </li>
                        <li class="nav-item"><a class="nav-link" href="${contextPath }/contents/listContents.do?compet_id=${compet_id}">컨텐츠 게시판</a></li>
                        <li class="nav-item"><a class="nav-link" href="javascript:submitContents('${loginStatus }', '${loginInfo }');">제출</a></li>
                        <li class="nav-item"> <a class="nav-link" href="${contextPath}/qna/qna.do?compet_id=${compet_id}">문의</a> </li>
                    </ul>
                </div>
							<div class="container">
							<div class="row">
								<div class="col-sm-12">
								<div class="card-body">
								<h4 class="card-title">공지사항</h4>
									<table class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr role="row">
												<th class="No">No.</th>
												<th class="categ_name">제목</th>
												<th class="compet_name" style="width: 105.656px;">작성자</th>
												<th class="compet_start" style="width: 95.7188px;">작성일</th>
												<th class="compet_end sorting"style="width: 79.8906px;">조회수</th>

											</tr>
										</thead>
										<tbody>

											<c:if test="${noticeCompetList !=null }">
												<c:forEach var="compet_Notice" items="${noticeCompetList}" varStatus="noticeNum">
													<tr align="center">
														<td width="5%">${compet_Notice.compet_notice_id}</td>
														<td width="25%">${compet_Notice.compet_notice_title }</td>
														<td width="5%">${compet_Notice.admin_id}</td>
														<td width="5%">${compet_Notice.compet_notice_date}</td>
														<td width="5%">${compet_Notice.compet_notice_view}</td>
													</tr>
												</c:forEach>
											</c:if>

										</tbody>
									</table>
								</div>
							</div>
							</div>
							</div>
							<div class="row">
								<div class="col-sm-12 col-md-5">
									<div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">Showing 1 to 10 of 57
										entries</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</html>
