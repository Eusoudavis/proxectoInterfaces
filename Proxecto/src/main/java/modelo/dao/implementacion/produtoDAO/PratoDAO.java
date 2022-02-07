package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Produto.Prato;
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
public class PratoDAO implements Interfaz<Produto> {

    /**
     * Método para realiar insert na bbdd
     * @param prato
     */
    @Override
    public void create(Produto prato) {
        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();

            estatuto.executeUpdate("Insert into prato Values( "
            + prato.getId() + ")"
            );
            estatuto.close();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conexion.desconectar();
            }catch (Exception e){
                System.out.println("Fallo na desconexion");
            }
        }
    }

    @Override
    public List<Produto> read() {
        return null;
    }

    /**
     * Método para buscar un produto por idMaximo
     * @param prato
     * @return
     */
    @Override
    public Produto findById(Produto prato) {
        String sql = "SELECT MAX(id_produto) as id_produto from produto";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                prato = new Prato();
                prato.setId(resultSet.getInt("id_produto"));
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return prato;
    }

        public List<Prato> findByIdList(Prato prato){
        List<Prato> pratos = new ArrayList<>();
        String sql = "SELECT * FROM prato WHERE id_prato = ?";
                ;

        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, prato.getId());
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                prato = new Prato();
                prato.setId(resultSet.getInt("id_prato"));
                prato.setNome(resultSet.getString("nome_prato"));
                pratos.add(prato);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pratos;
    }

    @Override
    public boolean update(Produto produto) {
return false;
    }

    /**
     * Método para borrar un produto según id
     * @param prato
     */
    @Override
    public void delete(Produto prato) {

        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("DELETE FROM prato WHERE id_prato = '"+
                    prato.getId() + "'");
            JOptionPane.showMessageDialog(null, " Eliminouse correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
