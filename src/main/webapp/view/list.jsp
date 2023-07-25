<%@page import="java.util.Iterator"%>
<%@page import="model.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="modeldao.AlumnoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="mb-3 mt-5">
    <h4 class="mb-3 text-info">Lista de Estudiantes</h4>
    <div style="overflow-y: scroll; max-height: 360px;">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Apellido Paterno</th>
                    <th scope="col">Apellido Materno</th>
                    <th scope="col">Nombres</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Semestre</th>
                    <th scope="col">ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <%
                    AlumnoDAO dao = new AlumnoDAO();
                    List<Alumno> list = dao.listar();
                    Iterator<Alumno> iter = list.iterator();
                    Alumno al = null;
                    while(iter.hasNext()) {
                        al = iter.next();
                %>
                <tr>
                    <th scope="row"><%= al.getCodigo()%></th>
                    <td><%= al.getApellido_P()%></td>
                    <td><%= al.getApellido_M()%></td>
                    <td><%= al.getNombre()%></td>
                    <td><%= al.getDireccion()%></td>
                    <td><%= al.getTel()%></td>
                    <td><%= al.getDni()%></td>
                    <td><%= al.getSemestre()%></td>
                    <td>
                        <form action="controller" method="POST" style="display: inline;">
                            <input type="hidden" name="action" value="changeForm">
                            <input type="hidden" name="id" value="<%= al.getId()%>">
                            <button type="submit" class="btn btn-warning" name="editBtn">Editar</button>
                        </form>
                        <form action="controller" method="POST" style="display: inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="<%= al.getId()%>">
                            <button type="submit" class="btn btn-danger"  onclick="return confirmDelete()">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

<script>
    function confirmDelete() {
        return confirm("¿Estás seguro de que deseas eliminar este estudiante?");
    }
</script>