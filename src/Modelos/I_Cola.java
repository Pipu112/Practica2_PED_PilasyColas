package Modelos;

public interface I_Cola<E> {
    void encolar(E x);
    E desencolar();
    E primero();
    boolean esVacia();
}
