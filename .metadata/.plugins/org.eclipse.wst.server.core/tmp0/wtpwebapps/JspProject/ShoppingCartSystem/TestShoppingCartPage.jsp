<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TSCP</title>
</head>
<body>
	<h1>Wellcome To My Shopping Mall</h1>
	<form action="TSCProcess.jsp" method="post">
		<h2>Please Select Item To Add & Delete:</h2>
		<div>
			<select name="products">
				<option value="movies">Movies</option>
				<option value="banana">Banana</option>
				<option value="tabaco">Tabaco</option>
				<option value="anime">Anime</option>
				<option value="flower">Flower</option>
				<option value="coffee">Coffee</option>
			</select>
		</div>
		<br/>
		<input type="submit" value="add" name="submit" />
		<input type="submit" value="delete" name="submit" />
	</form>
</body>
</html>