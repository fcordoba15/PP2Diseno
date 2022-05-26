/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacionExterna;

import comunicacionExterna.ConexionWebService;
import comunicacionExterna.ObtencionXML;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ranbe
 */
public class CambioMoneda {
    private String fechaInicio;
    private String fechaFinal;
    private int indicadorRequerido = 0;
    private final String nombre = "ProyectoD";
    private final String subNiveles = "N";
    private final String host = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
    private String url;
    private final String valueTag = "NUM_VALOR";

    public CambioMoneda(){
      setFecha();
    }
    
    private void setCompra(){
        this.indicadorRequerido = 317;
    }

    private void setVenta(){
        this.indicadorRequerido = 318;
    }
    
    public double getCompra(){
        setCompra();

        double valor = Double.parseDouble(getValores());
        return valor;
    }

    public double getVenta(){
        setVenta();

        double valor = Double.parseDouble(getValores());
        return valor;
    }
    
    private String getValores(){
        try {
          setUrl();

          String data = ConexionWebService.getHTML(url);
          ObtencionXML xml = new ObtencionXML(data);

          return xml.getValores(valueTag );
        } 
        catch (Exception e) {
          System.out.println("Error, no se obtuvo el valor de cambio.");
          return "0";
        }
    }

    private void setUrl(){
        String params = "Indicador="+indicadorRequerido+"&FechaInicio="+fechaInicio+"&FechaFinal="+fechaFinal+"&Nombre="+nombre+"&SubNiveles="+subNiveles+"&CorreoElectronico="+"proyectobanco2022@gmail.com"+"&Token="+"M2222151NS";
        this.url = host +"?"+params;
    }

    private void setFecha(){
        Date date = new Date();
        SimpleDateFormat fechaAuxiliar = new SimpleDateFormat("dd/MM/yyyy");

        this.fechaInicio = fechaAuxiliar.format(date);
        this.fechaFinal = fechaInicio;
    }
}
