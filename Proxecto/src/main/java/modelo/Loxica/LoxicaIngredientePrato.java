package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.IngredientePratoDAO;
import modelo.vo.Produto.Ingrediente;
import modelo.vo.Produto.IngredientePrato;

import java.util.List;

public class LoxicaIngredientePrato {
    IngredientePratoDAO ingredientePratoDAO = new IngredientePratoDAO();

    public List<IngredientePrato> validarRead(){
        return ingredientePratoDAO.read();
    }

    public List<IngredientePrato> validarfindByIdIngrediente(IngredientePrato ingredientePrato){
        return ingredientePratoDAO.findByIdIngrediente(ingredientePrato);
    }
}
