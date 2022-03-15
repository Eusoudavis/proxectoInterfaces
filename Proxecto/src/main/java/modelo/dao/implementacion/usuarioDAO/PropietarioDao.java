package modelo.dao.implementacion.usuarioDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Concello.Concello;
import modelo.vo.Estado;
import modelo.vo.Usuario.Propietario;
import modelo.vo.Usuario.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class PropietarioDao implements Interfaz<Usuario> {


    /**
     * Método par buscar usuario por id Propietario
     * @param usuario
     * @return
     */
    public Usuario findByIdPropietario(Usuario usuario) {
        String sql = "Select * from usuario where idUsuario =?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, usuario.getIdUsuario());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()) {
                usuario = new Propietario();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setApelido1(resultSet.getString("apelido1"));
                usuario.setApelido2(resultSet.getString("apelido2"));
                usuario.setRua(resultSet.getString("rua"));
                usuario.setNumero(resultSet.getInt("numero"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setRol(resultSet.getString("rol"));
                usuario.setContrasinal(resultSet.getString("contrasinal"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario;
    }

    /**
     * Método para a realización dun insert en BBBDD
     * @param propietario
     */
    @Override
    public void create(Usuario propietario) {
        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into propietario Values ("
            +propietario.getIdUsuario() + ")");
            estatuto.close();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            String idRexistro = String.valueOf(findById(propietario).getIdUsuario());
            JOptionPane.showMessageDialog(null, "RECORDA ACCEDER CO TEU USUARIO " + idRexistro, "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conexion.desconectar();
            }catch (Exception e){
                System.out.println("Fallo na desconexion");
            }
        }
    }



    @Override
    public List<Usuario> read() {
        return null;
    }

    /**
     * Método para buscar propietario por id maximo
     * @param propietario
     * @return
     */
    @Override
    public Usuario findById(Usuario propietario) {
        String sql = "SELECT MAX(idUsuario) as idUsuario FROM usuario";

        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                propietario = new Propietario();
                propietario.setIdUsuario(resultSet.getInt("idUsuario"));
            }
            sentenza.close();
            conexion.desconectar();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return propietario;
    }

    @Override
    public boolean update(Usuario usuario) {return false;

    }



    @Override
    public void delete(Usuario usuario) {

    }
}
