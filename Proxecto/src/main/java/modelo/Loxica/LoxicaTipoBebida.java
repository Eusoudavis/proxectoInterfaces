package modelo.Loxica;

import Controlador.Coordinador;
import modelo.dao.implementacion.produtoDAO.TipoBebidaDAO;
import modelo.vo.Produto.TipoBebida;

import java.util.List;

/**
 *
 */
public class LoxicaTipoBebida {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

    public List<TipoBebida> validarRead(){
        TipoBebidaDAO tipoBebidaDAO = new TipoBebidaDAO();
        return tipoBebidaDAO.read();
    }
}
