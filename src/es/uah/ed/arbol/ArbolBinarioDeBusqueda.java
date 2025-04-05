package es.uah.ed.arbol;
import es.uah.listas.ListadoblementeEnlazada;

public class ArbolBinarioDeBusqueda {
    /**ATRIBUTOS*/
    Nodo raiz=null;

    /**METODOS*/
    /**Metodo que inicializa el árbol, empieza vacío*/
    public ArbolBinarioDeBusqueda() {
    }
    /**Metodo privado que comprueba que si el árbol es vacío*/
    private boolean isVacio() {
        return raiz == null;
    }
    /**Metodo recursivo para añadir un nodo en la posicion correcta*/
    private Nodo addrecursivo(Nodo raiz, Object data){
        /**Si la raiz es nula, entonces, se crea un nodo nuevo y devuelve la raiz*/
        if (raiz == null) {
            Nodo n1 = new Nodo(data);
            raiz=n1;
            return raiz;
        }
        else{
            /**Se comparan los valores para comprobar si se inserta el nodo a la derecha o a la izquierda*/
            if (((Comparable)data).compareTo(raiz.getData())<0){
                Nodo añadido= addrecursivo(raiz.getIzquierda(),data);
                raiz.setIzquierda(añadido);/**Se inserta el nodo a la izquierda*/
            }
            else{
                Nodo añadido= addrecursivo(raiz.getDerecha(),data);
                raiz.setDerecha(añadido);/**Se inserta el nodo a la derecha*/
            }
            return raiz; /**Se devuelve la raiz*/
        }
    }
    /**Metodo que añade un nuevo nodo al árbol*/
    public void add(Object data) {
        /**Si el arbol esta vacio se añade el nodo como raiz*/
        if(isVacio()){
            Nodo n1 = new Nodo(data);
            raiz=n1;
        }
        /**En caso contrario, llama al metodo recursivo*/
        else {
            addrecursivo(raiz, data);
        }
    }
    /**Metodo que obtiene el subarbol izquierdo como un nuevo arbol*/
    public ArbolBinarioDeBusquedaEnteros getSubArbolIzquierda() {
        ArbolBinarioDeBusquedaEnteros subArbol = new ArbolBinarioDeBusquedaEnteros();
        /**Si la raiz no es nula y la raiz por parte de la izquierda tampoco, entonces se convierte
         * en un subarbol*/
        if (raiz != null && raiz.getIzquierda() != null) {
            subArbol.raiz = raiz.getIzquierda();
        }
        return subArbol;
    }
    /**Metodo que obtiene el subarbol derecho como un nuevo arbol*/
    public ArbolBinarioDeBusquedaEnteros getSubArbolDerecha() {
        ArbolBinarioDeBusquedaEnteros subArbol = new ArbolBinarioDeBusquedaEnteros();
        /**Si la raiz no es nula y la raiz por parte de la derecha tampoco, entonces se convierte
         * en un subarbol*/
        if (raiz != null && raiz.getDerecha() != null) {
            subArbol.raiz = raiz.getDerecha();
        }
        return subArbol;
    }
    /**Metodo que devuelve el nodo raiz del arbol*/
    public Nodo getRaiz() {
        return raiz;
    }
    /**Metodo que devuelve el grado del arbol*/
    public int getGrado() {
        return getGradoRecursivo(raiz);
    }
    /**Metodo recursivo para calcular el grado del árbol según sus nodos*/
    private int getGradoRecursivo(Nodo nodo) {
        /**En caso de que no haya nodos (nulo) el grado es 0*/
        if (nodo == null) {
            return 0;
        }
        /**Calcula el grado del subarbol izquierdo de manera recursiva*/
        int gradoIzquierda = getGradoRecursivo(nodo.getIzquierda());
        /**Calcula el grado del subarbol derecho de manera recursiva*/
        int gradoDerecha = getGradoRecursivo(nodo.getDerecha());
        /**Devuelve el máximo entre los grados izquierdo y derecho, sumando 1 por el nodo actual*/
        return Math.max(gradoIzquierda, gradoDerecha) + 1;

    }

    /**Devuelve la altura del arbol de manera recursiva*/
    public int getAltura() {
        return getAlturaRecursivo(raiz);
    }

    private int getAlturaRecursivo(Nodo nodo) {
        /**En caso de que no haya nodos (nulo) la altura es 0*/
        if (nodo == null) {
            return 0;
        }
        /**Calcula la altura del subarbol izquierdo de manera recursiva*/
        int alturaIzquierda = getAlturaRecursivo(nodo.getIzquierda());
        /**Calcula la altura del subarbol derecho de manera recursiva*/
        int alturaDerecha = getAlturaRecursivo(nodo.getDerecha());
        /**Devuelve el máximo entre las alturas izquierda y derecha, sumando 1 por el nodo actual*/
        return Math.max(alturaIzquierda, alturaDerecha) + 1;

    }
    /**Devuelve una lista con los datos de un nivel específico*/
    public ListadoblementeEnlazada<Integer> getListaDatosNivel(int nivel) {
        /**Se crea una lista doblemente enlazada vacía*/
        ListadoblementeEnlazada<Integer> datosnivel = new ListadoblementeEnlazada<>();
        /**Llama al metodo recursivo inicializandolo desde el nivel 1*/
        getDatosNivelRecursivo(raiz, nivel, datosnivel, 1);
        /**Devuelve una lista con los datos de ese nivel*/
        return datosnivel;
    }
    /**Metodo recursivo para llenar la lista con los datos de un nivel dado*/
    private void getDatosNivelRecursivo(Nodo nodo, int nivel, ListadoblementeEnlazada<Integer> datosnivel, int nivelActual) {
        /**Si el nodo es vacio entonces no hay nada que devolver*/
        if (nodo == null) {
            return;
        }
        /**Si el nivel actual coincide con el deseado, entonces,  se agrega el dato del nodo a la lista*/
        if (nivelActual == nivel) {
            datosnivel.add((Integer) nodo.getData());
        } else {
            /**Recorre recursivamente el subárbol izquierdo incrementando el nivel*/
            getDatosNivelRecursivo(nodo.getIzquierda(), nivel, datosnivel, nivelActual + 1);
            /**Recorre recursivamente el subárbol derecho incrementando el nivel*/
            getDatosNivelRecursivo(nodo.getDerecha(), nivel, datosnivel, nivelActual + 1);
        }
    }
    /**Metodo que comprueba si el árbol es homogéneo donde todos los subárboles tienen mismo grado tal que llama al metodo
     * recursivo pasando el grado del arbol*/
    public boolean isArbolHomogeneo() {
        return isArbolHomogeneoRecursivo(raiz, getGrado());
    }
    /**Metodo recursivo para comprobar homogeneidad del árbol */
    private boolean isArbolHomogeneoRecursivo(Nodo nodo, int grado) {
        /**Un nodo nulo es homogéneo por definición y por tanto, devuelve verdadero*/
        if (nodo == null) {
            return true;
        }
        /**Si solo tiene un hijo o el grado del subárbol desde este nodo no coincide con el grado total, no es homogéneo y por tanto,
         * devolverá falso*/
        if ((nodo.getIzquierda() != null && nodo.getDerecha() == null) ||
                (nodo.getIzquierda() == null && nodo.getDerecha() != null) ||
                getGradoRecursivo(nodo) != grado) {
            return false;
        }
        /**Comprueba recursivamente homogeneidad en ambos subárboles*/
        return isArbolHomogeneoRecursivo(nodo.getIzquierda(), grado) && isArbolHomogeneoRecursivo(nodo.getDerecha(), grado);
    }
    /** Metodo que comprueba si el árbol está completamente lleno (todos los niveles excepto el último están llenos)*/
    public boolean isArbolCompleto() {
        /**Se calcula la altura del arbol*/
        int altura = getAltura();
        /**Itera todos los niveles menos el ultimo*/
        for (int i = 1; i < altura-1; i++) {
            /**Si el número de elementos en un nivel no es 2^(i-1), no está completo*/
            if (getListaDatosNivel(i).getNumeroElementos() != Math.pow(2, i - 1)) {
                return false;
            }
        }
        return true; /**Si todos los niveles están completos, retorna true*/
    }
    /**Metodo que comprueba si el árbol es casi completo (último nivel puede estar incompleto pero bien alineado) */
    public boolean isArbolCasiCompleto() {
        int altura = getAltura(); /** Obtiene la altura total del árbol*/
        return isArbolCasiCompletoRecursivo(this.raiz, 0, altura); /**Vuelve a llamar
         al metodo recursivo desde el nivel 0*/
    }
    /**Metodo recursivo para verificar si el árbol es casi completo*/
    private boolean isArbolCasiCompletoRecursivo(Nodo nodo, int nivel, int altura) {
        /**Si el nodo es nulo, entonces devuelve verdadero*/
        if (nodo == null)
            return true;
        /**Si supera la altura permitida entonces, devuelve falso*/
        if (nivel >= altura)
            return false;
        /**Verifica recursivamente para ambos subárboles con el siguiente nivel*/
        return (isArbolCasiCompletoRecursivo(nodo.getIzquierda(), 2 * nivel + 1, altura) &&
                isArbolCasiCompletoRecursivo(nodo.getDerecha(), 2 * nivel + 2, altura));
    }
    /**Metodo que devuelve una lista con el camino desde la raíz hasta el elemento buscado*/
    public ListadoblementeEnlazada<Integer> getCamino(Integer elemento) {
        /**Se crea una lista doblemente enlazada para almacenar el camino*/
        ListadoblementeEnlazada<Integer> camino = new ListadoblementeEnlazada<>();
        /**Llama al metodo recursivo para llenarla y después, retorna el camino*/
        obtenerCamino(raiz, elemento, camino);
        return camino;
    }
    /**Metodo privado recursivo para encontrar el camino hacia un elemento*/
    private boolean obtenerCamino(Nodo nodo, Integer elemento, ListadoblementeEnlazada<Integer> camino) {
        /**En caso de que l nodo sea nulo, entonces devuelve falso*/
        if (nodo == null) {
            return false;
        }
        /**En caso contrario, añade el dato del nodo al camino*/
        camino.add((Integer) nodo.getData());
        /**Si el nodo es el que buscamos lo añade al camino*/
        if (nodo.getData().equals(elemento)) {
            return true;
        }
        /**Si el elemento está en alguno de los subárboles devuelve verdadero*/
        if (obtenerCamino(nodo.getIzquierda(), elemento, camino) || obtenerCamino(nodo.getDerecha(), elemento, camino)) {
            return true;
        }
        /**Si no se encuentra en este camino, elimina el último elemento añadido*/
        camino.del(camino.getNumeroElementos());
        return false;
    }
    /**Metodo que devuelve la lista del reorrido en preorden*/
    public ListadoblementeEnlazada<Integer> getListaPreOrden(){
        /**Se crea una lista doblemente enlazada para almaenar el recorrdio y luego llamar al metodo
         * recursivo y devolver la lista llena*/
        ListadoblementeEnlazada<Integer> lpreO = new ListadoblementeEnlazada<>();
        ListaPreOrden(raiz, lpreO);
        return lpreO;
    }
    /**Metodo privado recursivo para recorrido preorden (raíz, izquierda, derecha)*/
    private void ListaPreOrden(Nodo nodo, ListadoblementeEnlazada<Integer> lista) {
        /**Si el nodo es nulo, entonces no hay nada que devolver*/
        if (nodo == null) {
            return;
        }
        /**Agrega el nodo actual primero*/
        lista.add((Integer) nodo.getData());  //Añade el dato del nodo a la lista
        /**Recorre subárbol izquierdo*/
        ListaPreOrden(nodo.getIzquierda(), lista);
        /**Recorre subárbol derecho*/
        ListaPreOrden(nodo.getDerecha(), lista);
    }
    /**Metodo que devuelve la lista de recorrido en postorden*/
    public ListadoblementeEnlazada<Integer> getListaPostOrden(){
        /**Se crea una lista doblemente enlazada para almaenar el recorrdio y luego llamar al metodo
         * recursivo y devolver la lista llena*/
        ListadoblementeEnlazada<Integer> lpostO = new ListadoblementeEnlazada<>();
        ListaPostOrden(raiz, lpostO);
        return lpostO;
    }
    /**Metodo privado recursivo para recorrido postorden (izquierda, derecha, raíz) */
    private void ListaPostOrden(Nodo nodo, ListadoblementeEnlazada<Integer> lista) {
        /**Si el nodo es nulo, entonces no hay nada que devolver*/
        if (nodo == null) {
            return;
        }
        /**Recorre subárbol izquierdo*/
        ListaPostOrden(nodo.getIzquierda(), lista);
        /**Recorre subárbol derecho*/
        ListaPostOrden(nodo.getDerecha(), lista);
        /**Añade el dato del nodo a la lista*/
        lista.add((Integer) nodo.getData());
    }
    /**Metodo que devuelve la lista de recorrido en orden central (izquierda, raíz, derecha) */
    public ListadoblementeEnlazada<Integer> getListaOrdenCentral(){
        /**Se crea una lista doblemente enlazada para el recorrido, llama al metodo recursivo
         * y despues retorna la lista con el recorrido */
        ListadoblementeEnlazada<Integer> lOcent = new ListadoblementeEnlazada<>();
        ListaOrdenCentral(raiz, lOcent);
        return lOcent;
    }
    /**Metodo privado recursivo para recorrdio de orden central*/
    private void ListaOrdenCentral(Nodo nodo, ListadoblementeEnlazada<Integer> lista) {
        /**Si el nodo es nulo, entonces no hay nada que devolver*/
        if (nodo == null) {
            return;
        }

        ListaOrdenCentral(nodo.getIzquierda(), lista);/**Recorre subárbol inzquierdo*/
        lista.add((Integer) nodo.getData());  /**Añade el dato del nodo a la lista*/
        ListaOrdenCentral(nodo.getDerecha(), lista); /**Recorre subárbol derecho*/
    }
}

