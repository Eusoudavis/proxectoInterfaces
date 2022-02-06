package modelo.dao.implementacion.cartaDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Carta.Carta;
import modelo.vo.Local.Local;
import modelo.vo.Usuario.Propietario;

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
public class CartaDAO implements Interfaz<Carta> {

    /**
     *Método para crear unha carta na bbdd
     * @param carta
     */
    @Override
    public void create(Carta carta) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO carta (epoca_ano, nome_carta) VALUES('"
            + carta.getEpocaAno() + "', '" + carta.getNome() + "')");
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
     *Método para buscar cartas na bbdd
     * @return
     */
    @Override
    public List<Carta> read() {
        Carta carta = null;
        ArrayList<Carta>cartas = new ArrayList<>();
        String sql = "Select * from carta";
        try {
            Conexion conexion= new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cartas;
    }

    /**
     * Método para buscar unha carta na bbdd por id_local
     * @param local
     * @return
     */
    public List<Carta> findByIdLocal(Local local){
        Carta carta = null;
        List<Carta> cartas = new ArrayList<>();
        String sql = "select * from carta as ca join carta_local as cal " +
                "on ca.id_carta = cal.id_carta where cal.id_local = ?";
        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, local.getIdLocal());
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
                carta.setNome(resultSet.getString("nome_carta"));
                carta.setEpocaAno( resultSet.getString("epoca_ano"));
                cartas.add(carta);
            }
            sentenza.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexion.desconectar();
        }
        return cartas;
    }

    /**
     * Método para buscar unha carta na bbdd por nome
     * @param carta
     * @return
     */
    public Carta findByNomeCarta(Carta carta){
        String sql = "select id_carta from carta where nome_carta = ?";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, carta.getNome());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
                //carta.setEpocaAno((EstacionAno) resultSet.getObject("epoca_ano"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carta;
    }

    /**
     * Método para buscar unha carta na bbdd por id máximo
     * @param carta
     * @return
     */
    public Carta findByIdMax(Carta carta){
        String sql = "select MAX(id_carta) as id_carta from carta";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carta;
    }

    /**
     *Método para buscar unha carta na bbdd
     * @param carta
     * @return
     */
    @Override
    public Carta findById(Carta carta) {
        String sql = "select id_carta from carta where nome_carta = ?";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, carta.getNome());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
                //carta.setEpocaAno((EstacionAno) resultSet.getObject("epoca_ano"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carta;
    }

    /**
     *
     * @param carta
     * @return
     */
    @Override
    public boolean update(Carta carta) {
        return false;

    }

    /**
     *
     * @param carta
     */
    @Override
    public void delete(Carta carta) {

    }
}
