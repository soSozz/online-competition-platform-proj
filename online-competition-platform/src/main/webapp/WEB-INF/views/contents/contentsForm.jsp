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
                <div class="card-body">
                    <div class="summernote">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body" id="file-input-box">
                    <div class="custom-file mb-lg-3">
                        <input type="file" class="custom-file-input" />
                        <label class="custom-file-label">Choose file</label>
                    </div>
                    <button id="add-file" class="btn btn-outline-secondary float-right">파일 추가</button>
                </div>
            </div>
            <div class="text-center">
                <button id="save" class="btn btn-secondary btn-rounded mb-lg-5" onclick="save()" type="button">
                    제출하기
                </button>
            </div>
        </div>
    </div>
</compet-detail>

<script>
    const fileInputBox = document.getElementById("file-input-box");
    const addFileBtn = document.getElementById("add-file");

    addFileBtn.addEventListener("click", (e) => {
        const fileInput = document.getElementsByClassName("custom-file")[0].cloneNode(true);
        fileInputBox.insertBefore(fileInput, e.target);
    });

</script>