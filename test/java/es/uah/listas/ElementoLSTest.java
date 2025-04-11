package es.uah.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ElementoLSTest {

    @Test
    void getData() {
        ElementoLS elemento = new ElementoLS();
        elemento.setData("Hola");
        assertEquals("Hola", elemento.getData());
    }

    @Test
    void setData() {
        ElementoLS elemento = new ElementoLS();
        elemento.setData(123);
        assertEquals(123, elemento.getData());
    }

    @Test
    void testToString() {
        ElementoLS elemento = new ElementoLS();
        elemento.setData("Texto");
        assertEquals("Texto", elemento.toString());
    }

}