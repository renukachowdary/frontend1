<%@ page language="java" contentType="text/html" import="com.spring.model.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Category Page</title>
	</head>
<body>

		<!-- <form action="AddCategory" method="post">-->

		<form:form action="AddCategory" modelAttribute="category">
		<table align="center" cellspacing="2">
		<tr>
			<td colspan="2">Category Module</td>
		</tr>
		
		<tr>
			<td>Category ID</td>
			<!-- <td><input type="text" name="catId"/></td> -->
			<td><form:input path="catId"/></td>
		</tr>
	
	
		<tr>
			<td>Category Name</td>
			<!-- <td><input type="text" name="catName"/></td> -->
			<td><form:input path="catName"/></td>
		</tr>
	
		<tr>
			<td>Category Desc</td>
			<!-- <td><input type="text" name="catDesc"/></td> -->
			<td><form:input path="catDesc"/></td>
		</tr>
	
		<tr>
			<td colspan="2">
				<center><input type="submit" value="Insert"/></center>
			</td>
		</tr>
	</table>
	</form:form>

<table cellspacing="2" align="center">
	<tr bgcolor="blue">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${categoryList}" var="category">
		<tr bgcolor="pink">
			<td>${category.catId}</td>
			<td>${category.catName}</td>
			<td>${category.catDesc}</td>
			<td>
				<a href="<c:url value="deleteCategory/${category.catId}"/>">DELETE</a>/
				<a href="<c:url value="updateCategory/${category.catId}"/>">UPDATE</a>
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>