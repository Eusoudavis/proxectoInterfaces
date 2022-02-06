package modelo.dao.implementacion.concelloDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.InterfazReducida;
import modelo.vo.Concello.Concello;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class ConcelloDAO implements InterfazReducida<Concello> {

    /**
     *
     * @return
     */
    @Override
    public List<Concello> read() {
        Concello concello;
        ArrayList<Concello>concellos = new ArrayList<>();
        String sql = "Select * from concello ";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                concello = new Concello();
                concello.setIdConcello(resultSet.getInt("id_concello"));
                concello.setCodigoPostal(resultSet.getInt("codigo_postal"));
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                concellos.add(concello);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return concellos;
    }

    @Override
    public Concello findById(Concello concello) {

        return null;
    }

    /**
     *
     * @param concello
     * @return
     */
    @Override
    public Concello findByName(Concello concello) {
        Concello concello1 = null;
        String sql = "Select * from Concello where nome_concello = ?";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, concello.getNomeConcello());
            ResultSet resultSet = sentenza.executeQuery();
            if (resultSet.next()){
                concello1 = new Concello();
                concello1.setIdConcello(resultSet.getInt("id_concello"));
                concello1.setCodigoPostal(resultSet.getInt("codigo_postal"));
                concello1.setNomeConcello(resultSet.getString("nome_concello"));
            }
            resultSet.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            System.out.println("Concello non atopado");
        }
        return concello;
    }
}
