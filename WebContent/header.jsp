<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	border: 1px solid black;
	width: 200px;
	text-align: center;
}

table.mainmenu td.login:hover {
	background: pink;
}
</style>
</head>
<body>
	<table class="mainmenu" align="center">
		<!-- 로그인 전 화면 -->
		<c:if test="${empty loginUser }">

			<tr>
				<td></td>
				<td></td>
				<td class="login"><a name="login" href="login.do"
					style="text-decoration: none;">로그인</a></td>
				<td style="width: 250px">사원등록<br> <span
					style="color: red;">(관리자로 로그인 후 사용 가능)</span>
				</td>
				<td>마이페이지<br> <span style="color: red;">(로그인 후 사용
						가능)</span>
				</td>

			</tr>
		</c:if>
		<!-- 로그인 후 화면 -->
		<c:if test="${!empty loginUser}">
			<tr>
				<td>${loginUser.name}님 반갑습니다.</td>
				<td>레벨 : ${loginUser.lev}</td>
				<td class="login"><a name="logout" href="logout.do"
					style="text-decoration: none;">로그아웃</a></td>
				<c:choose>
					<c:when test="${result == 'A'}">
					<td style="width: 250px"><a href="custom.do"
						style="text-decoration: none;">사원등록</a></td>
					</c:when>
					<c:otherwise>
					<td style="width: 250px">사원등록<br> <span
						style="color: red;">(관리자로 로그인 후 사용 가능)</span>
					</td>
					</c:otherwise>
				</c:choose>
				<td><a href="myPage.do" style="text-decoration: none;">마이페이지</a>
				</td>

			</tr>
		</c:if>
	</table>
</body>
</html>