
package controlador;

import static controlador.ClienteCt.clientes;
import DAO.*;

public class ActualizacionDatos {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static CuentaBancariaDAO cuentaDAO = new CuentaBancariaDAO();
    private static OperacionDAO operacionDAO = new OperacionDAO();
    
     public static void refrescarPrograma(){
        clientes.clear();
        clienteDAO.downloadClienteDAO();
        cuentaDAO.downloadCuentaBancariaDAO();
        operacionDAO.DownloadOperacionesDAO();
     }
    
}
