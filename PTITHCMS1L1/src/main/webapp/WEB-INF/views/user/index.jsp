<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>USER</title>
<base href="${pageContext.servletContext.contextPath}/">
	<style>
		table{
			border-collapse: collapse;
			width: 100%;
		}
		th, td{
			line-height: 25px;
			border: 1px solid black;
			padding: 5px;
		}
		th{
			background-color: gray;
			}
	</style>
</head>

<body>
<table class="table table-hover">
	<tr>
		<th>Username</th>
		<th>Password</th>
		<th>Fullname</th>
		<td><a href="user/insert.htm">Insert</a></td>
		
	</tr>
	<c:forEach var="u" items="${users}">
		<tr>
			<td>${u.getUsername()}</td>
			<td>${u.getPassword()}</td>
			<td>${u.getFullname()}</td>
			<td><a href="user/update/${u.username}.htm"> Edit </a> | <a href="user/index/${u.username}.htm"> Delete </a></td> 
		</tr>
	</c:forEach>
</table>
</body>
</html>