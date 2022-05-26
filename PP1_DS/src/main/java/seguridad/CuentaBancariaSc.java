
package seguridad;

import java.util.ArrayList;
import logicadenegocios.CuentaBancaria;
import logicadenegocios.Cliente;
import comunicacionExterna.CorreoElectronico;
import comunicacionExterna.MensajeSMS;
public class CuentaBancariaSc {
    
    //autenticación para iniciar operaciones en cuentas
    public static boolean autenticarCuenta( int pNumCuenta,String pPin,ArrayList<Cliente>clientes){
        for (int i = 0; i < clientes.size(); i++){
            for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                if(autenticarNumCuenta(pNumCuenta,clientes) == true && autenticarPin(pNumCuenta,pPin,clientes) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Método para inactivar una cuenta en caso de anomalías (pin y mensaje)
    public static void inactivarCuenta(int pNumCuenta,ArrayList<Cliente>clientes){
        for (int i = 0; i < clientes.size(); i++){
                for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                    if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == pNumCuenta){
                        clientes.get(i).getMisCuentas().get(j).setActiva(false);
                        
                        MensajeSMS.enviarMensaje(String.valueOf(clientes.get(i).getNumeroTelefonico()), "Estimado Usuario! \n Su cuenta Num:"+ pNumCuenta+ "se inactivo por cuestiones de seguridad.");
                        CorreoElectronico.enviarCorreo(clientes.get(i).getCorreoElectronico(),"Inactivacion Cuenta Bancaria", "Estimado Usuario! \n Su cuenta Num:"+ pNumCuenta+ "se inactivo por cuestiones de seguridad.");
                    }
                }
            }
        
    }
         
    
    public static boolean autenticarNumCuenta(int pNumCuenta,ArrayList<Cliente>clientes){
            for (int i = 0; i < clientes.size(); i++){
                for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                    if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == pNumCuenta && clientes.get(i).getMisCuentas().get(j).isActiva().equals("Activa")){
                        return true;
                    }
                }
            }
      return false; 
    }
    
    private static boolean autenticarPin(int pNumCuenta,String pPin,ArrayList<Cliente>clientes){
        for (int i = 0; i < clientes.size(); i++){
                for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                    if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == pNumCuenta && clientes.get(i).getMisCuentas().get(j).getPin().equals(pPin)){
                        return true;
                    }
                }
            }
      return false;
    }
      
  }
    

