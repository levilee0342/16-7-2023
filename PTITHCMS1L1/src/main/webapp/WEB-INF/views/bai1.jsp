<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8"/>

<title>Spring MVC</title>

<base href="${pageContext.servletContext.contextPath}/">

<style>
    div {
        display: inline-block;
        text-align: center;
        margin: 5px;
        padding: 5px;
        border: 1px dotted orangered;
        border-radius: 5px;
    }
</style>

</head>

<body>

<h1>EL & JSTL</h1>
<div>
    <img src="${photo1}">
    <br>
    <strong>${name1}</strong>
    <em>${salary*level1}</em>
</div>

<div>
    <img src="${photo2}">
    <br>
    <strong>${name2}</strong>
    <em>${salary*level2}</em>
</div>

<div>
    <img src="${photo3}">
    <br>
    <strong>${name3}</strong>
    <em>${salary*level3}</em>
</div>

</body>

</html>
