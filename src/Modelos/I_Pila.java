package Modelos;

public interface I_Pila<E> {
    void apilar(E x);
    E desapilar();
    boolean estaVacia();
}
