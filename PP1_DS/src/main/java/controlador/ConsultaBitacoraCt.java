
package controlador;

import java.util.ArrayList;
import logicadenegocios.*;

public class ConsultaBitacoraCt {
    
    public ArrayList <String> ConsultarPorVistaXML(String pTipoVista){
        ArrayList <String> operacionesCuentas = new ArrayList(); 
         operacionesCuentas = ConsultaXML.consultaVista(pTipoVista);
         return operacionesCuentas;
          
    }
     /*public ArrayList <String> ConsultarPorFechaXML(String pTipoVista){
        ArrayList <String> operacionesCuentas = new ArrayList(); 
        operacionesCuentas =  ConsultaXML.consultaporFecha(pTipoVista);
        return operacionesCuentas;
    }*/
    
    
}
