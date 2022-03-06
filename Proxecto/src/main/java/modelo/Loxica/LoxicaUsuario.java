package modelo.Loxica;

import Controlador.Coordinador;

import modelo.dao.implementacion.usuarioDAO.PropietarioDao;
import modelo.dao.implementacion.usuarioDAO.UsuarioDAO;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Usuario.Usuario;

import javax.swing.*;
import java.util.List;

public class LoxicaUsuario {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

    public void validarCreateUsuario(Usuario usuario){
        UsuarioDAO usuarioDAO;
        if (usuario.getNome() != null && usuario.getApelido1() != null){
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.create(usuario);
        }else {
            JOptionPane.showMessageDialog(null, "Tamaño dos campos a introducir superado", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    public boolean validarUpdate(Usuario usuario){
        UsuarioDAO usuarioDAO =new UsuarioDAO();
        return usuarioDAO.update(usuario);
    }

    public void validarDelete(Usuario usuario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.delete(usuario);
    }

//    public Usuario validarFindRol(Usuario usuario){
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        return usuarioDAO.findRol(usuario);
//    }

    public List<Usuario> validarRead(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.read();
    }

    public Usuario validarFindById(Usuario usuario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findById(usuario);
    }

}
