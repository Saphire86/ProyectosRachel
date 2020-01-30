<%@page import="app.modelo.Contacto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="ISO-8859-1">
<title>Datos empleado</title>
</head>
<body>
<!-- NO HACE FALTA DECLARAR LOS HTTP--- HttpSession s1 = request.getSession();-->
<%
	Contacto con = null; 

	if (session.getAttribute("contacto")!=null) {
	con = (Contacto) session.getAttribute("contacto");
%>
	<h2>Su solicitud se ha recibido</h2>
	<h3>Datos del Contacto Solicitado</h3>
	<br>Nombre:  <%= con.getNombre()%> <br>
	<br>Email:  <%= con.getEmail()%> <br>
	<br>Telefono:  <%= con.getTelefono()%> <br>
		
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%}	else { %>
	<br><br><h2>No se han encontrado datos</h2>
	<br><br><a href='index.jsp'>Volver al indice</a>
	<%} %>
</body>
</html>