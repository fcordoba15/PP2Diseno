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
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/RegistrosCLIWeb"})
public class RegistrosCLIWeb extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String tipo = request.getParameter("TIPOS");

    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Registros CLI</title>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Registros CLI</h1>");
    out.println("<hr>");
    
    if (Integer.parseInt(tipo) == 1){
        ConsultaBitacoraCt consulta = new ConsultaBitacoraCt();
        ArrayList<String> datosXML = consulta.consultarPorVistaXML("vistaCLI"); 
        for (int i = 0; i < datosXML.size(); i++){
            out.println(" <details>\n" + "  <p>"+ datosXML.get(i) +"</p>\n" + "</details> ");
        }   
        out.println("<hr>");
        out.println("<form method=\"get\" action=\"vistaCLI.xml\">\n" +"            \n" +"            <button>Abrir árbol XML</button>\n" +"        </form>");    
    }
    
    else if (Integer.parseInt(tipo) == 2){
        ConsultaBitacoraCt consultaCSV = new ConsultaBitacoraCt();
        ArrayList<String> datosCSV = consultaCSV.consultarPorVistaCSV("vistaCLI"); 
        for (int i = 0; i < datosCSV.size(); i++){
            out.println(" <details>\n" + "  <p>"+ datosCSV.get(i) +"</p>\n" + "</details> ");
        }  
    }
    else{
        ConsultaBitacoraCt consultaTRAMAPLANA = new ConsultaBitacoraCt();
        ArrayList<String> datosTRAMAPLANA = consultaTRAMAPLANA.consultarPorVistaTramaPlana("vistaCLI"); 
        for (int i = 0; i < datosTRAMAPLANA.size(); i++){
            out.println(" <details>\n" + "  <p>"+ datosTRAMAPLANA.get(i) +"</p>\n" + "</details> ");
        }  
    }

    out.println("<hr><a href=\"Iniciar/Consultas/ConsultarBitacora.html\">Volver</a>");
    out.println("</body></html>");
  }

}