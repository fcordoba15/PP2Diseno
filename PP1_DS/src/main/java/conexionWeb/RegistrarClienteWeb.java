
package conexionWeb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;



@WebServlet(urlPatterns = {"/RegistrarClienteWeb "})
public class RegistrarClienteWeb extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String nombre = request.getParameter("NOMBRE");
    String apellido1 = request.getParameter("APELLIDO1");
    String apellido2 = request.getParameter("APELLIDO2");
    String cedula = request.getParameter("CEDULA");
    String telefono = request.getParameter("TELEFONO");
    String correo = request.getParameter("CORREO");
    String dia = request.getParameter("DIA");
    String mes = request.getParameter("MES");
    String anio = request.getParameter("AÑO");
    ActualizacionDatos.refrescarPrograma();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Cliente registrado</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>¡Usuario registrado!</h1>");
    out.println("<hr>");
        try {
            ClienteCt cliente = new ClienteCt();
            out.println(cliente.registrarCliente(apellido1, apellido2, nombre, cedula, dia, mes, anio, telefono, correo));
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarClienteWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    out.println("<hr><a href=\"index.html\">Volver</a>");
    out.println("</body></html>");
  }

}
