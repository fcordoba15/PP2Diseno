
package comunicacionExterna;

public abstract class NotificacionUsuarioDecorator implements NotificacionUsuario {
    protected NotificacionUsuario decorateNotificacionUsuario;
    
    public NotificacionUsuarioDecorator(NotificacionUsuario pDecorateNotificacionUsuario){
        decorateNotificacionUsuario =  pDecorateNotificacionUsuario;  
    }
    
    public void enviarNotificacion(String detinatario, String cuerpo){
        decorateNotificacionUsuario.enviarNotificacion(detinatario, cuerpo);
    }
    
   
}
