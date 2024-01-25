<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>게시판</title>
<style>
	    .wide-textarea {
        width: 100%; /* 전체 폭을 사용하도록 설정 */
        height: 500px; /* 원하는 높이로 조절 */
        resize: none; /* 드래그로 크기 조절 비활성화 */
    }
</style>

</head>

<%@ include file="header.jsp" %>

<div class="container">
	<header>
		<h1> 게시판</h1>
	</header>
	<hr />
	 
<%-- 	<div>
		<%@include file="nav.jsp" %> 
	</div> --%>
	
	<section id="container">
		<form action="/modify/board/????" method="get">					
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제목</label>
				<input type="text" id="title" name="title" class="form-control" value="${board.title}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">내용</label>
				<textarea id="content" name="content" class="form-control wide-textarea" readonly="readonly">${board.context}</textarea>
			</div>
			<div class="form-group">
				<label for="writer" class="col-sm-2 control-label">작성자</label>
				<input type="text" id="writer" name="writer" class="form-control" value="${board.writer}"  readonly="readonly"/>
			</div>
			<div class="form-group" >
				<label for="regdate" class="col-sm-2 control-label">작성날짜</label>
				<div class="col-sm-10">
		    			<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
		  			</div>	
			</div>
			
			<c:if test="${true}">				
		<%-- 		<c:if test="${board.writer == sessionScope.user.userId || sessionScope.user.author == 0}">				 --%>
				<div>
					<button type="submit" class="update_btn btn btn-warning">수정</button>
					<button type="button" class="delete_btn btn btn-danger">삭제</button>
				</div>
			</c:if>
		</form>
		
		<!-- 댓글 -->
		<div id="reply">
			<ol class="replyList">
				<c:forEach items="${comments}" var="comment">
					<li>
						<p>
						작성자 : ${comment.writer}<br>
						작성 날짜 :  <fmt:formatDate value="${comment.date}" pattern="yyyy-MM-dd" /> <br>
						<strong>${comment.context}</strong>
						</p>
						  
						<p></p>
						<%-- <c:if test="${comment.writer == sessionScope.user.userId || sessionScope.user.author == 0}"> --%>
						<c:if test="${true}">
							<div>
								<button type="button" class="replyDeleteBtn btn btn-danger">삭제</button>
							</div>
						</c:if>
					</li>
				</c:forEach>   
			</ol>
		</div>
		
		
			
		<%-- <c:if test="${not empty SessionScope.user}"> --%>
		<c:if test="${true}">
			<div class="form-group">
				<label for="writer" class="col-sm-2 control-label">댓글 작성자</label>
				<div class="col-sm-10">
					<input type="text" id="comment-writer" name="writer" class="form-control" value="${sessionScope.user.userId}" readonly="readonly"/>
				</div>
			</div>
		
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">댓글 내용</label>
				<div class="col-sm-10">
					<input type="text" id="comment-context" name="context" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="replyWriteBtn btn btn-success">작성</button>
				</div>
			</div>
		</c:if>
		
	</section>
	<hr />
</div>

<script type="text/javascript">

document.addEventListener("DOMContentLoaded", function () {
    // 작성 버튼 클릭 이벤트를 처리합니다.
    document.querySelector(".replyWriteBtn").addEventListener("click", function () {
        // 작성자와 댓글 내용을 가져옵니다.
        var writer = document.getElementById("comment-writer").value;
        var context = document.getElementById("comment-context").value;

        // 댓글 정보를 담은 객체를 생성합니다.
        var commentData = {
            writer: writer,
            context: context
        };

        // Axios를 사용하여 서버로 데이터를 전송합니다.
        axios.post('/comment', commentData)
            .then(function (response) {
                // 서버 응답을 처리합니다.
                console.log(response.data);
            })
            .catch(function (error) {
                // 오류가 발생한 경우 처리합니다.
                console.error('Error during comment post:', error);
            });
    });
});

document.addEventListener("DOMContentLoaded", function () {
    // 삭제 버튼 클릭 이벤트를 처리합니다.
    document.querySelector(".replyDeleteBtn").addEventListener("click", function () {
        // 알림을 통해 사용자에게 삭제 여부를 확인할 수 있습니다.
        var isConfirmed = confirm("댓글을 삭제하시겠습니까?");

        if (isConfirmed) {
            // 액시오스를 사용하여 서버로 DELETE 요청을 보냅니다.
            axios.delete('/comment')
            .then(function (response) {
                //ResponseEntity.ok 보내주면
                console.log(response.data);
                alert("댓글이 삭제되었습니다.");
            })
            .catch(function (error) {
            	//아닐시
                console.error('Error during comment deletion:', error);
                alert("삭제 실패");
            });
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    // 삭제 버튼 클릭 이벤트를 처리합니다.
    document.querySelector(".delete_btn").addEventListener("click", function (e) {
    	e.preventDefault();
    	
    	// 알림을 통해 사용자에게 삭제 여부를 확인할 수 있습니다.
        var isConfirmed = confirm("게시글을 삭제하시겠습니까?");

        if (isConfirmed) {
            // 액시오스를 사용하여 서버로 DELETE 요청을 보냅니다.
            axios.delete('/board')
            .then(function (response) {
            	//ResponseEntity.ok 보내주면
                console.log(response.data);
                alert("게시글이 삭제되었습니다.");
            })
            .catch(function (error) {
                // 아닐시
                console.error('Error during board deletion:', error);
                alert("게시글 삭제 실패");
            });
        }
    });
});


</script>

</body>
</html>