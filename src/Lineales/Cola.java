package Lineales;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Cola<E> implements Modelos.I_Cola<E> {

    protected LEGConUltimo<E> lista;
    protected int fin, primero;
    protected static final int CAPACIDAD_POR_DEFECTO = 200;
   public Cola() {
       lista = new LEGConUltimo<>();
       primero=0;
       fin=0;
   }
    @Override
    public void encolar(E x) {
        lista.insertar(x);
    }

    @Override
    public E desencolar() {
       if(lista.primero == null){
           return null;
       }
        E dato = lista.primero.dato; // Obtener el primer elemento
        lista.eliminarPrimero();     // Eliminar el primer nodo de la lista
        return dato;
    }

    @Override
    public E primero() {
        return lista.primero.dato;
    }


    @Override
    public boolean esVacia() {
       NodoLEG<E> aux = lista.primero;
       if(aux == null) {
           return true;
       }
       else{return false;}
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoLEG<E> current = lista.primero;
        while (current != null) {
            sb.append(current.dato);
            if (current.siguiente != null) {
                sb.append(", ");
            }
            current = current.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
