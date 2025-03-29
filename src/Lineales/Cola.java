package Lineales;

public class Cola<E extends Integer> implements Modelos.I_Cola<E> {

    protected LEGConUltimo<E> lista;


    public Cola() {
        lista = new LEGConUltimo<>();
    }

    @Override
    public void encolar(E x) {
        lista.insertarEnFin(x);
    }

    @Override
    public E desencolar() {
        if (lista.primero == null) {
            return null;
        }
        E dato = lista.primero.dato;
        lista.eliminarPrimero();
        return dato;
    }

    @Override
    public E primero() {
        return lista.primero != null ? lista.primero.dato : null;
    }

    @Override
    public boolean esVacia() {
        return lista.primero == null;
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
