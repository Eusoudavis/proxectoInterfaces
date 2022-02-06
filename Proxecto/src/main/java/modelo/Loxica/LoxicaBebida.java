package modelo.Loxica;

import Controlador.Coordinador;
import modelo.dao.implementacion.produtoDAO.BebidaDAO;
import modelo.vo.Produto.Bebida;

import java.util.List;

public class LoxicaBebida {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

    public List<Bebida> validarFindByIdBebida(Bebida bebida){
        BebidaDAO bebidaDAO = new BebidaDAO();
        return bebidaDAO.findByIdBebida(bebida);
    }
}
