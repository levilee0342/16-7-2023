<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
${message}
	<form:form action="insert.htm" modelAttribute="record">
		<div>
			<label>Nhân viên</label>
			<form:select path="staff.id"
						items="${staffs}" itemValue= "id" itemLabel="name"/>
		</div>
		<div>
			<label>Loại</label>
			<form:radiobutton path ="type" value="1" label="Thành tích"/>
			<form:radiobutton path="type" value="0" label= "Kỷ luật"/>
		</div>
		<div>
			<label>Lý do</label>
			<form:textarea path = "reason" rows="3"/>
			<form:errors path = "reason" />
		</div>
		<div>
			<button>Insert</button>
		</div>
	</form:form>
</body>
</html>