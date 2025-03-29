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
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        E dato = lista.primero.dato; // Guardamos el dato del nodo a eliminar
        lista.eliminar(dato); // Eliminamos usando el dato, no el nodo
        return dato;
    }

    @Override
    public boolean estaVacia() {
        return lista.primero == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Pila<E> aux = new Pila<>();

        // Copiamos la pila original a aux para invertir el orden
        NodoLEG<E> current = lista.primero;
        while (current != null) {
            aux.apilar(current.dato);
            current = current.siguiente;
        }

        // Extraemos de aux para mantener el orden LIFO en la impresión
        while (!aux.estaVacia()) {
            sb.append(aux.desapilar());
            if (!aux.estaVacia()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
