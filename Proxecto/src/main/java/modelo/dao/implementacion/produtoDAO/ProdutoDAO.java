package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.dao.interfaces.InterfazProduto;
import modelo.vo.Carta.Carta;
import modelo.vo.Produto.TipoBebida;
import modelo.vo.Produto.Bebida;
import modelo.vo.Produto.Produto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class ProdutoDAO implements InterfazProduto<Produto> {



    @Override
    public List<Produto> readProduto(Produto produto) {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "Select * from produto";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
               produto.setId(resultSet.getInt("id_produto"));
               produto.setNome(resultSet.getString("nome_produto"));
               produtos.add(produto);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return produtos;
    }

    /**
     *Método para crear produto na bbdd
     * @param produto
     */
    @Override
    public void create(Produto produto) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into produto (nome_produto, prezo, encargo) values ("
                    + produto.getNome() + "')");
            estatuto.close();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexion.desconectar();
        }

    }

    /**
     *Método para insertar datos en produtos_carta
     * @param produto
     * @param carta
     */
    public void insertPordutoCarta(Produto produto, Carta carta){

        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into produtos_carta (id_carta, id_produto) values ("
                    + carta.getIdCarta() + ", " + produto.getId() + ") ");
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexion.desconectar();
        }
    }

    /**
     *Método para buscar todos os produtos da bbdd
     * @return
     */
    @Override
    public List<Produto> read() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "Select * from produto";
        Produto produtoTodo = null;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                produtoTodo = new Bebida();
                produtoTodo.setId(resultSet.getInt("id_produto"));
                produtoTodo.setNome(resultSet.getString("nome_produto"));
                produtos.add(produtoTodo);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return produtos;
    }

    /**
     * Buscar produtos por id tipo Produto
     * @param tipoBebida
     * @return
     */
    public List<Produto> findByIdTipoProduto(TipoBebida tipoBebida){
        Produto produto = null;
        List<Produto> produtos = new ArrayList<>();
        String sql = "Select * from produto as pro join bebida as be \n" +
                "on pro.id_produto = be.id_bebida\n" +
                "join tipo_bebida as tib\n" +
                "on tib.id_tipo_bebida = be.id_tipo_bebida \n" +
                "where tib.nome_tipo_bebida= ?";

        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, tipoBebida.getNomeTipoBebida());
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                produto = new Bebida();
                produto.setId(resultSet.getInt("id_produto"));
                produto.setNome(resultSet.getString("nome_produto"));
                produtos.add(produto);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return produtos;
    }



    /**
     * Método para buscar produtos por nome de produto
     * @param produto
     * @return
     */
    public List<Produto> findByName(Produto produto){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE nome_produto = ?";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, produto.getNome());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                produto = new Bebida();
                produto.setId(resultSet.getInt("id_produto"));
                produto.setNome(resultSet.getString("nome_produto"));
                produtos.add(produto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return produtos;
    }

    public List<Produto> findByIdPrato(Produto produto){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE id_produto = ?";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, produto.getId());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                produto = new Bebida();
                produto.setId(resultSet.getInt("id_produto"));
                produto.setNome(resultSet.getString("nome_produto"));
                produtos.add(produto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return produtos;
    }



    @Override
    public Produto findById(Produto produto) {
//        String sql = "SELECT * FROM produto WHERE id_produto = ?";
//
//        try {
//            Conexion conexion = new Conexion();
//            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
//            sentenza.setInt(1, produto.getId());
//            ResultSet resultSet = sentenza.executeQuery();
//
//            if (resultSet.next()){
//                produto = new Produto() {
//                }
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return null;
    }

    /**
     *
     * @param produto
     */
    @Override
    public void update(Produto produto) {

        Conexion conexion = new Conexion();

        try {
            String sql = "UPDATE produto SET nome_produto = ?, prezo = ?, encargo = ?, especialidade =?";

            PreparedStatement estatuto = conexion.getConnection().prepareStatement(sql);

            estatuto.setString(1, produto.getNome());

            estatuto.executeUpdate();
            estatuto.close();

            JOptionPane.showMessageDialog(null, " Modificouse correctamente ", "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexion.desconectar();
        }
    }

    @Override
    public void delete(Produto produto) {

    }

}
