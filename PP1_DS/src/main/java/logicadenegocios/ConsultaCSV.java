/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ranbe
 */
public class ConsultaCSV {
    static String csv = "C:\\Users\\ranbe\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\CSV.csv";
    
    public static String consultaVista (String pVista) throws FileNotFoundException, IOException{
        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] fila = null;
        String msg ="";
        while((fila = reader.readNext()) != null) {
            if (pVista.equals(fila[0]) == true){
                for (int i=0;i<5;i++){
                    msg += fila[i] + ",";
                }
                msg += fila[5] + "\n";
            }
            
        }
            
        reader.close();
        return msg;
    }
    
    public static String consultaPorFecha (String pVista) throws FileNotFoundException, IOException{
        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] fila = null;
        String msg ="";
        while((fila = reader.readNext()) != null) {
            if (pVista.equals(fila[3]) == true){
                for (int i=0;i<5;i++){
                    msg += fila[i] + ",";
                }
                msg += fila[5] + "\n";
            }
            
        }
            
        reader.close();
        return msg;
    }
    
    public static String consultaGeneral () throws FileNotFoundException, IOException{
        CSVReader reader = new CSVReader(new FileReader(csv));
        String[] fila = null;
        String msg ="";
        while((fila = reader.readNext()) != null) {
            for (int i=0;i<5;i++){
                msg += fila[i] + ",";
            }
            msg += fila[5] + "\n";    
        }   
        reader.close();
        return msg;
    }
}
