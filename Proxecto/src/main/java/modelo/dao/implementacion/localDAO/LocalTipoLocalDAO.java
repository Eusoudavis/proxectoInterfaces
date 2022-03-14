package modelo.dao.implementacion.localDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Local.LocalTipoLocal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase que representa o DAO de LocalTipoLocal implementa unha interfaz
 */
public class LocalTipoLocalDAO implements Interfaz<LocalTipoLocal> {

    /**
     *Método para realizar un insert cos datos recibidos por parámetro na bbdd na táboa pertinente
     * @param localTipoLocal parámetro recibido cos datos necesarios
     */
    @Override
    public void create(LocalTipoLocal localTipoLocal) {

        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into local_tipo_local values ("
            + localTipoLocal.getTipoLocal().getIdTipoLocal() + ", " + localTipoLocal.getLocal().getIdLocal() +");");

            estatuto.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<LocalTipoLocal> read() {
        return null;
    }

    @Override
    public LocalTipoLocal findById(LocalTipoLocal localTipoLocal) {
        return null;
    }

    @Override
    public boolean update(LocalTipoLocal localTipoLocal) {
        return false;
    }

    @Override
    public void delete(LocalTipoLocal localTipoLocal) {

    }
}
