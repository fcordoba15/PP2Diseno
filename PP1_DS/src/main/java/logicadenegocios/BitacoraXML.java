
package logicadenegocios;


public class BitacoraXML extends BitacoraNotificationObserver{
    
     public BitacoraXML(CuentaBancaria pSubject) {
        subject= pSubject;
        subject.attach(this);
    }
    public void update() {
               subject.getExhangeRate();
           }
    
    
}
