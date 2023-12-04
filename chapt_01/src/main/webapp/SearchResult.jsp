<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.kh.model.dao.DAO" %>
<%@page import ="com.kh.model.vo.DTO" %>
<%@page import ="java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>searchResult 검색 결과</title>
	</head>
	<body>
		<h1>조회 결과</h1>
		<table border="1">
			<thead>
				<tr>
				<th>user number</th>
				<th>user id</th>
				<th>user name</th>
				<th>user age</th>
				</tr>
				
			</thead>
			<tbody>
			<%
			List<DTO> userList =(List<DTO>) request.getAttribute("userList");

			//조회된 사용자 정보를 전체 출력
			for(DTO user :userList){
				
			%>
			<tr>
				<td><%=user.getUser_number() %></td>
				<td><%=user.getUser_id() %></td>
				<td><%=user.getUser_name() %></td>
				<td><%=user.getUser_age() %></td>
			</tr>
			<% } %>
			</tbody>
			
		</table>
	
	</body>
</html>