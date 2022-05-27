package logicadenegocios;

public class BitacoraTramaPlana extends BitacoraNotificationObserver{
   
    public BitacoraTramaPlana(CuentaBancaria pSubject) {
        subject= pSubject;
        subject.attach(this);
    }
    
    
    public void update() {
          subject.getExhangeRate();
      }
   
}
