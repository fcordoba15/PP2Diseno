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


@WebServlet(urlPatterns = {"/PalabraEnviadaWeb"})
public class PalabraEnviadaWeb extends HttpServlet {

    static String numeroCuenta1;
    static String pin1;
    static String pPalabra;

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
      
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String numeroCuenta1 = request.getParameter("NUMEROCUENTA");
    String pin1 = request.getParameter("PIN");
    ActualizacionDatos.refrescarPrograma();
    ClienteCt cliente = new ClienteCt();
    pPalabra = cliente.realizarRetiroColonesAux(numeroCuenta1, pin1);
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Palabra enviada</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>¡Palabra enviada!</h1>");
    out.println("Se ha enviado una palabra se seguridad por mensaje a su celular.");
    out.println("</body></html>");
  }
}