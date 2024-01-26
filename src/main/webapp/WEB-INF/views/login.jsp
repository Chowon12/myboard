<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
	crossorigin="anonymous"></script>
<title>login</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	<div id="container">
		<!-- action, method -->
		<form action="/login" method="POST">
			<table align="center" cellpadding="5" cellspacing="1" width="600"
				border="1">
				<tr>
					<td width="1220" height="20" colspan="2" bgcolor="#336699">
						<p align="center">
							<font color="white" size="3"> <b>로그인</b>
							</font>
						</p>
					</td>
				</tr>
				<tr>
					<td width="150" height="20">
						<p align="center">
							<b><span style="font-size: 12pt;">아이디</span></b>
						</p>
					</td>
					<td width="450" height="20" align="center"><b> <span
							style="font-size: 12pt;"> <input id="id" type="text"
								name="id" size="30">
						</span> <br /> <span id="idMsg" style="font-size: 8pt;"></span>
					</b></td>
				</tr>
				<tr>
					<td width="150" height="20">
						<p align="center">
							<b><span style="font-size: 12pt;">비밀번호</span></b>
						</p>
					</td>
					<td width="450" height="20" align="center"><b> <span
							style="font-size: 12pt;"> <!-- input 박스 --> <input id="password"
								type="text" name="password" size="30">
						</span>
					</b></td>
				</tr>
				<tr>
					<td width="150" height="20">
						<p>
							<b><span style="font-size: 12pt;">&nbsp;</span></b>
						</p>
					</td>
					<td width="450" height="20" align="center"><b> <span
							style="font-size: 12pt;"> <input type="submit" value="로그인">
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="다시작성">
						</span>
					</b></td>
				</tr>
			</table>
		</form>
		<hr>
		<div align=center>
			<span style="font-size: 12pt;"><input type="button"
				value="메인으로" onclick="location.href='/main'"></span>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

	<script type="text/javascript">
		const inputId = document.getElementById('id');
		const idMsg = document.getElementById('idMsg');
	</script>

</body>
</html>