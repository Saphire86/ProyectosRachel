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
	Contacto cont = null; 

	if (session.getAttribute("contacto")!=null) {
	cont = (Contacto) session.getAttribute("contacto");
%>
	<h2>El contacto se ha insertado correctamente, los nuevos datos son:</h2>
	<h3>Datos del Contacto</h3>
	<br>Nombre:  <%= cont.getNombre()%> <br>
	<br>Email:  <%= cont.getEmail()%> <br>
	<br>Telefono:  <%= cont.getTelefono()%> <br>	
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%}	else { %>
	<br><br><h2>Error al insertar</h2>
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%} %>
</body>
</html>