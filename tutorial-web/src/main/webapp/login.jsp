<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
%>
<title>login</title>
</head>
<body>
	<form action="<%=path%>/framework/authority.action" method="post">
		UserName:<input type="text" name="username" />
		<p />
		Password:<input type="password" name="password" />
		<p />
		<input type="submit" name="login-submit" />
	</form>
</body>
</html>