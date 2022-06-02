
package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import logicadenegocios.*;

public class ConsultaBitacoraCt {
    
    public ArrayList <String> ConsultarPorVistaXML(String pTipoVista){
        ArrayList <String> operacionesCuentas = new ArrayList(); 
         operacionesCuentas = ConsultaXML.consultaVista(pTipoVista);
         return operacionesCuentas;
          
    }
     public ArrayList <String> ConsultarPorFechaXML(){
       String pFecha = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
       ArrayList <String> operacionesCuentas = new ArrayList(); 
       operacionesCuentas =  ConsultaXML.consultaPorFecha(pFecha);
       return operacionesCuentas;
    }
     
    public ArrayList <String> ConsultarGeneralXML(){
       ArrayList <String> operacionesCuentas = new ArrayList(); 
       operacionesCuentas =  ConsultaXML.consultaGeneralXML();
       return operacionesCuentas;
    }
    
    
}
