<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Page</title>
<style type="text/css">
    body {
	background-color: pink;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Lets add employee</h2>

		<form action="jspToController" method="post" commandName="employee">
			<table border="1" cellpadding="3">
				<tr>
					<td width="120"><b>Employee Name</b></td>
					<td><input type="text" name="employeeName" size="45"
						value="<c:out value='${employee.employeeName}' />" />
					</td>
				</tr>

				<tr>
					<td width="130"><b>Employee Address</b></td>
					<td><input type="text" name="employeeAddress" size="45"
						value="<c:out value='${employee.employeeAddress}' />" />
					</td>
				</tr>

				<tr>
					<td width="120"><b>Employee Phone</b></td>
					<td><input type="text" name="employeePhone" size="45"
						value="<c:out value='${employee.employeePhone}' />" />
					</td>
				</tr>

				<tr>
					<td width="120"><b>Employee Salary</b></td>
					<td><input type="text" name="employeeSalary" size="45"
						value="<c:out value='${employee.employeeSalary}' />" />
					</td>
				</tr>
				
				<tr>
					<td align="center">
            			<input type="submit" value="Submit" />
            		</td>
            	
            		<td align="center">
            			<input type="reset" value="Reset" />
            		</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
