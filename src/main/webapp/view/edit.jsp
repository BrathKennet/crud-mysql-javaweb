<%@page import="model.Alumno"%>
<%@page import="modeldao.AlumnoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String[] numerosRomanos = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // Array de números romanos hasta el décimo semestre

    // Obtener el valor seleccionado (si hay uno) del request
    String semestreSeleccionado = request.getParameter("txtSemestre");
%>
<div class="container pt-3 pb-3 mt-3 mb-3 rounded border border-warning">
    <%
        AlumnoDAO dao = new AlumnoDAO();
        String id = (String)request.getAttribute("codigo");
        Alumno a = (Alumno)dao.list(id);
    %>
    <h4 class="mb-3 text-warning">Editar Estudiante</h4>
    <form action="controller" method="POST">
        <div class="row">
            <div class="col-md-3">
                <span class="fw-bold">Código:</span><br>
                <input class="form-control" type="text" name="txtCodigo" value="<%= a.getCodigo()%>"><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Nombres:</span><br>
                <input class="form-control" type="text" name="txtNombre" value="<%= a.getNombre()%>"><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Apellido Paterno:</span><br>
                <input class="form-control" type="text" name="txtApellido_P" value="<%= a.getApellido_P()%>"><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Apellido Materno:</span><br>
                <input class="form-control" type="text" name="txtApellido_M" value="<%= a.getApellido_M()%>"><br>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <span class="fw-bold">Dirección:</span><br>
                <input class="form-control" type="text" name="txtDireccion" value="<%= a.getDireccion()%>"><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Teléfono:</span><br>
                <input class="form-control" type="text" name="txtTel" value="<%= a.getTel()%>"><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">DNI:</span><br>
                <input class="form-control" type="text" name="txtDni" value="<%= a.getDni()%>"><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Semestre:</span><br>
                <select class="form-control" name="txtSemestre" required>
                    <% for (String semestre : numerosRomanos) { %>
                        <% if (a.getSemestre().equals(semestre)) { %>
                            <option selected value="<%= semestre %>"><%= semestre %></option>
                        <% } else { %>
                            <option value="<%= semestre %>"><%= semestre %></option>
                        <% } %>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <input type="hidden" name="txtIdT" value="<%= id%>">
                <input type="hidden" name="action" value="update">
                <button class="btn btn-warning text-uppercase fw-bold" type="submit">Actualizar</button>
            </div>
        </div>
    </form>
</div>