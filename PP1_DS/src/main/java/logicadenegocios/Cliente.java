
package logicadenegocios;

import java.util.ArrayList;
import java.util.Date;
import util.Comparable;


public class Cliente implements Comparable{
    protected String primerApellido;
    protected String segundoApellido;
    protected String nombre;
    protected int identificacion;
    protected Date fechaNacimiento;
    protected int numeroTelefonico;
    protected String correoElectronico;
    protected String codigoCliente;
    protected ArrayList<CuentaBancaria> misCuentas;

    public Cliente(String pPrimerApellido, String pSegundoApellido, String pNombre, int pIdentificacion, Date pFechaNacimiento, int pNumeroTelefonico, String pCorreoElectronico) {
        misCuentas = new ArrayList<CuentaBancaria>();
        setPrimerApellido(pPrimerApellido);
        setSegundoApellido(pSegundoApellido);
        setNombre(pNombre);
        setIdentificacion(pIdentificacion);
        setFechaNacimiento(pFechaNacimiento);
        setNumeroTelefonico(pNumeroTelefonico);
        setCorreoElectronico(pCorreoElectronico);
    }
    
    public void agregarCuentaBancaria (CuentaBancaria pCuentaBancaria){
        misCuentas.add(pCuentaBancaria);
    }
    
    public boolean menorQue (Comparable pOtroObjeto){
        return (getPrimerApellido().compareTo(((Cliente)pOtroObjeto).getPrimerApellido())<0 ? true:false);
    }

    public void ejecutarCambioPin(CuentaBancaria pCuentaBancaria, String pPin){
        pCuentaBancaria.cambiarPin(pPin);
    }
    
    public String ejecutarDepositoColones(CuentaBancaria pCuentaBancaria, double pMontoDeposito){
        String msg = pCuentaBancaria.depositarColones(pMontoDeposito);
        return msg;
    }
    
    public String ejecutarDepositoDolares(CuentaBancaria pCuentaBancaria, double pMontoDeposito){
        String msg = pCuentaBancaria.depositarDolares(pMontoDeposito);
        return msg;
    }
    
    public String ejecutarRetiroColones(CuentaBancaria pCuentaBancaria, double pMontoRetiro){
        String msg = pCuentaBancaria.retirarColones(pMontoRetiro);
        return msg;
    }
    
    public String ejecutarRetiroDolares(CuentaBancaria pCuentaBancaria, double pMontoRetiro){
        String msg = pCuentaBancaria.retirarDolares(pMontoRetiro);
        return msg;
    }
    
    public String ejecutarTransferenca(CuentaBancaria pCuentaBancariaOrigen, CuentaBancaria pCuentaBancaria, double pMonto){
        String msg = pCuentaBancariaOrigen.transferirMonto(pMonto);
        pCuentaBancaria.depositarColones(pMonto);
        return msg;
    }
    
    public String EjecutarConsultaSaldoCuentaColones(CuentaBancaria pCuentaBancaria){
        String msg = pCuentaBancaria.consultarSaldoCuentaColones();
        return msg;
    }
    
    public String ejecutarConsultaSaldoCuentaDolares(CuentaBancaria pCuentaBancaria){
        String msg = pCuentaBancaria.consultarSaldoCuentaDolares();
        return msg;
    }
    
    public String ejecutarConsultaEstadoCuentaColones (CuentaBancaria pCuentaBancaria){
        String msg = pCuentaBancaria.consultarEstadoCuentaColones();
        return msg;
    }
    
    public String ejecutarConsultaEstadoCuentaDolares(CuentaBancaria pCuentaBancaria){
        String msg = pCuentaBancaria.consultarEstadoCuentaDolares();
        return msg;
    }

    public String ejecutarConsultaStatusCuenta(CuentaBancaria pCuentaBancaria){
        String msg = pCuentaBancaria.consultarStatusCuenta();
        return msg;
    }
        
    public void setPrimerApellido(String pPrimerApellido) {
        primerApellido = pPrimerApellido;
    }

    public void setSegundoApellido(String pSegundoApellido) {
        segundoApellido = pSegundoApellido;
    }

    public void setNombre(String pNombre) {
        nombre = pNombre;
    }

    public void setIdentificacion(int pIdentificacion) {
        identificacion = pIdentificacion;
    }

    public void setFechaNacimiento(Date pFechaNacimiento) {
        fechaNacimiento = pFechaNacimiento;
    }

    public void setNumeroTelefonico(int pNumeroTelefonico) {
        numeroTelefonico = pNumeroTelefonico;
    }

    public void setCorreoElectronico(String pCorreoElectronico) {
        correoElectronico = pCorreoElectronico;
    }

    public void setCodigoCliente(int pNum) {
     codigoCliente = "CF-" + String.valueOf(pNum);
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + primerApellido + " " + segundoApellido;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }
    
    public ArrayList<CuentaBancaria> getMisCuentas() {
        return misCuentas;
    }
    
    public String toString( ){
        String msg = "";
        msg += "Código Cliente: " + getCodigoCliente() + "\n";
        msg += "Identificacion: " + getIdentificacion() + "\n";
        msg += "Nombre: " + getNombreCompleto()  + "\n";
        msg += "Fecha Nacimiento: " + getFechaNacimiento() + "\n";
        msg += "Numero Telefonico: " + getNumeroTelefonico() + "\n";
        msg += "Correo Electronico: " + getCorreoElectronico() + "\n";
        msg += "Cuentas asociadas: ";
        for (int i=0; i < misCuentas.size(); i++){
            msg += "   " + misCuentas.get(i).getNumeroCuenta();
        }
        return msg;
    }
    
}
