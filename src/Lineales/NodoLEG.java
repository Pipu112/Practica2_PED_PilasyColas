package Lineales;

public class NodoLEG<E> {
    public NodoLEG<E> siguiente;
    public E dato;

    public NodoLEG(NodoLEG<E> siguiente, E dato) {
        this.siguiente = siguiente;
        this.dato = dato;
    }

    public NodoLEG(E dato){
        this(null,dato);
    }
    public void setSiguiente(NodoLEG<E> siguiente) {this.siguiente = siguiente;}
    public E getdato() {return dato;}
    public NodoLEG<E> getSiguiente() {return siguiente;}
}