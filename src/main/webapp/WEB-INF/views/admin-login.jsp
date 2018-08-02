<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5 style="color:red">${message}</h5>
	<form action="${pageContext.request.contextPath}/adminlogin" method="post">
		Username : <input type="email" name="admin_name"></br>
		Password : <input type="password" name="admin_pwd"></br>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>