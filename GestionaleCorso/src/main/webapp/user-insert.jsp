<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="card-container">
		<c:if test="${user != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="insert" method="post">
		</c:if>

		<caption>
			<h2>
				<c:if test="${user != null}">
                                    Edit User
                                </c:if>
				<c:if test="${user == null}">
                                    Add New User
                                </c:if>
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

		<button type="submit" class="btn btn-success">Save</button>
		</form>
	</div>
</body>
</html>