package modelo.dao.implementacion.produtoDAO;

import modelo.Conexion.Conexion;
import modelo.dao.interfaces.Interfaz;
import modelo.vo.Carta.Carta;
import modelo.vo.Produto.Prato;
import modelo.vo.Produto.Produto;
import modelo.vo.Produto.ProdutoCarta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "SELECT * from produtos_carta where id_produto = ?";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement sentenza = conexion.getConnection().prepareStatement(sql);
            sentenza.setInt(1, produtoCarta.getProduto().getId());
            ResultSet resultSet = sentenza.executeQuery();
            produtoCarta = new ProdutoCarta();
            if (resultSet.next()){
                Carta carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id_produto"));
                produtoCarta.setCarta(carta);
                produtoCarta.setProduto(produto);
                produtoCarta.setPrezo(resultSet.getInt("prezo"));
                produtoCarta.setEncargo(resultSet.getBoolean("encargo"));
                produtoCarta.setEspecialidade(resultSet.getBoolean("especialidade"));
            }
          //  sentenza.close();
           // conexion.desconectar();
        } catch (SQLException throwables) {
            produtoCarta = null;
            throwables.printStackTrace();
        }
        return produtoCarta;    }

    @Override
    public boolean update(ProdutoCarta produtoCarta) {
        return false;
    }

    @Override
    public void delete(ProdutoCarta produtoCarta) {

    }
}
