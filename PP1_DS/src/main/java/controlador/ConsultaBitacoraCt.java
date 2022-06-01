
package controlador;

import java.util.ArrayList;
import logicadenegocios.*;

public class ConsultaBitacoraCt {
    
    public void ConsultarPorVistaXML(String pTipoVista){
        ConsultaXML.consultaVista(pTipoVista);
          
    }
     public void ConsultarPorFechaXML(String pTipoVista){
        ConsultaXML.consultaporFecha(pTipoVista);
    
    }
    
    
}
