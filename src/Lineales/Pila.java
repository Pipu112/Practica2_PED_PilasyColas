package Lineales;

import Modelos.I_Pila;

public class Pila<E> implements I_Pila<E> {
    protected E elArray[];
    protected static final int CAPACIDAD_POR_DEFECTO =200;
    public Pila() {
        elArray = (E[]) new Object[CAPACIDAD_POR_DEFECTO];
    }
    @Override
    public void apilar(E x) {

    }

    @Override
    public E desapilar() {
        E elUltimo = elArray[elArray.length - 1];
        return elUltimo;
    }

    @Override
    public E tope() {
        return elArray[elArray.length - 1];
    }

    @Override
    public boolean estaVacia() {
        return (elArray.length-1 == -1);
    }
    public String toString(){
        String res="";
        for(int i=elArray.length;i>=0;i--){
            res+=elArray[i]+"\n";
        }
        return res;
    }
    private void duplicarArray(){
        E nuevoArray[] = (E[]) new Object[elArray.length*2];
        for(int i=0; i<=elArray.length;i++){
            nuevoArray[i]=elArray[i];
        }
        elArray=nuevoArray;
    }
}
