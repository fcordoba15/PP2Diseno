
package logicadenegocios;

import controlador.ClienteCt;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BitacoraXML extends BitacoraNotificationObserver{
    static String url = "C:\\Users\\Fiorella Mora\\Documents\\GitHub\\PP2Diseno\\PP1_DS\\src\\main\\webapp";
  

     public BitacoraXML(CuentaBancaria pSubject) {
        subject= pSubject;
        subject.attach(this);
    }
    
    public void update() {
        try {
            Operacion operacion = subject.getExhangeRate();
            
            anadirABitacoraXML (operacion, subject.numeroCuenta,"\\prueba.xml");
            anadirABitacoraXML (operacion, subject.numeroCuenta,"\\fecha.xml");
            
            if(operacion.getVista() ==0){
                anadirABitacoraXML (operacion, subject.numeroCuenta,"\\vistaCLI.xml");
            }else if (operacion.getVista() == 1){
                anadirABitacoraXML (operacion, subject.numeroCuenta,"\\vistaGUI.xml");
            }else{
                anadirABitacoraXML (operacion, subject.numeroCuenta,"\\vistaWEB.xml");
            }   
            
        } catch (Exception ex) {
            Logger.getLogger(BitacoraXML.class.getName()).log(Level.SEVERE, null, ex);
        }                   
    }
    
     private void anadirABitacoraXML (Operacion pCambio, int numCuenta, String pfile)throws Exception {
            File file = new File(url+pfile);
            String date = String.format("%1$tY-%1$tm-%1$td", pCambio.getFechaOperacion());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            //Elemento raíz
            Document doc = docBuilder.parse(file);
            Node root = doc.getElementById("0");
            NodeList vistas =  doc.getElementsByTagName(tipoVista(pCambio.getVista()));
            
            // Crear un nuevo nodo de cuentaOperacion
		Element  operacion = doc.createElement("operacion");
                // Crear varios nodos secundarios de persona
                Element  numeroCuenta = doc.createElement("numeroCuenta");
		Element tipoOperacion = doc.createElement("tipoOperacion");
		Element fechaOperacion = doc.createElement("fechaOperacion");
		Element monto = doc.createElement("monto");
                Element montoComision = doc.createElement("montoComision");
		 // Establecer valores para nodos secundarios
		tipoOperacion.setTextContent (pCambio.getTipoOperacion());
		fechaOperacion.setTextContent(date);
		monto.setTextContent (String.valueOf(pCambio.getMonto()));
                montoComision.setTextContent (String.valueOf(pCambio.getMontoComision()));
                numeroCuenta.setTextContent(String.valueOf(numCuenta));
              
		 
                // Añadir nodo hijo a persona
                operacion.appendChild(numeroCuenta);
		operacion.appendChild(tipoOperacion);
		operacion.appendChild(fechaOperacion);
		operacion.appendChild(monto);
                operacion.appendChild(montoComision);
		 
                // Establecer el valor para la identificación de la persona
                //operacion.setAttribute("id", "3");
		 
                // Agregar persona al nodo raíz
                vistas.item(0).appendChild(operacion);
                
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                //DOMSource source = new DOMSource(doc);
                Source source = new DOMSource(doc);
                
                Result result = new StreamResult(file);
                transformer.transform(source, result);
    }
    
    public String tipoVista(int pVista){
         switch (pVista) {
             case 0:
                 return "vistaCLI";
             case 1:
                 return "vistaGUI";
             default:
                 return "vistaWEB";
         }
    }
    
}
