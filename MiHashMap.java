import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class MiHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiHashMap{
    // instance variables - replace the example below with your own
    private ArrayList<String> claves;
    private ArrayListInt valores;

    /**
     * Constructor for objects of class MiHashMap
     */
    public MiHashMap(){
        claves = new ArrayList<String>();
        valores = new ArrayListInt();
    }
    
    /**
     * Agrega entradas al MiHashMap
     * Devuelve -1 si la clave es nueva
     * Devuelve el antiguo valor si la clave existe
     */
    public int put(String clave, int valor){
        int indice = -1;
        int encontrado = -1;
        int contador = 0;
        int cantidad = claves.size();
        while (contador < cantidad && indice == -1){
            if(claves.get(contador).equals(clave)){
                indice = contador;
            }else{
                contador++;
            }
        }
        if (indice != -1){
            encontrado = valores.get(indice);
            valores.set(indice, valor);
        }else{
            claves.add(clave);
            valores.add(valor);
        }
        return encontrado;
    }
}
