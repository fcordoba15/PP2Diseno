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
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/RetirarWeb"})
public class RetirarWeb extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String numeroCuenta = request.getParameter("NUMEROCUENTA");
    String divisa = request.getParameter("DIVISAS");
    String monto = request.getParameter("MONTO");
    String palabra = request.getParameter("PALABRA");
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Dinero Retirado</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>¡Dinero Retirado!</h1>");
    out.println("<hr>");
    
    ClienteCt cliente = new ClienteCt();
    if (Integer.parseInt(divisa) == 1){
        try {
            out.println(cliente.realizarRetiroDolares(numeroCuenta, monto, palabra, PalabraEnviadaWeb.pPalabra,2));
        } catch (Exception ex) {
            Logger.getLogger(RetirarWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else{
        out.println(cliente.realizarRetiroColones(numeroCuenta, monto, palabra, PalabraEnviadaWeb.pPalabra,2));
    }
    
    out.println("<hr><a href=\"Iniciar/operaciones.html\">Volver</a>");
    out.println("</body></html>");
  }

}