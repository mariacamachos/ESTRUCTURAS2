package es.uah.listas;
//esta clase representa un nodo de una LDE
public class ElementoLDE {
    /**ATRIBUTOS**/

    //cada lista guarda una referencia al anterior y al siguiente
    private ElementoLDE anterior;
    private ElementoLDE siguiente;
    //guarda el dato contenido en el nodo
    private Object data;

    /**METODOS**/

    //constructor que inicializa el nodo con el dato proporcionado
    public ElementoLDE (Object data){
        this.data=data;
    }
    //inserta un nuevo nodo inmediatamente despues de el
    protected void insertarmeEn(ElementoLDE el){
        el.siguiente=this.siguiente;
        el.anterior=this;

        if (this.siguiente !=null){
            this.siguiente.anterior=el;
        }
        this.siguiente=el;
    }
    //me devuelve el siguiente del elemento
    protected ElementoLDE getSiguiente(){
        return this.siguiente;
    }
    //me devuelve el anterior del elemento
    protected ElementoLDE getAnterior(){
        return this.anterior;
    }
    //me devuelve el dato del nodo
    public Object getData(){
        return this.data;
    }
    //establece el dato en el nodo
    public Object setData(Object o){
        Object temporal = data;
        this.data=o;
        return temporal;
    }
    //imprime el valor que tiene guardado dentro el nodo
    public String toString(){
        return String.valueOf(this.data);
    }
}

