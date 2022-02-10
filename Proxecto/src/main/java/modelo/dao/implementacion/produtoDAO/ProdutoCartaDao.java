package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Produto.ProdutoCarta;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProdutoCartaDao implements Interfaz<ProdutoCarta> {
    @Override
    public void create(ProdutoCarta produtoCarta) {
        Conexion conexion = new Conexion();

        try {
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("Insert into produtos_carta Values ("
                    + produtoCarta.getCarta().getIdCarta() + ", " + produtoCarta.getProduto().getId() + " , " + produtoCarta.getPrezo()
                    + " , " + produtoCarta.isEncargo() +  ", " + produtoCarta.isEspecialidade() +")" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<ProdutoCarta> read() {
        return null;
    }

    @Override
    public ProdutoCarta findById(ProdutoCarta produtoCarta) {
        return null;
    }

    @Override
    public boolean update(ProdutoCarta produtoCarta) {
        return false;
    }

    @Override
    public void delete(ProdutoCarta produtoCarta) {

    }
}
