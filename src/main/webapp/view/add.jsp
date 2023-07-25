<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String[] numerosRomanos = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // Array de números romanos hasta el décimo semestre

    // Obtener el valor seleccionado (si hay uno) del request
    String semestreSeleccionado = request.getParameter("txtSemestre");
%>

<div class="container pt-3 pb-3 mt-3 mb-3 rounded border border-primary">
    <h4 class="mb-3 text-primary">Agregar Estudiante</h4>
    <form action="controller" method="POST">
        <div class="row">
            <div class="col-md-3">
                <span class="fw-bold">Código:</span><br>
                <input class="form-control" type="text" name="txtCodigo" required><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Nombres:</span><br>
                <input class="form-control" type="text" name="txtNombre" required><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Apellido Paterno:</span><br>
                <input class="form-control" type="text" name="txtApellido_P" required><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Apellido Materno:</span><br>
                <input class="form-control" type="text" name="txtApellido_M" required><br>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <span class="fw-bold">Dirección:</span><br>
                <input class="form-control" type="text" name="txtDireccion" required><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Teléfono:</span><br>
                <input class="form-control" type="text" name="txtTel" required><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">DNI:</span><br>
                <input class="form-control" type="text" name="txtDni" required><br>
            </div>
            <div class="col-md-3">
                <span class="fw-bold">Semestre:</span><br>
                <select class="form-control" name="txtSemestre" required>
                    <option value="">Seleccione un semestre</option>
                    <% for (String semestre : numerosRomanos) { %>
                        <option value="<%= semestre %>" <%= semestre.equals(semestreSeleccionado) ? "selected" : "" %>><%= semestre %></option>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <input type="hidden" name="action" value="add">
                <button class="btn btn-success text-uppercase fw-bold" type="submit">Agregar</button>
            </div>
        </div>
    </form>
</div>
