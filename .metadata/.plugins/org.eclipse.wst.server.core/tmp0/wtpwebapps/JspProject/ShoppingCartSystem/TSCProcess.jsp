<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "TestShoppingCartPage.jsp" %>
<jsp:useBean id="myCart" class="tw.suzume.javabean.TestShoppongCartBean" scope="session"/>
<jsp:setProperty name="myCart" property="item" param="products"/>
<jsp:setProperty name="myCart" property="submit" param="submit"/>
<!DOCTYPE html>
<html>
<% myCart.processReq(); %>
<head>
<meta charset="UTF-8">
<title>TSCProcess</title>
</head>
<body>
<font size="3" color="red">
your cart : 
<br/>
<%
int i = 1;
for(String item:myCart.getItems()){
	out.write(i+". "+item+"<br/>");
}
%>
</font>
</body>
</html>