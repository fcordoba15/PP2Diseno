/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package conexionWeb;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.*;


@WebServlet(urlPatterns = {"/ConsultarEstadoCuentaWeb"})
public class ConsultarEstadoCuentaWeb extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String numeroCuenta = request.getParameter("NUMEROCUENTA");
    String pin = request.getParameter("PIN");
    String divisa = request.getParameter("DIVISAS");
    ActualizacionDatos.refrescarPrograma();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Estado de Cuenta</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Estado de Cuenta</h1>");
    out.println("<hr>");
    ClienteCt cliente = new ClienteCt();
    if (Integer.parseInt(divisa) == 1){
        out.println(cliente.consultarEstadoCuentaDolares (numeroCuenta, pin));
    }
    else{
        out.println(cliente.consultarEstadoCuentaColones (numeroCuenta, pin));
    }
        
    out.println("<hr><a href=\"Iniciar/consultas.html\">Volver</a>");
    out.println("</body></html>");
  }
}