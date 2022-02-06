package modelo.Loxica;

import modelo.dao.implementacion.localDAO.TipoLocalDAO;
import modelo.vo.Local.TipoLocal;

import java.util.List;

public class LoxicaTipoLocal {

    public List<TipoLocal> validarRead(){
        TipoLocalDAO tipoLocalDAO = new TipoLocalDAO();
        return tipoLocalDAO.read();
    }

    public TipoLocal validarFindByName (TipoLocal tipoLocal){
        TipoLocalDAO tipoLocalDAO = new TipoLocalDAO();
        return tipoLocalDAO.findByName(tipoLocal);
    }
}
