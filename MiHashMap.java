import java.util.Arrays;
import java.util.ArrayList;
/**
 * Coleccion de enteros indizada
 * Interfaz HashMap
 * Implementacion: Claves como String, Array de int como valor
 * 
 * @author Sourdaci
 * @version 1.2 (2015-03-02 02)
 */
public class MiHashMap
{
    // Declaracion de atributos: ArrayList<String> y int[]
    private ArrayList<String> claves;
    private int[] arrayDeEnteros;

    /**
     * Inicializamos los atributos
     */
    public MiHashMap()
    {
        claves = new ArrayList<String>();
        arrayDeEnteros = new int[0];
    }

    /**
     * Intentamos agregar un valor a la coleccion
     * Si el valor existe, se sobreescribe y se devuelve el antiguo
     * 
     * @param clave El indice 'String' del valor a almacenar
     * @param valor El valor 'int' a almacenar
     * @return existe -1 si no existe 'clave', antiguo 'valor' si existe
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
     * Indica si el valor esta almacenado
     * 
     * @param valor El valor que se quiere comprobar si existe
     * @return existe 'true' si se encuentra, 'false' si no se encuentra
     */
    public boolean containsValue(int valor){
        boolean existe = false;
        int contador = 0;
        int longitud = arrayDeEnteros.length;
        while (!existe && contador < longitud){
            if(arrayDeEnteros[contador] == valor){
                existe = true;
            }else{
                contador++;
            }
        }
        return existe;
    }
    
    /**
     * Busca la clave pedida y devuelve su valor asociado
     * 
     * @param clave El 'String' indice buscado
     * @return valor El 'valor' asociado a la clave, -1 si la clave no existe
     */
    public int get(String clave){
        int valor = -1;
        if (claves.contains(clave)){
            valor = arrayDeEnteros[claves.indexOf(clave)];
        }
        return valor;
    }
    
    /**
     * Informa de si el MiHashMap esta vacio
     * 
     * @return empty 'true' si esta vacio, 'false' si contiene algun valor
     */
    public boolean isEmpty(){
        return (arrayDeEnteros.length == 0);
    }
    
    /**
     * Devuelve cuantos datos hay en la coleccion
     * 
     * @return size El numero de elementos almacenados en el MiHashMap
     */
    public int size(){
        return arrayDeEnteros.length;
    }
    
    /**
     * Elimina el valor de la posicion indicada
     * 
     * @param clave El 'String' indice del valor a eliminar
     * @return valor El 'int' valor borrado, -1 si el indice no existe
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
     * Indica si el indice existe en el MiHashMap
     * 
     * @param clave El 'String' indice buscado
     * @return existe 'true' si se encuentra, 'false' si no se encuentra
     */
    public boolean containsKey(String clave){
        return claves.contains(clave);
    }
}