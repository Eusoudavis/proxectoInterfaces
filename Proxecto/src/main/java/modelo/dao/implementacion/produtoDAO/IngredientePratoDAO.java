package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Produto.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientePratoDAO implements Interfaz<IngredientePrato> {
    @Override
    public void create(IngredientePrato ingredientePrato) {
    }

    @Override
    public List<IngredientePrato> read() {
        IngredientePrato ingredientePrato;
        List<IngredientePrato> ingredientesPrato = new ArrayList<>();
        String sql = "Select * from ingrediente_prato";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                ingredientePrato = new IngredientePrato();
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(resultSet.getInt("id_ingrediente"));
                Prato prato = new Prato();
                prato.setId(resultSet.getInt("id_prato"));
                ingredientePrato.setIngrediente(ingrediente);
                ingredientePrato.setPrato(prato);
                ingredientesPrato.add(ingredientePrato);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ingredientesPrato;
    }

    public List<IngredientePrato> findByIdIngrediente(IngredientePrato ingredientePrato) {

        List<IngredientePrato> ingredientesPrato = new ArrayList<IngredientePrato>();


        return ingredientesPrato;
    }


        @Override
    public IngredientePrato findById(IngredientePrato ingredientePrato) {
        return ingredientePrato;
    }

    @Override
    public boolean update(IngredientePrato ingredientePrato) {
        return false;
    }

    @Override
    public void delete(IngredientePrato ingredientePrato) {

    }
}
