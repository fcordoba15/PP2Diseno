
package comunicacionExterna;

import java.util.logging.Level;
import java.util.logging.Logger;
import util.Traduccion;
public class TraduccionNotificacionUsuarioDecorate extends NotificacionUsuarioDecorator {
    
    public TraduccionNotificacionUsuarioDecorate(NotificacionUsuario pNotificacionUsuario){
        super (pNotificacionUsuario);
    }
    
    public void enviarNotificacion( String detinatario, String cuerpo){
        System.out.println(detinatario);
        decorateNotificacionUsuario.enviarNotificacion(detinatario,setIdiomaCuerpo(cuerpo));  
    }
    
    private String setIdiomaCuerpo(String cuerpo){
        String textoTraduccion = "";
        String texto = "";
        try {
            Traduccion traduccion  = Traduccion.getInstance();
            textoTraduccion = traduccion.translateText(cuerpo,"auto","en");
            texto = cuerpo + "\n" + textoTraduccion;
            
        } catch (Exception ex) {
            Logger.getLogger(TraduccionNotificacionUsuarioDecorate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return texto;   
    }
    
}
