<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<p>
这是动作指令生成的页面：
<%
SimpleDateFormat simpleDateFormate=new SimpleDateFormat();
out.println(simpleDateFormate.format(new Date()));
%>
</p>