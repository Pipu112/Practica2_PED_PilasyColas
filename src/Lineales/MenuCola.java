package Lineales;

import EntradaSalida.MyInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MenuCola extends Menu{
    public MenuCola(ClasePilaColaNum PilaCola) {
        super(PilaCola);
    }
    @Override
    public void mostrarOpcion() {
        System.out.println("2. Practicar con Colas");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Submenú de Colas:");
        System.out.println("1.- Restaurar las Colas");
        System.out.println("2.- Eliminar elementos cuyo valor sea igual al número de elementos en la cola(Versión Recursiva)");
        System.out.println("3.- Rotación Circular");
        System.out.println("4.- Intersección de Colas");
        System.out.println("0.- Volver al menú principal");
        System.out.println("Elija opción: ");
    }

    @Override
    public String seleccion(String s) {
        switch(s){
            case "0":
                return "n";
            case "1":
                System.out.println("Restauramos las colas");
                PilaCola.restaurarCola1();
                PilaCola.restaurarCola2();
                System.out.println(PilaCola.cola1.toString());
                System.out.println(PilaCola.cola2.toString());
                return "s";
            case "2":
                System.out.println("La cola 1 sin elementos repetidos es: ");
                System.out.println(eliminarElementosCola_Recursivo());
                System.out.println(PilaCola.cola1.toString());

                return "s";
            case "3":
                rotacionCircular();
                return "s";
            default:
                System.out.println("Opcion invalida");
        }
        return "";
    }
    public int eliminarElementosCola_Recursivo(){
        int nelem = 0;
        if(!PilaCola.cola1.esVacia()){
            int dato = PilaCola.cola1.desencolar();
            nelem = eliminarElementosCola_Recursivo() + 1;
            if(dato != nelem){
                PilaCola.cola1.encolar(dato);
            }
        }
        return nelem;
    }
    public void rotacionCircular(){
        Cola<Integer> colaAux = new Cola<Integer>();
        int i=0;
        boolean fin = false;
        System.out.println("La cola 1: ");
        System.out.println(PilaCola.cola1.toString());
        System.out.println("¿Cuántas rotaciones desea realizar?");
        int rot = MyInput.readInt();
        System.out.println(PilaCola.cola1.primero);
        PilaCola.cola1.encolar(null);
        while(!fin){
            Integer aux = PilaCola.cola1.desencolar();
            colaAux.encolar(aux);
            i++;
            if(aux == null){fin = true;}
        }
        for(int j=0; j<=i-rot;j++){
            PilaCola.cola1.encolar(PilaCola.cola1.desencolar());
        }
    }

}
