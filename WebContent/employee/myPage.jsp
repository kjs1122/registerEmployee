<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/employees.js"></script>
</head>
<body>
	<form action="myPage.do" method="post" name="frm">
		<table align="center">
			<tr>
				<td colspan="2">마이페이지</td>
			</tr>	
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${loginUser.id}" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td><select name="lev">
					<option value="A">운영자</option>
					<option value="B">일반회원</option>
				</select></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><select name="gender">
					<option value="1">남자</option>
					<option value="2">여자</option>
				</select></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정" onclick="return pageCheck()">
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>