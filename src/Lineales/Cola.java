package Lineales;

public class Cola<E> implements Modelos.I_Cola<E> {

    protected E elArray[];
    protected int fin, primero;
    protected static final int CAPACIDAD_POR_DEFECTO = 200;
   public Cola() {
       elArray=(E[])new Object[CAPACIDAD_POR_DEFECTO];
       primero=0;
       fin=0;
   }
    @Override
    public void encolar(E x) {
       //no entiendo esto, yo creo q no hay que poner talla
       //if(tallaActual == elArray.length){duplicarArray();} esto viene en los apuntes..
        fin=incrementa(fin);
        elArray[fin]=x;
    }

    @Override
    public E desencolar() {
       E elPrimero = elArray[primero];
       primero = incrementa(primero);
       return elPrimero;
    }

    @Override
    public E primero() {
        return elArray[primero];
    }

    @Override
    public boolean esVacia() {
        return (elArray.length-1==-1);
    }
    private int incrementa(int indice){
       if(++indice == elArray.length){indice=0;}
       return indice;
    }
    public String toString(){
       String res="";
       int aux=primero;
       for(int i=0; i<elArray.length; i++,aux=incrementa(aux)){
           res +=elArray[aux]+" ";
       }
       return res;
    }
    private void duplicarArray(){
       E nuevo[] = (E[]) new Object[elArray.length*2];
       for(int i=0; i<elArray.length; i++,primero=incrementa(primero)){
           nuevo[i]=elArray[primero];
       }
       elArray=nuevo;
       primero=0;
       fin= elArray.length-1;
    }
}
