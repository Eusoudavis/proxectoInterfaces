package modelo.dao.implementacion.localDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Local.TipoLocal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class TipoLocalDAO implements Interfaz<TipoLocal> {
    @Override
    public void create(TipoLocal tipoLocal) {

    }

    /**
     *Método para buscar todos os tipos de local na bbdd
     * @return
     */
    @Override
    public List<TipoLocal> read() {
        TipoLocal tipoLocal;
        List<TipoLocal> tipoLocalList = new ArrayList<>();
        String sql = "Select * from tipo_local";
        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                tipoLocal = new TipoLocal();
                tipoLocal.setIdTipoLocal(resultSet.getInt("id_tipo_local"));
                tipoLocal.setNomeTipo(resultSet.getString("nome_tipo"));
                tipoLocalList.add(tipoLocal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tipoLocalList;
    }

    /**
     *Método para buscar por nome
     * @param tipoLocal
     * @return
     */
    public TipoLocal findByName(TipoLocal tipoLocal){

        Conexion conexion = new Conexion();
        String sql = "Select * from tipo_local where nome_tipo = ?";

        try {
           PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, tipoLocal.getNomeTipo());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                tipoLocal.setIdTipoLocal(resultSet.getInt("id_tipo_local"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  tipoLocal;
    }

    @Override
    public TipoLocal findById(TipoLocal tipoLocal) {
        return null;
    }

    @Override
    public boolean update(TipoLocal tipoLocal) {
        return false;
    }

    @Override
    public void delete(TipoLocal tipoLocal) {

    }
}
