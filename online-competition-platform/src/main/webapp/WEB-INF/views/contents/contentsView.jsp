<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
 <script src="${contextPath}/resources/plugins/common/common.min.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>
    <script src="${contextPath}/resources/js/settings.js"></script>
    <script src="${contextPath}/resources/js/gleek.js"></script>
    <script src="${contextPath}/resources/js/styleSwitcher.js"></script>
    <link rel="icon" type="${contextPath}/resources/image/png" sizes="16x16" href="images/favicon.png">
    
<style>
	.heart:hover {
	color:#c0d126;
	}
	
	table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
  
</style>

<div id="main-wrapper" style="width:88%; margin: 0 auto;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<div class="card" style="padding:10px;">
					<div class="card-header bg-white">
						<h3 class="card-title" style="font-size: 25px">
							<strong>${contentsView[0].contents_name}</strong>
						</h3>
						<h5>
							<span class=" text-muted">제출자 : </span>${contentsView[0].mem_name}
						</h5>
						<h5 class="card-subtitle mb-2">
							<span class=" text-muted">제출일 : </span>
							${contentsView[0].contents_processing_date}
						</h5>
						<h5 class="card-subtitle mb-2">
							<span class="text-muted">조회수 : </span>
							${contentsView[0].contents_view}
						</h5>
						<hr />
					</div>
					<div class="card-body">
						<p class="card-text">${contentsView[0].contents_text}</p>
						<img class="img-fluid" 
					src="${contextPath}/contentsFile_download.do?contents_file_id=${contentsFileView[0].contents_file_id}&contents_file_name=${contentsFileView[0].contents_file_name}&contents_file_type=${contentsFileView[0].contents_file_type}">
					</div>
					<div class="card-footer">
						<div class="col-lg-12">  
                <div class="like_icon" style="display: flex; justify-content: center; padding:20px;">
                   <a href="" class="heart"><i class="far fa-heart  fa-3x"></i>50</a> 
                </div>              
                    <div class="card-body">
                            <div class="message_box col-lg-12">
                                <button class="btn btn-outline-success float-right" style="margin:15px;" onclick="fn_addCmt(event)">댓글달기</button> 
                                <textarea class="form-control float-right col-lg-10" name="textarea" id="textarea" cols="50" rows="3" style="width:80%;" placeholder="댓글을 입력해주세요." onclick="fn_articleForm('${loginStatus}')"></textarea>
                            </div>          
                    </div>
                    <br /><br /><br />
                    <div class="card">
                    <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table verticle-middle" >
                                        <tbody>
                                        <c:forEach var="cmtList" items="${contentsCmt}">
                                            <tr>
                                                <td class="memName" width="30px">${cmtList.mem_name}</td>
                                                <td class="cmtText" width="150px">${cmtList.cmt_text}</td>
                                                <td class="cmtDelete" width="10px"><span><a href="#" data-toggle="tooltip" data-placement="top" title="Edit"> </a><a href="#" data-toggle="tooltip" data-placement="top" title="Close"><i class="fa fa-close color-danger"></i></a></span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                </div>
                                </div>
                            </div>
                        </div>
                      </div>
					</div>
				</div>
			</div>
		</div>

		<script>
			function fn_addCmt(e){
				const cmt = e.target.parentNode.querySelector("textarea").value
				console.log(cmt);
			}
			
			function fn_articleForm(loginStatus){
				
				  if (loginStatus == "member" || loginStatus == "admin"){
				    location.href= "${contextPath}/qna/qnaForm.do?compet_id=${compet_id}";
				  } else {
				    alert("로그인 후 글쓰기가 가능합니다.");
				  }
				}
		</script>