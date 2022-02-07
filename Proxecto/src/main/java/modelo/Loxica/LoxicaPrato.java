package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.PratoDAO;
import modelo.vo.Produto.Prato;

import java.util.List;

public class LoxicaPrato {
    PratoDAO pratoDAO = new PratoDAO();

    public List<Prato> validarFindByIdList(Prato prato){
        return pratoDAO.findByIdList(prato);
    }

    }
