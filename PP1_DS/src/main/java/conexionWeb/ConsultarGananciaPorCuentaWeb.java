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


@WebServlet(urlPatterns = {"/ConsultarGananciaPorCuentaWeb"})
public class ConsultarGananciaPorCuentaWeb extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String numeroCuenta = request.getParameter("NUMEROCUENTA");
    String tipoCuenta = request.getParameter("CUENTA");
    ActualizacionDatos.refrescarPrograma();

    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Ganancia por cuenta</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Ganancia por cuenta</h1>");
    out.println("<hr>");
    CuentaBancariaCt cuenta = new CuentaBancariaCt();
    if (Integer.parseInt(tipoCuenta) == 1){
        out.println(cuenta.consultarGananciasDepositosCuenta(numeroCuenta));
    }
    else if (Integer.parseInt(tipoCuenta) == 2){
        out.println(cuenta.consultarGananciasRetirosCuenta(numeroCuenta));
    }
    else{
        out.println(cuenta.consultarGananciasTotalesCuenta(numeroCuenta));
    }
    out.println("<hr><a href=\"Iniciar/consultas.html\">Volver</a>");
    out.println("</body></html>");
  }
}