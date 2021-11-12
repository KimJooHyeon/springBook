<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세</title>
</head>
<body>
<!-- 
	{"TITLE" : "검은태양"}, {"CATEGORY" : "소설"},
	{"PRICE" : "10000"}, {"INSERT_DATE" : "2021-10-27 16:52:31.0"}
	
	컨트롤러에서 mav 객체에 data라는 이름을 DB 검색 결과를 넣었으므로
		=> 이렇게 !! mav.addObjecT("data", detailMap);
	${data.TITLE} 형식으로 사용하게 됨
-->
<h1>책 상세</h1>
<p>제목 : ${data.TITLE}</p>
<p>카테고리 : ${data.CATEGORY}</p>
<p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.PRICE}"/></p> <!-- 천 단위 구분기호 하려고 -->
<p>입력일 : <fmt:formatDate value="${data.INSERT_DATE}" pattern="yyyy.MM.dd HH:mm:ss" /></p>

<p><a href="/update?bookId=${bookId}">수정</a></p>

<form action="/delete" method="post">
	<input type="text" name="bookId" value="${bookId}" />
	<input type="submit" value="삭제" />
</form>

<p><a href="/list">목록으로</a></p>
</body>
</html>