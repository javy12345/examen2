<%-- 
    Document   : index.jsp
    Created on : 12 sep. de 2023, 21:33:04
    Author     : PC
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Persona"%>
<%
    if(session.getAttribute("listaper")==null){
        ArrayList<Persona>lisaux = new ArrayList<Persona>();
        session.setAttribute("Listaper",lisaux);
    }
    ArrayList<Persona> lista = (ArrayList<Persona>) session.getAttribute("listaper");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRIMER PARCIAL</h1>
        <h3>NOMBRE: JAVIER EDUARDO TICONA QUISPE</h3>
        <h3>CARNET: 5470656</h3>
        
        <h3>GESTION DE PRODUCTOS</h3>
        <a href="MainServlet?op=nuevo">Nuevo Producto </a>
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Descripcion</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>Categoria</th>
            <tr>
 <%
    if(lista != null){
        for (Persona item : lista) {
   
%>
        <tr>  
            <td><%=item.getId()%></td>
            <td><%=item.getDescripcion()%></td>
            <td><%=item.getCantidad()%></td>
            <td><%=item.getPrecio()%></td>
            <td><%=item.getCategoria()%></td>
            
         <td>
             <a href="MainServlet?op=editar&id=<%= item.getId()%>">Editar</a>
         </td>
            <td>
             <a href="MainServlet?op=editar&id=<%= item.getId()%>"
                 onclick="return('confirm(esta seguro de eliminar?'))">Eliminar</a>
         </td>
         </tr>
         <%
             }
             }
         %>
        </table>    
    </body>
</html>
