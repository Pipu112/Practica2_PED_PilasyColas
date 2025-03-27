package Lineales;

import Lineales.ClasePilaColaNum;
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
                a.regenerarPila();
                return "s";
        }
        return "";
    }
}
