<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<style type="text/css">
	li {list-style: none; display:inline; padding: 6px;}
</style>
<ul>
	<li><a href="/views/main">목록</a></li>
	<li><a href="/views/boardReg">글 작성</a></li>
	<li><a href="/views/login">로그인</a></li>
</ul>
=======
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
						value="목록" onclick="location.href='/main'"></span></li>
			<li><span style="font-size: 12pt;"><input type="button"
						value="게시글 등록" onclick="location.href='/board'"></span></li>
			<li><c:if test="${empty sessionScope.userId}">
					<span style="font-size: 12pt;"><input type="button"
						value="로그인" onclick="location.href='login'"></span>
				</c:if> 
				<%-- <c:if test="${not empty sessionScope.userId}">
					<span>${sessionScope.userId} 님 </span>
					<span style="font-size: 12pt;"><input type="button"
						value="로그아웃" onclick="location.href='logout'"></span>
				</c:if> --%>
			</li>
		</ul>
	</div>
</header>
>>>>>>> origin/main+search
