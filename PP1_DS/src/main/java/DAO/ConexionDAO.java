

package DAO;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConexionDAO {
 private static  Connection connect;
 private static String url;
 
  public ConexionDAO () {
      //pUrl =  "jdbc:sqlserver://;databaseName=BDBanco;user=administrador;password=diseno2022!";
      this.url = "jdbc:sqlserver://serverbanking2.database.windows.net:1433;database=BDBanco;user=administrador@serverbanking2;password=diseno2022!;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
   }
  
 
  public static void abrirConexioDAO() {
      try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
      connect = DriverManager.getConnection(url);
    } catch (SQLException ex) {
        System.out.println(ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  //** Metdo para cerrar la conexion sql server**//
  public static void cerrarConexionDAO() {
      try {
        connect.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
  
  public Connection getConnect(){
      return connect;
  }
  
}
     
  
