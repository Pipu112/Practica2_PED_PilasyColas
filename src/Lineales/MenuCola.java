package Lineales;

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
                cargarCola("cola.dat");
                return "s";
        }
        return "";
    }
    public static Cola<?> cargarCola(String nombreArchivo){
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Cola<?>) in.readObject(); // Cargar el objeto
        } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
}
