<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<h2>&nbsp; 文件上传	</h2>
  	<form action="upload.action" method="post" enctype="multipart/form-data">
  		上传文件：<input type="file" name="upload">
  		<input type="submit" value="提交">${result}
  	</form>
</body>
</html>