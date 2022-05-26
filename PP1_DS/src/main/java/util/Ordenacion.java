
package util;


public class Ordenacion {
    public static void insercion(Comparable [] arregloP){
        for(int i=1; i<arregloP.length; i++){
            Comparable nuevo = arregloP[i];
            int j = i - 1;
            
            while(j>=0 && !arregloP[j].menorQue(nuevo)){
                arregloP[j+1] = arregloP[j];
                j--;
            }
            arregloP [j+1] = nuevo;
        }
    }
}
