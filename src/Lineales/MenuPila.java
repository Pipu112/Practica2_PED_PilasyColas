package Lineales;

import EntradaSalida.MyInput;

import java.util.ArrayList;

public class MenuPila extends Menu{
    public MenuPila(ClasePilaColaNum PilaCola) {
        super(PilaCola);
    }
    @Override
    public void mostrarOpcion() {
        System.out.println("1. Practicar con Pilas");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Submenú de Pilas: ");
        System.out.println("1.- Restaurar la Pila p");
        System.out.println("2.- Eliminar elementos cuyo valor sea igual al número de elementos d ela pila - Versión Iterativa");
        System.out.println("3.- Eliminar elementos cuyo valor sea igual al número de elementos d ela pila - Versión Recursiva");
        System.out.println("4.- Eliminar elementos duplicados");
        System.out.println("5.- Detectar secuencias consecutivas");
        System.out.println("0.-Volver al menú principal");
    }

    @Override
    public String seleccion(String s) {
        switch(s){
            case "0":
                return "n";
            case "1":
                RestaurarPila();
                return "s";
            case "2":
                EliminarElem();
                return "s";
            case "3":
                eliminarElemRecursiva(0);
                System.out.println("Pila sin elementos repetidos: ");
                System.out.println(PilaCola.pila.toString());
                 return "s";
            case "4":
                eliminarDuplicadosPila();
                return "s";
            case "5":
                detectarSecuenciasPila();
                return "s";
            default:
                System.out.println("Opción invalida");
        }
        return "";
    }
    public void RestaurarPila(){
        System.out.println("Restaurando Pila");
        PilaCola.restaurarPila();
        System.out.println(PilaCola.pila.toString());
    }
    public void EliminarElem(){
        int i=0;
        Pila<Integer> pilaAux = new Pila<Integer>();
        System.out.println("Pila original: ");
        System.out.println(PilaCola.pila.toString());
        while(!PilaCola.pila.estaVacia()){
            pilaAux.apilar(PilaCola.pila.desapilar());
            i++;
        }
        while(!pilaAux.estaVacia()){
            if(pilaAux.lista.primero.dato != i){
                PilaCola.pila.apilar(pilaAux.desapilar());
            }
            else{
                pilaAux.desapilar();
            }

        }
        System.out.println("Pila sin elementos repetidos: ");
        System.out.println(PilaCola.pila.toString());
    }
    //mira, no tengo ni idea de cómo arreglarlo
    public int eliminarElemRecursiva(int tam){
        if(!PilaCola.pila.estaVacia()){
            int dato = PilaCola.pila.desapilar();
            tam = eliminarElemRecursiva(tam+1);
            if(dato != tam){
                PilaCola.pila.apilar(dato);
            }
        }
        return tam;
    }
    public void eliminarDuplicadosPila(){
        Pila<Integer> pilaAux = new Pila<Integer>();
        ArrayList<Integer> contador = new ArrayList<>();
        Integer dato1, dato2;
        System.out.println("Pila original: ");
        System.out.println(PilaCola.pila.toString());
        while(!PilaCola.pila.estaVacia()){
            dato1 = PilaCola.pila.desapilar();
            if(!contador.contains(dato1)){
                pilaAux.apilar(dato1);
            }
            contador.add(dato1);
        }
        while(!pilaAux.estaVacia()){
            PilaCola.pila.apilar(pilaAux.desapilar());
        }
        System.out.println("Pila después de eliminar elementos duplicados: ");
        System.out.println(PilaCola.pila.toString());
    }

    public void detectarSecuenciasPila(){
        Pila<Integer> pilap = secuencia();
        System.out.println("La pila que contiene la secuencia de números: ");
        System.out.println(pilap.toString());

        System.out.println("Secuencias encontradas: ");
        detectarSecuencia(pilap);

    }
    public Pila<Integer> secuencia(){
        System.out.println("Introduzca números (-1 para terminar): ");
        int dato = 0;
        Pila<Integer> pilaAux = new Pila<Integer>();
        while(dato != -1){
            dato = MyInput.readInt();
            pilaAux.apilar(dato);
        }
        pilaAux.desapilar();
        return pilaAux;
    }
    public void detectarSecuencia(Pila<Integer> pilaAux){
        Pila<Integer> pilaSecuencia = new Pila<Integer>();
        Integer dato2;
        Integer dato1 = pilaAux.desapilar();
        while(!pilaAux.estaVacia()){
            dato2 = pilaAux.desapilar();

            if(dato1+1 == dato2){
                if(pilaSecuencia.estaVacia()){
                    pilaSecuencia.apilar(dato1);
                }
                pilaSecuencia.apilar(dato2);
                System.out.println(pilaSecuencia.toString());
            }
            else{
                if(!pilaSecuencia.estaVacia()){
                    System.out.println(pilaSecuencia.toString());

                }
                while(!pilaSecuencia.estaVacia()){
                    pilaSecuencia.desapilar();
                }
            }
            dato1 = dato2;
        }
    }
}
