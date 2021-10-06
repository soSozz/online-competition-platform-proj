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

                 


							


<compet-detail>

							<div class="row">
								<div class="col-sm-12">
								<div class="card-body">
								<h4 class="card-title">공지사항</h4>
								<button type="button" class="btn btn-outline-secondary" onClick="fn_articleForm('${loginStatus}')">글쓰기</button>
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
														<td width="5%">${noticeNum.count}</td>
														<td width="25%"><a href="${contextPath}/notice/compet/noticeCompetDetail.do?compet_notice_id=${compet_Notice.compet_notice_id}">${compet_Notice.compet_notice_title }</a></td>
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
						
</compet-detail>
 <script>
    window.onload = () => {
    	document.getElementById("redirect").value =  "${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}";
    }
    
	function fn_articleForm(loginStatus){
		console.log(loginStatus)
		
	  if (loginStatus == "admin"){
	    location.href= "${contextPath}/notice/compet/noticeCompetForm.do?compet_id=${compet_id}";
	  } else {
	    alert("로그인 후 글쓰기가 가능합니다.");
	  }
	}
	
</script> 

