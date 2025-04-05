package es.uah.ed.arbol;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda {
    /**METODOS*/
    /**Metodo que llama al constructo de la clase padre ya que esta clase hereda la clase 'ArbolBinarioDeBusqueda'*/
    public ArbolBinarioDeBusquedaEnteros(){
        super();
    }
    /**Metodo que devuelve la suma total de los valores enteros del arbol llamando recursivamente
     * y pasando por la raiz del arbol*/
    public int getSuma(){
        return suma(this.getRaiz());
    }
    /**Metodo privado que calcula la suma de todos los nodos del árbol*/
    private int suma(Nodo nodo){  //Metodo recursivo
        /**En caso de que el nodo sea nulo, entonces se devuelve 0 porque no se suma nada*/
        if (nodo==null){
            return 0;
        }
        /**Calcula recursivamente la suma del subárbol izquierdo*/
        int izq = suma(nodo.getIzquierda());
        /**Calcula recursivamente la suma del subárbol derecho*/
        int dcha = suma(nodo.getDerecha());
        /**Suma del valor del nodo actual más las sumas de sus subárboles izquierdo y derecho*/
        int sumatotal = (int) nodo.getData() + izq + dcha;
        /**Devuelve la suma total desde este nodo*/
        return sumatotal;
    }
}

