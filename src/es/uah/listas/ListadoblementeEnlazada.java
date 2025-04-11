package es.uah.listas;

public class ListadoblementeEnlazada <I extends Number>{
    /**Apunta el primer nodo de la lista*/
    private ElementoLDE primero;
    /**Apunta el último nodo de la lista*/
    private ElementoLDE ultimo;

    /**Verifica si la lista está vacía*/
    public boolean isVacia() {
        return primero == null;  //No hay cadena
    }

    /**Elimina todos los elementos de la lista*/
    public void vaciar() {
        primero = null;
        ultimo = null;    //Corto la cadena
    }

    /** Agrega un nodo al final de la llista y devuelve la cantidad de elementos antes de agregar*/
    public int add(ElementoLDE el) {
        if (primero== null) {
            primero = el;
        }
        else {
            ultimo.insertarmeEn(el); //Enlaza el nuevo nodo al final
        }
        ultimo=el; //el nuevo nodo pasa a ser el último
        ElementoLDE posicion= primero;
        int contador=0;
        while(posicion.getSiguiente()!=null){
            contador++;
            posicion=posicion.getSiguiente();
        }
        return contador;
    }

    /**Agrega un nuevo elemento con datos tipo String*/
    public void add(String s) {
        ElementoLDE el = new ElementoLDE(s);
        this.add(el);
    }

    /** Agrega un nuevo elemento con datos tipo Object*/
    public void add(Object o) {
        ElementoLDE el = new ElementoLDE(o);
        this.add(el);
    }

    /**Inserta un String en una posición específica*/
    public void insert(String s, int posicion) {
        ElementoLDE el = new ElementoLDE(s);

        if (posicion >= 0) {
            if (posicion == 0 || isVacia()) { //Se inserta el primero o esta vacio
                el.insertarmeEn(primero);
                primero = el;
                if (ultimo == null) {
                    ultimo = el;
                }
            } else {
                ElementoLDE actual= primero;
                int contador=0;
                while(actual!=null && contador<posicion){  //Encontrar la poscion en la que insertar
                    actual=actual.getSiguiente();
                    contador ++;
                }
                if (actual!= null) {
                    actual.insertarmeEn(el);
                }
                else {
                    ultimo.insertarmeEn(el); // Insertar al final de la lista
                    ultimo = el;
                }

            }
        }
    }

    /**Inserta un Object en una posición específica*/
    public void insert(Object o, int posicion) {
        ElementoLDE el = new ElementoLDE(o);

        if (posicion >= 0) {
            if (posicion == 0 || isVacia()) { //Se inserta el primero o esta vacio
                el.insertarmeEn(primero);
                if (ultimo == null) {
                    ultimo = el;
                }
            } else {
                ElementoLDE actual= primero;
                int contador=0;
                while(actual!=null && contador<posicion){  //Encontrar la poscion en la que insertar
                    actual=actual.getSiguiente();
                    contador ++;
                }
                if (actual!= null) {
                    actual.insertarmeEn(el);
                }
                else {
                    ultimo.insertarmeEn(el); // Insertar al final de la lista
                    ultimo = el;
                }

            }
        }
    }


    /**Elimina el elemento en la posición indicada*/
    public int del(int posicion){
        if (!isVacia() && posicion >= 0) {
            if (posicion == 0) {
                primero = primero.getSiguiente();
                if (primero == null) {
                    ultimo = null;
                }
                return 1;
            }
            else {
                ElementoLDE actual = primero;
                int contador = 0;
                while (actual != null && contador < posicion) {
                    actual = actual.getSiguiente();
                    contador++;
                }
                if (actual != null && actual.getSiguiente() != null) {
                    actual.getSiguiente().insertarmeEn(actual.getAnterior());
                    if (actual.getSiguiente() == ultimo) {
                        ultimo = actual;
                    }
                    return 1;
                }
            }
        }
        return -1; //No se ha podido
    }

    /**Devuelve la cantidad de elementos en la lista*/
    public int getNumeroElementos(){
        int contador = 0;
        ElementoLDE actual = primero;
        while(actual!=null){
            contador++;
            actual=actual.getSiguiente();
        }
        return contador;
    }

    /**Devuelbe la posición de un elemento dado, o -1 si no se encuentra*/
    public int getPosicion(ElementoLDE el){
        int posicion=0;
        ElementoLDE actual=primero;

        while (actual !=null){
            if(actual.getData().equals(el.getData())){
                return posicion;
            }
            actual=actual.getSiguiente();
            posicion++;
        }
        return -1; //No hay
    }

    /**Devuelve el primer nodo de la lista*/
    public ElementoLDE getPrimero(){
        return this.primero;
    }

    /**Devuelve el último nodo de la lista*/
    public ElementoLDE getUltimo(){
        return this.ultimo;
    }

    /**Devuelve el nodo anterior al nodo dado*/
    public ElementoLDE getAnterior(ElementoLDE el){
        if (el != null) {
            return el.getAnterior();
        }
        return null;
    }

    /**Devuelve el nodo siguiente al nodo dado*/
    public ElementoLDE getSiguiente(ElementoLDE el){
        if (el != null) {
            return el.getSiguiente();
        }
        return null;
    }

    /**Devuelve el nodo en la posición indicada*/
    public ElementoLDE getElemento(int posicion){
        ElementoLDE actual = primero;
        int contador = 0;
        while (actual != null && contador < posicion) {
            actual = actual.getSiguiente();
            contador++;
        }
        return actual;
    }

}
