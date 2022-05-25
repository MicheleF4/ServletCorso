<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>User Form</title>
</head>
<body>
	<div class="container">
		<div class="container__form">
			<!--<c:if test="${user != null}">
				<form action="update" method="post">
			</c:if>
			<c:if test="${user == null}">
				<form action="insert" method="post">
			</c:if>-->
			
			<form action="update-form" method="post">

		<caption>
				<h2 class="h2__form">
				Update User
					<!--<c:if test="${user != null}">
                                    Edit User
                                </c:if>
					<c:if test="${user == null}">
                                    Add New User
                                </c:if>-->
				</h2>
			</caption>

			<c:if test="${user != null}">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			</c:if>

			<fieldset class="form-group">
				<label>User Name</label> <input type="text"
					value="<c:out value='${user.name}' />" class="form-control"
					name="name" required="required">
			</fieldset>

			<fieldset class="form-group">
				<label>User Email</label> <input type="text"
					value="<c:out value='${user.email}' />" class="form-control"
					name="email">
			</fieldset>

			<fieldset class="form-group">
				<label>User Country</label> <input type="text"
					value="<c:out value='${user.country}' />" class="form-control"
					name="country">
			</fieldset>
			
			<fieldset class="form-group">
				<label>User Age</label> <input type="text"
					value="<c:out value='${user.age}' />" class="form-control"
					name="age">
			</fieldset>
			
			<fieldset class="form-group">
				<label>User Date of Birth</label> <input type="text"
					value="<c:out value='${user.dateOfBirth}' />" class="form-control"
					name="dateOfBirth">
			</fieldset>

			<button type="submit" class="button__form">Save</button>
			</form>
		</div>
	</div>
</body>
</html>