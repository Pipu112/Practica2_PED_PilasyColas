import Lineales.ClasePilaColaNum;
import Lineales.MenuCola;
import Lineales.MenuPila;
import Lineales.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        ClasePilaColaNum a = new ClasePilaColaNum();
        MenuPrincipal menus = new MenuPrincipal(a);
        menus.agregarMenu(new MenuPila(a));
        menus.agregarMenu(new MenuCola<>(a));
        menus.ejecutar();
    }
}