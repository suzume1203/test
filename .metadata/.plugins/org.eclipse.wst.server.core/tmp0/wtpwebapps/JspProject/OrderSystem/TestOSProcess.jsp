<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="os" class="tw.suzume.javabean.TestOrderSystem" scope="page"/>
<jsp:setProperty name="os" property="customer" param="userName"/>
<jsp:setProperty name="os" property="shipAddress" param="userAddress"/>
<jsp:setProperty name="os" property="phone" param="userTel"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test OS Process</title>
</head>
<body>
Customer Name : <jsp:getProperty name="os" property="customer"/><br/>
Customer Add : <jsp:getProperty name="os" property="shipAddress"/><br/>
Customer Tel : <jsp:getProperty name="os" property="phone"/><br/>

</body>
</html>