package modelo.dao.implementacion.localDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Concello.Concello;
import modelo.vo.Estado;
import modelo.vo.Local.Local;
import modelo.vo.Local.TipoLocal;

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
public class LocalDAO implements Interfaz<Local> {

    /**
     * Método para realizar un insert na táboa local
     * @param local
     */
    @Override
    public void create(Local local) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO local (nome_local, nome_concello, rua, numero,telefono, email, especialidade, estado) VALUES ('"
                    + local.getNomeLocal() +
                            "' , '"
                    + local.getConcello().getNomeConcello() +
                            "' , '"
                    + local.getRua() +
                            "' , '"
                    + local.getNumero() +
                            "' , '"
                    + local.getTelefono() +
                            "' , '"
                    +local.getEmail() +
                            "' , '"
                    +local.getEspecialidade() +
                           "' , '"
                    + Estado.ACTIVO +
                    "')");
            estatuto.close();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Local> read() {
        List<Local> locais = new ArrayList<>();
        String sql = "Select * from local";
        Local local;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()){
                local = new Local();
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                local.setRangoPrezos(resultSet.getInt("rango_prezos"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                //local.getEstado(resultSet.getString("estado"));
               // TipoLocal tipoLocal = new TipoLocal();
              //  tipoLocal.setNomeTipo(resultSet.getString(""));
                locais.add(local);

            }sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locais;    }

    /**
     *Método para buscar local por nome
     * @param local
     * @return
     */
    public Local findByName(Local local){

        String sql = "Select * from local where nome_local = ?";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, local.getNomeLocal());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                local.setNomeLocal(resultSet.getString("nome_local"));
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return local;
    }

    /**
     * Método para buscar local por idMax
     * @param local
     * @return
     */
    public Local findByIdMax(Local local){
        String sql = "Select MAX(id_local) as id_local from local";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                local.setIdLocal(resultSet.getInt("id_local"));
            }sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return local;
    }

    @Override
    public Local findById(Local local) {
        return null;
    }

    /**
     * Método para actualizar datos dun local
     * @param local
     * @return
     */
    @Override
    public boolean update(Local local) {
        Conexion conexion = new Conexion();
        boolean actualizado = false;
        try {
            String sql = "UPDATE local SET nome_local = ?, rua = ?, numero = ?, " +
                    "telefono =?, email =? where nome_local = ?";

            PreparedStatement estatuto = conexion.getConnection().prepareStatement(sql);
            estatuto.setString(1, local.getNomeLocal());
            estatuto.setString(2, local.getRua());
            estatuto.setInt(3, local.getNumero());
            estatuto.setString(4, local.getTelefono());
            estatuto.setString(5, local.getEmail());
            //estatuto.setInt(6, local.getIdLocal());
            estatuto.setString(6, local.getNomeLocal());

            actualizado = estatuto.executeUpdate() > 0;
            estatuto.close();
            JOptionPane.showMessageDialog(null, " Modificouse correctamente ", "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actualizado;
    }

    /**
     * Método para borrar un local
     * @param local
     */
    @Override
    public void delete(Local local) {

        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("DELETE FROM local WHERE nome_local = '" +
                    local.getNomeLocal() + "'");
            JOptionPane.showMessageDialog(null, " Eliminouse correctamente", "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public List<Local> findByIdMauitasCcisas(Local local){
//        List<Local> locais = new ArrayList<>();
//        String sql = "Select * from local where nome_concello = ? and ";
//
//        try {
//            Conexion conexion = new Conexion();
//            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
//            sentenza.setInt();
//            ResultSet resultSet = sentenza.executeQuery();
//
//            if (resultSet.next()){
//                local.setIdLocal(resultSet.getInt("id_local"));
//            }sentenza.close();
//            conexion.desconectar();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return locais;
   // }
}
