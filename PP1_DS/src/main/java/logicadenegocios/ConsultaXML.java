package logicadenegocios;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ConsultaXML {
    
   static File archivo =  new File ("C:\\Users\\Fiorella Mora\\Documents\\GitHub\\PP2Diseno\\PP1_DS\\src\\main\\webapp\\prueba.xml");
  
   public static ArrayList <String> consultaVista(String pVista){
       
       ArrayList <String> operacionesCuentas = new ArrayList(); 
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            NodeList listaVista = document.getElementsByTagName(pVista);
             System.out.println(listaVista.getLength());
            for (int temp = 0; temp < listaVista.getLength(); temp++) {
                Node nodo = listaVista.item(temp);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                     for (int j  = 0; j < element.getElementsByTagName("numeroCuenta").getLength(); j++){
                        operacionesCuentas.add("\nNumero Cuenta: " + element.getElementsByTagName("numeroCuenta").item(j).getTextContent()+ "\nTipo Operación: " + element.getElementsByTagName("tipoOperacion").item(j).getTextContent() + "\nFecha Operación: " + element.getElementsByTagName("fechaOperacion").item(j).getTextContent() + "Monto: " + element.getElementsByTagName("monto").item(j).getTextContent() + "Monto Comision: " + element.getElementsByTagName("montoComision").item(j).getTextContent());  
                    }
                }
            }
            return operacionesCuentas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operacionesCuentas;
   }
        
        public static ArrayList <String>  consultaPorFecha(String pFecha){
            ArrayList <String> operacionesCuentas = new ArrayList(); 
            try {
  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            
            NodeList listaVista = document.getElementsByTagName("vistaCLI");
            NodeList listaGUI = document.getElementsByTagName("vistaGUI");
            NodeList listaWEB = document.getElementsByTagName("vistaWEB");
            
            operacionesCuentas = consultaFechaAux(listaVista, pFecha);
            operacionesCuentas.addAll(consultaFechaAux(listaGUI, pFecha));
            operacionesCuentas.addAll(consultaFechaAux(listaWEB, pFecha));
     
        } catch (Exception e) {
            e.printStackTrace();
        }
            return operacionesCuentas;
    }
    
    public static ArrayList <String>  consultaFechaAux(NodeList pLista, String pFecha){
            ArrayList <String> operacionesCuentas = new ArrayList(); 
            for (int temp = 0; temp < pLista.getLength(); temp++) {
                Node nodo = pLista.item(temp);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    if(pFecha.equals(element.getElementsByTagName("fechaOperacion").item(0).getTextContent() )){
                       for (int j  = 0; j < element.getElementsByTagName("numeroCuenta").getLength(); j++){
                        operacionesCuentas.add("\nNumero Cuenta: " + element.getElementsByTagName("numeroCuenta").item(j).getTextContent() + "Tipo Operación:" + element.getElementsByTagName("tipoOperacion").item(j).getTextContent() + "\nFecha Operación: " + element.getElementsByTagName("fechaOperacion").item(j).getTextContent() + "Monto: " + element.getElementsByTagName("monto").item(j).getTextContent() + "Monto Comision: " + element.getElementsByTagName("montoComision").item(j).getTextContent());
                       }
                    }
                }   
            }
            return operacionesCuentas;
        }
        
        
        public static ArrayList <String>  consultaGeneralXML(){
            ArrayList <String> operacionesCuentas = new ArrayList(); 
            try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            
            NodeList listaVista = document.getElementsByTagName("vistaCLI");
            NodeList listaGUI = document.getElementsByTagName("vistaGUI");
            NodeList listaWEB = document.getElementsByTagName("vistaWEB");
            
            operacionesCuentas = consultaAux(listaVista);
            operacionesCuentas.addAll(consultaAux(listaGUI));
            operacionesCuentas.addAll(consultaAux(listaWEB));
     
        } catch (Exception e) {
            e.printStackTrace();
        }
            return operacionesCuentas;
    }
        
       public static ArrayList <String>  consultaAux(NodeList pLista){
            ArrayList <String> operacionesCuentas = new ArrayList(); 
            for (int temp = 0; temp < pLista.getLength(); temp++) {
                Node nodo = pLista.item(temp);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                     for (int j  = 0; j < element.getElementsByTagName("numeroCuenta").getLength(); j++){
                    operacionesCuentas.add("\nNumero Cuenta: " + element.getElementsByTagName("numeroCuenta").item(j).getTextContent()+ "\nTipo Operación: " + element.getElementsByTagName("tipoOperacion").item(j).getTextContent() + "\nFecha Operación: " + element.getElementsByTagName("fechaOperacion").item(j).getTextContent() + "Monto: " + element.getElementsByTagName("monto").item(j).getTextContent() + "Monto Comision: " + element.getElementsByTagName("montoComision").item(j).getTextContent());  
                   }
                }
            }
            return operacionesCuentas;
        }
    
   
       
 }
