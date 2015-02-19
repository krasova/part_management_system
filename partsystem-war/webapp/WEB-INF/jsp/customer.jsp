<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title>Customer Manager</title>
</head>
<body>

<a href="<c:url value="/logout" />">
	Logout
</a>
  
<h2>Customer Manager</h2>

<form:form method="post" action="add" commandName="customer">

	<table>
		<tr>
			<td><form:label path="name">
				Name
			</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="Add Customer" /></td>
		</tr>
	</table>
</form:form>

<h3>Customers</h3>
<c:if test="${!empty customerList}">
	<table class="data">
		<tr>
			<th>Name</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.name}</td>
				<td><a href="delete/${customer.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>