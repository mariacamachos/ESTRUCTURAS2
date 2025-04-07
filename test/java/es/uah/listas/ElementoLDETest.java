package es.uah.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLDETest {

    @Test
    void insertarmeEn() {
        ElementoLDE nodo1 =  new ElementoLDE("A");
        ElementoLDE nodo2 =  new ElementoLDE("B");
        nodo1.insertarmeEn(nodo2);
        //verifica las relaciones entre los nodos
        assertEquals(nodo2,nodo1.getSiguiente());//nodo2 debe estar despues de nodo1

    }

    @Test
    void getSiguiente() {
        ElementoLDE nodo1 = new ElementoLDE(1);
        ElementoLDE nodo2 = new ElementoLDE(2);
        nodo2.insertarmeEn(nodo1);
        //nodo1 debe ser el siguiente a nodo2
        assertEquals(nodo1, nodo2.getSiguiente());
    }

    @Test
    void getAnterior() {
        ElementoLDE nodo1 = new ElementoLDE(1);
        ElementoLDE nodo2 = new ElementoLDE(2);
        nodo1.insertarmeEn(nodo2);
        //nodo1 debe ser el anterior a nodo2
        assertEquals(nodo1, nodo2.getAnterior());
    }

    @Test
    void getData() {
        ElementoLDE nodo = new ElementoLDE("Dato");
        //el dato del nodo debe ser "Dato"
        assertEquals("Dato", nodo.getData());
    }

    @Test
    void setData() {
        ElementoLDE nodo = new ElementoLDE("Original");
        Object anterior = nodo.setData("Nuevo");
        //anterior debe de ser el valor que he establecido en el nodo "Nuevo"
        assertEquals("Nuevo", nodo.getData(), "Debe actualizar el dato");
    }

    @Test
    void testToString() {
        ElementoLDE nodo = new ElementoLDE(123);
        //verifica que me imprima el valor de dentro del nodo
        assertEquals("123", nodo.toString());
    }
}