<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP-session 对象</title>
</head>
<body>
	<p>
		sessionid:<%
		out.println(session.getId());
	%>
	</p>
	<p>
		isNew:<%
		out.println(session.isNew());
	%>
	</p>
	<p>
		creationTime:<%
		out.println(session.getCreationTime());
	%>
	</p>
	<p>
		LastAccessedTime:<%
		out.println(session.getLastAccessedTime());
	%>
	</p>
	<p>
		MaxInactiveInterval:<%
		out.println(session.getMaxInactiveInterval());
	%>
	</p>
	<table>
		<tbody>
			<tr>
				<td>key</td>
				<td>value</td>
			</tr>
			<%
				Enumeration<String> enumeration = session.getAttributeNames();
				while (enumeration.hasMoreElements()) {
			%>
			<tr>
				<td>
					<%
						String key = enumeration.nextElement();
							out.print(key);
					%>
				</td>
				<td>
					<%
						out.print(session.getAttribute(key));
					%>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>