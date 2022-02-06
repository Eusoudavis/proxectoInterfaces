package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.InterfazReducida;
import modelo.vo.Produto.TipoBebida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class TipoBebidaDAO implements InterfazReducida<TipoBebida> {
    /**
     * Método para buscar todos os tipos de bebida na bbdd
     * @return
     */
    @Override
    public List<TipoBebida> read() {
        TipoBebida tipoBebida = null;
        ArrayList<TipoBebida> tipoBebidas = new ArrayList<>();
        String sql = "select * from tipo_bebida ";
        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                tipoBebida = new TipoBebida();
                tipoBebida.setIdTipoBebida(resultSet.getInt("id_tipo_bebida"));
                tipoBebida.setNomeTipoBebida(resultSet.getString("nome_tipo_bebida"));
                tipoBebidas.add(tipoBebida);
            }
            sentenza.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexion.desconectar();
        }
        return tipoBebidas;
    }

    @Override
    public TipoBebida findById(TipoBebida tipoBebida) {
        return null;
    }

    @Override
    public TipoBebida findByName(TipoBebida tipoBebida) {
        return null;
    }
}
