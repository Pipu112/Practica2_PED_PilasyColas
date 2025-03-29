package Lineales;

import EntradaSalida.MyInput;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPila extends Menu{
    public MenuPila(ClasePilaColaNum a) {super(a);}
    @Override
    public void mostrarOpcion() {
        System.out.println("1. Practicar con Pilas");
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Submenú de Pilas: ");
        System.out.println("1.- Restaurar la Pila p");
        System.out.println("2.- Eliminar elementos cuyo valor sea igual al número de elementos de la pila - Versión Iterativa");
        System.out.println("3.- Eliminar elementos cuyo valor sea igual al número de elementos de la pila - Versión Recursiva");
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
                a.regenerarPila();
                return "s";
            case "2":
                limpiarPantalla();
                eliminarElementosPila_Iterativo();
                pausa();
            case "3":
                limpiarPantalla();
                lanzadora();
                pausa();
            case "4":
                limpiarPantalla();
                eliminarDuplicadosPila();
                pausa();
            case "5":
                limpiarPantalla();
                Pila<Integer> p = pedirNumeros();
                detectarSecuenciasPila(p);
                pausa();

        }
        return "";
    }

    public void eliminarElementosPila_Iterativo() {
        Pila<Integer> aux = new Pila<>();
        int contador = 0;
        System.out.println("Pila Original:");
        System.out.println(a.pila.toString());
        while (!a.pila.estaVacia()) {
            aux.apilar(a.pila.desapilar());
            contador++;

        }
        while (!aux.estaVacia()) {
            int elemento = aux.desapilar();
            if (elemento != contador) {
                a.pila.apilar(elemento);
            }
        }

        System.out.println("Pila después de eliminar los elementos (iterativo):");
        System.out.println(a.pila.toString());
    }

    public void lanzadora(){
        System.out.println("Pila Original:");
        System.out.println(a.pila.toString());
        eliminarElementosPila_Recursiva(a.pila,0);
        System.out.println("Pila después de eliminar los elementos (recursivo):");
        System.out.println(a.pila.toString());
    }
    public int eliminarElementosPila_Recursiva(Pila<Integer> p1,int max) {
        if (p1.estaVacia()){
            return max;
        }
        Integer valor=p1.desapilar();
        max=eliminarElementosPila_Recursiva(p1,max+1);

        if(valor != max){
            p1.apilar(valor);
        }
        return max;
    }

    public void eliminarDuplicadosPila(){
        Pila<Integer> aux = new Pila<>();
        ArrayList<Integer> elementosvistos=new ArrayList<>();
        int valor=0;
        System.out.println("Pila Original:");
        System.out.println(a.pila.toString());

        while (!a.pila.estaVacia()){
            valor = a.pila.desapilar();
            if(!elementosvistos.contains(valor)){
                aux.apilar(valor);
                elementosvistos.add(valor);
            }
        }
        while (!aux.estaVacia()){
            a.pila.apilar(aux.desapilar());
        }
        System.out.println("Pila después de eliminar los elementos (recursivo):");
        System.out.println(a.pila.toString());
    }

    public Pila<Integer> pedirNumeros(){
        Pila<Integer> numeros = new Pila<>();
        int valor = 0;
        System.out.println("Introduzca numeros (-1 para terminar):");
        while (valor != -1){
            valor = MyInput.readInt();
            if (valor != -1) { // Solo apilar si el valor no es -1
                numeros.apilar(valor);
            }
        }
        return numeros;
    }
    public void detectarSecuenciasPila(Pila<Integer> numeros) {
        Pila<Integer> auxInvertida = new Pila<>();
        Pila<Integer> secuencia = new Pila<>();

        // Invertimos la pila original para procesar los números en orden de ingreso
        while (!numeros.estaVacia()) {
            auxInvertida.apilar(numeros.desapilar());
        }

        // Inicializamos con el primer número
        int anterior = auxInvertida.desapilar();
        secuencia.apilar(anterior);

        // Procesamos el resto de números
        while (!auxInvertida.estaVacia()) {
            int actual = auxInvertida.desapilar();

            if (actual == anterior + 1) {
                // Continúa la secuencia
                secuencia.apilar(actual);
            } else {
                // La secuencia se rompe, mostramos la secuencia actual
                Pila<Integer> secuenciaInvertida = new Pila<>();
                while (!secuencia.estaVacia()) {
                    secuenciaInvertida.apilar(secuencia.desapilar());
                }
                System.out.println(secuenciaInvertida.toString());
                secuencia = new Pila<>();
                secuencia.apilar(actual);
            }

            anterior = actual;
        }

        if (!secuencia.estaVacia()) {
            Pila<Integer> secuenciaInvertida = new Pila<>();
            while (!secuencia.estaVacia()) {
                secuenciaInvertida.apilar(secuencia.desapilar());
            }
            System.out.println(secuenciaInvertida.toString());
        }
    }

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
