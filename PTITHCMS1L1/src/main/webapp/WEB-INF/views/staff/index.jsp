<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>IndexStaff</title>
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
 		<th>Mã NV</th>
 		<th>Họ và Tên</th>
 		<th>Giới tính</th>
 		<th>Phòng</th>
 	<tr>
 	<c:forEach var = "s" items= "${staffs}">
 	<tr>
 		<td>${s.getId()}</td>
 		<td>${s.getName()}</td>
 		<td>${s.getGender()?'Nam':'Nữ'}</td>
 		<td>${s.getDepart().getName()}</td>
 	</tr>
 	</c:forEach>
 </table>
</body>
</html>