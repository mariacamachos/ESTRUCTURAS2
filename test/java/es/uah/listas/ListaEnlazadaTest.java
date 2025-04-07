package es.uah.listas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase ListaEnlazada
 * Verifica el correcto funcionamiento de todos los métodos públicos,incluyendo casos límite y entradas inválidas para lograr una cobertura del 100%.
 */
class ListaEnlazadaTest {

    private ListaEnlazada lista;

    //Inicializa una lista vacía antes de cada prueba.
    @BeforeEach
    void setUp() {
        lista = new ListaEnlazada();
    }

    //Verifica el constructor con un ElementoLE inicial.
    @Test
    void constructorConElemento() {
        ElementoLE el = new ElementoLE("inicio");
        ListaEnlazada lista2 = new ListaEnlazada(el);
        assertFalse(lista2.isVacia());
        assertEquals("inicio", lista2.getElemento(0).getData());
    }

    //Verifica si la lista detecta correctamente si está vacía o no.
    @Test
    void isVacia() {
        assertTrue(lista.isVacia());
        lista.add("dato");
        assertFalse(lista.isVacia());
    }

    //Verifica que el metodo vaciar() elimine todos los elementos.
    @Test
    void vaciar() {
        lista.add("dato");
        lista.vaciar();
        assertTrue(lista.isVacia());
    }

    //Verifica que se pueda añadir un ElementoLE directamente.
    @Test
    void add() {
        ElementoLE el = new ElementoLE("dato");
        lista.add(el);
        assertEquals(el, lista.getElemento(0));
    }

    //Verifica que se pueda añadir un String a la lista.
    @Test
    void testAdd() {
        lista.add("texto");
        assertEquals("texto", lista.getElemento(0).getData());
    }

    //Verifica que se pueda añadir un Object genérico a la lista.
    @Test
    void testAdd1() {
        lista.add(123);
        assertEquals(123, lista.getElemento(0).getData());
    }

    //Verifica que se pueda insertar un ElementoLE en una posición específica.
    //También se prueban inserciones en posiciones inválidas.
    @Test
    void insert() {
        ElementoLE el1 = new ElementoLE("uno");
        ElementoLE el2 = new ElementoLE("dos");
        lista.add(el1);
        lista.insert(el2, 0);
        assertEquals(el2, lista.getElemento(0));
        assertEquals(el1, lista.getElemento(1));

        // Inserciones inválidas (sólo imprimen mensaje)
        lista.insert(new ElementoLE("fuera"), -1);
        lista.insert(new ElementoLE("fuera2"), 100);
    }

    //Verifica la inserción usando un objeto en diferentes posiciones, incluyendo casos límite e inválidos.
    @Test
    void testInsert() {
        lista.insert("primero", 0);
        lista.insert("segundo", 1);
        lista.insert("tercero", 1);
        assertEquals("tercero", lista.getElemento(1).getData());

        // Inserciones inválidas (no insertan nada)
        lista.insert("invalido", -5);
        lista.insert("invalido", 100);
    }

    //Verifica el metodo de eliminación en diferentes posiciones incluyendo lista vacía y posiciones inválidas.

    @Test
    void del() {
        assertEquals(0, lista.del(0)); // Lista vacía
        lista.add("a");
        lista.add("b");
        lista.add("c");

        assertEquals(1, lista.del(1)); // Elimina "b"
        assertEquals("c", lista.getElemento(1).getData());

        assertEquals(0, lista.del(0)); // Elimina "a"
        assertEquals("c", lista.getElemento(0).getData());

        assertEquals(5, lista.del(5)); // Posición inválida
    }

    //Verifica el conteo total de elementos en la lista.
    @Test
    void getNumeroElementos() {
        assertEquals(0, lista.getNumeroElementos());
        lista.add("x");
        lista.add("y");
        assertEquals(2, lista.getNumeroElementos());
    }

    //Verifica la búsqueda de la posición de un elemento en la lista.
    @Test
    void getPosicion() {
        ElementoLE el1 = new ElementoLE("uno");
        ElementoLE el2 = new ElementoLE("dos");
        lista.add(el1);
        lista.add(el2);
        assertEquals(0, lista.getPosicion(el1));
        assertEquals(1, lista.getPosicion(el2));
        assertEquals(-1, lista.getPosicion(new ElementoLE("tres")));
    }

    //Verifica que se devuelva el último elemento correctamente.
    @Test
    void getUltimo() {
        assertNull(lista.getUltimo());
        lista.add("x");
        lista.add("y");
        assertEquals("y", lista.getUltimo().getData());
    }

    //Verifica que se devuelva el siguiente elemento de un nodo.
    @Test
    void getSiguiente() {
        ElementoLE el1 = new ElementoLE("a");
        ElementoLE el2 = new ElementoLE("b");
        el1.setSiguiente(el2);
        assertEquals(el2, lista.getSiguiente(el1));
    }

    //Verifica la obtención de elementos por índice, incluyendo casos inválidos.
    @Test
    void getElemento() {
        assertNull(lista.getElemento(0)); // Lista vacía
        lista.add("uno");
        lista.add("dos");
        assertEquals("uno", lista.getElemento(0).getData());
        assertEquals("dos", lista.getElemento(1).getData());
        assertNull(lista.getElemento(-1)); // Índice negativo
        assertNull(lista.getElemento(5)); // Fuera de rango
    }
}