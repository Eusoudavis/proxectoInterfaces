package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.BebidaDAO;
import modelo.vo.Produto.Bebida;

import java.util.List;

public class LoxicaBebida {

    public List<Bebida> validarFindByIdBebida(Bebida bebida) {
        BebidaDAO bebidaDAO = new BebidaDAO();
        return bebidaDAO.findByIdBebida(bebida);
    }
}
