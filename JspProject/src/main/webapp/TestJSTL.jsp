<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	123
	<c:set var="product">iPhone</c:set>
	<c:set var="price" value="5200" />
	<c:out value="Product Name : ${product}" />
	<c:out value="Price : ${price}" />
	<c:if test="${price>3000}">true</c:if>
	<c:set var="month">2</c:set>
	<c:choose>
		<c:when test="${month == 2}">true</c:when>
		<c:otherwise>false</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="check">
		<c:if test="${check.first}">start</c:if>
		Number:${i}<br/>
		<c:if test="${check.last}">end</c:if>
	</c:forEach>
	<hr/>
	<c:forTokens items="jogn*/=-mary*jack" delims="*/=-" var="item">
		${item}<br/>
	</c:forTokens>
	
</body>
</html>