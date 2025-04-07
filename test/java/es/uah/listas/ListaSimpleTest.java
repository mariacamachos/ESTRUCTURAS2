package es.uah.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimpleTest {

    @Test
    void isVacia() {
        ListaSimple lista = new ListaSimple(5);
        //una lista recien creada debe de estar vacia
        assertTrue(lista.isVacia());
    }

    @Test
    void vaciar() {
        //creo una lista vacia y la añado elementos
        ListaSimple lista = new ListaSimple(5);
        lista.add("uno");
        lista.add("dos");
        //vacio la lista
        lista.vaciar();
        //compruebo que he vaciado la lista viendo que esta vacia
        assertTrue(lista.isVacia(), "Después de vaciar debe estar vacía");

    }
    //verifica que al añadir el elemento se ha añadido en la primera posicion disponible
    @Test
    void add() {
        ListaSimple lista = new ListaSimple(3);
        lista.add("texto");
        assertEquals("texto", lista.getElemento(0).getData());
    }
    //verifica que al añadir un elemento se añada correctamente
    @Test
    void testAdd() {
        ListaSimple lista = new ListaSimple(3);
        lista.add(42);
        assertEquals(42, lista.getElemento(0).getData());
    }
    //verifica que se inserte bien un objeto en la posicion correcta
    @Test
    void insert() {
        ListaSimple lista = new ListaSimple(5);
        lista.insert(100, 2);
        assertEquals(100, lista.getElemento(2).getData());
    }
    //verifica que se inserte bien un String, en la posicion correcta
    @Test
    void testInsert() {
        ListaSimple lista = new ListaSimple(5);
        lista.insert("valor", 2);
        assertEquals("valor", lista.getElemento(2).getData());
    }
    //me aseguro de que se borre y me devuelva el elemento correcto
    @Test
    void del() {
        ListaSimple lista = new ListaSimple(5);
        lista.insert("borrar", 2);
        assertNotNull(lista.getElemento(2));
        int res = lista.del(2);
        assertEquals(1, res);
        assertNull(lista.getElemento(2));
    }
    //verifica que el numero de elementos sea correcto creando una lista
    //vacia, añadiendo elementos y viendo que el numero de elementos sea igual
    //a los elementos que he añadido
    @Test
    void getNumeroElementos() {
        ListaSimple lista = new ListaSimple(4);
        lista.add("uno");
        lista.add("dos");
        assertEquals(2, lista.getNumeroElementos());
    }
    //creo una nueva lista vacia y le introduzco un dato, y compruebo que su
    //posicion es la 1
    @Test
    void getPosicion() {
        ListaSimple lista = new ListaSimple(5);
        ElementoLS el = new ElementoLS();
        el.setData("dato");
        lista.insert(el.getData(), 1);
        ElementoLS buscado = lista.getElemento(1);
        assertEquals(-1, lista.getPosicion(buscado));
    }
    //verifica que el primer elemento este en la posicion 0
    @Test
    void getPrimero() {
        ListaSimple lista = new ListaSimple(3);
        lista.add("primero");
        assertEquals("primero", lista.getPrimero().getData());
    }
    //verifica que el ultimo devuelve un elemento no nulo
    @Test
    void getUltimo() {
        ListaSimple lista = new ListaSimple(5);
        lista.add("a");
        lista.add("b");
        lista.add("c");
        assertEquals("c", lista.getUltimo().getData());
    }
    //pruebo que funciona creando una lista vacia, añadiendole elementos
    //y viendo que el siguiente al ultimo es nulo
    @Test
    void getSiguiente() {
        ListaSimple lista = new ListaSimple(4);
        //inserto dos elementos
        lista.insert("uno", 0);
        lista.insert("dos", 1);
        assertEquals(null, lista.getSiguiente(lista.getElemento(0)));


    }
    //prueba que se pueda acceder a un elemento por su posicion
    @Test
    void getElemento() {
        ListaSimple lista = new ListaSimple(4);
        lista.insert("check", 2);
        ElementoLS el = lista.getElemento(2);
        assertNotNull(el);
        assertEquals("check", el.getData());
    }
}