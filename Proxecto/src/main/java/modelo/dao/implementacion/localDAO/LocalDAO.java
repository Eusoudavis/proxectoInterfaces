package modelo.dao.implementacion.localDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Concello.Concello;
import modelo.vo.Estado;
import modelo.vo.Local.Local;

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
     * Método para realizar un insert dos datos recibidos na táboa local da base de datos
     *
     * @param local parámetro recibido cos valores necesarios
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
                    + local.getEmail() +
                    "' , '"
                    + local.getEspecialidade() +
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

    /**
     * Método que busca todos os locais gardados na base de datos
     *
     * @return devolve unha lista de locais
     */
    @Override
    public List<Local> read() {
        List<Local> locais = new ArrayList<>();
        String sql = "Select * from local";
        Local local;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                local = new Local();
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                local.setEspecialidade(resultSet.getString("especialidade"));
                locais.add(local);
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locais;
    }

    /**
     * Método para buscar local por nome por parámetro
     *
     * @param local parámetro cos datos precisos para a búsqueda
     *
     * @return devolve o local que coincida coa búsqueda
     */
    public Local findByName(Local local) {
        String sql = "Select * from local where nome_local = ?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, local.getNomeLocal());
            ResultSet resultSet = sentenza.executeQuery();
            if (resultSet.next()) {
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
            } else {
                local = new Local();
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
     *
     * @param local parámetro coa información necesaria para o utilizar o método
     * @return devolve o local que coincida ca búsqueda
     */
    public Local findByIdMax(Local local) {
        String sql = "Select MAX(id_local) as id_local from local";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()) {
                local.setIdLocal(resultSet.getInt("id_local"));
            }
            sentenza.close();
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
     *
     * @param local Parámetro cos valores necesarios para executar o método
     * @return devolve un booleano que indica se se realizou ou non
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
     *
     * @param local Parámetro cos valores necesarios para executar o método
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

    /**
     *
     * @param local
     * @return
     */
    public List<Local> readByParam(Local local) {
        List<Local> locais = new ArrayList<>();
        String sql = "Select * from local where nome_concello =? and especialidade = ?";
        //Local local;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, local.getConcello().getNomeConcello());
            sentenza.setString(2, local.getEspecialidade());
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                local = new Local();
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                local.setEspecialidade(resultSet.getString("especialidade"));
                locais.add(local);
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locais;
    }

    /**
     *
     * @param local
     * @return
     */
    public List<Local> readByCouncilParam(Local local) {
        List<Local> locais = new ArrayList<>();
        String sql = "Select * from local l where l.nome_concello =?";
        //Local local;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, local.getConcello().getNomeConcello());
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                local = new Local();
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                local.setEspecialidade(resultSet.getString("especialidade"));
                locais.add(local);
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locais;
    }

    /**
     *
     * @param local
     * @return
     */
    public List<Local> readBySpecialtyParam(Local local) {
        List<Local> locais = new ArrayList<>();
        String sql = "Select * from local where especialidade = ?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, local.getEspecialidade());
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                local = new Local();
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                local.setEspecialidade(resultSet.getString("especialidade"));
                locais.add(local);
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locais;
    }

    /**
     *
     * @param idPropietario
     * @return
     */
    public List<Local> readByOwner(String idPropietario) {
        List<Local> locais = new ArrayList<>();
        String sql = "SELECT * from local as lo " +
                "join local_propietario as lp " +
                "on lo.id_local = lp.id_local " +
                "join propietario as pr " +
                "on lp.id_propietario = pr.id_propietario " +
                "where pr.id_propietario = ?";
        Local local;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, idPropietario);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                local = new Local();
                local.setIdLocal(resultSet.getInt("id_local"));
                local.setNomeLocal(resultSet.getString("nome_local"));
                Concello concello = new Concello();
                concello.setNomeConcello(resultSet.getString("nome_concello"));
                local.setConcello(concello);
                local.setRua(resultSet.getString("rua"));
                local.setNumero(resultSet.getInt("numero"));
                local.setTelefono(resultSet.getString("telefono"));
                local.setEmail(resultSet.getString("email"));
                local.setEspecialidade(resultSet.getString("especialidade"));
                locais.add(local);
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return locais;
    }

    /**
     *
     * @param idPropietario
     * @param nomeLocal
     * @return
     */
    public Local readLocalAndPRopietarioByOwner(String idPropietario, String nomeLocal) {
        String sql = "SELECT * from local as lo join local_propietario as lp on lo.id_local = lp.id_local " +
                "join propietario as pr " +
                "on lp.id_propietario = pr.id_propietario " +
                "where pr.id_propietario = ? and lo.nome_local =?";
        Local local = new Local();
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setString(1, idPropietario);
            sentenza.setString(2, nomeLocal);
            ResultSet resultSet = sentenza.executeQuery();
            if (resultSet.next()) {
                local.setIdLocal(resultSet.getInt("id_local"));
            }else {
                local= new Local();
            }
            sentenza.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return local;
    }
}
