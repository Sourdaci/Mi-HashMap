import java.util.Arrays;
/**
 * Coleccion de enteros
 * Interfaz ArrayList
 * Implementacion Array
 */
public class ArrayListInt
{
    // instance variables - replace the example below with your own
    private int[] arrayDeEnteros;

    /**
     * Creamos el array vacio
     */
    public ArrayListInt()
    {
        arrayDeEnteros = new int[0];
    }

    /**
     * Agregamos un entero al final del array
     */
    public void add(int valor){
        int longitudBase = arrayDeEnteros.length; // Guardo tamaño
        // Creo una copia de si mismo con un espacio mas
        arrayDeEnteros = Arrays.copyOf(arrayDeEnteros, (longitudBase + 1));
        // Agrego el valor en la ultima posicion, que es el tamaño antes de la copia
        arrayDeEnteros[longitudBase] = valor;
    }
    
    /**
     * Agregamos un elemento en la posicion especificada
     */
    public void add(int posicion, int valor){
        int longitudBase = arrayDeEnteros.length; // Guardo tamaño
        if (posicion >= 0 && posicion < longitudBase){ // Si la posicion esta en rango y hay elementos
            int[] arrayTemp = new int[longitudBase + 1]; // Creo el nuevo array
            for (int i1 = 0; i1 < posicion; i1++){ // Guardo datos hasta llegar a posicion
                arrayTemp[i1] = arrayDeEnteros[i1];
            }
            arrayTemp[posicion] = valor; // Guardo el nuevo dato en posicion
            for (int i2 = posicion + 1; i2 < longitudBase + 1; i2++){
                // Guardo los siguientes datos hasta acabar
                arrayTemp[i2] = arrayDeEnteros[i2 - 1];
            }
            arrayDeEnteros = arrayTemp; // Reasigno las referencias para quedarme con el array bueno
        }
    }
    
    /**
     * Elimina la coleccion, y crea una vacia
     */
    public void clear(){
        arrayDeEnteros = new int[0];
    }
    
    /**
     * Busca el elemento pedido
     * Si existe, devuelve true
     * Si no existe, devuelve false
     */
    public boolean contains(int elemento){
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
     * Las posiciones comienzan en CERO
     * Si esa posicion no existe, devuelve -1
     */
    public int get(int index){
        int valor = -1;
        if (index >= 0 && index < arrayDeEnteros.length){
            valor = arrayDeEnteros[index];
        }
        return valor;
    }
    
    /**
     * Cambia el valor del elemento de la posicion indicada
     */
    public void set(int index, int element){
        if(index >= 0 && index < arrayDeEnteros.length){
            arrayDeEnteros[index] = element;
        }
    }
    
    /**
     * Devuelve la primera posicion del elemento buscado
     * Si el elemento no existe, se devuelve -1
     */
    public int indexOf(int elemento){
        int posicion = -1;
        int contador = 0;
        int longitud = arrayDeEnteros.length;
        while (posicion == -1 && contador < longitud){
            if(arrayDeEnteros[contador] == elemento){
                posicion = contador;
            }else{
                contador++;
            }
        }
        return posicion;
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
    public int remove(int index){
        int valor = -1;
        int longitud = arrayDeEnteros.length;
        if (index >= 0 && index < longitud){
            int[] arrayTemp = new int[longitud - 1];
            int contador = 0;
            for (; contador < index; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador];
            }
            valor = arrayDeEnteros[contador];
            for (; contador < longitud - 1; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador + 1];
            }
            arrayDeEnteros = arrayTemp;
        }
        return valor;
    }
}
