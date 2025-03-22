package Modelos;

public interface Pila<E> {
    void apilar(E x);
    E desapilar();
    E tope();
    boolean estaVacia();
}
