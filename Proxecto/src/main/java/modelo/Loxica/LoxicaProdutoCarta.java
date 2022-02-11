package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.ProdutoCartaDao;
import modelo.vo.Produto.ProdutoCarta;

import javax.swing.*;

public class LoxicaProdutoCarta {

    ProdutoCartaDao produtoCartaDao = new ProdutoCartaDao();

    public void validarCreate(ProdutoCarta produtoCarta){
        ProdutoCarta produtoCarta1 = produtoCartaDao.findById(produtoCarta);
        if (produtoCarta1.equals(null)){
        produtoCartaDao.create(produtoCarta);
        } else {
            JOptionPane.showMessageDialog(null, "Produto xa existente na carta", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
