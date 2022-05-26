
package util;

import java.util.Random;

public class PalabraAleatoria {
    public static String generarPalabra(){
     
     Random r = new Random(); 
    StringBuilder sb = new StringBuilder(3);
    int value = r.nextInt((90 - 10) + 10) + 10;
    for(int i = 0; i <3; i++) { 
        char tmp = (char) ('a' + r.nextInt('z' - 'a')); 
        sb.append(tmp); 
    }  
     sb.append(String.valueOf(value));
    
     //System.out.println(sb.toString());
    return sb.toString();
    }
    
}
