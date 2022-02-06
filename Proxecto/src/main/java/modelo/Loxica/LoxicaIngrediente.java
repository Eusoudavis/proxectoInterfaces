package modelo.Loxica;

import modelo.dao.implementacion.produtoDAO.IngredienteDAO;
import modelo.vo.Produto.Ingrediente;

import java.util.List;

public class LoxicaIngrediente {
    IngredienteDAO ingredienteDAO = new IngredienteDAO();

    public List<Ingrediente> validarRead(){
        return ingredienteDAO.read();
    }

    public Ingrediente validarFindByNameIngrediente(Ingrediente ingrediente){
        return ingredienteDAO.findByName(ingrediente);
    }
}
