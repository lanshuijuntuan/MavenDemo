<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>taglib指令测试 引入JSP标准库</title>
</head>
<body>
<h1>即将采用标准库输出5行</h1>
<c:forEach begin="1" end="5" step="1">
<h2>这是用标准库输出的html</h2>
</c:forEach>

</body>
</html>