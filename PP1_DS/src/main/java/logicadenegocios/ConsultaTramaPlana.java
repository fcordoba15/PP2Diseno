/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ranbe
 */
public class ConsultaTramaPlana {
     static File file = new File("C:\\Users\\ranbe\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\tramaPlana.txt");
    //static File file = new File("C:\\Users\\fabih\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\tramaPlana.txt");
    //static File file = new File("C:\\Users\\Fiorella Mora\\Documents\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\tramaPlana.txt");
    public static ArrayList<String> consultaVista (String pVista) throws FileNotFoundException, IOException{
        FileReader aux = new FileReader(file);
        String msg;
        ArrayList <String> operacionesCuentas = new ArrayList();
        
        msg = obtenerDatos(aux);
        
        while (msg != ""){
            if (msg.substring(0,8).equals(pVista) == true){
                operacionesCuentas.add(obtenerLineaDatos(msg));
            }
            msg = eliminarLineaDatos(msg);
        }
        return operacionesCuentas;
    }
    
    public static ArrayList<String> consultaPorFecha (String pFecha) throws FileNotFoundException, IOException{
        FileReader aux = new FileReader(file);
        String fechaAux;
        String msg;
        ArrayList <String> operacionesCuentas = new ArrayList();
        
        msg = obtenerDatos(aux);
        
        while (msg != ""){
            
            fechaAux = obtenerFecha(msg);
            System.out.println(fechaAux);
            if (fechaAux.equals(pFecha) == true){
                operacionesCuentas.add(obtenerLineaDatos(msg));
            }
            msg = eliminarLineaDatos(msg);
        }
        return operacionesCuentas;
    }
    
    public static ArrayList<String> consultaGeneral () throws FileNotFoundException, IOException{
        FileReader aux = new FileReader(file);
        String msg;
        ArrayList <String> operacionesCuentas = new ArrayList();
        msg = obtenerDatos(aux);
        while (msg != ""){
            operacionesCuentas.add(obtenerLineaDatos(msg));
            msg = eliminarLineaDatos(msg);
        }
        return operacionesCuentas;
    }
    
    public static String obtenerFecha(String msg){
        String resultado ="";
        char indice = ' ';
        int contador = 0;
        while (indice != '\n'){
            if (contador > 15 && msg.substring(0,1).matches("[0-9]*")){
                resultado = msg.substring(0,10);
                return resultado;
            }
            contador+=1;
            msg = msg.substring(1);
        }
        return "";
    }
    
    public static String obtenerLineaDatos(String msg){
        String resultado ="";
        char indice = ' ';
        while (indice != '\n'){
            resultado += msg.substring(0,1);
            msg = msg.substring(1);
            indice = msg.charAt(0);
        }
        return resultado;     
    }
    
    public static String eliminarLineaDatos(String msg){
        char indice = ' ';
        while (indice != '\n'){
                msg = msg.substring(1);
                indice = msg.charAt(0);
        }
        msg = msg.substring(1);
        return msg;     
    }
    
    public static String obtenerDatos (FileReader file) throws IOException{
        String resultado = "";
        int ch;
        while ((ch = file.read()) != -1){
           resultado += (char)ch;
        }
        file.close();
        return resultado;
    }
}
