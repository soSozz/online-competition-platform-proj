<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link href="${contextPath }/resources/plugins/summernote/dist/summernote.css" rel="stylesheet" />

<compet-detail>
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div id="summernote" class="card-body">
                    <div class="summernote">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="text-center">
                <button id="save" class="btn btn-secondary btn-rounded mb-lg-5" onclick="save()" type="button">
                    제출하기
                </button>
            </div>
        </div>
    </div>
</compet-detail>

<script>
const contents_file_id_list = []

window.addEventListener("load", ()=>{
	// textarea에 사진이 업로드될 경우,
    const summernote = document.querySelector("#summernote");
    summernote.addEventListener("DOMSubtreeModified", (e) => {
        if (e.target.tagName === "P") {
            const uploadedImg = e.target.getElementsByTagName("img")[0]; //업로드된 이미지
            const fileName = uploadedImg.getAttribute("data-filename"); //이미지 이름
            const srcData = uploadedImg.src;
            
            //srcData = data:image/{이미지 확장자};base64,{인코딩된 파일}
            const commaIdx = srcData.indexOf(",");
            const semicolonIdx = srcData.indexOf(";");
            const slashIdx = srcData.indexOf("/");
            const base64 = srcData.slice(commaIdx + 1); // base64로 인코딩 되어 있는 이미지 데이터
            const ext = srcData.slice(slashIdx + 1, semicolonIdx);
            
    		//ajax 요청 객체 생성
    		const xhr = new XMLHttpRequest();

    		//서버에게 비동기 응답을 받았을 때 발생하는 이벤트 함수 정의
    		xhr.onreadystatechange = function () {
    			if (xhr.readyState === xhr.DONE && xhr.status === 200) { //정상 응답 시
    				const contents_file_id = parseInt(xhr.responseText);
    				contents_file_id_list.push(contents_file_id);
    				
    				uploadedImg.src = "/ocp/contents/downloadImgInText.do?contents_file_id=" + contents_file_id + "&fileName=" + fileName;
    			}
    		};

    		//요청 방식과 요청 url 설정
    		//true: 비동기 설정
    		xhr.open("POST", '${contextPath}/contents/uploadImgInText.do', true);
    		//서버에 요청 보내기
			xhr.send(JSON.stringify({
			"base64": base64,
			"fileName": fileName,
			"ext": ext
		}))

            
            
        }
        
        
    });
})

</script>