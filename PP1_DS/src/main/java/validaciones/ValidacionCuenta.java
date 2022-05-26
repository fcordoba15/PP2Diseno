
package validaciones;

import logicadenegocios.CuentaBancaria;

public class ValidacionCuenta {
    public static boolean validarPin(String pPin){
       //requisitos del pin
       final int MAX=5;                   
       final int MIN_Uppercase=1;
       final int NUM_Digits=1;
       final int Special=1;
       
       int uppercaseCounter=0;
       int digitCounter=0;
       int specialCounter=0;
       
        for (int i=0; i < pPin.length(); i++ ) {
                    char dato = pPin.charAt(i);
                    if(Character.isUpperCase(dato)) 
                          uppercaseCounter++;
                    else if(Character.isDigit(dato)) 
                          digitCounter++;     
                     if(dato>=33&&dato<=46||dato==64){
                      specialCounter++;
                  }
                    
             }
             
       if (pPin.length() >= MAX && uppercaseCounter >= MIN_Uppercase && digitCounter >= NUM_Digits && specialCounter >= Special) { 
               return true;
             }
       
       return false;   
    }
    
    public static boolean validarSaldoCuenta(CuentaBancaria cuenta,double pMonto, double pMontoComision){
        double monto = pMonto + pMontoComision;
        if  (monto<= cuenta.getSaldo()){
            return true;
        }else{
            return false;
        }   
    } 
    
    public static boolean validarCobroComision (int cantidadComisiciones){
        if (cantidadComisiciones < 3){
            return true;
        }
        else{
            return false;
        }
    }
    
}
