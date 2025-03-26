package Lineales;

import EntradaSalida.MyInput;


public abstract class Menu {
    protected ClasePilaColaNum PilaCola;
    public Menu(ClasePilaColaNum PilaCola) {
        this.PilaCola = PilaCola;
    }

    public void  ejecutar(){
        String respuesta="";
        do{
            respuesta= ejecutarOpciones();
        }while(respuesta.equals("s"));
    }

    public String ejecutarOpciones(){
        mostrarOpciones();
        String respuesta= MyInput.readString();
        respuesta=seleccion(respuesta);
        if(respuesta.equals("")){
            System.out.println("Opción no válida. Vuelva a intentarlo."); return "s";}
        else return respuesta;
    }
    public String solicitarInfoS(String cad){
        System.out.println("Introduzca "+ cad);
        return MyInput.readString();
    }
    public double solicitarInfoD(String cad){
        System.out.println("Introduzca "+ cad);
        return MyInput.readDouble();
    }
    public int solicitarInfoI(String cad){
        System.out.println("Introduzca "+ cad);
        return MyInput.readInt();
    }

    public abstract void mostrarOpcion();
    public abstract void mostrarOpciones();
    public abstract String seleccion(String s);
}
