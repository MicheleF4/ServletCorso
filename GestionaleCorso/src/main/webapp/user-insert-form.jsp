<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">

<title>Add New User</title>
</head>
<body>
	<div align="center">
		<div class="container">
			<div class="container__form">
				<h2 class="h2__form">Insert New User</h2>
				<c:if test="${errorName != null}">
					<h2 class="h2__error">${errorName}</h2>
				</c:if>
				<form action="<%=request.getContextPath()%>/user-insert"
					method="post">
					<table class="form__table" style="with: 80%">
						<tr>
							<td>Name</td>
							<td><input type="text" name="name" /></td>

						</tr>

						<tr>
							<td>Email</td>
							<td><input type="text" name="email" /></td>
						</tr>
						<tr>
							<td>Country</td>
							<td><input type="text" name="country" /></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><input type="text" name="age" /></td>
						</tr>
						<tr>
							<td>Date of Birth</td>
							<td><input type="text" name="dateOfBirth" /></td>
						</tr>
					</table>
					<!--<input type="submit" value="Submit" />-->
					<button type="submit" class="button__form">Add User</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>