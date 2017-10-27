<%@ page language="java" contentType="text/html" import="com.spring.model.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supplier</title>
</head>
	<body background="${pageContext.request.contextPath}/resources/images/Autumn-nature-backgrounds-wallpaper.jpg" >

	   	<!-- <form action="AddSupplier" method="post">-->

			<form:form action="AddSupplier" modelAttribute="supplier">
<center>
			<table align="center" cellspacing="2">


<tr>
		
		
		<form:input type="hidden" name="supId" path="supId" class="form-control" />
		
		
	</tr>

			<tr>
				<td colspan="2">Supplier Module</td>
			</tr>
			
		
	
			<tr>
				<td>Supplier Name</td>
				<!-- <td><input type="text" name="supName"/></td> -->
				<td><form:input path="supName"/></td>
			</tr>
			
			<tr>
				<td>Supplier Desc</td>
				<!-- <td><input type="text" name="SupDescription"/></td> -->
				<td><form:input path="supDesc"/></td>
			</tr>
				
			<tr>
				<td>Supplier Address</td>
				<!-- <td><input type="text" name="SupAddress"/></td> -->
				<td><form:input path="supAddress"/></td>
			</tr>
	
		<tr>
			<td colspan="2">
				<center><input type="submit" value="Insert"/></center>
			</td>
		</tr>

	</table>
</center>
	</form:form>

<table cellspacing="2" align="center">
	<tr bgcolor="violet">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Description</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${supplierList}" var="supplier">
		<tr bgcolor="blue">
			<td>${supplier.supId}</td>
			<td>${supplier.supName}</td>
			<td>${supplier.supDesc}</td>
			<td>${supplier.supAddress}</td>
			<td>
			
				<a href="<c:url value="deleteSupplier/${supplier.supId}"/>">DELETE</a>
				<a href="<c:url value="updateSupplier/${supplier.supId}"/>">UPDATE</a>
			</td>
		</tr>
	</c:forEach>

</table>
		

</body>
</html>