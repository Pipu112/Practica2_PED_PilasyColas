package Modelos;

public interface LE<E> {
    public void insertar(E x);
    public void eliminar(E x);
    public void insertarEnFin(E x);
    public E recuperar(int i);
    public int indiceDe(E e);
    public E[] toArray(E[] a);
    public String toString();

}
