package es.uah.listas;

/**
 * Clase que representa un nodo de una lista enlazada simple.
 * Cada nodo contiene un dato y una referencia al siguiente nodo.
 */
public class ElementoLE {
    /**ZONA DE ATRIBUTOS*/

    //Dato almacenado en el nodo.
    private Object data;

    //Referencia al siguiente nodo en la lista.
    private ElementoLE siguiente;
    /**ZONA DE METODOS*/
    //Constructor que inicializa el nodo con un dato.
    public ElementoLE(Object data) {
        this.data = data; //El dato que se almacenará en el nodo
        this.siguiente = null; //El siguiente nodo se establece como null
    }
    /**ZONA DE GETTERS Y SETTERS*/
    //Obtiene el dato almacenado en el nodo.
    public Object getData() {
        return data;
    }

    //Establece el dato almacenado en el nodo.
    public void setData(Object data) {
        this.data = data; //nuevo valor del dato
    }

    //Obtiene el nodo siguiente.
    public ElementoLE getSiguiente() {
        return siguiente; //Referencia al siguiente nodo o null si no hay ninguno.
    }

    //Establece el nodo siguiente.
    public void setSiguiente(ElementoLE siguiente) {
        this.siguiente = siguiente; //El nodo siguinte al actual
    }
}