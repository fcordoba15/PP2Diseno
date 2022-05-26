
package validaciones;

import java.util.regex.*;
import java.util.*;
import logicadenegocios.Cliente;
import seguridad.ClienteSc;

public class ValidacionCliente {
    
    public static boolean validarNumTelefonico(int pNumeroTelefono){
        int cantCifras = 0;
        
        while(pNumeroTelefono!=0){
            pNumeroTelefono = pNumeroTelefono/10;
            cantCifras++;                    
        }
        if(cantCifras>7){
            return true;
        }else{
            return false;
        }   
    }
    
    public static boolean validarCorreoElectronico(String pCorreo){
         String regx = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(pCorreo);
        return matcher.matches();
    }
    
   
    
    
    
    
 
}
