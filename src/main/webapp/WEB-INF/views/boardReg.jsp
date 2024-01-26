<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    /* 이 부분을 원하는 값으로 조절하세요. */
    .form-group {
        margin-bottom: 10px; /* 아래쪽 간격 조절 */
        
    }
    .wide-textarea {
        width: 100%; /* 전체 폭을 사용하도록 설정 */
        height: 500px; /* 원하는 높이로 조절 */
        resize: none; /* 드래그로 크기 조절 비활성화 */
    }
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<div class="container">
		<header>
			<h1> 게시판</h1>
		</header>
		<hr />
		 
		<div>
			<%-- <%@include file="nav.jsp" %> --%>
		</div>
		
		<section id="container">
		    <form id="myForm" role="form" method="post" action="/board">
		        <div class="form-group">
		            <label for="title" class="col-sm-2 control-label">제목</label>
		            <c:choose>
		            	<c:when test="${empty board}">
		            		<input type="text" id="title" name="title" class="form-control"/>	
		            	</c:when>
		            	<c:otherwise>
		            		<input type="text" id="title" name="title" class="form-control" value="${board.title}"/>
		            	</c:otherwise>
		            </c:choose>  
		        </div>
		        <div class="form-group">
		            <label for="content" class="col-sm-2 control-label">내용</label>
		            <c:choose>
		            	<c:when test="${empty board}">		           
		            		<textarea id="content" name="content" class="form-control wide-textarea"></textarea>
		        		</c:when>
		        		<c:otherwise>
		        			<textarea id="content" name="content" class="form-control wide-textarea">${board.context}</textarea>
		        		</c:otherwise>		        	
		        	</c:choose>
		        
		        </div>                            
		        <div class="form-group" style="text-align: right;">
		            <button type="submit" class="update_btn btn btn-warning">등록</button>    
		        </div>
		    </form>
		</section>
		<hr />
	</div>
</div>

    <hr class="my-4">
    <div class="row">
        <div class="col">
            <button class="w-100 btn btn-primary btn-lg" type="submit">게시글 등록</button>
        </div>
        <div class="col">
            <button class="w-100 btn btn-secondary btn-lg"
                    onclick="location.href='boards.html'"
                    th:onclick="|location.href='@{/boards}'|"
                    type="button">취소</button>
        </div>
    </div>
</form>
</body>
</html>