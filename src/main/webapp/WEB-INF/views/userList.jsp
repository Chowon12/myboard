<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>userList</title>
</head>
<body>

<%@ include file="header.jsp" %>

<%-- <c:if test="${sessionScope.author == 0}"> --%>
<c:if test="${true}">
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center">
            <font color="white"><b><span style="font-size:12pt;">아이디</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">비밀번호</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:12pt;">권한</span></b></font></p>
        </td>
    </tr>

	<!-- 부서 객체 유무 검증 -->
	<c:if test="${empty requestScope.userList}">    
		<tr>
	        <td colspan="5">
	            <p align="center"><b><span style="font-size:12pt;">등록된 회원이 존재하지 않습니다.</span></b></p>
	        </td>
	    </tr>
	</c:if>
	<!-- 반복 출력 -->
	<c:forEach items="${requestScope.userList}" var="user">
		    <tr>
		        <td bgcolor="">
		            <p align="center">
			            <span style="font-size:12pt;">
			            	<!-- 부서번호 -->
			            	<b>
								<a href="user/${user.id}">${user.id}</a>
							</b>
			            </span>
		            </p>
		        </td>
		        <td bgcolor="">
					<p align="center">
						<span style="font-size:12pt;">
							<b>${user.password}</b>
						</span>
					</p>
		        </td>
		        <td bgcolor="">
		            <p align="center">
		            	<span style="font-size:12pt;">
		            		<!-- 부서위치 -->
		             		<b>${user.author}</b>
		             	</span>
		             </p>
		        </td>
		    </tr>
    </c:forEach>
</table>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/main'"></span>
	<span style="font-size:12pt;"><input type="button" value="회원가입" onclick="location.href='/user-insert'"></span>
</div>
</c:if>

<c:if test="${empty sessionScope.id}">
	<div align="center">
  		<span style="font-size:12pt;">로그인이 필요한 서비스입니다.</span>
	</div>
</c:if>

<%@ include file="footer.jsp" %>

</body>
</html>