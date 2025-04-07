package es.uah.listas;

public class ListaSimple {
    /**Atributos**/
    //almacena los elementos
    private ElementoLS[] datos;
    //declara el tamaño maximo de la lisa
    private int maximo;
    /**METODOS**/
    //inicializa la lista con el tamaño maximo
    public ListaSimple(int maximo){
        this.maximo=maximo;
        datos=new ElementoLS[maximo];
    }
    //comprueba si todos los elementos de la lista son null
    public boolean isVacia(){
        for (int i=0;i<maximo-1;i++){
            if (datos[i]!=null){
                return false;
            }
        }
        return true;
    }
    //pone en null todos los elementos excepto el ultimo
    public void vaciar(){
        if (!isVacia()){
            for (int i=0;i<maximo-1;i++){
                datos[i]=null;
            }
        }
    }
    //recorre la lista y añade el elemento en el primer espacio que encuentra libre
    private int add(ElementoLS el){
        for (int i=0;i<maximo-1;i++){
            if (datos[i]==null){   //Hay una posición libre
                datos[i]=el;
                return i;
            }
        }
        return -1; //indica que la lista está llena
    }
    //crea un nuevo elemento, le mete un dato y lo añade con la anterior funcion
    public void add(String s){
        ElementoLS el=new ElementoLS(); //Creo nuevo elemento
        el.setData(s);
        add(el);  //Agrego
    }
    //crea un nuevo elemento, le mete un dato y lo añade con la anterior funcion
    public void add(Object o){
        ElementoLS el=new ElementoLS(); //Creo nuevo elemento
        el.setData(o);
        add(el);  //Agrego
    }
    //inserta un elemento en una posicion concreta
    public void insert(Object o, int posicion) {
        if ((posicion >= 0) && (posicion < maximo-1)) {
            ElementoLS el=new ElementoLS();
            el.setData(o);
            datos[posicion] = el;
        }
    }
    //inserta un String en una posicion especifica
    public void insert(String s, int posicion) {
        if((posicion > 0) && (posicion < maximo-1)) {
            ElementoLS el=new ElementoLS();
            el.setData(s);
            datos[posicion] = el;
        }
    }
    //elimina un elemento de una posicion dada comprobando que esta sea valida
    public int del(int posicion) {
        if ((posicion > 0) && (posicion < maximo-1)) {  //comprueba si la posicion es valida
            datos[posicion] = null;
            return 1;
        }
        return -1; //devuelve esto si la posicion no es valida
    }
    //recorre la lista y con un contador mira cuantos elementos no nulos hay
    public int getNumeroElementos() {
        int cont = 0;
        for (int i = 0; i < maximo-1; i++) {
            if (datos[i] != null) {
                cont++;
            }
        }
        return cont;
    }
    //devuelve la posicion de un elemento dado
    public int getPosicion(ElementoLS el) {
        ElementoLS actual = getPrimero();
        int posicion = 0;

        while (actual != null) {
            if (actual.getData().equals(el)) {
                return posicion; // Se encontró el elemento
            }
            actual = getSiguiente(actual); // Siguiente
            posicion++; // Aumenta la posición
        }
        return -1;  //Error
    }
    //devuelve el primer elemento siempre que no sea nulo
    public ElementoLS getPrimero() {
        if (datos[0]!=null){
            return datos[0];
        }
        return null;//Lista vacia;
    }
    //busca el ultimo empezando por el final hasta que encuentre uno no nulo
    public ElementoLS getUltimo() {
        for (int i=maximo-1;i>0;i--){
            if (datos[i]!=null){
                return datos[i];
            }
        }
        return null;//Lista vacia
    }
    //devuelve el siguiente elemento a uno dado
    protected ElementoLS getSiguiente(ElementoLS el) {
        if (el != null) {
            ElementoLS siguiente = null;
            for (int i = 0; i < maximo; i++) {
                if (datos[i] == el) {
                    if (i + 1 < maximo) {
                        siguiente = datos[i + 1];
                    }
                    break; //
                }
            }
            return siguiente;
        }
        return null;
    }
    //devuelve el elemento en la posicion dada si es que la posicion es valida
    public ElementoLS getElemento(int posicion) {
        if ((posicion >= 0) && (posicion < maximo-1)) {
            return datos[posicion];
        }
        return null; //si la posicion no es valida o esta vacia
    }
}


