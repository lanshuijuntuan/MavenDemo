<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP-response 对象</title>
</head>
<body>
	<h2>response自动刷新时间</h2>
	<%
	response.setIntHeader("Refresh", 5);
     SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	out.println("当前时间是："+simpleDateFormat.format(new Date()));
		
	%>
</body>
</html>