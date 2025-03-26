package Lineales;

import Modelos.I_Pila;

public class Pila<E> implements I_Pila<E> {
    protected LEG<E> lista;
    protected static final int CAPACIDAD_POR_DEFECTO =200;
    public Pila() {
        lista = new LEG<E>();
    }
    @Override
    public void apilar(E x) {
        lista.insertar(x);
    }

    @Override
    public E desapilar() {
        NodoLEG<E> aux = lista.primero;
        lista.eliminar((E) aux);
        return aux.dato;
    }

    @Override
    public boolean estaVacia() {
        if(lista == null){return true;}
        else{return false;}
    }

}
