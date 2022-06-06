package logicadenegocios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitacoraTramaPlana extends BitacoraNotificationObserver{
   
    static File file = new File("C:\\Users\\ranbe\\OneDrive\\Documentos\\GitHub\\PP2Diseno\\PP1_DS\\bitacoras\\tramaPlana.txt");
    
    public BitacoraTramaPlana(CuentaBancaria pSubject) {
        subject= pSubject;
        subject.attach(this);

    }

    BitacoraTramaPlana() {
    }
    
    public void update() {
        try {
            Operacion operacion = subject.getExhangeRate();
            anadirABitacoraTramaPlana (operacion, subject.numeroCuenta);
        } catch (Exception ex) {
            Logger.getLogger(BitacoraCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void anadirABitacoraTramaPlana (Operacion pCambio, int numCuenta) throws IOException{
        String date = String.format("%1$tY-%1$tm-%1$td", pCambio.getFechaOperacion());
        FileWriter aux = new FileWriter(file, true);
        aux.write(tipoVista(pCambio.getVista()) + String.valueOf(numCuenta) + pCambio.getTipoOperacion() + date + String.valueOf(pCambio.getMonto()) + String.valueOf(pCambio.getMontoComision()) + "\n");
        aux.close();
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
