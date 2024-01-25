<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>userUpdate</title>
</head>
<body>

<%@ include file="header.jsp" %>

<form action="/user" method="POST">
<!-- PUT으로 데이터 보낼 때 넣어줘야 함. -->
<!-- 파일을 가지고 수정할 때 무조건 post임. 히든메소드로 put을 넣어놨어도 소용없음. -->
<!-- enctype="multipart/form-data" 타입이 multipart인 이상 무조건 post메소드만 실행됨. -->
<input type="hidden" name="_method" value="PUT">
<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#336699">
            <p align="center">
            	<font color="white" size="3">
            		<b>회원 정보 업데이트</b>
            	</font>
            </p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="center"><b><span style="font-size:9pt;">아이디</span></b></p>
        </td>
        <td width="450" height="20" align="center">
        	<b>
        		<span style="font-size:9pt;">
        			<!-- 부서번호는 수정되지 않도록 지정 -->
        			<input type="text" name="id" size="30" value="${user.id}" readonly>
        		</span>
        	</b>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="center"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20" align="center">
        	<b>
        		<span style="font-size:9pt;">
        			<!-- 부서명 출력 -->
        			<input type=text name="dname" size="30" value="${user.password}">
        		</span>
        	</b>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="center"><b><span style="font-size:9pt;">권한</span></b></p>
        </td>
        <td width="450" height="20" align="center">
        	<b>
        		<span style="font-size:9pt;">
        			<!-- 부서위치 출력 -->
        			<input type=text name="loc" size="30" value="${user.author}" readonly>
        		</span>
        	</b>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p><b><span style="font-size:9pt;">&nbsp;</span></b></p>
        </td>
        <td width="450" height="20" align="center">
        	<b>
        		<span style="font-size:9pt;">
					<input type="submit" value="회원정보 수정">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시작성">
				</span>
			</b>
		</td>
    </tr>
</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/main'"></span>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>