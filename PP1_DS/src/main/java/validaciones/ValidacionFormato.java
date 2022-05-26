
package validaciones;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ValidacionFormato {
    
    public static boolean isNumeric(String pCadena){
	try {
		Integer.parseInt(pCadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static boolean validarFecha(String pDia, String pMes, String pAnio){
         try {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        formatoFecha.parse(pDia + "/" + pMes + "/" + pAnio);
        return true;
       } catch (ParseException e) {
          return false;
       }
    }  
    
    public static Date crearFecha(String pDia, String pMes, String pAnio) throws ParseException{
        Date simpleDateFormat  = new Date(pDia+"/"+pMes+"/"+ pAnio);
        return simpleDateFormat;
    }
    
}
