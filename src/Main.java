import es.uah.ed.arbol.*;
import es.uah.listas.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /**Primer ejemplo*/
        System.out.println("ARBOL EJEMPLO 1");
        /**Añade los números del 0 al 128 al árbol*/
        ArbolBinarioDeBusquedaEnteros arbol1 = new ArbolBinarioDeBusquedaEnteros();
        for (int i = 0; i <= 128; i++) {
            arbol1.add(i);
        }


        /** Muestra la suma total de los elementos del árbol*/
        System.out.println("Suma árbol 1:" + arbol1.getSuma());
        /**Obtiene la lista de elementos en preorden*/
        ListadoblementeEnlazada<Integer> listapreorden = arbol1.getListaPreOrden();
        int sumapre = 0; /**Se inicializa en 0*/
        /**Recorre la lista en preorden y suma sus elementos*/
        for (int i = 0; i < listapreorden.getNumeroElementos(); i++) {
            ElementoLDE elempre = listapreorden.getElemento(i);
            /**Lo convierte a entero para poder sumarlo*/
            sumapre += Integer.parseInt(elempre.getData().toString());
        }
        /** Muestra la suma total de los elementos del árbol ordenado en preorden*/
        System.out.println("Suma arbol 1 ordenado en preorden:" + sumapre);
        /**Obtiene la lista en postorden*/



        ListadoblementeEnlazada<Integer> listapostorden = arbol1.getListaPostOrden();
        int sumapost = 0; /**Se inicializa en 0*/
        /**Recorre la lista en postorden y suma sus elementos*/
        for (int i = 0; i < listapostorden.getNumeroElementos(); i++) {
            ElementoLDE elempost = listapostorden.getElemento(i);
            /**Lo convierte a entero para poder sumarlo*/
            sumapost += Integer.parseInt(elempost.getData().toString()); //Lo convierte a entero para poder sumarlo
        }
        /** Muestra la suma total de los elementos del árbol ordenado en postorden*/
        System.out.println("Suma arbol 1 ordenado en postrden:" + sumapost);


        /**Obtiene la lista en orden centrado*/
        ListadoblementeEnlazada<Integer> listaordencentral = arbol1.getListaOrdenCentral();
        int sumacent = 0; /**Se inicializa en 0*/
        /**Recorre la lista en orden centrado y suma sus elementos*/
        for (int i = 0; i < listaordencentral.getNumeroElementos(); i++) {
            ElementoLDE elemcent = listaordencentral.getElemento(i);
            /**Lo convierte a entero para poder sumarlo*/
            sumacent += Integer.parseInt(elemcent.getData().toString()); //Lo convierte a entero para poder sumarlo
        }
        /** Muestra la suma total de los elementos del árbol ordenado en orden centrado*/
        System.out.println("Suma arbol 1 ordenado en orden central:" + sumacent);

        /** Obtiene los subárboles izquierdo y derecho*/
        ArbolBinarioDeBusquedaEnteros subArbolIzquierda = (ArbolBinarioDeBusquedaEnteros) arbol1.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros subArbolDerecha = (ArbolBinarioDeBusquedaEnteros) arbol1.getSubArbolDerecha();
        /**Se imprimen las sumas de los subárboles izquierdo y derecho*/
        System.out.println("Suma subarbol izquierdo 1:" + subArbolIzquierda.getSuma());
        System.out.println("Suma subarbol derecha 1:" + subArbolDerecha.getSuma());

        /**Verifica si las sumas obtenidas por diferentes recorridos son iguales*/
        if (arbol1.getSuma() == sumapre && arbol1.getSuma() == sumapost && arbol1.getSuma() == sumacent) {
            System.out.println("Las sumas son iguales independientemente del recorrido");
        } else {
            System.out.println("Las sumas dependen del recorrido");
        }
        /**Verifica si la suma total del árbol es igual a la suma de los subárboles*/
        if (arbol1.getSuma() == subArbolIzquierda.getSuma() + subArbolDerecha.getSuma()) {
            System.out.println("Las sumas son iguales independientemente de los elementos del subarbol dcho o izq");
        } else {
            System.out.println("Las sumas dependen del subarbol dcho o izq");
        }
        /**Muestra la altura del árbol*/
        System.out.println("Altura del árbol 1:" + arbol1.getAltura());
        /**Obtiene el camino desde la raíz hasta el elemento 110*/
        ListadoblementeEnlazada<Integer> camino = arbol1.getCamino(110);
        System.out.println("Obtener camino hasta el elemento 110 en arbol 1:");
        for (int i = 0; i < camino.getNumeroElementos(); i++) {
            System.out.println(camino.getElemento(i));
        }


        /**Segundo ejemplo*/
        System.out.println("ARBOL EJEMPLO 2");
        /**Crea un nuevo árbol binario y una lista doblemente enlazada*/
        ArbolBinarioDeBusquedaEnteros arbol2 = new ArbolBinarioDeBusquedaEnteros();
        Random random = new Random();
        ListadoblementeEnlazada lista = new ListadoblementeEnlazada();
        /**Genera 129 números aleatorios únicos entre 0 y 128 y los añade a la lista*/
        while (lista.getNumeroElementos() < 129) {
            int numerosAleatorios = random.nextInt(0, 129);
            boolean estaenlaLista = false;
            /**Comprueba si el número ya está en la lista*/
            for (int i = 0; i < lista.getNumeroElementos(); i++) {
                if (numerosAleatorios == Integer.parseInt(String.valueOf(lista.getElemento(i).getData()))) {
                    estaenlaLista = true;
                    break;
                }
            }
            /**En caso de no estar en la lista, lo añade*/
            if (!estaenlaLista) {
                lista.add(numerosAleatorios); // Añade el número a la lista si no está presente
            }
        }
        /**Inserta todos los elementos de la lista en el árbol*/
        for (int i = 0; i < lista.getNumeroElementos(); i++) {
            arbol2.add(lista.getElemento(i).getData());
        }
        /**Muestra la suma total del árbol 2*/
        System.out.println("Suma árbol 2:" + arbol2.getSuma());
        /**Suma de elementos en preorden del árbol 2*/
        ListadoblementeEnlazada<Integer> listapreorden2 = arbol2.getListaPreOrden();
        int sumapre2 = 0;
        for (int i = 0; i < listapreorden2.getNumeroElementos(); i++) {
            ElementoLDE elempre2 = listapreorden2.getElemento(i);
            sumapre2 += Integer.parseInt(elempre2.getData().toString()); //Lo convierte a entero para poder sumarlo
        }
        System.out.println("Suma arbol 2 ordenado en preorden:" + sumapre2);


        /**Suma de elementos en postorden del árbol 2*/
        ListadoblementeEnlazada<Integer> listapostorden2 = arbol2.getListaPostOrden();
        int sumapost2 = 0;
        for (int i = 0; i < listapostorden2.getNumeroElementos(); i++) {
            ElementoLDE elempost2 = listapostorden2.getElemento(i);
            sumapost2 += Integer.parseInt(elempost2.getData().toString()); //Lo convierte a entero para poder sumarlo
        }
        System.out.println("Suma arbol 2 ordenado en postrden:" + sumapost2);

        /**Duma de elementos en orden central del árbol 2*/
        ListadoblementeEnlazada<Integer> listaordencentral2 = arbol2.getListaOrdenCentral();
        int sumacent2 = 0;
        for (int i = 0; i < listaordencentral2.getNumeroElementos(); i++) {
            ElementoLDE elemcent2 = listaordencentral2.getElemento(i);
            sumacent2 += Integer.parseInt(elemcent2.getData().toString()); //Lo convierte a entero para poder sumarlo
        }
        System.out.println("Suma arbol 2 ordenado en orden central:" + sumacent2);

        /** Obtiene subárboles izquierdo y derecho del árbol 2*/
        ArbolBinarioDeBusquedaEnteros subArbolIzquierda2 = (ArbolBinarioDeBusquedaEnteros) arbol2.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros subArbolDerecha2 = (ArbolBinarioDeBusquedaEnteros) arbol2.getSubArbolDerecha();
        /**Muestra la suma de los subárboles izquierdo y derecho*/
        System.out.println("Suma subarbol izquierdo 2:" + subArbolIzquierda2.getSuma());
        System.out.println("Suma subarbol derecha 2:" + subArbolDerecha2.getSuma());

        /**Comprueba si las sumas por recorrido coinciden con la suma total*/
        if (arbol2.getSuma() == sumapre2 && arbol2.getSuma() == sumapost2 && arbol2.getSuma() == sumacent2) {
            System.out.println("Las sumas son iguales independientemente del recorrido");
        } else {
            System.out.println("Las sumas dependen del recorrido");
        }
        Object datoraiz = arbol2.getRaiz().getData();

        /**Comprueba si la suma de subárboles + raíz es igual a la suma total*/
        if (arbol2.getSuma() == subArbolIzquierda2.getSuma() + subArbolDerecha2.getSuma() + Integer.parseInt(datoraiz.toString())) {
            System.out.println("Las sumas son iguales independientemente de los elementos del subarbol dcho o izq");
        } else {
            System.out.println("Las sumas dependen del subarbol dcho o izq");
        }
        /**Muestra la altura del árbol 2*/
        System.out.println("Altura del árbol 2:" + arbol2.getAltura());
        /**Obtiene el camino desde la raíz hasta el nodo 110 en el árbol 2*/
        ListadoblementeEnlazada<Integer> camino2 = arbol2.getCamino(110);
        System.out.println("Obtener camino hasta el elemento 110 en arbol 2:");
        for (int i = 0; i < camino2.getNumeroElementos(); i++) {
            System.out.println(camino2.getElemento(i));
        }
    }
}
