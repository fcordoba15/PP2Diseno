/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import seguridad.AdministradorSc;
import java.lang.String;
import java.util.ArrayList;
import logicadenegocios.Administrador;
import static seguridad.AdministradorSc.autenticarCredenciales;
/**
 *
 * @author fabih
 */
public class AdministradorCt {
    static Administrador admin = new Administrador();
    public static boolean inicioSesion (String usuario, String contrasena){
        System.out.println(admin.getUser());
        System.out.println(admin.getPassword());
        if (autenticarCredenciales(usuario, contrasena, admin) == true){
            return true;
        }
        return false;
    }
}
