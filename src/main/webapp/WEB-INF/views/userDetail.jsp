<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>

<%-- <c:if test="${sessionScope.author == 0 || sessionScope.id == user.id}"> --%>
<c:if test="${not empty sessionScope.id}">
<!-- action, method -->
<form action="/modify/user" method="GET" name="detailForm" id="detailForm">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>회원 상세 정보</b>
	            	</font>
	            </p>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">아이디</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span id="id" style="font-size:12pt;">
	        			${user.id}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">비밀번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${user.password}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">권한</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${user.author}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
						<input type="submit" value="회원정보수정">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/main'"></span>
	<span style="font-size:12pt;"><input type="button" value="회원탈퇴" onclick="deleteUser(${user.id})"></span>
</div>
</c:if>

<c:if test="${empty sessionScope.id}">
	<div align="center">
  		<span style="font-size:12pt;">로그인이 필요한 서비스입니다.</span>
	</div>
</c:if>


<%@ include file="footer.jsp" %>

<script type="text/javascript">
		
	/* https://developer.mozilla.org/en-US/docs/Learn/Forms/Sending_forms_through_JavaScript */
	/* https://www.javascripttutorial.net/javascript-dom/javascript-form/ */
	
	function deleteDept(id){
	  // ???	  
	  // type:hidden, 
	  // name:_method, 
	  // value:'DELETE' 값을 가지는 input 태그 내부에서 생성!
		  
		let detailForm = document.getElementById('detailForm');
	  	let hiddenInput = document.createElement('input');
	  	hiddenInput.type = 'hidden';
	  	hiddenInput.name = '_method';
	  	hiddenInput.value = 'DELETE';
		
	  	detailForm.append(hiddenInput);
	  	//let deptno = document.getElementById('deptno').innerHTML;
		detailForm.action = "/user/" + id;
		detailForm.method = "POST";
		detailForm.submit();
	}
</script>
</body>
</html>