package Lineales;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Cola<E extends Integer> implements Modelos.I_Cola<E> {

    protected LEGConUltimo<E> lista;
    protected int fin;
    protected NodoLEG<E> primero;
    protected static final int CAPACIDAD_POR_DEFECTO = 200;

    public Cola() {
       lista = new LEGConUltimo<>();
       primero=null;
       fin=0;
   }
    public void insertar(E x){
        NodoLEG<E> nuevo = new NodoLEG<>(null, x);

        if (primero == null) {
            primero = nuevo;
            return;
        }

        NodoLEG<E> actual = primero;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    @Override
    public void encolar(E x) {
        lista.insertar(x);
    }
    @Override
    public E desencolar() {
       if (lista.primero == null){
           return null;
       }
        E dato = lista.primero.dato;
        // Obtener el primer elemento
        System.out.println("Desencolado: " + dato + " (Tipo: " + (dato != null ? dato.getClass().getName() : "null"));
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
    public void guardarCola(String nombreArchivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(this); // Guardamos el objeto actual
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoLEG<E> current = lista.primero;

        while (current != null) {
            sb.append(current.dato);  // Add the node's data to the string
            if (current.siguiente != null) {
                sb.append(", ");
            }
            current = current.siguiente;  // Move to the next node
        }

        sb.append("]");  // Close the string representation
        return sb.toString();  // Return the string representation
    }

}
