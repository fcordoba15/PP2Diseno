
package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import logicadenegocios.*;

public class ConsultaBitacoraCt {
    
    public ArrayList <String> consultarPorVistaXML(String pTipoVista){
        ArrayList <String> operacionesCuentas = new ArrayList(); 
        operacionesCuentas = ConsultaXML.consultaVista(pTipoVista);
        return operacionesCuentas;
          
    }
     public ArrayList <String> consultarPorFechaXML(){
       String pFecha = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
       ArrayList <String> operacionesCuentas = new ArrayList(); 
       operacionesCuentas =  ConsultaXML.consultaPorFecha(pFecha);
       return operacionesCuentas;
    }
     
    public ArrayList <String> consultarGeneralXML(){
       ArrayList <String> operacionesCuentas = new ArrayList(); 
       operacionesCuentas =  ConsultaXML.consultaGeneralXML();
       return operacionesCuentas;
    }
    
    public String consultarPorVistaCSV (String pTipoVista) throws IOException{
        String resultado;
        resultado = ConsultaCSV.consultaVista(pTipoVista);
        return resultado;
    }
    
    public String consultarPorFechaCSV () throws IOException{
        String pFecha = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        String resultado;
        resultado = ConsultaCSV.consultaPorFecha(pFecha);
        return resultado;
    }
    
    public String consultarGeneralCSV () throws IOException{
        String resultado;
        resultado = ConsultaCSV.consultaGeneral();
        return resultado;
    }
    
    public String consultarPorVistaTramaPlana (String pTipoVista) throws IOException{
        String resultado;
        resultado = ConsultaTramaPlana.consultaVista(pTipoVista);
        return resultado;
    }
    
    public String consultarPorFechaTramaPlana () throws IOException{
        String pFecha = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        String resultado;
        resultado = ConsultaTramaPlana.consultaPorFecha(pFecha);
        return resultado;
    }
    
    public String consultarGeneralTramaPlana () throws IOException{
        String resultado;
        resultado = ConsultaTramaPlana.consultaGeneral();
        return resultado;
    }
}
