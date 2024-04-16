<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update</title>
</head>
<body>
	${messager}
 <form:form action = "${u.username}.htm" modelAttribute="user">
 	<div>
 		<label> Username </label>
 		<input value = "${user.username}" name ="username" readonly />
 	</div>
 	
 	<div>
 		<label>Password</label>
 		<input value ="${user.password}" name="password"/>
 	</div>
 	
 	<div>
 		<label>Fullname</label>
 		<input value="${user.fullname}" name ="fullname"/>
 	</div>
 	
 	<div>
 		<button class="btn btn-default">Update</button>
 	</div>
 </form:form>
 
</body>
</html>