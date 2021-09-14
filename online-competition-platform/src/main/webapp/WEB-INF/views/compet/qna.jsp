<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%request.setCharacterEncoding("UTF-8");%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1" width="80%">
  <tr height="10" align="center" bgcolor="lightgreen">
    <td>글번호</td>
    <td>작성자</td>
    <td>제목</td>
    <td>작성일</td>
  </tr>
<c:choose>
 <c:when test="${qnaList==null} ">
<tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
</c:when>
<c:when test="${qnaList !=null }">
 <c:forEach var="qna" items="${qnaList}" varStatus="articleNum">
    <tr align="center">
	<td width="5%">${qna.compet_qna_id}</td>
	<td width="10%">${qna.compet_id }</td>
	<td align='left'  width="35%">
      <span style="padding-right:30px"></span>
  <%-- <c:choose>
	      <c:when test='${qna.level > 1 }'>  
	         <c:forEach begin="1" end="${qna.level }" step="1">
	              <span style="padding-left:20px"></span>    
	         </c:forEach>
	         <span style="font-size:12px;">[답변]</span>
                   <a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
	          </c:when>
	          <c:otherwise>
	            <a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title }</a>
	          </c:otherwise>
           </c:choose>   --%>
        </td>
	   <td  width="10%">${qna.compet_qna_date}</td> 
	  </tr>
      </c:forEach>
       </c:when>
     </c:choose>
</table>
</body>
</html>