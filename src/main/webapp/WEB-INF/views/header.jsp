<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
li {
	list-style: none;
	display: inline;
	padding: 6px;
}
</style>
<header>
	<div align="right">
		<ul>
			<li><span style="font-size: 12pt;"><input type="button"
						value="목록" onclick="redirectToPath('/boards')"></span></li>
			<li><span style="font-size: 12pt;"><input type="button"
						value="게시글 등록" onclick="location.href='boardReg'"></span></li>
			<li><c:if test="${empty sessionScope.userId}">
					<span style="font-size: 12pt;"><input type="button"
						value="로그인" onclick="redirectToPath('/login')"></span>
				</c:if> 
				<%-- <c:if test="${not empty sessionScope.userId}">
					<span>${sessionScope.userId} 님 </span>
					<span style="font-size: 12pt;"><input type="button"
						value="로그아웃" onclick="redirectToPath('/logout')"></span>
				</c:if> --%>
			</li>
		</ul>
	</div>
	<script>
	    function redirectToPath(path) {
	        var rootUrl = window.location.origin; // 현재 URL의 루트 경로
	        var destinationUrl = rootUrl + path;
	        window.location.href = destinationUrl;
	    }
	</script>
</header>