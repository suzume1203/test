<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test OS</title>
<style>
table {
	margin: auto;
	margin-top: 20vh;
	
}
</style>
</head>
<body>
	<form action="TestOSProcess.jsp" method="get">
		<table>
			<tr>
				<td>Name :</td>
				<td>
					<input type="text" name="userName" value="">
				</td>
			</tr>
			<tr>
				<td>Address :</td>
				<td>
					<input type="text" name="userAddress" value="">
				</td>
			</tr>
			<tr>
				<td>Tel :</td>
				<td>
					<input type="text" name="userTel" value="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="submit" value="Submit">
					<input type="reset" value="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>