<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acto Vadalico List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="ActoVandalicoController">
					<input type="submit" name="btn_new" value="New" />
				</form>
			</th>
			<th>Id</th>
			<th>Fecha</th>
			<th>Cod Mobiliario</th>
			<th>Lugar</th>
			<th>Descripcion</th>
		</tr>
		<c:forEach var="acto" items="${actos}">
			<tr>
				<td>
					<form action="ActoVandalicoController">
						<input type="hidden" name="id" value="${acto.id}" />
						 <input type="submit" name="btn_edit" value="Edit" />
							 <input type="submit" name="btn_delete" value="Delete" />
							
					</form>
				</td>
				<td>${acto.id}</td>
				<td>${acto.fecha}</td>
				<td>${acto.codigo}</td>
				<td>${acto.lugar}</td>
				<td>${acto.descripcion}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>