<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("test", "789");
	%>
	<%
		out.println(request.getAttribute("test"));
	%>


	<%@ include file="header.jsp"%>

	<p>
		当前路径：
		<%
		out.println(request.getContextPath());
	%>
	</p>
	<p>
		本地计算机IP:<%
		out.println(request.getLocalAddr());
	%>
	</p>
	<p>
		本地计算机端口:<%
		out.println(request.getLocalPort());
	%>
	</p>
	<p>
		本地计算机名称：<%
		out.println(request.getLocalName());
	%>
	</p>
	<p>
		远程计算机地址:<%
		out.println(request.getRemoteAddr());
	%>
	</p>
	<p>
		远程计算机名称:<%
		out.println(request.getRemoteHost());
	%>
	</p>
	<p>
		远程计算机端口:<%
		out.println(request.getRemotePort());
	%>
	</p>
	<p>
		请求的Scheme:<%
		out.println(request.getScheme());
	%>
	</p>

	<p>
		请求的ServerName:<%
		out.println(request.getServerName());
	%>
	</p>

	<p>
		请求的ServerPort:<%
		out.println(request.getServerPort());
	%>
	</p>


	<p>
		请求的RealPath:<%
		out.println(request.getServletContext().getRealPath("/classpath/"));
	%>
	</p>


	<%
		for (int i = 0; i < 5; i++) {
	%>
	<p>
		这是第<%=i%>行
	</p>
	<%
		}
	%>

	<jsp:include page="action_test.jsp"></jsp:include>


	<%@ include file="footer.jsp"%>


</body>
</html>