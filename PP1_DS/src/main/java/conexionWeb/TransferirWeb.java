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


@WebServlet(urlPatterns = {"/TransferirWeb"})
public class TransferirWeb extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String numeroCuenta = request.getParameter("NUMEROCUENTA");
    String numeroCuentaDestino = request.getParameter("NUMEROCUENTADES");
    String pin = request.getParameter("PIN");
    String palabra = request.getParameter("PALABRA");
    String monto = request.getParameter("MONTO");
    ActualizacionDatos.refrescarPrograma();
    ClienteCt cliente = new ClienteCt();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Transferencia Realizada</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>¡Transferencia Realizada!</h1>");
    out.println("<hr>");
    out.println(cliente.realizarTransferencia(numeroCuenta, numeroCuentaDestino, monto, pin, palabra));
    out.println("<hr><a href=\"Iniciar/operaciones.html\">Volver</a>");
    out.println("</body></html>");
  }

}
