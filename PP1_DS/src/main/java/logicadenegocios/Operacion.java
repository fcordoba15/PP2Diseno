
package logicadenegocios;

import java.time.LocalDate;
import java.util.ArrayList;


public class Operacion {
    private LocalDate fechaOperacion;
    private String tipoOperacion;
    private double monto;
    private boolean comision;
    private double montoComision;
    private int vista;

    public Operacion(String pTipoOperacion, double pMonto,double pMontoComision, int pVista) {
        setTipoOperacion(pTipoOperacion);
        setMonto(pMonto);
        obtenerFechaActual();
        setMontoComision(pMontoComision);
        setVista(pVista);
    }

    Operacion() {
 
    }

 
    private void obtenerFechaActual(){
        LocalDate fechaActual = LocalDate.now();
        fechaOperacion = fechaActual;
    }

    public void setFechaOperacion(LocalDate pFechaOperacion){
        fechaOperacion = pFechaOperacion;
    }
    public void setTipoOperacion(String pTipoOperacion) {
        tipoOperacion = pTipoOperacion;
    }

    public void setMonto(double pMonto) {
        monto = pMonto;
    }

    public void setComision(boolean pComision) {
        comision = pComision;
    }
   
    

    public void setMontoComision(double montoComision) {
        this.montoComision = montoComision;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isComision() {
        return comision;
    }

    public double getMontoComision() {
        return montoComision;
    }
    
      public int getVista() {
        return vista;
    }

    private void setVista(int pVista) {
       vista = pVista;
    }
}
