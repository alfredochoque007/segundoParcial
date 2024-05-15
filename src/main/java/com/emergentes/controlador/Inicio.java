package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.EstutianteDAO;

@WebServlet(name = "Inicio", urlPatterns = ("/inicio"))
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EstutianteDAO dao = new EstudianteDAOimpl();
            int id;
            Estudiante estudiante = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmEstudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    estudiante = dao.getById(id);
                    System.out.println(estudiante);
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmEstudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/inicio");
                    break;
                case "view":
                    List<Estudiante> lista = dao.getAll();

                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        boolean confirmacion = Boolean.parseBoolean(request.getParameter("confirmacion"));
        String fecha = request.getParameter("fecha");

        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombres(nombres);
        estudiante.setApellidos(apellidos);
        estudiante.setSeminario(seminario);
        estudiante.setConfirmacion(confirmacion);
        estudiante.setFecha(fecha);
        
        if (id == 0){
            try {
                EstutianteDAO dao = new EstudianteDAOimpl();
                dao.insert(estudiante);
                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            try {
                EstutianteDAO dao = new EstudianteDAOimpl();
                dao.update(estudiante);

                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
