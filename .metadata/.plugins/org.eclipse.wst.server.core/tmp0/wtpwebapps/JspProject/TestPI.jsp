<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%= calc(3).toString()%></h1>
<h1><%= new java.util.Date()%></h1>
<%!
public static final double PI =3.14;

public Double calc(int number){
	return PI*number*number;
}
%>
<%
Date date = new Date();
SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd a hh:mm:ss");

out.write(df.format(date)+"<br/>");
out.write(calc(4).toString());
%>

</body>
</html>