package modelo.dao.implementacion.cartaDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Carta.CartaLocal;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase que representa o DAO cos métodos Crud. Implementa a interfaz Interfaz<>
 */
public class CartaLocalDAO implements Interfaz<CartaLocal> {

    /**
     * Método para a creación na bbdd un rexistro na táboa pertinente dos datos
     * @param cartaLocal parámetro recibido coa información necesaria
     */
    @Override
    public void create(CartaLocal cartaLocal) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO carta_local VALUES("
                    + cartaLocal.getCarta().getIdCarta() + ", " + cartaLocal.getLocal().getIdLocal() + ")");
            estatuto.close();
            JOptionPane.showMessageDialog(null, "Rexistrouse Exitosamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conexion.desconectar();
        }
    }

    @Override
    public List<CartaLocal> read() {
        return null;
    }

    @Override
    public CartaLocal findById(CartaLocal cartaLocal) {
        return null;
    }

    @Override
    public boolean update(CartaLocal cartaLocal) {
        return false;
    }

    @Override
    public void delete(CartaLocal cartaLocal) {

    }
}
