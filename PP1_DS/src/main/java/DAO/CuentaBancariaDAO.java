package DAO;

import controlador.CuentaBancariaCt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CuentaBancariaDAO {
    private static ConexionDAO instance = new ConexionDAO();
    
    public void registrarCuentaDAO(int pNumCuenta,LocalDate pFechaCreacion ,double pSaldo, boolean pActiva, String pPin, int pCedulaDuenio, int pCantOperaciones ){
        instance.abrirConexioDAO();
        try {
        PreparedStatement st = instance.getConnect().prepareStatement("EXEC encriptarCuentaBancaria ?,?,?,?,?,?,?");
        st.setInt(1, pNumCuenta);
        st.setInt(2,pCedulaDuenio);
        st.setDate(3, java.sql.Date.valueOf(pFechaCreacion));
        st.setString(4,String.valueOf(pSaldo));
        if(pActiva ==true){
            st.setInt(5,1);
        }else{
           st.setInt(5,0); 
        }
        st.setString(6,pPin);
        st.setInt(7,pCantOperaciones);
        st.executeUpdate(); 
   
        instance.cerrarConexionDAO();
        } catch (SQLException ex) {   
           System.out.println(ex);
         instance.cerrarConexionDAO();
        } 
    }
    
    public void cambiarPinDAO(int pNumCuenta,String pPin){
     try {
        instance.abrirConexioDAO();
        
        PreparedStatement st = instance.getConnect().prepareStatement("UPDATE CUENTABANCARIA SET pin = (ENCRYPTBYPASSPHRASE('encriptar','"+pPin+"')) WHERE numeroCuenta = ?");
        st.setInt(1, pNumCuenta);
        st.executeUpdate(); 
        instance.cerrarConexionDAO();
        } catch (SQLException ex) {   
           System.out.println(ex);
         instance.cerrarConexionDAO();
        } 
    }
    
    public void inactivarCuentaDAO(int pNumCuenta){
     try {
        instance.abrirConexioDAO();
        
        PreparedStatement st = instance.getConnect().prepareStatement("UPDATE CUENTABANCARIA SET isActiva = '0' WHERE numeroCuenta = ?");
        st.setInt(1, pNumCuenta);
        st.executeUpdate(); 
   
        instance.cerrarConexionDAO();
        } catch (SQLException ex) {   
           System.out.println(ex);
         instance.cerrarConexionDAO();
        } 
    }
    
    public void actualizarSaldoCuentaDAO(int pNumCuenta,double pSaldo, int cantOperacion){
     try {
        instance.abrirConexioDAO();
        
        PreparedStatement st = instance.getConnect().prepareStatement("UPDATE CUENTABANCARIA SET saldo = (ENCRYPTBYPASSPHRASE('encriptar','"+pSaldo+"')),cantOperaciones = '"+cantOperacion+"' WHERE numeroCuenta = ?");
        st.setInt(1,pNumCuenta);
        st.executeUpdate(); 
   
        instance.cerrarConexionDAO();
        } catch (SQLException ex) {   
           System.out.println(ex);
         instance.cerrarConexionDAO();
        } 
    }
    
    public void downloadCuentaBancariaDAO(){
       boolean isActiva = true;
       ResultSet result = null;
   try {
        instance.abrirConexioDAO();
        PreparedStatement st = instance.getConnect().prepareStatement("desencriptar_cuentaBancaria");
        result = st.executeQuery();
        
            while (result.next()) { 
                int pIdentificacion = result.getInt("duenioId");
                int pNumeroCuenta = result.getInt("numeroCuenta");
                LocalDate pFechaCreacion =  result.getObject("fechaCreacion",LocalDate.class );
                double pSaldo = result.getDouble("saldo");
                int pIsActiva = result.getInt("isActiva");
                String pPin = result.getString("pin");
                if (pIsActiva == 0){
                    isActiva = false;
                }else{
                    isActiva = true;
                }
                int pCantOperaciones = result.getInt("cantOperaciones");
               CuentaBancariaCt.cargarCuentasCt(pNumeroCuenta, pFechaCreacion, pSaldo, isActiva, pIdentificacion, pCantOperaciones, pPin);
            }
         instance.cerrarConexionDAO();
        } 
        catch (SQLException ex) {
          instance.cerrarConexionDAO();
        }       
}    
        
}

