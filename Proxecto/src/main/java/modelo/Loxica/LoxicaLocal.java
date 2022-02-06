package modelo.Loxica;

import Controlador.Coordinador;
import modelo.dao.implementacion.localDAO.LocalDAO;
import modelo.vo.Local.Local;

public class LoxicaLocal {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

    public void validarCreate (Local local){
        LocalDAO localDAO = new LocalDAO();
        localDAO.create(local);
    }

    public Local validarFindByIdMax(Local local){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.findByIdMax(local);
    }

    public Local validarFindByName (Local local){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.findByName(local);
    }

    public boolean validarUpdate(Local local){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.update(local);
    }

    public void validarDelete(Local local){
        LocalDAO localDAO = new LocalDAO();
        localDAO.delete(local);
    }
}

