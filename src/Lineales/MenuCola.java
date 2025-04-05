package Lineales;

import EntradaSalida.MyInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.ulp;

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
                eliminarElementosCola_Recursivo(0);
                System.out.println(PilaCola.cola1.toString());
                return "s";
            case "3":
                rotacionCircular();
                System.out.println("La cola ha quedado: ");
                System.out.println(PilaCola.cola1.toString());
                return "s";
            case "4":
                InterseccionColas();
                return "s";
            default:
                System.out.println("Opcion invalida");
        }
        return "";
    }
    public int eliminarElementosCola_Recursivo(int nelem){
        if(!PilaCola.cola1.esVacia()){
            int dato = PilaCola.cola1.desencolar();
            nelem = eliminarElementosCola_Recursivo(nelem+1);
            if(dato != nelem){
                PilaCola.cola1.encolar(dato);
            }
        }
        return nelem;
    }
    public void rotacionCircular(){
        System.out.println("La cola 1: ");
        System.out.println(PilaCola.cola1.lista.toString());

        System.out.println("¿Cuántas rotaciones desea realizar?");
        int rot = MyInput.readInt();

        for(int j=0; j<rot;j++){
            Integer elemento = PilaCola.cola1.desencolar();
            PilaCola.cola1.encolar(elemento);
        }
    }
    public void InterseccionColas(){
        Set<Integer> conjuntoCola1 = new HashSet<>();
        Set<Integer> conjuntoCola2 = new HashSet<>();
        while(!PilaCola.cola1.esVacia()){
            conjuntoCola1.add(PilaCola.cola1.desencolar());
        }
        while(!PilaCola.cola2.esVacia()){
            conjuntoCola2.add(PilaCola.cola2.desencolar());
        }
        conjuntoCola1.retainAll(conjuntoCola2);
        System.out.println("Cola resultante de la intersección: ");
        System.out.println(conjuntoCola1);
    }
}
