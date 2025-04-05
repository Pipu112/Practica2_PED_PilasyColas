package Lineales;

public class ClasePilaColaNum {
    public Pila<Integer> pila;
    protected Cola<Integer> cola1;
    protected Cola<Integer> cola2;
    public ClasePilaColaNum() {
        pila = new Pila<Integer>();
        cola1 = new Cola<Integer>();
        cola2 = new Cola<Integer>();
        restaurarPila();
        restaurarCola1();
        restaurarCola2();
    }
    public void mostrarPila() {
        System.out.println(pila.lista.toString());
    }
    public void mostrarCola1() {
        System.out.println(cola1.lista.toString());
    }
    public void mostrarCola2() {
        System.out.println(cola2.lista.toString());
    }
    public void restaurarPila(){
        while(!pila.estaVacia()){
            pila.desapilar();
        }
        //inicializamos pila
        pila.lista.insertar(1);
        pila.lista.insertar(2);
        pila.lista.insertar(5);
        pila.lista.insertar(3);
        pila.lista.insertar(5);
    }
    public void restaurarCola1() {
        while(!cola1.esVacia()){
            cola1.desencolar();
        }
        //inicializamos cola 1
        cola1.encolar(5);
        cola1.encolar(13);
        cola1.encolar(5);
        cola1.encolar(21);
        cola1.encolar(30);
    }
    public void restaurarCola2() {
        while(!cola2.esVacia()){
            cola2.desencolar();
        }
        //inicializamos cola 2
        cola2.encolar(6);
        cola2.encolar(27);
        cola2.encolar(5);
        cola2.encolar(1);
        cola2.encolar(21);
        cola2.encolar(13);
    }
}
