<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acto Vandalico Form</title>
</head>
<body>
	<form action="ActoVandalicoController">
		<label>Fecha:</label><br/>
		<input type="text" name="fecha" value="${acto.fecha}"><br/>
		
		<label>Cod Mobiliario:</label><br/>
		<input type="number" name="codigo" value="${acto.codigo}"><br/>
		
		<label>Lugar:</label><br/>
		<input type="text" name="lugar" value="${acto.lugar}"><br/>
		
		<label>Descripcion:</label><br/>
		<input type="text" name="descripcion" value="${acto.descripcion}"><br/><br/>
		
		
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>