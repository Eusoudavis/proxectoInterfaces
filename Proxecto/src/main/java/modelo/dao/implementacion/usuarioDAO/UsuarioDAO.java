package modelo.dao.implementacion.usuarioDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Estado;
import modelo.vo.Usuario.Propietario;
import modelo.vo.Usuario.Usuario;

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
public class UsuarioDAO implements Interfaz<Usuario> {
    /**
     * Método para a realización dun insert en BBBDD
     *
     * @param usuario
     */
    @Override
    public void create(Usuario usuario) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO usuario (nome, apelido1, apelido2, nome_concello, rua, numero,telefono, email, estado, rol, contrasinal) VALUES ('"

                    + usuario.getNome() +
                    "' , '"
                    + usuario.getApelido1() +
                    "' , '"
                    + usuario.getApelido2() +
                    "' , '"
                    + usuario.getConcello().getNomeConcello() +
                    "' , '"
                    + usuario.getRua() +
                    "' , '"
                    + usuario.getNumero() +
                    "' , '"
                    + usuario.getTelefono() +
                    "' , '"
                    + usuario.getEmail() +
                    "' , '"
                    + Estado.ACTIVO +
                    "' , '"
                    + usuario.getRol() +
                    "' , '"
                    + usuario.getContrasinal() +
                    "')");

            estatuto.close();
            conexion.desconectar();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List read() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "Select * from usuario";
        Usuario usuario;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            ResultSet resultSet = sentenza.executeQuery();
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));


                usuarios.add(usuario);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuarios;
    }

//    public Usuario findRol (Usuario usuario){
//        String sql = "Select idUsuario, rol, contrasinal from usuario where idUsuario =?";
//        try {
//            Conexion conexion = new Conexion();
//            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
//            sentenza.setInt(1, usuario.getIdUsuario());
//            ResultSet resultSet = sentenza.executeQuery();
//
//            if (resultSet.next()){
//                usuario = new Propietario();
//                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
//                usuario.setRol(resultSet.getString("rol"));
//                usuario.setContrasinal(resultSet.getString("contrasinal"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return usuario;
//    }

    /**
     * Métpdp para buscar usuario por id
     *
     * @param usuario
     * @return
     */
    @Override
    public Usuario findById(Usuario usuario) {
        String sql = "Select * from usuario where idUsuario =?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, usuario.getIdUsuario());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()) {
                usuario = new Propietario();
                Integer userNumber = resultSet.getInt("idUsuario");
                if (!userNumber.equals(null)) {
                    usuario.setIdUsuario(userNumber);
                    String nome = resultSet.getString("nome");
                    usuario.setNome(nome);
                    usuario.setApelido1(resultSet.getString("apelido1"));
                    usuario.setApelido2(resultSet.getString("apelido2"));
                    usuario.setRua(resultSet.getString("rua"));
                    usuario.setNumero(resultSet.getInt("numero"));
                    usuario.setTelefono(resultSet.getString("telefono"));
                    usuario.setEmail(resultSet.getString("email"));
                    // usuario.setEstado((Estado) resultSet.getObject("estado"));
                    usuario.setRol(resultSet.getString("rol"));
//                Concello concello = new Concello();
//                concello.setNomeConcello(resultSet.getString("nome_concello"));
//                usuario.setConcello(concello);
                    usuario.setContrasinal(resultSet.getString("contrasinal"));
                }
            }else {
                usuario = new Usuario();
            }
        } catch (SQLException throwables) {
            //Usuario usuarioVacio = new Usuario();
            throwables.printStackTrace();
        }
        return usuario;
    }

    /**
     * @param usuario
     * @return
     */
    @Override
    public boolean update(Usuario usuario) {
        Conexion conexion = new Conexion();
        boolean actualizado = false;
        try {
            String sql = "UPDATE usuario SET nome= ?, apelido1= ?, apelido2= ?, rua =?, numero= ?, " +
                    "telefono= ?, email= ? where idUsuario = ?";

            PreparedStatement estatuto = conexion.getConnection().prepareStatement(sql);

            estatuto.setString(1, usuario.getNome());
            estatuto.setString(2, usuario.getApelido1());
            estatuto.setString(3, usuario.getApelido2());
            estatuto.setString(4, usuario.getRua());
            estatuto.setInt(5, usuario.getNumero());
            estatuto.setString(6, usuario.getTelefono());
            estatuto.setString(7, usuario.getEmail());
            estatuto.setInt(8, usuario.getIdUsuario());

            actualizado = estatuto.executeUpdate() > 0;
            estatuto.close();
            JOptionPane.showMessageDialog(null, " Modificouse correctamente ", "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            conexion.desconectar();
        }
        return actualizado;
    }

    /**
     * @param usuario
     */
    @Override
    public void delete(Usuario usuario) {

        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("DELETE FROM usuario WHERE idUsuario = '" +
                    usuario.getIdUsuario() + "'");
            JOptionPane.showMessageDialog(null, " Eliminouse correctamente", "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
