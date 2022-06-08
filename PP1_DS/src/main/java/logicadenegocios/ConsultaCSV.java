/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ranbe
 */
public class ConsultaCSV {
    //static String csv = "C:\\Users\\ranbe\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\CSV.csv";
    //static String csv = "C:\\Users\\fabih\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\CSV.csv"
    static String csv = "C:\\Users\\Fiorella Mora\\Documents\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\CSV.csv";
    
    public static ArrayList <String> consultaVista (String pVista) throws FileNotFoundException, IOException{
        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] fila = null;
        String msg;
        ArrayList <String> operacionesCuentas = new ArrayList();
        while((fila = reader.readNext()) != null) {
            msg ="";
            if (pVista.equals(fila[0]) == true){
                for (int i=0;i<5;i++){
                    msg += fila[i] + ",";
                }
                msg += fila[5] + "\n";
                operacionesCuentas.add(msg);
            }
            
        }
            
        reader.close();
        return operacionesCuentas;
    }
    
    public static ArrayList <String> consultaPorFecha (String pFecha) throws FileNotFoundException, IOException{
        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] fila = null;
        String msg;
        ArrayList <String> operacionesCuentas = new ArrayList();
        while((fila = reader.readNext()) != null) {
            msg ="";
            if (pFecha.equals(fila[3]) == true){
                for (int i=0;i<5;i++){
                    msg += fila[i] + ",";
                }
                msg += fila[5] + "\n";
                operacionesCuentas.add(msg);
            }
            
        }
            
        reader.close();
        return operacionesCuentas;
    }
    
    public static ArrayList <String> consultaGeneral () throws FileNotFoundException, IOException{
        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] fila = null;
        String msg;
        ArrayList <String> operacionesCuentas = new ArrayList();
        while((fila = reader.readNext()) != null) {
            msg = "";
            for (int i=0;i<5;i++){
                msg += fila[i] + ",";
            }
            msg += fila[5] + "\n";
            operacionesCuentas.add(msg);
        }   
        reader.close();
        return operacionesCuentas;
    }
}
