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


@WebServlet(urlPatterns = {"/AbrirCuentaBancariaWeb"})
public class AbrirCuentaBancariaWeb extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String identificacion = request.getParameter("NUMEROCUENTA");
    String pin = request.getParameter("PIN");
    String monto = request.getParameter("MONTO");
    ActualizacionDatos.refrescarPrograma();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Cuenta Bancaria Abierta</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>¡Cuenta Abierta!</h1>");
    out.println("<hr>");
    out.println(CuentaBancariaCt.resgistrarCuentaBancaria(monto, pin, identificacion) );
    out.println("<hr><a href=\"iniciar.html\">Volver</a>");
    out.println("</body></html>");
  }

}