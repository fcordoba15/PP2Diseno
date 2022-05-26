package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Date;
import controlador.ClienteCt;
import java.sql.Connection;

public class ClienteDAO {
    ConexionDAO conexionDAO = new ConexionDAO();
    Connection c = null;
    
    //METODO PRINCIPAL PARA REGISTRAR CLIENTE
    public void clienteDAO(String pPrimerApellido, String pSegundoApellido, String pNombre, int pIdentificacion, String pDia, String pMes, String pAnio, int pCodigoCliente, int pTelefono, String pCorreo){
        registrarClienteDAO(pPrimerApellido,pSegundoApellido,pNombre, pIdentificacion,pDia, pMes,pAnio, pCodigoCliente);
        registrarContactoClienteDAO(pIdentificacion,pTelefono, pCorreo);
    }
    
    
    private void registrarClienteDAO(String pPrimerApellido, String pSegundoApellido, String pNombre, int pIdentificacion, String pDia, String pMes, String pAnio, int pCodigoCliente){
        conexionDAO.abrirConexioDAO();
        c = conexionDAO.connect;
        try {
        PreparedStatement st = c.prepareStatement("INSERT INTO CLIENTE(identificacion, primerApellido,segundoApellido,nombre,fechaNacimiento,codigoCliente)VALUES (?,?,?,?,?,?)");
        st.setInt(1,pIdentificacion);
        st.setString(2, pPrimerApellido);
        st.setString(3, pSegundoApellido);
        st.setString(4, pNombre);
        st.setString(5,pAnio+"/"+pMes+"/"+pDia);
        st.setInt(6,pCodigoCliente);
        st.executeUpdate(); 
        conexionDAO.cerrarConexionDAO();
        
        } 
        catch (SQLException ex) {
         conexionDAO.cerrarConexionDAO();
        } 
    }
    
    private void registrarContactoClienteDAO(int pIdentificacion,int pTelefono, String pCorreo){
     try {
        conexionDAO.abrirConexioDAO();
        c = conexionDAO.connect;
        
        PreparedStatement st = c.prepareStatement("INSERT INTO CLIENTECONTACTO(identificacion,numeroTelefonico,correoElectronico)VALUES (?,?,?)");
        conexionDAO.abrirConexioDAO();
        st.setInt(1,pIdentificacion);
        st.setInt(2,pTelefono);
        st.setString(3,pCorreo);
        st.executeUpdate();
        conexionDAO.cerrarConexionDAO();
        } 
        catch (SQLException ex) {
          conexionDAO.cerrarConexionDAO();
        } 
     }
    
   public void downloadClienteDAO(){
       ResultSet result = null;
   try {
        conexionDAO.abrirConexioDAO();
        
        PreparedStatement st = conexionDAO.connect.prepareStatement("SELECT CLIENTE.identificacion, CLIENTE.primerApellido, CLIENTE.segundoApellido, CLIENTE.nombre, CLIENTE.fechaNacimiento, CLIENTE.codigoCliente, CLIENTECONTACTO.numeroTelefonico, CLIENTECONTACTO.correoElectronico \n" +
        "FROM CLIENTE \n" +
        "INNER JOIN CLIENTECONTACTO ON  CLIENTECONTACTO.identificacion = CLIENTE.identificacion");
        result = st.executeQuery();
        
            while (result.next()) { 
                int pIdentificacion = result.getInt("identificacion");
                String pPrimerApellido = result.getString("primerApellido");
                String pSegundoApellido = result.getString("segundoApellido");
                String pNombre = result.getString("nombre");
                Date pFechaNacimiento = result.getDate("fechaNacimiento");
                int pCodigo = result.getInt("codigoCliente");
                int pNumeroTelefonico = result.getInt("numeroTelefonico");
                String pCorreoElectronico = result.getString("correoElectronico");
                ClienteCt.cargarClientesCt(pPrimerApellido, pSegundoApellido,pNombre, pIdentificacion, pFechaNacimiento,pNumeroTelefonico,pCorreoElectronico,pCodigo);
            }
         conexionDAO.cerrarConexionDAO();
        } 
        catch (SQLException ex) {
          conexionDAO.cerrarConexionDAO();
        }       
}    
      
}

