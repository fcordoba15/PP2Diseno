

package DAO;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConexionDAO {
 //private String url;
 public  Connection connect;

 
 /*public ConexionDAO (String pUrl) {
      //pUrl =  "jdbc:sqlserver://;databaseName=BDBanco;user=administrador;password=diseno2022!";
      pUrl = "jdbc:sqlserver://serverbanking1.database.windows.net:1433;database=BDBanco;user=administrador@serverbanking1;password=diseno2022!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
      this.url = pUrl;
   }*/
  
  /**
   * Método para conectarse a la base de datos por medio del driver JDBC para realizar operaciones.
   */
  public void abrirConexioDAO() {
      try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
      String url = "jdbc:sqlserver://;databaseName=BDBanco;user=administrador;password=diseno2022!;encrypt=true;trustServerCertificate=true;loginTimeout=30;";
     
      connect = DriverManager.getConnection(url);
    } catch (SQLException ex) {
        System.out.println(ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  //** Metdo para cerrar la conexion sql server**//
  public void cerrarConexionDAO() {
      try {
        connect.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
}
     
  
