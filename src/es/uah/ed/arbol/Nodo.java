package es.uah.ed.arbol;

public class Nodo {
    /**ATRIBUTOS*/
    private Object data;
    private Nodo izquierda;
    private Nodo derecha;

    /**METODOS*/
    /**Metodo que inicializa el nodo con un dato, siendo los hijos izquierdos y derechos nulos*/
    public Nodo(Object data) {
        this.data = data;
        this.izquierda = null;
        this.derecha = null;
    }
    /**Metodo que devuelve el dato almacenado en el nodo*/
    public Object getData() {
        return data;
    }
    /**Metodo que permite modificar el dato almacenado en el nodo*/
    public void setData(Object data) {
        this.data = data;
    }
    /**Metodo que devuelve la referencia al hijo izquierdo del nodo*/
    public Nodo getIzquierda(){
        return this.izquierda;
    }
    /**Metodo que devuelve la referencia al hijo derecho del nodo*/
    public Nodo getDerecha(){
        return this.derecha;
    }
    /**Metodo que permite establecer el hijo izquierdo del nodo*/
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
    /**Metodo que permite establecer el hijo derecho del nodo*/
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
}
