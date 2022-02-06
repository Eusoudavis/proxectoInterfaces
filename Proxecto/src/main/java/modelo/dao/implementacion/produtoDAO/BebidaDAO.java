package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Produto.Bebida;
import modelo.vo.Produto.Produto;
import modelo.vo.Produto.TipoBebida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class BebidaDAO implements Interfaz<Bebida> {

    /**
     * Método para crear unha bebida na bbdd
     * @param bebida
     */
    @Override
    public void create(Bebida bebida) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into bebida Values ("
            +bebida.getId() + ", '" + bebida.getFabricante() + "' , " + bebida.getTipo().getIdTipoBebida() + ")" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Método para buscar todas as bebidas da bbdd
     * @return
     */
    @Override
    public List<Bebida> read() {
        Bebida bebida = null;
        ArrayList<Bebida> bebidas = new ArrayList<>();
        String sql = "Select * from bebida";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                bebida = new Bebida();
                bebida.setId(resultSet.getInt("id_bebida"));
                bebida.setFabricante(resultSet.getString("nome_fabricante"));
                TipoBebida tipoBebidaBD = new TipoBebida();
                tipoBebidaBD.setIdTipoBebida(resultSet.getInt("id_tipo_bebida"));
                bebida.setTipo(tipoBebidaBD);
                bebidas.add(bebida);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bebidas;
    }

    /**
     * Método para buscar bebidas por id tipo de bebida
     * @param tipoBebida
     * @return
     * @throws SQLException
     */
    public List<Bebida> findByIdTipo(TipoBebida tipoBebida) throws SQLException {
        Bebida bebida = null;
        List<Bebida> bebidas = new ArrayList<>();
        String sql= "Select * from bebida where id_tipo_bebida = ?";
        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                bebida = new Bebida();
                bebida.setId(resultSet.getInt("id_bebida"));
                bebida.setFabricante(resultSet.getString("nome_fabricante"));
                TipoBebida tipoBebidaBD = new TipoBebida();
                tipoBebidaBD.setIdTipoBebida(resultSet.getInt("id_tipo_bebida"));
                bebida.setTipo(tipoBebidaBD);
            }
        } finally {

        }
        return bebidas;
    }

    @Override
    public Bebida findById(Bebida bebida) {
        return null;
    }

    /**
     *Método para buscar por id máximo na bbdd
     * @param bebida
     * @return
     */
    public Produto findById(Produto bebida) {
        String sql = "SELECT MAX(id_produto) as id_produto FROM produto";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                bebida = new Bebida();
                bebida.setId(resultSet.getInt("id_produto"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bebida;
    }

    /**
     *Método para buscar por id de Bebida na bbdd
     * @param bebida
     * @return
     */
    public List<Bebida> findByIdBebida(Bebida bebida) {
        List<Bebida> bebidaList = new ArrayList<>();
        String sql = "SELECT * FROM bebida where id_bebida = ?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, bebida.getId());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                bebida = new Bebida();
                bebida.setId(resultSet.getInt("id_bebida"));
                bebida.setFabricante(resultSet.getString("nome_fabricante"));
                TipoBebida tipoBebidaBD = new TipoBebida();
                tipoBebidaBD.setIdTipoBebida(resultSet.getInt("id_tipo_bebida"));
                bebida.setTipo(tipoBebidaBD);
                bebidaList.add(bebida);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bebidaList;
    }

    @Override
    public boolean update(Bebida bebida) {
        return false;

    }

    @Override
    public void delete(Bebida bebida) {
    }
}
