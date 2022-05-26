/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package conexionWeb;

import controlador.ActualizacionDatos;
import controlador.CuentaBancariaCt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet(name = "ConsultarCuentaWeb", urlPatterns = {"/ConsultarCuentaWeb"})
public class ConsultarCuentaWeb extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static String holaaa = "Holaaaa";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("        <title>Consultar Cuenta</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link href='Inicio.css' rel='stylesheet' type='text/css'/>");    
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Consultar Cuenta</h1>\n" + "        <nav>");
            out.println(" <details>\n" + "  <summary>Lista de cuentas</summary>\n" +
            "  <p>"+ "</p>\n" + "</details> ");
        ActualizacionDatos.refrescarPrograma();    
        CuentaBancariaCt datosCuentas = new CuentaBancariaCt();
        ArrayList<String> listaDatos = datosCuentas.listarCuentas();
        for (int i = 0; i < listaDatos.size(); i++){
            out.println(" <details>\n" + "  <p>"+ listaDatos.get(i) +"</p>\n" + "</details> ");
        }        
        
            out.println("<form METHOD=\"GET\" action=\"CuentaConsultadaWeb\">\n" +
"                <hr>\n" +
"                <label>Numero de cuenta :</label>\n" +
"                <input type=\"Number\"  name=\"NUMEROCUENTA\" required>"
            + "            <br><br>\n" +
"                <button>Consultar</button>\n" +
"            </form>\n" +
"        </nav>\n" +
"        <hr>\n" +
"        <a href=\"Iniciar/consultas.html\">Volver</a>" );
            out.println("<link href='Inicio.css' rel='stylesheet' type='text/css'/>  "  ); 
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}