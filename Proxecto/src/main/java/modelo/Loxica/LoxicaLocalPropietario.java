package modelo.Loxica;

import modelo.dao.implementacion.LocalPropietarioDAO;
import modelo.vo.Local.Local;
import modelo.vo.LocalPropietario;
import modelo.vo.Usuario.Usuario;

public class LoxicaLocalPropietario {

    public void validarCreate(LocalPropietario localPropietario){
        LocalPropietarioDAO localPropietarioDAO = new LocalPropietarioDAO();
        localPropietarioDAO.create(localPropietario);
    }
}
