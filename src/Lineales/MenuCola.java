package Lineales;


import EntradaSalida.MyInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuCola<E> extends Menu {
    protected Cola<Integer> c1;

    public MenuCola(ClasePilaColaNum a) {
        super(a);
        this.c1 = a.cola1; // Usamos la cola de la clase principal
    }

    @Override
    public void mostrarOpcion() {
        System.out.println("2. Practicar con Colas");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Submenú de Colas:");
        System.out.println("1.- Restaurar las Colas");
        System.out.println("2.- Eliminar elementos cuyo valor sea igual al número de elementos en la cola (Versión Recursiva)");
        System.out.println("3.- Rotación Circular");
        System.out.println("4.- Intersección de Colas");
        System.out.println("0.- Volver al menú principal");
        System.out.println("Elija opción: ");
    }

    @Override
    public String seleccion(String s) {
        switch (s) {
            case "0":
                return "n";
            case "1":
                limpiarPantalla();
                regenerarC1();
                System.out.println("Cola C1 y C2 se han regenerado");
                pausa();
                return "s";
            case "2":
                limpiarPantalla();
                eliminarC1();
                pausa();
                return "s";
            case "3":
                limpiarPantalla();
                System.out.println("Indique el numero de rotaciones que queires: ");
                int nrotaciones= MyInput.readInt();
                rotaciones(nrotaciones,c1);
            case "4":
                limpiarPantalla();
                System.out.println("*******Interseccion de colas *******");
                interseccionDeColas();
                pausa();
        }
        return "";
    }

    public void eliminarC1() {
        System.out.println("C1 antes de eliminar elementos en la cola:");
        System.out.println(a.cola1.toString());
        Cola<Integer> nuevaCola = new Cola<>();
        eliminarColaElementos(a.cola1, nuevaCola,0);
        a.cola1 = nuevaCola;
        System.out.println("C1 después de la eliminación:");
        System.out.println(a.cola1.toString());
    }

    public int eliminarColaElementos(Cola<Integer> cola, Cola<Integer> nuevaCola, int totalElementos) {
        if (cola.esVacia()) {
            return totalElementos;
        }
        Integer elemento = cola.desencolar();
        totalElementos++;
        totalElementos = eliminarColaElementos(cola, nuevaCola, totalElementos);
        if (elemento != totalElementos) {
            nuevaCola.encolar(elemento);
        }

        return totalElementos;
    }

    public void rotaciones(int nrotaciones, Cola<Integer> c1) {
        System.out.println("C1 antes de rotar los elementos en la cola:");
        System.out.println(c1.toString());
        for (int i = 0; i < nrotaciones; i++) {
            Integer elemento = c1.desencolar(); // Sacamos el primer elemento
            c1.encolar(elemento); // Lo colocamos al final
        }
        System.out.println("C1 después de rotarla "+ nrotaciones+" veces:");
        System.out.println(c1.toString());

    }

    public void interseccionDeColas(){
        Cola<Integer>  colaResultado = new Cola<>();
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Cola C1:");
        System.out.println(a.cola1.toString());
        System.out.println("Cola C2:");
        System.out.println(a.cola2.toString());
        System.out.println("Cola resultante de la interseccion:");

        while (!a.cola1.esVacia()) {
            numeros.add(a.cola1.desencolar());
        }
        while (!a.cola2.esVacia()) {
            Integer elemento;
            elemento = a.cola2.desencolar();
            if (numeros.contains(elemento)) {
                colaResultado.encolar(elemento);
            }
        }
        System.out.println(colaResultado.toString());
    }


    public void regenerarC1() {a.regenerarColas();}
    public void limpiarPantalla() {
        int i=0;
        while(i<50){
            System.out.println(" ");
            i++;
        }
    }
    public void pausa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona cualquier tecla para continuar...");
        scanner.nextLine();  // Detiene la ejecución hasta que el usuario presiona ENTER
    }
}
