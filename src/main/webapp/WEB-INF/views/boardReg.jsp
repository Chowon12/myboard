<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>boardReg</title>
</head>
<body>
	<h1>boardReg</h1>
	<form action="main.jsp" th:action  method="post">
    <div>
        <label for="title">제목</label>
        <input type="text" id="title" name="title" class="formcontrol" placeholder="제목을 입력해주세요">
    </div>
    <div>
        <label for="context">본문</label>
        <input type="text" id="context" name="context" class="form-control"
                placeholder="본문을 입력해주세요">
    </div>
    <div>
        <label for="name">글쓴이</label>
        <input type="text" id="writer" name="writer" class="form-control"
                placeholder="닉네임을 입력해주세요">
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