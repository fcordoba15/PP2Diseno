/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad;
import logicadenegocios.Administrador;
/**
 *
 * @author fabih
 */
public class AdministradorSc {
    public static boolean autenticarCredenciales (String usuario, String contrasena, Administrador admin){
        if (admin.getUser().equals(usuario)){
            if (admin.getPassword().equals(contrasena)){
                return true;
            }
            else{
                return false; 
            }
        }
        else{
           return false; 
        }
    }
}
