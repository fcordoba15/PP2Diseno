
package logicadenegocios;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import comunicacionExterna.CambioMoneda;
import util.Comparable;
import validaciones.ValidacionCuenta;



public class CuentaBancaria implements Comparable{
    protected int numeroCuenta;
    protected LocalDate fechaCreacion; 
    protected double saldo;
    protected boolean activa;
    protected String pin; 
    protected Cliente duenio;
    protected ArrayList<Operacion> operaciones;
    protected int cantidadOperacionesRetirosDepositos;  
    

    public CuentaBancaria(double pSaldo, String pPin, Cliente pDuenio) {
        setFechaCreacion();
        setSaldo(pSaldo);
        setActiva(true);
        setPin(pPin);
        setDuenio(pDuenio);
        setNumeroCuenta();
        setCantidadOperacionesRetirosDepositos(0);
        operaciones = new ArrayList <Operacion>();
    }  
    
    public CuentaBancaria() {

    }
    
    public void cambiarPin(String pPin){
        setPin(pPin);
        agregarOperacion("Cambio de pin",0,0);
    }
    
    public String depositarColones(double pMontoDeposito){
        DecimalFormat df = new DecimalFormat("#.00");
        ValidacionCuenta aux = new ValidacionCuenta();
        double montoComision = 0;
        if (aux.validarCobroComision(getCantidadOperacionesRetirosDepositos()) != true){
            montoComision = calcularComision(pMontoDeposito);
        }
        setSaldo(getSaldo() + (pMontoDeposito - montoComision));
        setCantidadOperacionesRetirosDepositos(getCantidadOperacionesRetirosDepositos() + 1);
        agregarOperacion("Deposito",pMontoDeposito,montoComision);
        return "Estimado usuario, se han depositado correctamente " + pMontoDeposito +" colones" + "\n[El monto real depositado a su cuenta " + getNumeroCuenta() + " es de " + pMontoDeposito + " colones]" + "\n[El monto cobrado por concepto de comisión fue de " + df.format(montoComision) + " colones, que  fueron rebajados automáticamente de su saldo actual]";
    }
    
    public String depositarDolares(double pMontoDeposito){
        DecimalFormat df = new DecimalFormat("#.00");
        double montoDepositoColones = calcularTipoCambioCompra(pMontoDeposito);
        ValidacionCuenta aux = new ValidacionCuenta();
        double montoComision = 0;
        if (aux.validarCobroComision(getCantidadOperacionesRetirosDepositos()) != true){
            montoComision = calcularComision(montoDepositoColones);
        }
        setSaldo(getSaldo() + (montoDepositoColones - montoComision));
        setCantidadOperacionesRetirosDepositos(getCantidadOperacionesRetirosDepositos() + 1);
        agregarOperacion("Deposito",montoDepositoColones,montoComision);
        return "Estimado usuario, se han recibido correctamente " + pMontoDeposito + " dolares" + "\n[Según el BCCR, el tipo de cambio de compra del dólar del " + obtenerFechaActual() + " es: " + calcularTipoCambioCompra(1) + "\n[El monto equivalente en colones es " + df.format(montoDepositoColones) + "]\n[El monto real depositado a su numero de cuenta " + getNumeroCuenta() + " es de " + pMontoDeposito + " dolares]" + "\n[El monto cobrado por concepto de comisión fue de " + df.format(montoComision) + " colones, que  fueron rebajados automáticamente de su saldo actual]";
    }
    
    public String retirarColones(double pMontoRetiro){
        DecimalFormat df = new DecimalFormat("#.00");
        ValidacionCuenta aux = new ValidacionCuenta();
        double montoComision = 0;
        if (aux.validarCobroComision(getCantidadOperacionesRetirosDepositos()) != true){
            montoComision = calcularComision(pMontoRetiro);
        }
        setSaldo(getSaldo() - (pMontoRetiro + montoComision));
        setCantidadOperacionesRetirosDepositos(getCantidadOperacionesRetirosDepositos() + 1);
        agregarOperacion("Retiro",pMontoRetiro,montoComision);
        return "Estimado usuario, el monto de este retiro es " + pMontoRetiro + " colones." + "\n[El monto cobrado por concepto de comisión fue de " + df.format(montoComision) + " colones, que  fueron rebajados automáticamente de su saldo actual]";
    }
    
    public String retirarDolares(double pMontoRetiro){
        DecimalFormat df = new DecimalFormat("#.00");
        
        double montoRetiroColones = calcularTipoCambioVenta(pMontoRetiro);
        ValidacionCuenta aux = new ValidacionCuenta();
        double montoComision = 0;
        if (aux.validarCobroComision(getCantidadOperacionesRetirosDepositos()) != true){
            montoComision = calcularComision(montoRetiroColones);
        }
        setSaldo(getSaldo() - (montoRetiroColones + montoComision));
        setCantidadOperacionesRetirosDepositos(getCantidadOperacionesRetirosDepositos() + 1);
        agregarOperacion("Retiro",montoRetiroColones,montoComision);
        return "Estimado usuario, el monto de este retiro es " + pMontoRetiro + " dólares." + "\n[Según el BCCR, el tipo de cambio de venta del dólar de hoy es: " + calcularTipoCambioVenta(1) + "]\n[El monto equivalente de su retiro es " + df.format(montoRetiroColones) + " colones] \n[El monto cobrado por concepto de comisión fue de " + df.format(montoComision) + " colones, que fueron rebajados automáticamente de su saldo actual]";
    }
    
    public String transferirMonto (double pMonto){
        DecimalFormat df = new DecimalFormat("#.00");
        ValidacionCuenta aux = new ValidacionCuenta();
        double montoComision = 0;
        if (aux.validarCobroComision(getCantidadOperacionesRetirosDepositos()) != true){
            montoComision = calcularComision(pMonto);
        }
        setSaldo(getSaldo() - (pMonto + montoComision));
        agregarOperacion("Transferencia",pMonto,montoComision);
        return "Estimado usuario, la transferencia de fondos se ejecutó satisfactoriamente. El monto retirado de la cuenta origen y depositado en la cuenta destino es " + pMonto + "colones. \n" + "[El monto cobrado por concepto de comisión a la cuenta origen fue de " + df.format(montoComision) + " colones, que fueron rebajados automáticamente de su saldo actual]";
    }
    
    public String consultarSaldoCuentaColones(){
        DecimalFormat df = new DecimalFormat("#.00");
        agregarOperacion("Consulta",0,0);
        return "Estimado usuario el saldo actual de su cuenta es " + df.format(getSaldo()) + " colones. ";
    }
    
    public String consultarSaldoCuentaDolares(){
        DecimalFormat df = new DecimalFormat("#.00");
        agregarOperacion("Consulta",0,0);
        return "Estimado usuario el saldo actual de su cuenta es " + df.format(getSaldo()/calcularTipoCambioCompra(1)) + " dólares.\nPara esta conversión se utilizó el tipo de cambio del dólar, precio de compra.\n[Según el BCCR, el tipo de cambio de compra del dólar de hoy es:" + calcularTipoCambioCompra(1) + "]"; 
    }
    
    public String consultarEstadoCuentaColones (){
        DecimalFormat df = new DecimalFormat("#.00");
        agregarOperacion("Consulta",0,0);
        return "Propietario: " + duenio.getNombre() + duenio.getPrimerApellido() + "\nFecha creacion: " + getFechaCreacion() + "\nNumero de Cuenta: " + getNumeroCuenta() + "\nSaldo en colones: " + df.format(getSaldo());
    }
    
    public String consultarEstadoCuentaDolares(){
        DecimalFormat df = new DecimalFormat("#.00");
        agregarOperacion("Consulta",0,0);
        return "Duenio: " + duenio.getNombre() + duenio.getPrimerApellido() + "\nFecha creacion: " + getFechaCreacion() + "\nNumero de Cuenta: " + getNumeroCuenta() + "\nSaldo en dolares: " + df.format(getSaldo()/calcularTipoCambioVenta(1));
    }
    
    public String consultarStatusCuenta(){
        agregarOperacion("Consulta",0,0);
        return "“La cuenta número " + getNumeroCuenta() + " se encuentra: " + isActiva();
    }
    
    public boolean menorQue(Comparable pOtroObjeto){
        return getSaldo() > ((CuentaBancaria)pOtroObjeto).getSaldo();
    }
    
     //Se debe acceder desde la clase cliente
    public LocalDate obtenerFechaActual(){
        LocalDate fechaActual = LocalDate.now();
        return fechaActual;
    }
    
    //Se debe acceder desde la clase cliente
    public void agregarOperacion (String pTipoOperacion, double pMonto,double pMontoComision){
        Operacion nuevaOperacion = new Operacion (pTipoOperacion, pMonto, pMontoComision);
        operaciones.add(nuevaOperacion);
    }
    
    public void agregarOperacion(String pTipoOperacion, double pMonto, double pMontoComision, 
            LocalDate pFechaCreacion, boolean pIsComision) {
         Operacion operacion = new Operacion (pTipoOperacion, pMonto, pMontoComision);
         operacion.setComision(pIsComision);
         operacion.setFechaOperacion(pFechaCreacion);

         operaciones.add(operacion);
    }
    
    
    public double calcularComision(double pMonto){
        return pMonto * 0.02;
    }
    
    public double calcularTipoCambioCompra(double pMonto){
        CambioMoneda aux = new CambioMoneda ();
        return pMonto * aux.getCompra();
    }
    
    public double calcularTipoCambioVenta(double pMonto){
        CambioMoneda aux = new CambioMoneda ();
        return pMonto * aux.getVenta();
    }
        
    public void setNumeroCuenta() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=7000; i<100000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i=0; i<3; i++) {
          numeroCuenta =  list.get(i);
        }
    }

    public void setDuenio (Cliente pDuenio){
        duenio = pDuenio;
    }
    
    public void setFechaCreacion(){
        fechaCreacion = obtenerFechaActual();
    }

    public void setSaldo(double pSaldo) {
        saldo = pSaldo;
    }

    public void setActiva(boolean pActiva) {
        activa = pActiva;
    }

    public void setPin(String pPin) {
        pin = pPin;
    }
    public void setNumCuenta(int pNumeroCuenta) {
       numeroCuenta=  pNumeroCuenta;
    }
     public void setFechaCreacion(LocalDate pFecha){
        fechaCreacion = pFecha;
    }

    public void setOperaciones(ArrayList<Operacion> pOperaciones) {
        this.operaciones = pOperaciones;
    }
  
    public void setCantidadOperacionesRetirosDepositos(int pCantidadOperacionesRetirosDepositos){
        cantidadOperacionesRetirosDepositos = pCantidadOperacionesRetirosDepositos;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }
     public boolean getactiva() {
        return activa;
    }

    public String isActiva() {
        if (activa == true){
            return "Activa";
        }
        else{
            return "Inactiva";
        }
    }

    public String getPin() {
        return pin;
    }
    
    public Cliente getDuenio() {
        return duenio;
    }
    
    public int getCantidadOperacionesRetirosDepositos() {
        return cantidadOperacionesRetirosDepositos;
    }
    
    public ArrayList<Operacion> getMisOperacioes() {
        return operaciones;
    }
    
    public String toString( ){
        String msg = "";
        msg += "Número Cuenta: " + getNumeroCuenta() + "\n";
        msg += "Fecha De Creación: " + getFechaCreacion() + "\n";
        msg += "Saldo: " + getSaldo() +"\n";
        msg += "Status: " + isActiva() + "\n";
        msg += "\n\n";
        msg += getDuenio().toString();
        return msg;
    }

    
    
}
