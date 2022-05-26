
package DAO;

import controlador.CuentaBancariaCt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class OperacionDAO {
    
    ConexionDAO conexionDAO = new ConexionDAO();
    Connection c = null;
    
    public void registrarOperacionDAO(int pNumCuenta,String pTipoOperacion, LocalDate pFechaOperacion ,double pMonto, boolean pIsComision,double pMontoComision){
    
        conexionDAO.abrirConexioDAO();
        c = conexionDAO.connect;
        try {
        
        PreparedStatement st = c.prepareStatement("INSERT INTO OPERACION(numeroCuenta,tipoOperacion, fechaOperacion,monto,isComision,montoComision)VALUES (?,?,?,?,?,?)");
        st.setInt(1, pNumCuenta);
        st.setString(2,pTipoOperacion);
        st.setDate(3, java.sql.Date.valueOf(pFechaOperacion));
        st.setString(4,String.valueOf(pMonto));
        if(pIsComision ==true){
            st.setInt(5,1);
        }else{
           st.setInt(5,0); 
        }
        st.setString(6,String.valueOf(pMontoComision));
        st.executeUpdate(); 
   
        conexionDAO.cerrarConexionDAO();
        } catch (SQLException ex) {   
        
         conexionDAO.cerrarConexionDAO();
        } 
    }
    
    public void DownloadOperacionesDAO(){
    ResultSet result = null;
    boolean isComision = true;
     try {
        conexionDAO.abrirConexioDAO();
    
        PreparedStatement st = conexionDAO.connect.prepareStatement("SELECT * FROM OPERACION");
        result = st.executeQuery();
            while (result.next()) { 
                int pNumeroCuenta = result.getInt("numeroCuenta");
                String pTipoOperacion= result.getString("tipoOperacion");
                LocalDate pFechaOperacion =  result.getObject("fechaOperacion",LocalDate.class);
                double pMonto= result.getDouble("monto");
                int pIsComision = result.getInt("isComision");
                if (pIsComision == 0){
                    isComision = false;
                }
                double pMontoComision = result.getDouble("montoComision");
                
              
             CuentaBancariaCt.cargarOperacionCuentaCt(pNumeroCuenta,pFechaOperacion,pTipoOperacion,pMonto, isComision, pMontoComision);  
            }
         conexionDAO.cerrarConexionDAO();
        } 
        catch (SQLException ex) {
          conexionDAO.cerrarConexionDAO();
        }  
    }    
        
    
    
}