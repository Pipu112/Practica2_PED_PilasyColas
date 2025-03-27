package Lineales;

public class ClasePilaColaNum {
    protected Pila<Integer> pila;
    protected Cola<Integer> cola1;
    protected Cola<Integer> cola2;
    public ClasePilaColaNum() {
        pila = new Pila<Integer>();
        cola1 = new Cola<Integer>();
        cola2 = new Cola<Integer>();
        //inicializamos pila
        pila.lista.insertar(1);
        pila.lista.insertar(2);
        pila.lista.insertar(5);
        pila.lista.insertar(3);
        pila.lista.insertar(5);
        //inicializamos cola 1
        cola1.insertar(5);
        cola1.insertar(13);
        cola1.insertar(5);
        cola1.insertar(21);
        cola1.insertar(30);
        //inicializamos cola 2
        cola2.lista.insertar(6);
        cola2.lista.insertar(27);
        cola2.lista.insertar(5);
        cola2.lista.insertar(1);
        cola2.lista.insertar(21);
        cola2.lista.insertar(13);
    }
    public void mostrarPila()  {System.out.println(pila.lista.toString());}
    public void mostrarCola1() {System.out.println(cola1.lista.toString());}
    public void mostrarCola2() {System.out.println(cola2.lista.toString());}

    public void regenerarPila(){
        while (pila.estaVacia()) {
            pila.desapilar();
        }
        pila.lista.insertar(1);
        pila.lista.insertar(2);
        pila.lista.insertar(5);
        pila.lista.insertar(3);
        pila.lista.insertar(5);
    }
    public void regenerarColas() {
        while (!cola1.esVacia() || !cola2.esVacia()) {
            if (!cola1.esVacia()) cola1.desencolar();
            if (!cola2.esVacia()) cola2.desencolar();
        }
        cola1.lista.insertar(5);
        cola1.lista.insertar(13);
        cola1.lista.insertar(5);
        cola1.lista.insertar(21);
        cola1.lista.insertar(30);

        cola2.lista.insertar(6);
        cola2.lista.insertar(27);
        cola2.lista.insertar(5);
        cola2.lista.insertar(1);
        cola2.lista.insertar(21);
        cola2.lista.insertar(13);
    }

}
