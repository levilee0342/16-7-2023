<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert</title>
</head>
<body>
 <form:form action = "insert.htm" modelAttribute="user">
 	<div>
 		<label> Username </label>
 		<form:input path = "username"/>
 		<form:errors path = "username"/>
 	</div>
 	
 	<div>
 		<label>Password</label>
 		<form:input path ="password"/>
 		<form:errors path ="password"/>
 	</div>
 	
 	<div>
 		<label>Fullname</label>
 		<form:input path="fullname"/>
 		<form:errors path ="fullname"/>
 	</div>
 	
 	<div>
 		<button class="btn btn-default">Insert</button>
 		<a href="index.htm">Trở Lại Danh Sách</a>

 	</div>
 </form:form>
</body>
</html>