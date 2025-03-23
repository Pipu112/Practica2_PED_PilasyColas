package Lineales;

public class LEGConUltimo<E> extends LEG<E>{
    protected NodoLEG<E> ultimo;
    public LEGConUltimo() {
        primero = null;
        ultimo = null;
    }
    public void insertar(E x) {
        primero = new NodoLEG(new NodoLEG(x),primero);
        if(ultimo == null){ultimo=primero;}
    }

    public boolean eliminarlo(E x) {
        NodoLEG<E> aux= primero;
        NodoLEG<E> ant= ultimo;
        while(aux!= null && !aux.dato.equals(x)){
            ant = aux;
            aux = aux.siguiente;
        }
        if(aux==null){return false;}
        if(ant==null){primero=aux.siguiente;}
        else{ant.siguiente=aux.siguiente;}
        if(aux.siguiente==null){ultimo=ant;}
        return true;
    }
    public void insertarEnFin(E x){
        NodoLEG<E> nuevo = new NodoLEG(x);
        if(ultimo != null){ultimo.siguiente=nuevo;}
        else{primero=nuevo;}
        ultimo=nuevo;
    }
}
