
package seguridad;

import java.util.ArrayList;
import comunicacionExterna.CorreoElectronico;
import comunicacionExterna.MensajeSMS;
import logicadenegocios.Cliente;

public class ClienteSc {
     //método para autenticar que el cliente exista en el sistema
      public static boolean autenticarCliente(int pIdentificacion, ArrayList<Cliente>clientes){
          for (int i = 0; i < clientes.size(); i++){
            if ( clientes.get(i).getIdentificacion() == pIdentificacion){
                return true;
            }
        }
      return false; 
    }
      
    
}
