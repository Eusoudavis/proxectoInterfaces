package Controlador;

import modelo.Loxica.LoxicaCarta;
import modelo.Loxica.LoxicaTipoBebida;
import modelo.Loxica.LoxicaUsuario;
import lombok.Data;

@Data
public class Coordinador {

    private LoxicaUsuario loxicaUsuario = new LoxicaUsuario();
    private LoxicaCarta loxicaCarta = new LoxicaCarta();
    private LoxicaTipoBebida loxicaTipoBebida = new LoxicaTipoBebida();
//    private DialogoRexistro dialogoRexistro = new DialogoRexistro();
//    private XanelaPropietario xanelaPropietario /*= new XanelaPropietario()*/;
//    private XanelaCliente xanelaCliente = new XanelaCliente();
//    private Xanela1 xanela1 = new Xanela1();
//
//    public void mostrarXanelaPropietario(){
//        xanelaPropietario.setVisible(true);
//    }
//    public void mostrarXanelaCliente(){
//        xanelaPropietario.setVisible(true);
//    }
//    public void mostrarDialogoRexistro(){
//        dialogoRexistro.setVisible(true);
//    }
//    public void mostrarXanela1(){
//        dialogoRexistro.setVisible(true);
//    }



}
