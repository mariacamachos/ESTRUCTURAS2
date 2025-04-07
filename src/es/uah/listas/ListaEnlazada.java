package es.uah.listas;

/**
 * Clase que representa una lista enlazada simple.
 */
public class ListaEnlazada {
    /**ZONA DE ATRIBUTOS*/
    private ElementoLE primero;
    /**ZONA DE METODOS*/

    //Constructor por defecto. Crea una lista vacía.
    public ListaEnlazada() {
        this.primero = null;
    }
     //Constructor que inicializa la lista con un primer elemento.
     //primero es el primer elemento de la lista.
    public ListaEnlazada(ElementoLE primero) {
        this.primero = primero;
    }

    //Verifica si la lista está vacía.
    //Devuele true si la lista no contiene elementos, false en caso contrario.
    public boolean isVacia() {
        return primero == null;
    }

    //Vacía la lista eliminando todos los elementos.
    public void vaciar() {
        primero = null;
    }

    //Agrega un elemento al final de la lista.
    //el es el elemento a agregar.

    public void add(ElementoLE el) {
        if (primero == null) {
            primero = el;
        } else {
            ElementoLE actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(el);
        }
    }

    //Agrega un nuevo elemento con una cadena al final de la lista.
    //s es la cadena de texto a encapsular en un nuevo elemento.
    public void add(String s) {
        ElementoLE nuevoElemento = new ElementoLE(s);
        add(nuevoElemento);
    }

    //Agrega un nuevo elemento con un objeto al final de la lista.
    //o es el objeto a encapsular en un nuevo elemento.
    public void add(Object o) {
        ElementoLE nuevoElemento = new ElementoLE(o);
        add(nuevoElemento);
    }

    //Inserta un elemento en la posición indicada.
    //elemento es el elemento a insertar.
    //posicion es la posición en la que se desea insertar.
    public void insert(ElementoLE elemento, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida");
            return;
        }

        if (posicion == 0) {
            elemento.setSiguiente(primero);
            primero = elemento;
        } else {
            ElementoLE anterior = getElemento(posicion - 1);
            if (anterior != null) {
                elemento.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(elemento);
            } else {
                System.out.println("Posición inválida");
            }
        }
    }

    //Inserta un objeto en la posición indicada.
    //o es el objeto a insertar.
    //posicion es la posición en la que se desea insertar.
    public void insert(Object o, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida");
            return;
        }

        ElementoLE nuevoElemento = new ElementoLE(o);

        if (posicion == 0) {
            nuevoElemento.setSiguiente(primero);
            primero = nuevoElemento;
        } else {
            ElementoLE anterior = getElemento(posicion - 1);
            if (anterior != null) {
                nuevoElemento.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(nuevoElemento);
            } else {
                System.out.println("Posición inválida");
            }
        }
    }

    //Elimina el elemento en la posición especificada.
    //posicion es la posición del elemento a eliminar.
    //La posición eliminada (o la original si fue inválida).
    public int del(int posicion) {
        if (posicion < 0 || primero == null) {
            System.out.println("Posición inválida o lista vacía");
            return posicion;
        }
        if (posicion == 0) {
            primero = primero.getSiguiente();
        } else {
            ElementoLE anterior = getElemento(posicion - 1);
            if (anterior != null && anterior.getSiguiente() != null) {
                anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
            } else {
                System.out.println("Posición inválida");
            }
        }
        return posicion;
    }
    /**ZONA DE GETTERS Y SETTERS*/
    //Devuelve el número de elementos en la lista.
    public int getNumeroElementos() {
        int contador = 0;
        ElementoLE actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    //Obtiene la posición de un elemento específico.
    //el es elemento a buscar.
    //Posición del elemento o -1 si no se encuentra.
    public int getPosicion(ElementoLE el) {
        int posicion = 0;
        ElementoLE actual = primero;
        while (actual != null) {
            if (actual == el){
                return posicion;
            }
            posicion++;
            actual = actual.getSiguiente();
        }
        return -1;
    }

    //Obtiene el último elemento de la lista.
    //Último elemento o null si la lista está vacía.
    public ElementoLE getUltimo() {
        ElementoLE actual = primero;
        while (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    //Devuelve el siguiente elemento del proporcionado.
    //el es elemento del que se quiere el siguiente.
    //Elemento siguiente o null si no hay más.
    public ElementoLE getSiguiente(ElementoLE el) {
        return el.getSiguiente();
    }

    //Devuelve el elemento en una posición específica.
    //Índice de la posición.
    //Elemento en la posición o null si es inválida.
    public ElementoLE getElemento(int posicion) {
        if (posicion < 0 || primero == null) {
            return null;
        }
        ElementoLE actual = primero;
        for (int i = 0; i < posicion; i++) {
            if (actual == null) {
                return null;
            }
            actual = actual.getSiguiente();
        }
        return actual;
    }
}
