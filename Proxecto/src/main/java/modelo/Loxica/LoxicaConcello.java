package modelo.Loxica;

import Controlador.Coordinador;
import modelo.dao.implementacion.concelloDAO.ConcelloDAO;
import modelo.vo.Concello.Concello;

import java.util.List;

public class LoxicaConcello {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

    public List<Concello> validarRead(){
        ConcelloDAO concelloDAO = new ConcelloDAO();
        return concelloDAO.read();
    }
}
