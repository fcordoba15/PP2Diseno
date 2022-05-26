
package comunicacionExterna;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class CorreoElectronico {
    public static void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.user", "proyectobanco2022");
        props.put("mail.smtp.clave", "miClaveDeGMail");    
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("proyectobanco2022"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "proyectobanco2022", "disenio2022!");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();  
        }
    }   
}
