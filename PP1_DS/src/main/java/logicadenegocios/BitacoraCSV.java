
package logicadenegocios;

public class BitacoraCSV extends BitacoraNotificationObserver{
 
     public BitacoraCSV(CuentaBancaria pSubject) {
        subject= pSubject;
        subject.attach(this);
       
    }
    
    public void update() {
        subject.getExhangeRate();
    }
    
}
