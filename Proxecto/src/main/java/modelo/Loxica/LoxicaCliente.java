package modelo.Loxica;

import Controlador.Coordinador;
import modelo.dao.implementacion.usuarioDAO.clienteDAO.ClienteDAO;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Usuario.Usuario;

import javax.swing.*;

public class LoxicaCliente {
    private Coordinador miCoordinador;
    public static boolean modifica = false;



    public void validarCreateCliente(Usuario cliente){
        Interfaz clienteDAO;
        clienteDAO = new ClienteDAO();
        int value = ((Usuario) clienteDAO.findById(cliente)).getIdUsuario();
        if (value != 0){
            clienteDAO.create(clienteDAO.findById(cliente));
        }else {
            JOptionPane.showMessageDialog(null, "ID de usuario non válido", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);}
    }


}
