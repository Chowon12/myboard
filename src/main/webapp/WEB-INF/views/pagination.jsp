<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	<!-- https://getbootstrap.com/docs/5.3/components/list-group/ -->
	<!-- https://getbootstrap.com/docs/5.3/components/pagination/ -->
	<div class="row justify-content-center">
		<div class="col-6">
			<ul class="list-group">
				<c:if test="${not empty boardList}">
					<c:forEach var="notice" items="${boardList}">
						<li class="list-group-item d-flex justify-content-between align-items-start">
							<div class="ms-2 me-auto">
								<div class="fw-bold">${board.title}</div>
								${board.context}
							</div> <span class="badge bg-primary rounded-pill">${board.regDate}</span>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
 	<div class="row justify-content-center">
		<div class="col-auto">
			<nav class="page navigation">
				<ul class="pagination">
					<c:if test="${pageInfo.prev}">
						<li class="page-item">
							<a class="page-link" aria-label="Previous" 
								href="/page?pageNum=${pageInfo.startPage - 1}&amount=${pageInfo.pageRequest.amount}">Prev</a>
						</li>
					</c:if>
					<c:forEach var="num" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
						<li class="page-item ${pageInfo.pageRequest.pageNum == num? "active" : ""}">
							<a class="page-link" 
								href="/page?pageNum=${num}&amount=10">${num}</a>
						</li>
					</c:forEach>
					<c:if test="${pageInfo.next}">
						<li class="page-item next">
							<a class="page-link" aria-label="next" 
								href="/page?pageNum=${pageInfo.endPage + 1}&amount=${pageInfo.pageRequest.amount}">Next</a>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	</div>

</body>
</html>