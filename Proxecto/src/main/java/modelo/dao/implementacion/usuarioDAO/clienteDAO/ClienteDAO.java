package modelo.dao.implementacion.usuarioDAO.clienteDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Usuario.Cliente;
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
public class ClienteDAO implements Interfaz<Usuario> {

    /**
     * Método para a realización dun insert en BBBDD
     * @param cliente parámetro necesario
     */
    @Override
    public void create(Usuario cliente) {
        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            //  findById(propietario);
            estatuto.executeUpdate("Insert into cliente Values ("
                    +cliente.getIdUsuario() + ")");
            estatuto.close();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
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
     * Método para buscar usuario por id Cliente
     * @param usuario
     * @return
     */
    public Usuario findByIdCliente(Usuario usuario) {
        String sql = "Select * from usuario where idUsuario =?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, usuario.getIdUsuario());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()) {
                usuario = new Cliente();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setApelido1(resultSet.getString("apelido1"));
                usuario.setApelido2(resultSet.getString("apelido2"));
                usuario.setRua(resultSet.getString("rua"));
                usuario.setNumero(resultSet.getInt("numero"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setEmail(resultSet.getString("email"));
                //usuario.setEstado((Estado) resultSet.getObject("estado"));
                usuario.setRol(resultSet.getString("rol"));
//                Concello concello = new Concello();
//                concello.setNomeConcello(resultSet.getString("nome_concello"));
//                usuario.setConcello(concello);
                usuario.setContrasinal(resultSet.getString("contrasinal"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario;
    }

    /**
     * Método que busca por id maximo
     * @param cliente parámtro necesario
     * @return devolve un cliente de tipo usuario
     */
    @Override
    public Usuario findById(Usuario cliente) {
        String sql = "SELECT MAX(idUsuario) as idUsuario FROM usuario";

        Conexion conexion = new Conexion();
        try {
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            //sentenza.setInt(1, usuario.getIdUsuario());
            ResultSet resultSet = sentenza.executeQuery();

            if (resultSet.next()){
                cliente = new Cliente();
                cliente.setIdUsuario(resultSet.getInt("idUsuario"));
                //   create(propietario);
            }
             sentenza.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conexion.desconectar();
            }catch (Exception e){
                System.out.println("Erro na desconexión");
            }
        }
        return cliente;    }

    @Override
    public boolean update(Usuario usuario) {
        return false;

    }


    /**
     * Método para borrar un rexistro da bbdd
     * @param cliente parámetro necesario
     */
    @Override
    public void delete(Usuario cliente) {

        Conexion conexion = new Conexion();
        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("DELETE FROM cliente WHERE id_cliente = '"+
                    cliente.getIdUsuario() + "'");
            JOptionPane.showMessageDialog(null, " Eliminouse correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conexion.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
