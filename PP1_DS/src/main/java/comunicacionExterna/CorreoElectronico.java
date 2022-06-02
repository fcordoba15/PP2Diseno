
package comunicacionExterna;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class CorreoElectronico implements NotificacionUsuario{
   public void enviarNotificacion(String destinatario, String cuerpo) {
        String asunto = "BancoInforma: Invactivacion Cuenta";
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.office365.com");  
        props.put("mail.smtp.user", "BancoTEC@outlook.com");    
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("BancoTEC@outlook.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("BancoTEC@outlook.com", "diseno2022!");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();  
        }
     }   
    }
    
  
        
    
