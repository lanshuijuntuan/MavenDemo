<!-- 此网页是用来测试JSP的隐含对象application -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP-application 对象</title>
</head>
<body>
	<p>
		MajorVersion:
		<%
		out.print(application.getMajorVersion());
	%>
	</p>

	<p>
		MinorVersion:
		<%
		out.print(application.getMinorVersion());
	%>
	</p>
	<p>
		MajorVersion:
		<%
		out.print(application.getMajorVersion());
	%>
	</p>
	<p>
		effectiveMajorVersion:
		<%
		out.print(application.getEffectiveMajorVersion());
	%>
	</p>
	<p>
		effectiveMinorVersion:<%
		out.print(application.getEffectiveMinorVersion());
	%>
	</p>
	<p>
		realPath:<%
		out.print(application.getRealPath(""));
	%>
	</p>
	<p>
		contextPath:<%
		out.print(application.getContextPath());
	%>
	</p>
	<p>
		serverInfo:<%
		out.print(application.getServerInfo());
	%>
	</p>
	<p>
		servletContextName:<%
		out.print(application.getServletContextName());
	%>
	</p>

	<p>ServletRegistrations:</p>
	<%
		Map<String, ? extends ServletRegistration> map = application.getServletRegistrations();
		for (Map.Entry<String, ? extends ServletRegistration> entry : map.entrySet()) {
	%>

	<p>
		servletName:
		<%
		out.println(entry.getKey());
	%>
	</p>
	<p>
		servletClass:
		<%
		out.println(entry.getValue().getClassName());
	%>
	</p>
	<%
		}
	%>


</body>
</html>