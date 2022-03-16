package modelo.Loxica;

import modelo.dao.implementacion.usuarioDAO.PropietarioDao;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Usuario.Usuario;

import javax.swing.*;

public class LoxicaPropietario {

    public void validarCreatePropietario(Usuario propietario) {
        Interfaz propietarioDao;
        propietarioDao = new PropietarioDao();
        int value = ((Usuario) propietarioDao.findById(propietario)).getIdUsuario();
        if (value != 0) {
            propietarioDao.create(propietarioDao.findById(propietario));
        } else {
            JOptionPane.showMessageDialog(null, "ID de usuario non válido", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public Usuario validarFindByIdPropietario(Usuario usuario) {
        PropietarioDao propietarioDao = new PropietarioDao();
        return propietarioDao.findByIdPropietario(usuario);
    }

}
