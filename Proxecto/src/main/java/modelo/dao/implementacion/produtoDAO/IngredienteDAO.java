package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Produto.Ingrediente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO implements Interfaz<Ingrediente> {
    @Override
    public void create(Ingrediente ingrediente) {

    }

    @Override
    public List<Ingrediente> read() {
        Ingrediente ingrediente = null;
        List<Ingrediente> ingredientes = new ArrayList<>();
        String sql = "Select * from ingrediente";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(resultSet.getInt("id_ingrediente"));
                ingrediente.setNomeIngrediente(resultSet.getString("nome_ingrediente"));
                ingredientes.add(ingrediente);
            }
            sentenza.close();
            conexion.desconectar();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Ingrediente findById(Ingrediente ingrediente) {
        return null;
    }


    public Ingrediente findByName(Ingrediente ingrediente) {
        String sql = "Select * from ingrediente where nome_ingrediente = ? ";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, ingrediente.getNomeIngrediente());
            ResultSet resultSet = sentenza.executeQuery();
            if (resultSet.next()) {
                ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(resultSet.getInt("id_ingrediente"));
                ingrediente.setNomeIngrediente(resultSet.getString("nome_ingrediente"));
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ingrediente;
    }

    @Override
    public boolean update(Ingrediente ingrediente) {
        return false;
    }

    @Override
    public void delete(Ingrediente ingrediente) {

    }
}
