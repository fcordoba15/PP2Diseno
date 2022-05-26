
package vistaCLI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.IOException;
import controlador.*;
import java.text.ParseException;
import java.util.ArrayList;



public class Consola {
    static BufferedReader in;
    static PrintStream out; 
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException, ParseException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = System.out;
        paginaPrincipal();
    }
 
    static void paginaPrincipal() throws IOException, ParseException {
       ActualizacionDatos.refrescarPrograma();
        boolean salir = false;
        while (!salir) {
            System.out.println("\n------------ BIENVENIDO AL SISTEMA BANCARIO NACIONAL ------------");
            System.out.println("    1. Registrarse");
            System.out.println("    2. Iniciar");
            System.out.println("    3. Salir");
            opcionElegidaPaginaPrincipal();
            if (opcionElegidaPaginaPrincipal() == true) {
                salir = true;
            }
        }
    }
    
    static Boolean opcionElegidaPaginaPrincipal() throws java.io.IOException, ParseException{
        ActualizacionDatos.refrescarPrograma();
        int opcion;
        try{
            System.out.println("\nSeleccione la accion que desea realizar: ");
            Scanner entrada = new Scanner(System.in);
            opcion = entrada.nextInt();           
        }catch (Exception e) {opcion = 17;}
        switch (opcion) {
            case 1:
                registrarCliente();
                return false;
            case 2:
                menuInicio();
                return false;
            case 3:
                System.out.println("Hasta pronto!!");
                return true;
            default:
                System.out.println("\nERROR: la opción elegida debe estar entre 1 y 3");
                return false;
        }
    }

    static int opcionDivisa()throws java.io.IOException{
        int divisa;
        try{
            Scanner entrada = new Scanner(System.in);
            System.out.println("  1. Dolar");
            System.out.println("  2. Colon");
            System.out.println("\nIngrese la divisa que desea utilizar: ");
            divisa = entrada.nextInt();
            return divisa;
        } catch (Exception e) {divisa = 3; return divisa;}    
    }

    static void registrarCliente() throws ParseException{
        ClienteCt cliente = new ClienteCt();
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\n------------ REGISTRO DE CLIENTES ------------");
        System.out.println("Ingrese el numero de cedula: ");
        String cedula = entrada.next();
        System.out.println("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el primer apellido: ");
        String apellido1 = entrada.next();
        System.out.println("Ingrese el segundo apellido: ");
        String apellido2 = entrada.next();
        System.out.println("\nINFORMACION DE LA FECHA DE NACIMIENTO \n");
        System.out.println("Ingrese la fecha del dia de nacimiento (DD): ");
        String dia = entrada.next();
        System.out.println("Ingrese la fecha del mes de nacimiento (MM): ");
        String mes = entrada.next();
        System.out.println("Ingrese del año de nacimiento (AAAA): ");
        String anio = entrada.next();
        System.out.println("\nIngrese el numero telefono: ");
        String telefono = entrada.next();
        System.out.println("Ingrese el correo electronico (example@gmail.com): ");
        String correo = entrada.next();

        System.out.println("\n" + cliente.registrarCliente(apellido1, apellido2, nombre, cedula, dia, mes, anio, telefono, correo));
    }

    static void menuInicio() throws java.io.IOException{
        ActualizacionDatos.refrescarPrograma();
        boolean volverPaginaPrincipal = false;
        while (!volverPaginaPrincipal)
        {
            System.out.println("\n------------ MENU DE INICIO ------------");
            System.out.println("   1. Crear nueva cuenta");
            System.out.println("   2. Cambiar PIN");
            System.out.println("   3. Realizar movimiento");
            System.out.println("   4. Realizar consulta");
            System.out.println("   5. Volver");
            opcionElegidaMenuInicio();
            if (opcionElegidaMenuInicio() == true)
            {
                volverPaginaPrincipal = true;
            }
        }
    }

    static Boolean opcionElegidaMenuInicio() throws java.io.IOException{
        ActualizacionDatos.refrescarPrograma();
        int opcion;
        try{        
            Scanner entrada = new Scanner(System.in);
            System.out.println("\nSeleccione la accion que desea realizar: ");
            opcion = entrada.nextInt();
        } catch (Exception e) {opcion = 17;}
        switch (opcion){
            case 1:
                crearCuentaBancaria();
                return false;
            case 2:
                cambiarPin();
                return false;
            case 3:
                menuMovimientos();
                return false;
            case 4:
                menuConsultas();
                return false;
            case 5:
                return true;
            default:
                System.out.println("ERROR: la opción elegida debe estar entre 1 y 5");
                return false;
        }
    } 

     static void crearCuentaBancaria(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\n------------ CREACION DE CUENTA BANCARIA ------------");
        System.out.println("Ingrese el numero de cedula del cliente: ");
        String cedula = entrada.next();
        System.out.println("Ingrese el PIN de la cuenta: ");
        String pin = entrada.next();
        System.out.println("Ingrese el saldo inicial: ");
        String saldo = entrada.next();

        System.out.println("\n" + CuentaBancariaCt.resgistrarCuentaBancaria(saldo, pin, cedula));
    }  

     static void cambiarPin(){
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        System.out.println("\n--------------- CAMBIO DE PIN ---------------");
        System.out.println("Ingrese el numero de cuenta: ");
        String numeroCuenta = entrada.next();
        System.out.println("Ingrese el PIN actual de la cuenta: ");
        String pinActual = entrada.next();
        System.out.println("Ingrese el PIN nuevo de la cuenta: ");
        String pinNuevo = entrada.next();

        System.out.println("\n" + cliente.cambiarPin(numeroCuenta, pinActual, pinNuevo));
    }          

    static void menuMovimientos() throws java.io.IOException{
        ActualizacionDatos.refrescarPrograma();
        boolean volverMenuInicio = false;
        while (!volverMenuInicio){
            System.out.println("\n--------------- MENU DE MOVIMIENTOS EN CUENTAS ---------------");
            System.out.println("   1. Depositar dinero a cuenta");
            System.out.println("   2. Retirar dinero de cuenta");
            System.out.println("   3. Realizar transferencia de una cuenta a otra");
            System.out.println("   4. Volver");
            opcionElegidaMenuMovimientos();
            if (opcionElegidaMenuMovimientos() == true) {
                volverMenuInicio = true;
            }
        }
    } 

    static Boolean opcionElegidaMenuMovimientos()  throws java.io.IOException{
        ActualizacionDatos.refrescarPrograma();
        int opcion;
        try {
            Scanner entrada = new Scanner(System.in);
            System.out.println("\nSeleccione la accion que desea realizar: ");
            opcion = entrada.nextInt();
        } catch (Exception e) {opcion = 17;}
        switch (opcion) {
            case 1:
                depositar();
                return false;
            case 2:
                retirar();
                return false;
            case 3:
                transferir();
                return false;
            case 4:
                return true;
            default:
                System.out.println("\nERROR: la opción elegida debe estar entre 1 y 4");
                return false;
        }
    }     

    static void depositar() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        
        System.out.println("\n---------------- DEPOSITO DE DINERO ----------------");
        System.out.println("Ingrese el numero de cuenta a depositar: ");
        String numeroCuenta = entrada.next();
        System.out.println("Ingrese el monto a depositar: ");
        String monto = entrada.next();
        int divisa = opcionDivisa();
        if (divisa == 1){
            System.out.println("\n" + cliente.realizarDepositoDolares (numeroCuenta, monto));
        }
        else if (divisa == 2){
            System.out.println("\n" + cliente.realizarDepositoColones (numeroCuenta, monto));
        }
        else{
            System.out.println("ERROR: opcion no valida!!");
        }            
    }

    static void retirar() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        System.out.println("\n------------------------- RETIRO DE DINERO -------------------------");
        System.out.println("Ingrese el numero de cuenta a la que desea retirar dinero: ");
        String numeroCuenta = entrada.next();
        System.out.println("Ingrese el pin de la cuenta: ");
        String pin = entrada.next();
        System.out.println("Ingrese el monto a retirar: ");
        String monto = entrada.next();   
        
        int divisa = opcionDivisa();
        if (divisa == 1){
            String palabraMensajeDolares = cliente.realizarRetiroDolaresAux(numeroCuenta, pin);
        
            System.out.println("Ingrese la palabra que le fue enviada por mensaje: ");
            String palabraIngresadaDolares = entrada.next();  
            
            System.out.println("\n" + cliente.realizarRetiroDolares(numeroCuenta, monto, palabraIngresadaDolares, palabraMensajeDolares));           
        }
        else if (divisa == 2){
            String palabraMensajeColones = cliente.realizarRetiroColonesAux(numeroCuenta, pin);
        
            System.out.println("Ingrese la palabra que le fue enviada por mensaje: ");
            String palabraIngresadaColones = entrada.next();  
            
            System.out.println("\n" + cliente.realizarRetiroColones(numeroCuenta, monto, palabraIngresadaColones, palabraMensajeColones));           
        }
        else{
            System.out.println("\nERROR: opcion no valida!!");
        }    
    } 

    static void transferir() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        System.out.println("\n------------------------- TRANSFERENCIA DE DINERO -------------------------");
        System.out.println("Ingrese el numero de cuenta origen: ");
        String numeroCuentaOrigen = entrada.next();
        System.out.println("Ingrese el pin de la cuenta: ");
        String pin = entrada.next();
        System.out.println("Ingrese el monto a transferir: ");
        String monto = entrada.next();         
        
        String pPalabra = cliente.realizarTransferenciaAux (numeroCuentaOrigen, pin);
        
        System.out.println("Ingrese la palabra que le fue enviada por mensaje: ");
        String palabraIngresada= entrada.next();    
        System.out.println("Ingrese el numero de cuenta a depositar: ");
        String numeroCuentaDestino = entrada.next(); 
        
        System.out.println("\n" + cliente.realizarTransferencia(numeroCuentaOrigen, numeroCuentaDestino, monto, pin, palabraIngresada));            
    }


    static void menuConsultas() throws java.io.IOException{
        ActualizacionDatos.refrescarPrograma();
        boolean volverMenuInicio = false;
        while (!volverMenuInicio) {
            System.out.println("------------------ MENU DE CONSULTAS ------------------");
            System.out.println("   1. Consultar clientes");
            System.out.println("   2. Consultar cuentas");
            System.out.println("   3. Consultar tipo de cambio");
            System.out.println("   4. Consultar saldo de cuenta");
            System.out.println("   5. Consultar estado de cuenta");
            System.out.println("   6. Consultar status de cuenta");
            System.out.println("   7. Consultar ganancias totales");
            System.out.println("   8. Consultar ganancias por cuenta");    
            System.out.println("   9. Volver");
            opcionElegidaMenuConsultas();
            if (opcionElegidaMenuConsultas() == true) {
                volverMenuInicio = true;
            }
        }
    }    
  
    static Boolean opcionElegidaMenuConsultas()  throws java.io.IOException{
        ActualizacionDatos.refrescarPrograma();
        int opcion;
        try {
            Scanner entrada = new Scanner(System.in);
            System.out.println("\nSeleccione la accion que desea realizar: ");
            opcion = entrada.nextInt();            
        } catch (Exception e) {opcion = 17;}
        switch (opcion){
            case 1:
                consultarCliente();
                return false;
            case 2:
                 consultarCuenta();
                return false;
            case 3:
                consultarTipoCambio();
                return false;
            case 4:
                 consultarSaldoCuenta();
                return false;
            case 5:
                consultarEstadoCuenta();
                return false;
            case 6:
                 consultarStatusCuenta();
                return false;
            case 7:
                 consultarGananciasTotales();
                return false;
            case 8:
                 consultarGananciasPorCuenta();
                return false;               
            case 9:
                return true;
            default:
                System.out.println("\nERROR: la opción elegida debe estar entre 1 y 9");
                return false;
        }
    }    
    
    static void consultarTipoCambio() throws IOException{
        ClienteCt cliente = new ClienteCt();
        int tipo;
        try{
            Scanner entrada = new Scanner(System.in);
            System.out.println("\n------------- CONSULTA DE TIPO DE CAMBIO -------------");
            System.out.println("  1. Compra");
            System.out.println("  2. Venta");
            System.out.println("\nIngrese el tipo de consulta: ");
            tipo = entrada.nextInt();
        }catch (Exception e) {tipo = 3;}

        if (tipo == 1){
            System.out.println("\n" + cliente.consultarTipoCambioCompra());
        }
        else if (tipo == 2){
            System.out.println("\n" + cliente.consultarTipoCambioVenta());
        }
        else{
            System.out.println("ERROR: opcion no disponible!!");
        }            
    }            
 
    static void consultarSaldoCuenta() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        System.out.println("\n---------------- CONSULTA DE SALDO ----------------");
        System.out.println("Ingrese el numero de cuenta a consultar: ");
        String numeroCuenta = entrada.next();
        System.out.println("Ingrese el pin de la cuenta: ");
        String pin = entrada.next();
        int divisa = opcionDivisa();
        if (divisa == 1){
            System.out.println("\n" + cliente.consultarSaldoCuentaDolares (numeroCuenta, pin));
        }
        else if (divisa == 2){
            System.out.println("\n" + cliente.consultarSaldoCuentaColones (numeroCuenta, pin));
        }
        else{
            System.out.println("ERROR: opcion no valida!!");
        }            
    }   
    
    static void consultarEstadoCuenta() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        System.out.println("\n---------------- CONSULTA DE ESTADO DE CUENTA ----------------");
        System.out.println("Ingrese el numero de cuenta a consultar: ");
        String numeroCuenta = entrada.next();
        System.out.println("Ingrese el pin de la cuenta: ");
        String pin = entrada.next();
        int divisa = opcionDivisa();
        if (divisa == 1){
            System.out.println("\n" + cliente.consultarEstadoCuentaDolares (numeroCuenta, pin));
        }
        else if (divisa == 2){
            System.out.println("\n" + cliente.consultarEstadoCuentaColones (numeroCuenta, pin));
        }
        else{
            System.out.println("ERROR: opcion no valida!!");
        }            
    } 

    static void consultarStatusCuenta() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
        System.out.println("\n---------------- CONSULTA DE STATUS DE CUENTA ----------------");
        System.out.println("Ingrese el numero de cuenta a consultar: ");
        String numeroCuenta = entrada.next();
        System.out.println("\n" + cliente.consultarStatusCuenta (numeroCuenta));          
    } 
    
     static void consultarGananciasTotales() throws IOException{
        Scanner entrada = new Scanner(System.in);
        int tipo;
        try{
            System.out.println("\n------------- CONSULTA DE GANANCIAS TOTALES POR COMISIONES-------------");
            System.out.println("  1. Depositos y retiros totales");
            System.out.println("  2. Depositos totales");
            System.out.println("  3. Retiros totales");
            System.out.println("\nIngrese el tipo de consulta: ");
            tipo = entrada.nextInt();
        }catch (Exception e) {tipo = 5;}

        if (tipo == 1){
            System.out.println("\n" + CuentaBancariaCt.consultarGananciasTotalesBanco());
        }
        else if (tipo == 2){
            System.out.println("\n" + CuentaBancariaCt.consultarGananciasDepositosBanco());
        }
        else if (tipo == 3){
            System.out.println("\n" + CuentaBancariaCt.consultarGananciasRetirosBanco());
        }
        else{
            System.out.println("ERROR: opcion no disponible!!");
        }            
    }    
    
     static void consultarGananciasPorCuenta() throws IOException{
        Scanner entrada = new Scanner(System.in);
        CuentaBancariaCt cuenta = new CuentaBancariaCt();
        System.out.println("Ingrese el numero de cuenta a consultar: ");
        String numeroCuenta = entrada.next();
        
        int tipo;
        try{
            System.out.println("\n------------- CONSULTA DE GANANCIAS POR CUENTA POR COMISIONES-------------");
            System.out.println("  1. Depositos y retiros totales");
            System.out.println("  2. Depositos totales");
            System.out.println("  3. Retiros totales");
            System.out.println("\nIngrese el tipo de consulta: ");
            tipo = entrada.nextInt();
        }catch (Exception e) {tipo = 5;}

        if (tipo == 1){
            System.out.println("\n" + cuenta.consultarGananciasTotalesCuenta(numeroCuenta));
        }
        else if (tipo == 2){
            System.out.println("\n" + cuenta.consultarGananciasDepositosCuenta(numeroCuenta));
        }
        else if (tipo == 3){
            System.out.println("\n" + cuenta.consultarGananciasRetirosCuenta(numeroCuenta));
        }
        else{
            System.out.println("ERROR: opcion no disponible!!");
        } 
    }
     
    static void consultarCliente() throws IOException{
        Scanner entrada = new Scanner(System.in);
        ClienteCt cliente = new ClienteCt();
            
        System.out.println("\n---------------- LISTA DE CLIENTES ORDENADOS POR APELLIDO ----------------");
        ClienteCt datosClientes = new ClienteCt();
        ArrayList<String> listaDatos = datosClientes.listarClientes();   
        for (int i = 0; i < listaDatos.size(); i++){
            System.out.println(listaDatos.get(i) + "\n" );
        }        
        
        System.out.println("Ingrese el numero de cédula del cliente a consultar: ");
        String numeroCedula = entrada.next();
        
        System.out.println("\n" + cliente.consultarCliente(numeroCedula)); 
    }  

    static void consultarCuenta() throws IOException{
        CuentaBancariaCt cuenta = new CuentaBancariaCt();
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\n---------------- LISTA DE CUENTAS ORDENADAS POR SALDO ----------------");
        CuentaBancariaCt datosCuentas = new CuentaBancariaCt();
        ArrayList<String> listaDatos = datosCuentas.listarCuentas();   
        for (int i = 0; i < listaDatos.size(); i++){
            System.out.println(listaDatos.get(i) + "\n" );
        }        
        
        System.out.println("Ingrese el numero de cuenta de la cuenta bancaria a consultar: ");
        String numeroCuenta = entrada.next();
        
        System.out.println("\n" + cuenta.consultarCuenta(numeroCuenta)); 
    }    
}
