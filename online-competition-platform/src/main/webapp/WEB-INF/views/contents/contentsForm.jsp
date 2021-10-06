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
            	<input type="text" class="form-control" id="contents_name" placeholder="컨텐츠 제목">
            </div>
        </div>
    </div>
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
                <button id="submit" class="btn btn-secondary btn-rounded mb-lg-5" type="button">
                    제출하기
                </button>
            </div>
        </div>
    </div>
</compet-detail>

<script>
let contents_file_list = ""; //컨텐츠 정상 제출 후, contents id 수정해야 할 contents file들
const uploadedImgArr = [];

function search(arr, img){
	for (let e of arr){
		if (e == img){
			return true;
		}
	}
	return false;
}

window.addEventListener("load", ()=>{
	// textarea에 사진이 업로드될 경우,
    const summernote = document.querySelector("#summernote");
	
    summernote.addEventListener("DOMSubtreeModified", (e) => {
        if (e.target.tagName === "P") {
        	const uploadedImg = e.target.getElementsByTagName("img")[0];
        	if (uploadedImg != undefined && !search(uploadedImgArr, uploadedImg)) {
        		uploadedImgArr.push(uploadedImg);
        		upload(uploadedImg);
        	}
        }
    });
    
	document.getElementById("submit").addEventListener("click", (e)=>{
		e.preventDefault();
		const form = document.createElement("form");
		form.method = "post";
		form.action = "/ocp/contents/addContents.do";
		
		const compet_id = document.createElement("input");
		compet_id.name = "compet_id";
		compet_id.value = "${compet_id}";
		
		const mem_id = document.createElement("input");
		mem_id.name = "mem_id";
		mem_id.value = "${mem_id}";
		
		const contents_name = document.createElement("input");
		contents_name.name = "contents_name";
		contents_name.value = document.getElementById("contents_name").value;
		
		const contents_text = document.createElement("input");
		contents_text.name = "contents_text";
		const textarea = document.querySelector("#summernote > div.note-editor.note-frame.panel.panel-default > div.note-editing-area > div.note-editable.panel-body").innerHTML;
		contents_text.value = textarea;
		
		const constents_file_list_input = document.createElement("input");
		constents_file_list_input.name = "constents_file_list";
		constents_file_list_input.value = contents_file_list;
		
		form.appendChild(compet_id);
		form.appendChild(mem_id);
		form.appendChild(contents_name);
		form.appendChild(contents_text);
		form.appendChild(constents_file_list_input);
		
		document.body.appendChild(form);
		form.submit();
	});
})

function upload(uploadedImg){
	if (uploadedImg !== undefined){
	const srcData = uploadedImg.getAttribute("src");
	let fileName = uploadedImg.getAttribute("data-filename"); //이미지 이름
    
    //srcData = data:image/{이미지 확장자};base64,{인코딩된 파일}
	const commaIdx = srcData.indexOf(",");
	const semicolonIdx = srcData.indexOf(";");
	const slashIdx = srcData.indexOf("/");
	const base64 = srcData.slice(commaIdx + 1); // base64로 인코딩 되어 있는 이미지 데이터
	let ext = srcData.slice(slashIdx + 1, semicolonIdx);
	if (ext === "jpeg"){
		ext = "jpg";
	}
	if (fileName === null){
		const date = new Date();
		fileName = String(date.getFullYear()) + String(date.getMonth() + 1) + String(date.getDate()) + String(date.getHours())
		+ String(date.getMinutes()) + String(date.getSeconds()) + '.' + ext;
	}
	
    
	//ajax 요청 객체 생성
	const xhr = new XMLHttpRequest();

	//서버에게 비동기 응답을 받았을 때 발생하는 이벤트 함수 정의
	xhr.onreadystatechange = function () {
		if (xhr.readyState === xhr.DONE && xhr.status === 200) { //정상 응답 시
			contents_file_list += xhr.responseText + ",";
			
			uploadedImg.src = "/ocp/contents/downloadImgInText.do?contents_file_id=" + xhr.responseText + "&fileName=" + fileName;
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
}

</script>