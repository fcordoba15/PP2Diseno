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
import logicadenegocios.Administrador;


@WebServlet(urlPatterns = {"/InicioSesionWeb"})
public class InicioSesionWeb extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String usuario = request.getParameter("USUARIO");
    String contrasena = request.getParameter("CONTRASENA");
    

    if (AdministradorCt.inicioSesion(usuario, contrasena)==true){
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sesion Iniciada</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>¡Ha iniciado sesion como Administrador!"+"</h1>");
        out.println("<hr>");
        out.println("            <form name=\"registrosDiarios\" method=\"GET\" action=\"RegistrosDiariosWeb\" >\n" +
"                <hr>\n" +
"                <h2> Seleccione la consulta que desea</h2>\n" +
"                <button  >Consultar registros diarios por: </button>\n" +
"                <select name=\"TIPOS\">\n" +
"                    <optgroup label=\"Tipos\">\n" +
"                        <option value=\"1\">XML</option>\n" +
"                        <option value=\"2\">CSV</option>\n" +
"                        <option value=\"3\">Trama Plana</option>\n" +
"                    </optgroup>\n" +
"                </select>\n" +
"                \n" +
"                <BR>\n" +
"            </form>\n" +
"             <br>\n" +
"        <br>\n" +
"                        <form name=\"registrosDiarios\" method=\"GET\" action=\"RegistrosCLIWeb\" >\n" +
"\n" +
"                <button  >Consultar registros CLI por: </button>\n" +
"                <select name=\"TIPOS\">\n" +
"                    <optgroup label=\"Tipos\">\n" +
"                        <option value=\"1\">XML</option>\n" +
"                        <option value=\"2\">CSV</option>\n" +
"                        <option value=\"3\">Trama Plana</option>\n" +
"                    </optgroup>\n" +
"                </select>\n" +
"                <BR>\n" +
"            </form>\n" +
"         <br>\n" +
"        <br>\n" +
"            \n" +
"\n" +
"                        <form name=\"registrosDiarios\" method=\"GET\" action=\"RegistrosGUIWeb\" >\n" +
"\n" +
"                <button  >Consultar registros GUI por: </button>\n" +
"                <select name=\"TIPOS\">\n" +
"                    <optgroup label=\"Tipos\">\n" +
"                        <option value=\"1\">XML</option>\n" +
"                        <option value=\"2\">CSV</option>\n" +
"                        <option value=\"3\">Trama Plana</option>\n" +
"                    </optgroup>\n" +
"                </select>\n" +
"                <BR>\n" +
"            </form>\n" +
"         <br>\n" +
"        <br>\n" +
"                        \n" +
"\n" +
"                        <form name=\"registrosDiarios\" method=\"GET\" action=\"RegistrosWebWeb\" >\n" +
"\n" +
"                <button  >Consultar registros WEB por: </button>\n" +
"                <select name=\"TIPOS\">\n" +
"                    <optgroup label=\"Tipos\">\n" +
"                        <option value=\"1\">XML</option>\n" +
"                        <option value=\"2\">CSV</option>\n" +
"                        <option value=\"3\">Trama Plana</option>\n" +
"                    </optgroup>\n" +
"                </select>\n" +
"                <BR>\n" +
"            </form>\n" +
"         <br>\n" +
"        <br>\n" +
"                        \n" +
"\n" +
"                        <form name=\"registrosDiarios\" method=\"GET\" action=\"RegistrosTotalesWeb\" >\n" +
"\n" +
"                <button  >Consultar registros totales por: </button>\n" +
"                <select name=\"TIPOS\">\n" +
"                    <optgroup label=\"Tipos\">\n" +
"                        <option value=\"1\">XML</option>\n" +
"                        <option value=\"2\">CSV</option>\n" +
"                        <option value=\"3\">Trama Plana</option>\n" +
"                    </optgroup>\n" +
"                </select>\n" +
"                <BR>\n" +
"            </form>\n" +
"         <br>\n" +
"        <br>");
        out.println("<hr><a href=\"Iniciar/Consultas/InicioSesionBitacora.html\">Volver</a>");
        out.println("</body></html>");
                                   }
    else{
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sesion fallida</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  );    
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hay un error con su el usuario o la contraseña. Por favor intente denuevo.</h1>");
        out.println("<hr>");
        out.println("<hr><a href=\"Iniciar/Consultas/InicioSesionBitacora.html\">Volver</a>");
        out.println("</body></html>");
    }
  }

}