package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.TipoBebidaDAO;
import modelo.vo.Produto.TipoBebida;

import java.util.List;

/**
 *
 */
public class LoxicaTipoBebida {

    public List<TipoBebida> validarRead() {
        TipoBebidaDAO tipoBebidaDAO = new TipoBebidaDAO();
        return tipoBebidaDAO.read();
    }
}
