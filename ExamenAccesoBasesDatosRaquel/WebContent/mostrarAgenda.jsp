<%@page import="app.modelo.Contacto"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla</title>
</head>
<body>
<h1>Lista de contactos</h1>
<% ArrayList <Contacto> lista = (ArrayList<Contacto>)request.getAttribute("lista"); %>
<table border = "1">
<tr>
<th>IdContacto</th>
<th>Nombre</th>
<th>Email</th>
<th>Telefono</th>
</tr>

<% for(Contacto cont:lista){%>
<tr>
<td><%= cont.getIdContacto()%></td>
<td><%= cont.getNombre()%></td>
<td><%= cont.getEmail()%></td>
<td><%= cont.getTelefono()%></td>
</tr>
<% }%>
</table>
<br><br>

<a href="index.jsp">Volver al indice</a>
</body>
</html>