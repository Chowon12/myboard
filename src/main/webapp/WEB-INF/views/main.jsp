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
<title>게시판 목록</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>게시판</h1>
		</header>
		<hr />

		<div>
			<%@include file="header.jsp"%>
		</div>
		
		<div class="container">
		<c:if test="${not empty sessionScope.userId}">
        <table class="table">
            <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
            </thead>
            <c:if test="${empty requestScope.boardList}">  
            	<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>  
            </c:if>
            <c:forEach items="${requestScope.boardList}" var="board">
            <tbody>
             	<tr>
	             	<td bgcolor="">
			            <p align="center">
				            <span style="font-size:12pt;">
				            	<!-- 글 번호 -->
				            	<b>${board.fileNo}</b>
				            </span>
			            </p>
			        </td>
			        <td bgcolor="">
						<p align="center">
							<span style="font-size:12pt;">
								<!--
									제목 클릭 시, 해당 게시물 출력
								 -->
								<b>
									<a href="board/${board.fileNo}">${board.title}</a>
								</b>
							</span>
						</p>
			        </td>
			        <td bgcolor="">
			            <p align="center">
			            	<span style="font-size:12pt;">
			            		<!-- 작성자 -->
			             		<b>${board.writer}</b>
			             	</span>
			             </p>
			        </td>
			        <td bgcolor="">
			            <p align="center">
			            	<span style="font-size:12pt;">
			            		<!-- 작성일 -->
			             		<b>${board.regDate}</b>
			             	</span>
			             </p>
			        </td>
		        </tr>
            </tbody>
            </c:forEach>
            
        </table>
        </c:if>
        
        <c:if test="${empty sessionScope.userId}">
			<div align="center">
	  		<span style="font-size:12pt;">존재하는 게시물이 없습니다.</span>
			</div>
		</c:if>
    </div>
    <hr />

		<div class="container">
			<!-- https://getbootstrap.com/docs/5.3/forms/form-control/ -->
			<div>
				<form id="mainForm" class="row justify-content-center g-3"
					action="/main" method="GET" onsubmit="checkKeyword()">
					<div class="col-auto">
						<label for="keyword" class="visually-hidden">검색</label> <input
							type="text" class="form-control" id="searchKeyword"
							placeholder="SearchKeyword" name="searchKeyword"
							value="${pageInfo.pageRequest.searchKeyword}">
						<!-- hidden -->
						<input name="pageNum" type="hidden"
							value="${pageInfo.pageRequest.pageNum}"> <input
							name="amount" type="hidden"
							value="${pageInfo.pageRequest.amount}">
					</div>
					<div class="col-auto">
						<input type="submit" class="btn btn-primary mb-3" value="검색" />
					</div>
				</form>
			</div>
			<!-- https://getbootstrap.com/docs/5.3/components/list-group/ -->
			<div class="row justify-content-center">
				<div class="col-6">
					<ul class="list-group">
						<c:if test="${not empty boardList}">
							<c:forEach var="board" items="${boardList}">
								<li
									class="list-group-item d-flex justify-content-between align-items-start">
									<div class="ms-2 me-auto">
										<div class="fw-bold">${board.title}</div>
										${board.context}
									</div>
								</li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
			</div>
			<!-- Paging -->
			<!-- https://getbootstrap.com/docs/5.3/layout/columns/#alignment -->
			<!-- https://getbootstrap.com/docs/5.3/components/pagination/#disabled-and-active-states -->
			<div class="row justify-content-center">
				<div class="col-auto">
					<nav class="page navigation">
						<ul class="pagination">
							<c:if test="${pageInfo.prev}">
								<li class="page-item"><a class="page-link"
									aria-label="Previous"
									href="/main?pageNum=${pageInfo.startPage - 1}&amount=${pageInfo.pageRequest.amount}">이전</a>
								</li>
							</c:if>
							<c:forEach var="num" begin="${pageInfo.startPage}"
								end="${pageInfo.endPage}">
								<li class="page-item ${pageInfo.pageRequest.pageNum == num ? "active" : "" } ">
									<a class="page-link"
									href="/main?pageNum=${num}&amount=${pageInfo.pageRequest.amount}&searchKeyword=${pageInfo.pageRequest.searchKeyword}">${num}</a>
								</li>
							</c:forEach>
							<c:if test="${pageInfo.next}">
								<li class="page-item next"><a class="page-link"
									aria-label="next"
									href="/main?pageNum=${pageInfo.endPage + 1}&amount=${pageInfo.pageRequest.amount}">다음</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- 페이징 버튼 클릭시 => pageNum, amount, keyword -->
		<script type="text/javascript">
		//step01 : 페이징 버튼 클릭시 지정 url 요청 갈수 있도록 이벤트 등록
		Array.from(document.getElementsByClassName('page-link'))
			.forEach((pagingButton) => {
				pagingButton.addEventListener('click', function(e) {
					e.preventDefault();
					// step02 : 등록 후, action : '/main' 으로 요청 시, keyword 값 유무에 따라 queryString 변경
					// step03 : 요청
					let mainForm = document.getElementById('mainForm');
					
					// 현재 페이지 값으로 변경하여 /main 요청하도록 지정
					mainForm.pageNum.value = e.target.innerHTML;
					
					if(mainForm.searchKeyword.value === '' || mainForm.searchKeyword.value === null) {
						mainForm.searchKeyword.remove();
					}
					
					mainForm.action = '/main';
					mainForm.method = 'GET';
					mainForm.submit();
				})
		})
	
		function checkKeyword() {
			let mainForm = document.getElementById('mainForm');
			if(mainForm.searchKeyword.value === null || mainForm.searchKeyword.value === '') {
				mainForm.searchKeyword.remove();
			}
		}
		
		
		
			<div>
				<%@include file="footer.jsp"%>
			</div>
		</div>
	</body>
</html>