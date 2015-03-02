import java.util.Arrays;
import java.util.ArrayList;
/**
 * Coleccion de enteros
 * Interfaz ArrayList
 * Implementacion Array
 */
public class MiHashMap
{
    // instance variables - replace the example below with your own
    private ArrayList<String> claves;
    private int[] arrayDeEnteros;

    /**
     * Creamos el array vacio
     */
    public MiHashMap()
    {
        claves = new ArrayList<String>();
        arrayDeEnteros = new int[0];
    }

    /**
     * Agregamos un entero al final del array
     */
    public int put(String clave, int valor){
        int existe = -1;
        if(!claves.contains(clave)){
            int longitudBase = arrayDeEnteros.length; // Guardo tamaño
            // Creo una copia de si mismo con un espacio mas
            arrayDeEnteros = Arrays.copyOf(arrayDeEnteros, (longitudBase + 1));
            // Agrego el valor en la ultima posicion, que es el tamaño antes de la copia
            arrayDeEnteros[longitudBase] = valor;
            claves.add(clave);
        }else{
            int indice = claves.indexOf(clave);
            existe = arrayDeEnteros[indice];
            arrayDeEnteros[indice] = valor;
        }
        return existe;
    }
    
    /**
     * Elimina la coleccion, y crea una vacia
     */
    public void clear(){
        arrayDeEnteros = new int[0];
        claves = new ArrayList<String>();
    }
    
    /**
     * Busca el elemento pedido
     * Si existe, devuelve true
     * Si no existe, devuelve false
     */
    public boolean containsValue(int elemento){
        boolean existe = false;
        int contador = 0;
        int longitud = arrayDeEnteros.length;
        while (!existe && contador < longitud){
            if(arrayDeEnteros[contador] == elemento){
                existe = true;
            }else{
                contador++;
            }
        }
        return existe;
    }
    
    /**
     * Devuelve el entero almacenado en la posicion indicada
     * Si esa posicion no existe, devuelve -1
     */
    public int get(String clave){
        int valor = -1;
        if (claves.contains(clave)){
            valor = arrayDeEnteros[claves.indexOf(clave)];
        }
        return valor;
    }
    
    /**
     * Devuelve true si no hay enteros guardados
     * Devuelve false si hay algun elemento guardado
     */
    public boolean isEmpty(){
        return (arrayDeEnteros.length == 0);
    }
    
    /**
     * Devuelve cuantos enteros hay en la coleccion
     */
    public int size(){
        return arrayDeEnteros.length;
    }
    
    /**
     * Elimina el elemento de la posicion indicada
     * Si la posicion existe, devuelve el elemento
     * Si la posicion no existe, devuelve -1
     */
    public int remove(String clave){
        int valor = -1;
        if(claves.contains(clave)){
            int indice = claves.indexOf(clave);
            int longitud = arrayDeEnteros.length;
            int[] arrayTemp = new int[longitud - 1];
            int contador = 0;
            for (; contador < indice; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador];
            }
            valor = arrayDeEnteros[indice];
            for (; contador < longitud - 1; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador + 1];
            }
            arrayDeEnteros = arrayTemp;
            claves.remove(indice);
        }
        return valor;
    }
    
    /**
     * Devuelve true si el MiHashMap contiene la clave buscada
     */
    public boolean containsKey(String clave){
        return claves.contains(clave);
    }
}