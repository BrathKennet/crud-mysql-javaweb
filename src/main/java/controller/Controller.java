package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Alumno;
import modeldao.AlumnoDAO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    String index="/index.jsp";
    Alumno a = new Alumno();
    AlumnoDAO dao = new AlumnoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String access = "";
        String action = request.getParameter("action");

        switch (action) {
            case "add" -> {
                a.setId(a.generateId());
                a.setNombre(request.getParameter("txtNombre"));
                a.setApellido_P(request.getParameter("txtApellido_P"));
                a.setApellido_M(request.getParameter("txtApellido_M"));
                a.setDireccion(request.getParameter("txtDireccion"));
                a.setTel(request.getParameter("txtTel"));
                a.setDni(request.getParameter("txtDni"));
                a.setSemestre(request.getParameter("txtSemestre"));
                a.setCodigo(request.getParameter("txtCodigo"));
                dao.add(a);
                access = index;
            }
            case "update" -> {
                String idT = request.getParameter("txtIdT");
                a.setId(request.getParameter("txtIdT"));
                a.setNombre(request.getParameter("txtNombre"));
                a.setApellido_P(request.getParameter("txtApellido_P"));
                a.setApellido_M(request.getParameter("txtApellido_M"));
                a.setDireccion(request.getParameter("txtDireccion"));
                a.setTel(request.getParameter("txtTel"));
                a.setDni(request.getParameter("txtDni"));
                a.setSemestre(request.getParameter("txtSemestre"));
                a.setCodigo(request.getParameter("txtCodigo"));
                dao.edit(a, idT);
                access = index;
            }
            case "delete" -> {
                String id = request.getParameter("id");
                a.setId(id);
                dao.delete(id);
                access = index;
            }
            case "changeForm" -> {
                request.setAttribute("codigo", request.getParameter("id"));
                access = index;
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(access);
        view.forward(request, response);

    }


    /*@Override
    public String getServletInfo() {
        return "Short description";
    }*/

}
