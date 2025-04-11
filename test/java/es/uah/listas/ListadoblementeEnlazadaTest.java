package es.uah.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListadoblementeEnlazadaTest {

    @Test
    void isVacia() {
        // Verifica que una lista nueva esté vacía
        var lista = new ListadoblementeEnlazada<>();
        assertTrue(lista.isVacia());
    }

    @Test
    void vaciar() {
        // Verifica que vaciar elimine todos los elementos
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.vaciar();
        assertTrue(lista.isVacia());
    }

    @Test
    void add() {
        // Verifica que se puede agregar un String
        var lista = new ListadoblementeEnlazada<>();
        lista.add("Hola");
        assertEquals(1, lista.getNumeroElementos());
        assertEquals("Hola", lista.getPrimero().getData());
    }

    @Test
    void testAdd() {
        // Verifica que se puede agregar un Object
        var lista = new ListadoblementeEnlazada<>();
        lista.add(123);
        assertEquals(1, lista.getNumeroElementos());
    }

    @Test
    void insert() {
        // Inserta un elemento en la posición 0 (al inicio)
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.insert("B", 0);
        assertEquals("B", lista.getElemento(0).getData());
        assertEquals("A", lista.getElemento(1).getData());
    }

    @Test
    void testInsert() {
        // Inserta un elemento al final
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.insert("C", 1);
        assertEquals("C", lista.getUltimo().getData());
    }

    @Test
    void del() {
        // Elimina el primer elemento
        var lista = new ListadoblementeEnlazada<>();
        lista.add("X");
        lista.add("Y");
        int result = lista.del(0);
        assertEquals(1, result);
        assertEquals("Y", lista.getPrimero().getData());
    }

    @Test
    void getNumeroElementos() {
        // Verifica el conteo correcto de elementos
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        assertEquals(3, lista.getNumeroElementos());
    }

    @Test
    void getPosicion() {
        // Verifica que se puede obtener la posición de un nodo
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        ElementoLDE el = lista.getPrimero();
        assertEquals(0, lista.getPosicion(el));
    }

    @Test
    void getPrimero() {
        // Devuelve correctamente el primer elemento
        var lista = new ListadoblementeEnlazada<>();
        lista.add("Inicio");
        assertEquals("Inicio", lista.getPrimero().getData());
    }

    @Test
    void getUltimo() {
        // Devuelve correctamente el último elemento
        var lista = new ListadoblementeEnlazada<>();
        lista.add("Primero");
        lista.add("Ultimo");
        assertEquals("Ultimo", lista.getUltimo().getData());
    }

    @Test
    void getAnterior() {
        // Verifica la referencia al nodo anterior
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.add("B");
        ElementoLDE b = lista.getUltimo();
        assertEquals("A", lista.getAnterior(b).getData());
    }

    @Test
    void getSiguiente() {
        // Verifica la referencia al nodo siguiente
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.add("B");
        ElementoLDE a = lista.getPrimero();
        assertEquals("B", lista.getSiguiente(a).getData());
    }

    @Test
    void getElemento() {
        // Verifica acceso por posición
        var lista = new ListadoblementeEnlazada<>();
        lista.add("A");
        lista.add("B");
        assertEquals("B", lista.getElemento(1).getData());
    }

}