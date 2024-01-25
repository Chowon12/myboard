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
<title>Error</title>
</head>
<body>

 	<%@ include file="header.jsp" %> 

	<div align="center">
		<h2>죄송합니다. 문제가 발생하였습니다.</h2>
	</div>
	
	<br><hr><br>
	
	<div align="center">
		<h3>??</h3>
	</div>
	 
	<br>
	
	<div align=center>
		<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/main'"></span>
	</div>
	
 	<%@ include file="footer.jsp" %> 
</body>
</html>