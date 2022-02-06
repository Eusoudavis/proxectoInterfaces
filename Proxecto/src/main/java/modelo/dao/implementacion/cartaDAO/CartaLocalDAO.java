package modelo.dao.implementacion.cartaDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Carta.CartaLocal;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CartaLocalDAO implements Interfaz<CartaLocal> {
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
