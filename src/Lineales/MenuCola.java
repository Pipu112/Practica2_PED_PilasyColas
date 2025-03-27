package Lineales;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.annotation.IncompleteAnnotationException;

public class MenuCola<E> extends Menu{
    protected Cola<Integer> c1;

    public MenuCola(ClasePilaColaNum a) {
        super(a);
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
                cargarColas();
                return "s";
            case "2":
                eliminarC1();
                return "s";
        }
        return "";
    }

    public void cargarColas() {
        a.regenerarColas();
    }

    public void eliminarC1() {
        System.out.println("C1 antes de eliminar elementos en la cola");
        a.cola1.toString();
        eliminarColaElementos(0);
        System.out.println("C1 despues de la aliminacion");
        a.cola1.toString();

    }

    public void eliminarColaElementos(int elementos) {
        Integer aux = a.cola1.desencolar();


        System.out.println("Desencolado: " + aux + " (Tipo: " + (aux != null ? aux.getClass().getName() : "null") + ")");
        if (aux == null) {
            return;
        }
        int totalElementos = elementos+1;
        eliminarColaElementos(totalElementos);
        if (!aux.equals(totalElementos)) {
            a.cola1.lista.insertar(aux);
        }
    }
    public void regenerarC1(){
        c1.lista.insertar(5);
        c1.lista.insertar(13);
        c1.lista.insertar(5);
        c1.lista.insertar(21);
        c1.lista.insertar(30);
    }
}

