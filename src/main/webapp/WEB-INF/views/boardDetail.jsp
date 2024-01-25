<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
	crossorigin="anonymous"></script>
<title>게시판</title>
</head>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var formObj = $("form[name='readForm']");

						// 수정 
						$(".update_btn").on("click", function() {
							formObj.attr("action", "/views/boardReg");
							formObj.attr("method", "get");
							formObj.submit();
						})

						// 삭제
						$(".delete_btn").on("click", function() {

							var deleteYN = confirm("삭제하시겠습니까?");
							if (deleteYN == true) {

								formObj.attr("action", "/views/main");
								formObj.attr("method", "post");
								formObj.submit();

							}
						})

						// 목록
						$(".list_btn")
								.on(
										"click",
										function() {

											location.href = "/main?page=${scri.page}"
													+ "&PageNum=${PageRequest.pageNum}"
													+ "&searchType=${PageRequest.searchKeyword}";
										})

						$(".commentWriteBtn").on("click", function() {
							var formObj = $("form[name='commentForm']");
							formObj.attr("action", "/views/boardDetail");
							formObj.submit();
						});

						//댓글 수정 View
						/* $(".commentUpdateBtn").on("click", function(){
							location.href = "/views/commentUpdateView?bno=${read.bno}"
											+ "&page=${scri.page}"
											+ "&perPageNum=${scri.perPageNum}"
											+ "&searchType=${scri.searchType}"
											+ "&keyword=${scri.keyword}"
											+ "&rno="+$(this).attr("data-rno");
						});  */

						//댓글 삭제 View
						/* $(".commentDeleteBtn").on("click", function(){
							location.href = "/views/commentDeleteView?bno=${read.bno}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&rno="+$(this).attr("data-rno");
						}); */
					})
</script>

<body>
	<div class="container">
		<header>
			<h1>게시판</h1>
		</header>
		<hr />

		<div>
			<%@include file="header.jsp"%>
		</div>

		<section id="container">
			<form name="readForm" role="form" method="post">
				<input type="hidden" id="bno" name="bno" value="${board.fileNo}" />
				<input type="hidden" id="page" name="page" value="${scri.page}">
				<input type="hidden" id="perPageNum" name="perPageNum"
					value="${scri.perPageNum}"> <input type="hidden"
					id="searchType" name="searchType" value="${scri.searchType}">
				<input type="hidden" id="keyword" name="keyword"
					value="${scri.keyword}">
			</form>

			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제목</label> <input
					type="text" id="title" name="title" class="form-control"
					value="${board.title}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label for="context" class="col-sm-2 control-label">내용</label>
				<textarea id="context" name="context" class="form-control"
					readonly="readonly"><c:out value="${board.context}" /></textarea>
			</div>
			<div class="form-group">
				<label for="writer" class="col-sm-2 control-label">작성자</label> <input
					type="text" id="writer" name="writer" class="form-control"
					value="${board.writer}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label for="regDate" class="col-sm-2 control-label">작성날짜</label>
				<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
			</div>

			<div>
				<button type="button" class="update_btn btn btn-warning">수정</button>
				<button type="button" class="delete_btn btn btn-danger">삭제</button>
				<button type="button" class="list_btn btn btn-primary">목록</button>
			</div>

			<!-- 댓글 -->
			<div id="comment">
				<ol class="commentList">
					<c:forEach items="${comment}" var="commentList">
						<li>
							<p>
								작성자 : ${comment.writer}<br /> 작성 날짜 :
								<fmt:formatDate value="${comment.date}" pattern="yyyy-MM-dd" />
							</p>

							<p>${replyList.content}</p>
							<div>
								<button type="button" class="commentUpdateBtn btn btn-warning"
									data-rno="${comment.id}">수정</button>
								<button type="button" class="commentDeleteBtn btn btn-danger"
									data-rno="${comment.id}">삭제</button>
							</div>
						</li>
					</c:forEach>
				</ol>
			</div>

			<form name="commentForm" method="post" class="form-horizontal">
				<input type="hidden" id="id" name="id" value="${board.fileNo}" /> <input
					type="hidden" id="page" name="page" value="${scri.page}"> <input
					type="hidden" id="perPageNum" name="perPageNum"
					value="${scri.perPageNum}"> <input type="hidden"
					id="searchType" name="searchType" value="${scri.searchType}">
				<input type="hidden" id="keyword" name="keyword"
					value="${scri.keyword}">

				<div class="form-group">
					<label for="writer" class="col-sm-2 control-label">댓글 작성자</label>
					<div class="col-sm-10">
						<input type="text" id="writer" name="writer" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label for="content" class="col-sm-2 control-label">댓글 내용</label>
					<div class="col-sm-10">
						<input type="text" id="context" name="context"
							class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="commentWriteBtn btn btn-success">작성</button>
					</div>
				</div>
			</form>
		</section>
		<hr />
	</div>
</body>
</html>