import Lineales.ClasePilaColaNum;
import Lineales.MenuPila;
import Lineales.MenuPrincipal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //metemos valores de las colas
        ClasePilaColaNum a = new ClasePilaColaNum();
        MenuPrincipal menu = new MenuPrincipal(a);
        menu.agregarMenu(new MenuPila(a));
        menu.agregarMenu(new MenuCola(a));
    }
}