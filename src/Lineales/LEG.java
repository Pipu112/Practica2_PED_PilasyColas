package Lineales;

import Modelos.LE;

public class LEG<E> implements LE<E>{
    protected NodoLEG<E> primero;

    public LEG() {
        this.primero = null;
    }

    /**
     * se encarga de insertar un nuevo elemento al inicio de la lista
     * @param x
     */
    public void insertar(E x){
        NodoLEG<E> nuevo = new NodoLEG<E>(primero, x);
        primero = nuevo;
    }

    /**
     * elimina el elemento que entra como parámetro que está en la lista
     * @param x
     */
    public void eliminar(E x){
        NodoLEG<E> aux = primero;
        NodoLEG<E> anterior = null;
        while(aux != null && !aux.dato.equals(x)){
            anterior = aux;
            aux = aux.siguiente;
        }
        if(aux != null){
            if (anterior == null){
                primero = aux.siguiente;
            }else{
                anterior.siguiente = aux.siguiente;
            }
        }
    }

    /**
     * imprime todos los datos de la lista
     */
    public void imprimir() {
        NodoLEG<E> actual = primero;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.getSiguiente();
        }
    }

    /**
     * inserta un dato al final de la lista. Ese dato se pasa como parámetro
     * @param x
     */
    public void insertarEnFin(E x){
        NodoLEG<E> nl = new NodoLEG<E>(x);
        NodoLEG<E> aux = primero;
        if(aux == null){primero = nl;}
        else{
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nl;
        }
    }

    /**
     * Dado un índice, te devuelve el valor de la posición que has indicado a la entrada
     * @param i
     * @return
     */
    public E recuperar(int i){
        NodoLEG<E> aux = primero;
        int indice=0;
        while(aux != null){
            if(indice == i){
                return aux.dato;
            }
            aux = aux.siguiente;
            indice++;
        }
        return null;
    }

    /**
     *dado un dato inicial de entrada, te retorna el índice con la posición en la que se encuentra
     * @param e
     * @return
     */
    public int indiceDe(E e){
        NodoLEG<E> aux = primero;
        int indice = 0;
        while(aux != null){
            if(aux.dato.equals(e)){
                return indice;
            }
        }
        return -1;
    }

    /**
     * dado un dato aún sin definir, te devuelve un array del dato
     * @param a
     * @return
     */
    public E[] toArray(E[] a){
        NodoLEG<E> actual = primero;
        int indice = 0;
        while(actual != null){
            a[indice++] = actual.dato;
            actual = actual.getSiguiente();
        }
        return a;
    }

    /**
     * pasa todos los datos de tipo E a string
     * @return
     */
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(NodoLEG<E> aux= primero; aux != null; aux=aux.getSiguiente()){
            res.append(aux.dato.toString()).append("\n");
        }
        return res.toString();
    }


}
