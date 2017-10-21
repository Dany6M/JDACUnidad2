<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Form</title>
</head>
<body>
	<form action="LocationController">
		<label>Parent Id:</label><br/>
		<input type="text" name="parentId" value="${location.parentId}"><br/>
		
		<label>Location Type:</label><br/>
		<input type="text" name="type" value="${location.type}"><br/>
		
		<label>Name:</label><br/>
		<input type="text" name="name" value="${location.name}"><br/>
		
		
		<label>Code:</label><br/>
		<input type="number" name="code" value="${location.code}"><br/><br/>
			
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>