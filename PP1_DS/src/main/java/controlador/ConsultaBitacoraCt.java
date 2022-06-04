
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
     
    public static ArrayList <String> consultarGeneralXML(){
       ArrayList <String> operacionesCuentas = new ArrayList(); 
       operacionesCuentas =  ConsultaXML.consultaGeneralXML();
       return operacionesCuentas;
    }
    
    public ArrayList <String> consultarPorVistaCSV (String pTipoVista) throws IOException{
        ArrayList <String> operacionesCuentas = new ArrayList();
        operacionesCuentas  = ConsultaCSV.consultaVista(pTipoVista);
        return operacionesCuentas;
    }
    
    public ArrayList <String> consultarPorFechaCSV () throws IOException{
        String pFecha = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        ArrayList <String> operacionesCuentas = new ArrayList();;
        operacionesCuentas  = ConsultaCSV.consultaPorFecha(pFecha);
        return operacionesCuentas;
    }
    
    public ArrayList <String> consultarGeneralCSV () throws IOException{
        ArrayList <String> operacionesCuentas = new ArrayList();
        operacionesCuentas  = ConsultaCSV.consultaGeneral();
        return operacionesCuentas;
    }
    
    public ArrayList <String> consultarPorVistaTramaPlana (String pTipoVista) throws IOException{
        ArrayList <String> operacionesCuentas = new ArrayList();
        operacionesCuentas  = ConsultaTramaPlana.consultaVista(pTipoVista);
        return operacionesCuentas;
    }
    
    public ArrayList <String> consultarPorFechaTramaPlana () throws IOException{
        String pFecha = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        ArrayList <String> operacionesCuentas = new ArrayList();
        operacionesCuentas  = ConsultaTramaPlana.consultaPorFecha(pFecha);
        return operacionesCuentas;
    }
    
    public ArrayList <String> consultarGeneralTramaPlana () throws IOException{
        ArrayList <String> operacionesCuentas = new ArrayList();
        operacionesCuentas  = ConsultaTramaPlana.consultaGeneral();
        return operacionesCuentas;
    }
}
