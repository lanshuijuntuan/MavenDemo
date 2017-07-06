<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:useBean id="student" class="com.sdj.mytest.Student"></jsp:useBean>
</head>
<body>
	<jsp:setProperty property="name" name="student" value="张三" />
	<jsp:setProperty property="nickName" name="student" value="二狗子" />

	<p>学生的name：${student.name}</p>
	<p>学生的nickname：${student.nickName }</p>
	<jsp:text>测试jsp:text</jsp:text>
	
	<p>
		获得的跳转信息errormsg：<span>${param.errormsg},</span><span>${param.test},</span>
	</p>
	<p>
		获得的跳转信息test：<span>${requestScope.test},</span><span>${test},</span><span>${requestScope.errormsg}</span>
	</p>
	<p>
		获得的跳转信息errormsg：
		<%
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		String todaystr = simpleDateFormat.format(new Date());
		out.println(request.getParameter("errormsg"));
		out.println(request.getParameter("test"));
	%>
	</p>
	<p>
		获得的跳转信息test：
		<%
		out.println(request.getAttribute("test"));
	%>
	</p>
</body>
</html>