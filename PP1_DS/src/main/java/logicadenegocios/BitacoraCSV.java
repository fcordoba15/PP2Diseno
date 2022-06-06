
package logicadenegocios;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitacoraCSV extends BitacoraNotificationObserver{
    static String csv = "C:\\Users\\ranbe\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\CSV.csv";
    public BitacoraCSV(CuentaBancaria pSubject) {
        subject= pSubject;
        subject.attach(this);
       
    }
    
    public void update() {
        try {
        Operacion operacion = subject.getExhangeRate();
            anadirABitacoraCSV (operacion, subject.numeroCuenta);
        } catch (Exception ex) {
            Logger.getLogger(BitacoraCSV.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void anadirABitacoraCSV (Operacion pCambio, int numCuenta) throws FileNotFoundException, IOException{
        String date = String.format("%1$tY-%1$tm-%1$td", pCambio.getFechaOperacion());
        CSVReader reader = new CSVReader(new FileReader(csv));
        List<String[]> allData = new ArrayList<String[]>();
        
        String[] data = new String[]{tipoVista(pCambio.getVista()),String.valueOf(numCuenta),pCambio.getTipoOperacion(),date,String.valueOf(pCambio.getMonto()),String.valueOf(pCambio.getMontoComision())};
        
        allData = reader.readAll();
        
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        
        writer.writeAll(allData);
        writer.writeNext(data);
        writer.close();
    }
    
    private String tipoVista(int pVista){
         switch (pVista) {
             case 0:
                 return "vistaCLI";
             case 1:
                 System.out.println("vistaGUI");
                 return "vistaGUI";
             default:
                 return "vistaWEB";
         }
    }
}
