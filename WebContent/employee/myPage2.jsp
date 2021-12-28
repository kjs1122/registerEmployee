<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../main.jsp" method="post" >
		<table align="center">
			<tr>
				<td colspan="2"><h2>사원 정보</h2> <br>
				${update}
				</td>
			</tr>	
			
			<c:if test="${!empty customUser}">
			<tr>
				<td>아이디</td>
				<td>${customUser.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${customUser.pass}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${customUser.name}</td>
			</tr>
			<tr>
				<td>권한</td>
				<c:if test="${customUser.lev == 'A'}">
					<td>운영자</td>
				</c:if>
				<c:if test="${customUser.lev == 'B'}">
					<td>일반회원</td>
				</c:if>
			</tr>
			<tr>
				<td>성별</td>
				<c:if test="${customUser.gender == '1'}">
					<td>남자</td>
				</c:if>
				<c:if test="${customUser.gender == '2'}">
					<td>여자</td>
				</c:if>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${customUser.phone}</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="메인 페이지로 이동">
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>