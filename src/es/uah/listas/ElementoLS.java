package es.uah.listas;

public class ElementoLS {
    /**Atributo que almacena cualquier tipo de objeto como dato del nodo*/
    private Object data;

    /**Metodo que devuelve el contenido del nodo*/
    public Object getData(){
        return this.data;
    }

    /**Metodo que establece el contenido del nodo*/
    public void setData(Object data){
        this.data=data;
    }

    /**Representacion en texto del nodo*/
    public String toString(){
        return String.valueOf(data);
    }
}
