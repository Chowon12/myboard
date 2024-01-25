<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
	<!-- https://getbootstrap.com/docs/5.3/forms/form-control/ -->
	<div>
		<form class="row justify-content-center g-3" action="/search/keyword" method="GET">
			<div class="col-auto">
				<label for="keyword" class="visually-hidden">Search</label> 
					<input	
						type="text" 
						class="form-control" 
						id="searchKeyword"
						placeholder="SearchKeyword" 
						name="searchKeyword">
			</div>
			<div class="col-auto">
					<input type="submit" class="btn btn-primary mb-3" value="Search" />
			</div>
		</form>
	</div>
	<!-- https://getbootstrap.com/docs/5.3/components/list-group/ -->
	<div class="row justify-content-center">
		<div class="col-6">
			<ul class="list-group">
				<c:if test="${not empty boardList}">
					<c:forEach var="notice" items="${boardList}">
						<li class="list-group-item d-flex justify-content-between align-items-start">
							<div class="ms-2 me-auto">
								<div class="fw-bold">${board.title}</div>
								${notice.context}
							</div> <span class="badge bg-primary rounded-pill">${notice.regDate}</span>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</div>
	
</body>
</html>