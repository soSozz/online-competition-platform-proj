class competDetail extends HTMLElement {
	constructor() {
		super();
		this.containerBodyInner = this.innerHTML;
		this.innerHTML = "";
	}

	connectedCallback() {
		this.render();
	}

	render() {
		const container = this.createContainer();

		const containerHeader = document.createElement("div");
		containerHeader.id = "container-header";
		const row = this.createRow();
		const nav = this.createNav();
		row.appendChild(nav);
		containerHeader.appendChild(row);

		const containerBody = document.createElement("div");
		containerBody.id = "container-body";
		containerBody.innerHTML = this.containerBodyInner;

		container.appendChild(containerHeader);
		container.appendChild(containerBody);
		this.appendChild(container);
	}

	createContainer() {
		const div = document.createElement("div");
		div.classList.add("container", "justify-content-lg-center");
		return div;
	}

	createRow() {
		const div = document.createElement("div");
		div.classList.add("row");

		const div2 = document.createElement("div");
		div2.classList.add("col-lg-12");

		div.appendChild(div2);
		return div;
	}

	createNav() {
		const ul = document.createElement("ul");
		ul.classList.add("nav", "nav-tabs", "mb-3", "justify-content-lg-center");

		const hrefArr = [
			"${contextPath}" + "/competInfo.do?compet_id=" + "${compet_id}",
			"${contextPath}/notice/compet/listCompetNotices.do?compet_id=${compet_id}",
			"${contextPath }/contents/listContents.do?compet_id=${compet_id}",
			"javascript:submitContents();",
			"${contextPath}/qna/qna.do?compet_id=${compet_id}",
		];
		const innerHTMLArr = ["대회안내", "공지사항", "컨텐츠 게시판", "제출", "문의"];

		for (let i = 0; i < hrefArr.length; i++) {
			const li = document.createElement("li");
			li.classList.add("nav-item");

			const a = document.createElement("a");
			a.classList.add("nav-link");
			a.href = hrefArr[i];
			a.innerHTML = innerHTMLArr[i];

			li.appendChild(a);
			ul.appendChild(li);
		}

		return ul;
	}
}

window.customElements.define("compet-detail", competDetail);