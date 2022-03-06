package modelo.Loxica;

import Controlador.Coordinador;
import modelo.dao.implementacion.localDAO.LocalDAO;
import modelo.vo.Local.Local;

import java.util.List;

public class LoxicaLocal {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

    public void validarCreate (Local local){
        LocalDAO localDAO = new LocalDAO();
        localDAO.create(local);
    }

    public List<Local> validarRead(){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.read();
    }

    public List<Local> validarReadConParametros(Local local){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.readByParam(local);
    }

    public List<Local> validarReadConParametroConcello(Local local){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.readByCouncilParam(local);
    }
    public List<Local> validarReadConParametroEspecialidade(Local local){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.readBySpecialtyParam(local);
    }

    public List<Local> validarReadPorDono(String idPropietario){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.readByOwner(idPropietario);
    }

    public List<Local> validatereadLocalAndPRopietarioByOwner(String idPropietario){
        LocalDAO localDAO = new LocalDAO();
        return localDAO.readLocalAndPRopietarioByOwner(idPropietario);
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

