package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.ProdutoCartaDao;
import modelo.vo.Produto.ProdutoCarta;

public class LoxicaProdutoCarta {

    ProdutoCartaDao produtoCartaDao = new ProdutoCartaDao();

    public void validarCreate(ProdutoCarta produtoCarta){
        produtoCartaDao.create(produtoCarta);
    }
}
