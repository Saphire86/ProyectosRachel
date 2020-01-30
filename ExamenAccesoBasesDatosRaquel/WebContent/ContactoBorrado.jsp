<%@page import="app.modelo.Contacto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datos empleado modificado</title>
</head>
<body>
<%
	Contacto contacto = new Contacto();; 
	
	if (session.getAttribute("contacto")!=null) {
	contacto = (Contacto) session.getAttribute("contacto");
	
%>
	<h2>El contacto se ha borrado con éxito, datos borrados:</h2>
	<br>Nombre:  <%= contacto.getNombre()%> <br>
	<br>Email:  <%= contacto.getEmail()%> <br>
	<br>Telefono:  <%= contacto.getTelefono()%> <br>
			
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%}	else { %>
	<br><br><h2>Error en el borrado</h2>
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%} %>
</body>
</html>