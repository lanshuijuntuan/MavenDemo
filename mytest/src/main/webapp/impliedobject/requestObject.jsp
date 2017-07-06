<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Enumeration,java.util.Map,org.apache.commons.io.IOUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP-request 对象</title>
</head>

<body>
	<h1>Request Header</h1>
	<table>
		<thead>
			<tr>
				<td>header名称</td>
				<td>header值</td>
			</tr>
		</thead>
		<tbody>
			<%
				Enumeration<String> lst = request.getHeaderNames();
				while (lst.hasMoreElements()) {
					String key = lst.nextElement();
			%>

			<tr>
				<td><%=key%></td>
				<td><%=request.getHeader(key)%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<h3>request详细信息</h3>
	<p>
		<%
			String result = IOUtils.toString(request.getInputStream(), "utf-8");
			out.println(result);
		%>
	</p>
</body>
</html>