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
<!-- NO HACE FALTA DECLARAR LOS HTTP--- HttpSession s1 = request.getSession();-->


<%
	Contacto contacto1 = new Contacto(); 
	Contacto contacto2 = new Contacto();  

	if (session.getAttribute("contacto2")!=null) {
	contacto1 = (Contacto) session.getAttribute("contacto1");
	contacto2 = (Contacto) session.getAttribute("contacto2");
%>
	<h2>El contacto se ha modificado, datos antiguos:</h2>
	<br>Nombre:  <%= contacto1.getNombre()%> <br>
	<br>Email:  <%= contacto1.getEmail()%> <br>
	<br>Telefono:  <%= contacto1.getTelefono()%> <br>
	
	<h2>Los nuevos datos son:</h2>
	<br>Nombre:  <%= contacto2.getNombre()%> <br>
	<br>Email:  <%= contacto2.getEmail()%> <br>
	<br>Telefono:  <%= contacto2.getTelefono()%> <br>
	
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%}	else { %>
	<br><br><h2>No se han encontrado datos</h2>
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%} %>
</body>
</html>