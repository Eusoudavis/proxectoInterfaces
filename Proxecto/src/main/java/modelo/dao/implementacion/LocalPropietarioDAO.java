package modelo.dao.implementacion;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Local.Local;
import modelo.vo.LocalPropietario;
import modelo.vo.Usuario.Usuario;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class LocalPropietarioDAO implements Interfaz<LocalPropietario> {

    /**
     * Método para a realización dun insert en BBBDD
     * @param localPropietario parámetro a usar no método
     */
    @Override
    public void create(LocalPropietario localPropietario) {
        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into local_propietario values (" +
                    localPropietario.getIdPropietario().getIdUsuario() + ", " + localPropietario.getIdLocal().getIdLocal() + ")");
            estatuto.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<LocalPropietario> read() {
        return null;
    }

    @Override
    public LocalPropietario findById(LocalPropietario localPropietario) {
        return null;
    }

    @Override
    public boolean update(LocalPropietario localPropietario) {
        return false;
    }

    @Override
    public void delete(LocalPropietario localPropietario) {

    }
}
