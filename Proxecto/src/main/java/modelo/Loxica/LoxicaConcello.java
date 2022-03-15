package modelo.Loxica;

import modelo.dao.implementacion.concelloDAO.ConcelloDAO;
import modelo.vo.Concello.Concello;

import java.util.List;

public class LoxicaConcello {

    public List<Concello> validarRead() {
        ConcelloDAO concelloDAO = new ConcelloDAO();
        return concelloDAO.read();
    }
}
