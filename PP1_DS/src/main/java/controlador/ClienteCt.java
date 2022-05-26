
package controlador;

import DAO.ClienteDAO;
import logicadenegocios.Cliente;
import static validaciones.ValidacionCliente.*;
import static validaciones.ValidacionFormato.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import static util.PalabraAleatoria.generarPalabra;
import static comunicacionExterna.MensajeSMS.enviarMensaje;
import util.Ordenacion;
import DAO.CuentaBancariaDAO;
import DAO.OperacionDAO;


import static validaciones.ValidacionCuenta.validarSaldoCuenta;
import logicadenegocios.CuentaBancaria;
import static seguridad.ClienteSc.autenticarCliente;
import static seguridad.CuentaBancariaSc.*;

public class ClienteCt {
    
    
    static int numCliente = 0;
    static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static CuentaBancariaDAO cuentaDAO = new CuentaBancariaDAO();
    private static OperacionDAO operacionDAO = new OperacionDAO();
    
    public String registrarCliente (String pPrimerApellido, String pSegundoApellido, String pNombre, String pIdentificacion, String pDia, String pMes, String pAnio, String pNumeroTelefonico, String pCorreoElectronico) throws ParseException {
        if(isNumeric(pIdentificacion)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        if(isNumeric(pNumeroTelefonico)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        if (validarNumTelefonico(Integer.parseInt(pNumeroTelefonico)) == false){
            return "Numero telefónico invalido, inténtelo de nuevo.";
        }
        
        if (validarCorreoElectronico(pCorreoElectronico) == false){
            return "Correo electrónico invalido, inténtelo de nuevo.";
        }
        
        if (validarFecha(pDia, pMes, pAnio) == false){
            return "Fecha de nacimiento invalida, inténtelo de nuevo.";
        }
        if(autenticarCliente(Integer.parseInt(pIdentificacion), clientes)==true){
            return "El cliente ya se encuentra registrado";
        }
        
        Date pFechaNacimiento = crearFecha(pDia,pMes, pAnio);
        Cliente clienteAux = new Cliente(pPrimerApellido,pSegundoApellido,pNombre,Integer.parseInt(pIdentificacion),pFechaNacimiento,Integer.parseInt(pNumeroTelefonico),pCorreoElectronico);
        clienteAux.setCodigoCliente(numCliente++);
        //agregar clientes
        clientes.add(clienteAux);
        clienteDAO.clienteDAO(pPrimerApellido, pSegundoApellido, pNombre,Integer.parseInt(pIdentificacion), pDia, pMes, pAnio,numCliente,Integer.parseInt(pNumeroTelefonico), pCorreoElectronico);
        
        return "Se ha creado un nuevo cliente en el sistema, los datos que fueron almacenados  son: \n" +
        "Código: "+ clienteAux.getCodigoCliente() +"\n" +
        "Nombre: "+ clienteAux.getNombreCompleto() +"\n" +
        "Identificación: "+ clienteAux.getIdentificacion() +"\n" +
        "Fecha de Nacimiento: "+ pDia + "-" + pMes + "-" + pAnio +"\n" +
        "Número telefónico:"+ clienteAux.getNumeroTelefonico();
    }
    
    //Preguntar sobre si deben ser por separado
    public String cambiarPin (String pNumCuenta, String pPinActual, String pPinNuevo){
        CuentaBancaria cuenta = new CuentaBancaria();
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPinActual,clientes) == false){
                intentos++;
            }else{
                for (int i = 0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            cuenta = clientes.get(i).getMisCuentas().get(j);
                            clientes.get(i).ejecutarCambioPin(clientes.get(i).getMisCuentas().get(j), pPinNuevo);
                            
                            
                        }
                    }
                }
                agregarOperacionADAO(cuenta);
                cuentaDAO.cambiarPinDAO(Integer.parseInt(pNumCuenta), pPinNuevo);
                
                return "Estimado usuario, se ha cambiado satisfactoriamente el PIN de su cuenta" + pNumCuenta;
            }
        }
      
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    public ArrayList<String> listarClientes(){
        ArrayList <String> datosClientes = new ArrayList();
        Cliente [] clientesOrdenados = new Cliente [clientes.size()];
        for (int i = 0; i < clientes.size(); i++){
            clientesOrdenados[i] = clientes.get(i);
        }
        Ordenacion.insercion(clientesOrdenados);
        for (int i = 0; i < clientesOrdenados.length; i++){
            datosClientes.add(clientesOrdenados[i].getNombreCompleto() + "   " + clientesOrdenados[i].getIdentificacion());
        }
        return datosClientes;
    }
    
    public  String consultarCliente(String pIdentificacion){
        String msg="";
        if (isNumeric(pIdentificacion) != true){
            return "Identificacion invalida, debe ingresar un valor numerico";
        }
        
        if (autenticarCliente(Integer.parseInt(pIdentificacion),clientes) != true){
            return "Identificacion invalida, inténtelo de nuevo";
        }
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getIdentificacion() == Integer.parseInt(pIdentificacion)){
                msg = clientes.get(i).toString();
            }
        }
        return msg;
    }     
        
    
    public String consultarSaldoCuentaColones (String pNumCuenta, String pPin){
        String msg = "";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPin,clientes) == false){
                intentos++;
            }else{
                for (int i = 0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            msg = clientes.get(i).EjecutarConsultaSaldoCuentaColones(clientes.get(i).getMisCuentas().get(j));
                        }
                    }
                }
                return msg;
            }
        }
      
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    public String consultarSaldoCuentaDolares (String pNumCuenta, String pPin){
        String msg = "";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPin,clientes) == false){
                intentos++;
            }else{
                for (int i = 0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            msg = clientes.get(i).ejecutarConsultaSaldoCuentaDolares(clientes.get(i).getMisCuentas().get(j));
                        }
                    }
                }
                return msg;
            }
        }
      
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    public String consultarEstadoCuentaColones (String pNumCuenta, String pPin){
        String msg = "";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPin,clientes) == false){
                intentos++;
            }else{
                for (int i = 0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            msg = clientes.get(i).ejecutarConsultaEstadoCuentaColones(clientes.get(i).getMisCuentas().get(j));
                        }
                    }
                }
                return msg;
            }
        }
      
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    public String consultarEstadoCuentaDolares (String pNumCuenta, String pPin){
        String msg = "";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPin,clientes) == false){
                intentos++;
            }else{
                for (int i = 0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            msg = clientes.get(i).ejecutarConsultaEstadoCuentaDolares(clientes.get(i).getMisCuentas().get(j));
                        }
                    }
                }
                return msg;
            }
        }
      
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    public String consultarStatusCuenta (String pNumCuenta){
        String msg="";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        
        for (int i = 0; i < clientes.size(); i++){
            for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                    msg = clientes.get(i).ejecutarConsultaStatusCuenta(clientes.get(i).getMisCuentas().get(j));
                }
            }
        }
        return msg; 
    }
    
    
    public String realizarDepositoColones (String pNumCuenta, String pMonto){
        String msg ="";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }
        if (isNumeric(pMonto) == false){
            return "Monto invalido, inténtelo de nuevo";
        }
        for (int i = 0; i < clientes.size(); i++){
            for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                    
                    msg = clientes.get(i).ejecutarDepositoColones(clientes.get(i).getMisCuentas().get(j), Integer.parseInt(pMonto));
                    cuentaDAO.actualizarSaldoCuentaDAO(Integer.parseInt(pNumCuenta),clientes.get(i).getMisCuentas().get(j).getSaldo(),clientes.get(i).getMisCuentas().get(j).getCantidadOperacionesRetirosDepositos());
                    
                    agregarOperacionADAO(clientes.get(i).getMisCuentas().get(j));
                }
            }
        }
        return msg;
    }
    
    public String realizarDepositoDolares(String pNumCuenta, String pMonto){
        String msg ="";
        if(isNumeric(pNumCuenta)==false){
            return "Se encuentran caracteres donde solamente se permiten números";
        }  
        if (isNumeric(pMonto) == false){
            return "Monto invalido, inténtelo de nuevo";
        }        
        if (autenticarNumCuenta(Integer.parseInt(pNumCuenta), clientes) != true){
            return "Cuenta invalida, inténtelo de nuevo";
        }
        
        if (isNumeric(String.valueOf(pMonto)) != true){
            return "Monto invalido, inténtelo de nuevo";
        }
        
        for (int i = 0; i < clientes.size(); i++){
            for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                    msg = clientes.get(i).ejecutarDepositoDolares(clientes.get(i).getMisCuentas().get(j), Integer.parseInt(pMonto));
                    cuentaDAO.actualizarSaldoCuentaDAO(Integer.parseInt(pNumCuenta),clientes.get(i).getMisCuentas().get(j).getSaldo(),clientes.get(i).getMisCuentas().get(j).getCantidadOperacionesRetirosDepositos());
                    
                    agregarOperacionADAO(clientes.get(i).getMisCuentas().get(j));
                }
            }
        }
        return msg;
    }

    static String pPalabra;
    
    public String realizarRetiroColonesAux (String pNumCuenta, String pPin){       
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPin,clientes) == false){
                intentos++;
            }
            else{
                for (int i=0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            pPalabra = generarPalabra();
                            enviarMensaje(Integer.toString(clientes.get(i).getNumeroTelefonico()),pPalabra);
                        }
                    }
                }
                return pPalabra;
            }
        }
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";       
    }
        
    
    public  String realizarRetiroColones (String pNumCuenta, String pMonto, String pPalabraIngresada, String pPalabra){
        int intentos =0;
        String msg ="";
        if (isNumeric(pMonto) == false){
            return "Monto invalido, inténtelo de nuevo";
        }
        while (intentos < 2){
            if (pPalabraIngresada.equals(pPalabra)){
                for (int i = 0; i < clientes.size(); i++){
                for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                    if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                        if (validarSaldoCuenta(clientes.get(i).getMisCuentas().get(j),Integer.parseInt(pMonto),clientes.get(i).getMisCuentas().get(j).calcularComision(Integer.parseInt(pMonto))) == false){
                            return "Monto insuficiente, ingrese un monto menor e inténtelo de nuevo";
                        }
                        msg = clientes.get(i).ejecutarRetiroColones(clientes.get(i).getMisCuentas().get(j),Integer.parseInt(pMonto));
                        cuentaDAO.actualizarSaldoCuentaDAO(Integer.parseInt(pNumCuenta),clientes.get(i).getMisCuentas().get(j).getSaldo(),clientes.get(i).getMisCuentas().get(j).getCantidadOperacionesRetirosDepositos());
                        agregarOperacionADAO(clientes.get(i).getMisCuentas().get(j));
                        return msg; 
                    }
                }
            }
               
            }else{
               intentos++; 
            }
        }
        inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
        cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    
    public String realizarRetiroDolaresAux (String pNumCuenta, String pPin){       
        int intentos = 0;
        while (intentos < 2){
            if (autenticarCuenta(Integer.parseInt(pNumCuenta),pPin,clientes) == false){
                intentos++;
            }
            else{
                for (int i=0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                            pPalabra = generarPalabra();
                            enviarMensaje(Integer.toString(clientes.get(i).getNumeroTelefonico()),pPalabra);
                        }
                    }
                }
                return pPalabra;
            }
        }
       inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
       cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";       
    }
    
    public String realizarRetiroDolares (String pNumCuenta, String pMonto, String pPalabraIngresada, String pPalabra){
        int intentos =0;
        String msg ="";
        if (isNumeric(pMonto) == false){
            return "Monto invalido, inténtelo de nuevo";
        }
        while (intentos < 2){
            if (pPalabraIngresada.equals(pPalabra)){
                for (int i = 0; i < clientes.size(); i++){
                for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                    if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                        double pMontoColones = clientes.get(i).getMisCuentas().get(j).calcularTipoCambioCompra(Integer.parseInt(pMonto));
                        if (validarSaldoCuenta(clientes.get(i).getMisCuentas().get(j),pMontoColones,clientes.get(i).getMisCuentas().get(j).calcularComision(pMontoColones)) == false){
                            return "Monto insuficiente, ingrese un monto menor e inténtelo de nuevo";
                        }
                        msg = clientes.get(i).ejecutarRetiroDolares(clientes.get(i).getMisCuentas().get(j),Integer.parseInt(pMonto));
                        cuentaDAO.actualizarSaldoCuentaDAO(Integer.parseInt(pNumCuenta),clientes.get(i).getMisCuentas().get(j).getSaldo(),clientes.get(i).getMisCuentas().get(j).getCantidadOperacionesRetirosDepositos());
                        agregarOperacionADAO(clientes.get(i).getMisCuentas().get(j));
                        return msg; 
                    }
                }
            }
               
            }else{
               intentos++; 
            }
        }
        inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
        cuentaDAO.inactivarCuentaDAO(Integer.parseInt(pNumCuenta));
       return "Estimado usuario, su cuenta está inactiva";
    }
    
    public String realizarTransferenciaAux (String pNumCuentaOrigen, String pPin){
        if (autenticarCuenta(Integer.parseInt(pNumCuentaOrigen),pPin,clientes) != true){
            return "Cuenta invalida, inténtelo de nuevo";
        }
        
        for (int i=0; i < clientes.size(); i++){
            for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuentaOrigen)){
                    pPalabra = generarPalabra();
                    enviarMensaje(Integer.toString(clientes.get(i).getNumeroTelefonico()),pPalabra);
                }
            }
        }
        
        return "Se le ha enviado un codigo a su celular, por favor ingrese los datos requeridos";
    }
    
    public String realizarTransferencia (String pNumCuentaOrigen, String pNumCuenta, String pMonto, String pPin,String pPalabraIngresada){
        String msg ="";
        int intentos =0;
        
        if (isNumeric(String.valueOf(pMonto)) != true){
            return "Monto invalido, inténtelo de nuevo";
        }
        
        if (autenticarNumCuenta(Integer.parseInt(pNumCuenta),clientes) != true){
            return "Cuenta de deposito invalida, inténtelo de nuevo";
        }
        while (intentos < 2){
            if (pPalabraIngresada.equals(pPalabra)){
                for (int i = 0; i < clientes.size(); i++){
                    for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
                        if (clientes.get(i).getMisCuentas().get(j).getNumeroCuenta() == Integer.parseInt(pNumCuentaOrigen)){

                            if (validarSaldoCuenta(clientes.get(i).getMisCuentas().get(j),Double.parseDouble(pMonto),clientes.get(i).getMisCuentas().get(j).calcularComision(Double.parseDouble(pMonto))) != true){
                                return "Monto insuficiente, ingrese un monto menor e inténtelo de nuevo";
                            }    
                            for (int i1 = 0; i1 < clientes.size(); i1++){
                                for (int j1=0; j1 < clientes.get(i1).getMisCuentas().size(); j1++){
                                    if (clientes.get(i1).getMisCuentas().get(j1).getNumeroCuenta() == Integer.parseInt(pNumCuenta)){
                                       msg = clientes.get(i).ejecutarTransferenca(clientes.get(i).getMisCuentas().get(j),clientes.get(i1).getMisCuentas().get(j1), Double.parseDouble(pMonto));
                                       
                                       cuentaDAO.actualizarSaldoCuentaDAO(Integer.parseInt(pNumCuentaOrigen),clientes.get(i).getMisCuentas().get(j).getSaldo(), clientes.get(i).getMisCuentas().get(j).getCantidadOperacionesRetirosDepositos());
                                       cuentaDAO.actualizarSaldoCuentaDAO(Integer.parseInt(pNumCuenta),clientes.get(i1).getMisCuentas().get(j1).getSaldo(),clientes.get(i1).getMisCuentas().get(j1).getCantidadOperacionesRetirosDepositos());
                                       agregarOperacionADAO(clientes.get(i).getMisCuentas().get(j));
                                       
                                       return msg;
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
               intentos++; 
            }
        }
        inactivarCuenta(Integer.parseInt(pNumCuenta),clientes);
        return "Estimado usuario, su cuenta está inactiva";
    }  
    
    
    public ArrayList<Integer> numCuentas (){
       ArrayList<Integer> numCuentas = new ArrayList<Integer>();
        for (int i=0; i < clientes.size(); i++){
           for (int j=0; j < clientes.get(i).getMisCuentas().size(); j++){
               numCuentas.add(clientes.get(i).getMisCuentas().get(j).getNumeroCuenta());
           }
        }
        return numCuentas;
    }
    
    public ArrayList<Integer> cedulaClientes (){
       ArrayList<Integer> cedulas = new ArrayList<Integer>();
       for (int i = 0; i < clientes.size(); i++){
           cedulas.add(clientes.get(i).getIdentificacion());
       }
       return cedulas;
    }
     
    public double consultarTipoCambioCompra(){
       CuentaBancaria aux = new CuentaBancaria();
       return aux.calcularTipoCambioCompra(1);
     }
     
    public double consultarTipoCambioVenta(){
       CuentaBancaria aux = new CuentaBancaria();
       return aux.calcularTipoCambioVenta(1);
     }
    //-----------------------------CONTROLADOR - DAO ----------------------------//
     private static void agregarOperacionADAO(CuentaBancaria cuenta){
        int contador = cuenta.getMisOperacioes().size()-1;
        operacionDAO.registrarOperacionDAO(cuenta.getNumeroCuenta(),cuenta.getMisOperacioes().get(contador).getTipoOperacion(),cuenta.getMisOperacioes().get(contador).getFechaOperacion(),cuenta.getMisOperacioes().get(contador).getMonto(),cuenta.getMisOperacioes().get(contador).isComision(),cuenta.getMisOperacioes().get(contador).getMontoComision());
              
    }
      
   
    
    public static void cargarClientesCt(String pPrimerApellido, String pSegundoApellido, String pNombre, int pIdentificacion, Date pFechaNacimiento, int pNumeroTelefonico, String pCorreoElectronico,int pCodigo){
        numCliente = pCodigo;
        Cliente clienteAux = new Cliente(pPrimerApellido,pSegundoApellido,pNombre,pIdentificacion,pFechaNacimiento,pNumeroTelefonico,pCorreoElectronico);
        clienteAux.setCodigoCliente(pCodigo);
        clientes.add(clienteAux);   
    }
}
