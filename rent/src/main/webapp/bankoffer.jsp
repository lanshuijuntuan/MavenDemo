<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:useBean id="bankoffers" class="com.sdj.rent.models.data.BankOffer" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/content/plugins/jQueryUI/jquery-3.2.1.min.js"></script>

<title>银行托收信息</title>

</head>
<body>
<div align="center">
	<table>
		<caption>银行信息表</caption>
		<tbody>
			<tr>
				<td><div align="center">ID</div></td>
				<td><div align="center">银行名称</div></td>
				<td><div align="center">银行代码</div></td>
				<td><div align="center">支持类型</div></td>
				<td><div align="center">是否启用</div></td>
				<td><div align="center">备注</div></td>
				<td><div align="center">项目ID</div></td>
			</tr>
			
			<c:forEach items="${bankoffers}" var="entity">
				<tr>
					<td><div align="center">${entity.Id}</div></td>
					<td><div align="center">${entity.BankName}</div></td>
					<td><div align="center">${entity.BankCode}</div></td>
					<td><div align="center">${entity.Type}</div></td>
					<td><div align="center">${entity.IsEnable}</div></td>
					<td><div align="center">${entity.Remark}</div></td>
					<td><div align="center">${entity.ProId}</div></td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>

</body>
</html>