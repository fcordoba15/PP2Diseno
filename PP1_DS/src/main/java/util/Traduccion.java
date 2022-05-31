
package util;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

public class Traduccion {
    
    private static final String PATH = "https://translate.googleapis.com/translate_a/single"; // Dirección
    private static final String CLIENT="gtx";
 
    private static final String USER_AGENT="Mozilla/5.0";//"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36";
 
    private static final Map<String,String> LANGUAGE_MAP=new HashMap();
 
    private static Traduccion _instance = null;
 
    /**
           * Obtener singleton
     * @return
     */
    public static Traduccion getInstance() {
        if( null == _instance){
            _instance = new Traduccion();
            _instance.init();
        }
        return _instance;

    }
    
    private void init(){
        LANGUAGE_MAP.put("auto","Automatic");
        LANGUAGE_MAP.put("en","English");
    }
    
    public boolean isSupport(String language){
        if( null == LANGUAGE_MAP.get( language )){
            return false;
        }
        return true;
    }
 
   
    public String getCode(String desiredLang){
        if( null != LANGUAGE_MAP.get(desiredLang)){
            return desiredLang;
        }
        String tmp = desiredLang.toLowerCase();
        for(Map.Entry<String, String> enter : LANGUAGE_MAP.entrySet() ){
            if( enter.getValue().equals( tmp)){
                return enter.getKey();
            }
        }
 
        return null;
    }
 
   
    public String translateText(String text,String sourceLang, String targetLang) throws Exception{
        String retStr="";
        List<NameValuePair> nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("client", CLIENT));
        nvps.add(new BasicNameValuePair("sl", sourceLang));
        nvps.add(new BasicNameValuePair("tl", targetLang));
        nvps.add(new BasicNameValuePair("dt", "t"));
        nvps.add(new BasicNameValuePair("q", text));
//        String finalPath=PATH +"?client="+CLIENT+"&sl="+sourceLang+"&tl="+targetLang+"&dt=t&q="+ text ;
 
        String resp =  postHttp( PATH,nvps);
        if( null == resp ){
                System.out.println("Excepción de red");
        }
 
 // System.out.println ("==> Devolver contenido:" + resp);
 
        JSONArray jsonObject = JSONArray.parseArray( resp );
        for (Iterator<Object> it = jsonObject.getJSONArray(0).iterator(); it.hasNext(); ) {
            JSONArray a = (JSONArray) it.next();
            retStr += a.getString(0);
        }
 
        return retStr;
    }
 
 
    /**
           * post solicitud
           * @param dirección de solicitud de URL
           * @param nvps lista de parámetros
     * @return
     * @throws UnsupportedEncodingException
     */
    private   String postHttp( String url ,List<NameValuePair> nvps){
        String responseStr = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost( url );
                 //¡importante! ! Se debe establecer el encabezado http; de lo contrario, la devolución se distorsiona
        httpPost.setHeader("User-Agent",USER_AGENT);
        CloseableHttpResponse response2 = null;
        try {
                         // ¡Importante! ! Especifique la codificación para codificar chino
            httpPost.setEntity( new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8"))  );
            response2 = httpclient.execute(httpPost);
            HttpEntity entity2 = response2.getEntity();
            responseStr = EntityUtils.toString(entity2);
            EntityUtils.consume(entity2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != response2) {
                try {
                    response2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( null != httpclient ){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseStr;
    }
    
}
