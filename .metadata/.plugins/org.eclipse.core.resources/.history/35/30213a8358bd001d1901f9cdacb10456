<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
EX:<%=exception%>

ExStack Trace :
<%
exception.printStackTrace(new PrintWriter(out));
%>
</body>
</html>