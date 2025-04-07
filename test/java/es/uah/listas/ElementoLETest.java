package es.uah.listas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**Pruebas unitarias para la clase ElementoLE.
 +Se asegura el correcto funcionamiento del constructor, los métodos de acceso (getters) y los métodos de modificación (setters).
 */
class ElementoLETest {

    //Prueba que el constructor almacena correctamente el dato y que el nodo siguiente se inicializa como null.
    @Test
    void constructorTest() {
        ElementoLE el = new ElementoLE("dato");
        assertEquals("dato", el.getData());
        assertNull(el.getSiguiente());
    }

    //Prueba el metodo getData().
    @Test
    void getData() {
        ElementoLE el = new ElementoLE("valor");
        assertEquals("valor", el.getData());
    }

    //Prueba el metodo setData(Object).
    @Test
    void setData() {
        ElementoLE el = new ElementoLE("original");
        el.setData("nuevo");
        assertEquals("nuevo", el.getData());
    }

    //Prueba el metodo getSiguiente().
    //Debe retornar null al inicio y luego el nodo enlazado.
    @Test
    void getSiguiente() {
        ElementoLE el1 = new ElementoLE("nodo1");
        ElementoLE el2 = new ElementoLE("nodo2");
        el1.setSiguiente(el2);
        assertEquals(el2, el1.getSiguiente());
    }

    //Prueba el metodo setSiguiente(ElementoLE).
    @Test
    void setSiguiente() {
        ElementoLE el1 = new ElementoLE("uno");
        ElementoLE el2 = new ElementoLE("dos");
        el1.setSiguiente(el2);
        assertSame(el2, el1.getSiguiente());
    }
}