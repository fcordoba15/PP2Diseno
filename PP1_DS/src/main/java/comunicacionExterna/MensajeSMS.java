
package comunicacionExterna;

import java.net.*;
import java.util.Base64;
import java.io.*;

public class MensajeSMS {
    
    public static void enviarMensaje(String numMovil, String mensaje){
        
        try{
             String myURI = "https://api.bulksms.com/v1/messages";

            String myUsername = "diseno2022";
            String myPassword = "Pdiseno2022";
            String codPais = "+506";

            String myData = "{to: \""+codPais+""+numMovil+"\", encoding: \"UNICODE\", body: \""+mensaje+"\"}";

            URL url = new URL(myURI);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setDoOutput(true);

            String authStr = myUsername + ":" + myPassword;
            String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
            request.setRequestProperty("Authorization", "Basic " + authEncoded);

            request.setRequestMethod("POST");
            request.setRequestProperty( "Content-Type", "application/json");

            OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
            out.write(myData);
            out.close();

            try {
              InputStream response = request.getInputStream();
              BufferedReader in = new BufferedReader(new InputStreamReader(response));
              String replyText;
              while ((replyText = in.readLine()) != null) {
                System.out.println(replyText);
              }
              in.close();
            } catch (IOException ex) {
              System.out.println("An error occurred:" + ex.getMessage());
              BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()));
            
              String replyText;
              while ((replyText = in.readLine()) != null) {
                System.out.println(replyText);
              }
              in.close();
            }
            request.disconnect();
        }catch(Exception e){
            System.out.println(e);
        
         }
    }   
             
}

    
